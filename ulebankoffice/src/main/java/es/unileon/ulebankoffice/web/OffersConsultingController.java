package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebankoffice.domain.FinancialAdvisorRequest;
import es.unileon.ulebankoffice.domain.QuestionStore;
import es.unileon.ulebankoffice.repository.FinancialAdvisorRequestsRepository;
import es.unileon.ulebankoffice.repository.QuestionStoreRepository;

@Controller
public class OffersConsultingController {
	
	@Autowired
	private FinancialAdvisorRequestsRepository repo;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@Autowired
	QuestionStoreRepository qSRepository;
	
	@RequestMapping(value= "/consuLogin", method = RequestMethod.GET) 
	public String getLogin(){
		QuestionStore.populateSingleton(qSRepository);
		return "offersConsultingLogin";
	}

	@RequestMapping(value = "/offersconsulting", method = RequestMethod.GET)
	public String add(ModelMap model, HttpServletRequest req, HttpServletResponse resp, Principal principal) throws IOException {		
		List<FinancialAdvisorRequest> lists;
		if(hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")){
			lists = repo.findAllByOrderByStatusDesc();
			logger.info("Showing all inquiries, pending first");
		} else {
			lists = repo.findByEmailOrderByStatusDesc(req.getUserPrincipal().getName());
			logger.info("Showing only inquiries from user " + req.getUserPrincipal().getName() + ", pending first");
		}
		
			model.addAttribute("lists", lists);
						
			model.addAttribute("name", req.getUserPrincipal().getName());
		

			return "offersconsulting";
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

		

	
}
