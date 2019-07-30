package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.gridfs.GridFSDBFile;

import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.domain.FinancialAdvisorRequest;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;
import es.unileon.ulebankoffice.repository.FinancialAdvisorRequestsRepository;

@Controller
@RequestMapping(value = "/offersconsulting/querypage")
public class QueryPageController {

	@Autowired
	private GridFsTemplate template;
	
	@Autowired
	private FinancialAdvisorRequestsRepository repo;
	
	@Autowired
	private AdvisorUserRepository repoUser;

	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@GetMapping(params = { "id" })
	public String add(ModelMap model, HttpServletRequest req, HttpServletResponse resp, Principal principal,
			@RequestParam("id") String requestID) throws IOException {

		FinancialAdvisorRequest request = repo.findOne(requestID);

		if (request == null) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
					" has tried to access a nonexistent inquiry. Returning 404.");
			
			return "redirect:/e/404";
		}
		
		/*
		 * It's checked if the user who is accessing the request is the creator or 
		 * an employee from the office/superior employee. Every other user who is not
		 * admin or bank employees has a ROLE_ADVISOREUSER role. If the user has this role and 
		 * he isn't the creator of the inquiry, an error is returned.
		 */
		
		String requestCreator = request.getEmail();
		if (hasRole("ROLE_ADVISORUSER") && !principal.getName().equals(requestCreator)) {
			
			logger.warn("User " + principal.getName() + " " + req.getRemoteAddr() + " has tried to access inquiry " +
							request.getId() + " of user " + requestCreator + ". Redirecting to 403.");
			
			return "redirect:/e/403";
		}

		/*
		 * If he/she's an employee, he/she could see the commands to add a new response.
		 * If it already has a response, a text area would be loaded to modify it.
		 */
		
		
		String address = request.getFileBlobKey() == null ? null : request.getId();
		
		model.addAttribute("offerMatter", request.getOfferMatter());
		model.addAttribute("idQuery", request.getId());
		model.addAttribute("fileLink", "/offersconsulting/querypage/serve?id=" + address);		
		model.addAttribute("offerText", request.getOfferText());
		model.addAttribute("offerUrl", request.getOfferUrl());
		model.addAttribute("offerResponse", request.getOfferResponse());
		model.addAttribute("inquiryAuthor", requestCreator);
		model.addAttribute("creationDate", request.getCreationDate());
		
		AdvisorUser user = repoUser.findByEmail(requestCreator);
		model.addAttribute("testScore", request.getTestResult());
		model.addAttribute("testProfile", request.getProfile());

		return "querypage";

	}

	@PostMapping(params = { "id" })
	public String addResponse(ModelMap model, @RequestParam("response") String requestResponse,
			@RequestParam("id") String requestID, @RequestParam("scoreTest") double scoreTest, Principal principal, HttpServletRequest req) {
		
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			FinancialAdvisorRequest request = repo.findOne(requestID);

			if (request == null) {
				logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
						" has tried to access a nonexistent inquiry. Returning 404.");
				
				return "redirect:/e/404";
			}

			request.setOfferResponse(requestResponse);
			request.setStatus("Contestada");
			
			repo.save(request);
			logger.info(principal.getName() + " has added a response to inquiry " + request.getId());
			
			return "redirect:/offersconsulting/querypage?id=" + requestID;
		} else {
			logger.error(req.getRemoteAddr() + " " + req.getLocalAddr() + " has tried to POST to a enquiry's id without the needed role and"
					+ " without been logged in. Someone tried to answer a query from external media.");
			return "redirect:/e/403";
		}

	}

	@GetMapping(value = "/e", params = { "id" })
	public String deleteInquiry(ModelMap model, HttpServletRequest req, HttpServletResponse resp,
			Principal principal, @RequestParam("id") String requestID) {
		
		FinancialAdvisorRequest request = repo.findOne(requestID);
		
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
				" is trying to delete an enquiry");

		if (request == null) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
					" is trying to delete a nonexistent enquiry. Returning 404");
			return "redirect:/e/404";
		}

		if (!hasRole("ROLE_ADMIN")) {
			logger.error(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
					" is trying to delete an enquiry without the needed privileges. Returning 403");
			return "redirect:/e/403";
		}

		if (request.getFileBlobKey() != null) {
			/*
			 * Si no encuentra la key no hay nullPointer, aparentemente,
			 * simplemente lo omite.
			 */

			template.delete(new Query(Criteria.where("_id").is(request.getFileBlobKey())));
		}

		repo.delete(request);
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + 
				" deleted enquiry " + requestID);
		
		return "redirect:/offersconsulting";
	}

	private boolean hasRole(String role) {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		boolean hasRole = false;
		for (GrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals(role);
			if (hasRole) {
				break;
			}
		}
		return hasRole;
	}
	
	
	@RequestMapping(value = "/serve", params = { "id" }, method = RequestMethod.GET)
	public @ResponseBody
	void download(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response, Principal principal) throws IOException {
		FinancialAdvisorRequest solicitud = repo.findOne(id);
		
		if (solicitud == null) {
			logger.warn(principal.getName() + " " + request.getRemoteAddr() + " " + request.getLocalAddr() + 
					" is trying to access a nonexistent enquiry");
			
		}else {
			GridFSDBFile file = template.findOne(new Query(Criteria.where("_id").is(solicitud.getFileBlobKey())));
			
			if (file == null) {
				logger.warn(principal.getName() + " " + request.getRemoteAddr() + " " + request.getLocalAddr() + 
						" is trying to access a nonexistent file of enquiry " + id);
				
			}else if(hasRole("ROLE_ADVISORUSER") && !principal.getName().equals(solicitud.getEmail())) {
				logger.info(principal.getName() + " " + request.getRemoteAddr() + " " + request.getLocalAddr() + 
						" is trying to access an enquiry without required privileges.");
		    }else {
		    	try {
		    		response.setContentType(file.getContentType());
			    	response.setContentLength((int)file.getLength());
			    	response.setHeader("content-Disposition", "attachment; filename=" + file.getFilename());// "attachment;filename=test.xls"
			        IOUtils.copyLarge(file.getInputStream(), response.getOutputStream());
			        logger.info("File downloaded correctly");
			        
			    } catch (IOException ex) {
			    	logger.info("Error writing file to output stream. Filename was '" + id + "'");
			    	logger.info(ex);
			    	throw new RuntimeException("IOError writing file to output stream");
			    }
		    }
		}		
		
	}

}
