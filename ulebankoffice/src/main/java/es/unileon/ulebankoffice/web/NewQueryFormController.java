package es.unileon.ulebankoffice.web;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.domain.FinancialAdvisorRequest;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;
import es.unileon.ulebankoffice.repository.FinancialAdvisorRequestsRepository;
import es.unileon.ulebankoffice.service.FinancialAdvisorRequestPOJO;

@Controller
@RequestMapping("/offersconsulting/newquery")
public class NewQueryFormController {

	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String REDIRECTNEWQUERY = "redirect:/o/offersconsulting/newquery";
	private static final String FILEERROR = "fileError";

	@Autowired
	private FinancialAdvisorRequestsRepository repo;
	
	@Autowired
	private AdvisorUserRepository repoUser;
	
	@Autowired
	private GridFsTemplate template;
	
	@ModelAttribute("newQuestion")
	public FinancialAdvisorRequestPOJO getNewQuestion() {
		return new FinancialAdvisorRequestPOJO();
	}

	@PostMapping
	public String processAdd(@Valid @ModelAttribute("newQuestion") FinancialAdvisorRequestPOJO newRequest,
			BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res, Principal principal,
			ModelMap model) throws IOException {
		
		List<MultipartFile> multiFiles = newRequest.getFiles();
		logger.info("The user has uploaded " + multiFiles.size() + " files.");
		
		String[] id;
        
		/*
		 * Only one file is considered in the application at the moment
		 * but the code allows more than one
		 */
		
        int j = 0;
        id = new String[multiFiles.size()];
        for (MultipartFile multipartFile : multiFiles) {
        	if(!multipartFile.isEmpty()) {
        		if(!"application/pdf".equals(multipartFile.getContentType())) {
        			logger.warn("A file which type isn't PDF was uploaded. Deleting...");
        			model.addAttribute(FILEERROR, "Must be PDF!");
        			return REDIRECTNEWQUERY;
        		}
            		
        		byte[] fileBytes = multipartFile.getBytes();
        		byte[] bytesPDF = { 37, 80, 68, 70 };
        		for(int i = 0; i < 4; i++) {
        			if(fileBytes[i] != bytesPDF[i]) {
        				logger.warn("A file whose magic number doesn't match with PDF magic numbers was uploaded. Deleting...");
        				model.addAttribute(FILEERROR, "PDF Content!");
        				return REDIRECTNEWQUERY;
        			}
        		}
        		logger.info("File content + magic numbers -> OK");
        		InputStream inputStream =  new BufferedInputStream(multipartFile.getInputStream());
        		id[j] = template.store(inputStream, principal.getName() + ".pdf").getId().toString();
        		j++;
            		
        	}
   
        }
        
        String offerText = newRequest.getOfferText();
		String offerMatter = newRequest.getOfferMatter();
		String offerUrl = newRequest.getOfferUrl();
		String userEmail = principal.getName();
		FinancialAdvisorRequest solicitud = new FinancialAdvisorRequest();
		solicitud.setEmail(userEmail);
		solicitud.setStatus("Pendiente");
		//Right now, only one file is considered
		if(!multiFiles.isEmpty()) {
			solicitud.setFileBlobKey(id[0]);
		}
		solicitud.setOfferUrl(offerUrl);
		solicitud.setOfferText(offerText);
		solicitud.setOfferMatter(offerMatter);
		LocalDateTime now = LocalDateTime.now();

		solicitud.setCreationDate(now.getDayOfMonth() + "-" + now.getMonthOfYear() + "-" + now.getYear());

		repo.save(solicitud);
		logger.info("A new request from " + userEmail + " with id: " + solicitud.getId() + 
				" and matter: " + offerMatter + " was stored in the db");
		
		return "redirect:/offersconsulting/survey?id=" + solicitud.getId();
	}
	
	@GetMapping
	public String add(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return "newquery";

	}
	
	
}
