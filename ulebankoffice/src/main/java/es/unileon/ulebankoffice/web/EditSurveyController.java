package es.unileon.ulebankoffice.web;

import java.security.Principal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.unileon.ulebankoffice.domain.Answer;
import es.unileon.ulebankoffice.domain.Answers;
import es.unileon.ulebankoffice.domain.Client;
import es.unileon.ulebankoffice.domain.Compound;
import es.unileon.ulebankoffice.domain.Option;
import es.unileon.ulebankoffice.domain.OptionHandler;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.domain.QuestionHandler;
import es.unileon.ulebankoffice.domain.QuestionStore;
import es.unileon.ulebankoffice.domain.Simple;
import es.unileon.ulebankoffice.domain.Test;
import es.unileon.ulebankoffice.repository.ClientRepository;
import es.unileon.ulebankoffice.repository.TestRepository;

@Controller
@RequestMapping("/offersconsulting/editsurvey")
public class EditSurveyController {
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String VIEW = "edittest";

	
	@Autowired
	TestRepository testRepository;	

	@GetMapping
	public String get(ModelMap model, HttpServletRequest req, Principal principal, HttpServletResponse resp) {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			Test.populateSingleton(testRepository);
			model.addAttribute("listQuestions", Test.getInstance().getQuestions());
			return VIEW;
		}else {
			logger.warn("User " + principal.getName() + " " + req.getRemoteAddr() + " has tried to access inquiry " + VIEW +". Redirecting to 403.");
			return "redirect:/e/403";
		}

	}

	@PostMapping
	public String delete(ModelMap model, Principal principal, HttpServletRequest req, HttpServletResponse resp) {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			Test.populateSingleton(testRepository);
			Test test = Test.getInstance();
			test.remove(new QuestionHandler(Long.parseLong(req.getParameter("question-delete"))));
			testRepository.save(test);
	        return "redirect:/offersconsulting/editsurvey";
		}else {
			logger.warn("User " + principal.getName() + " " + req.getRemoteAddr() + " has tried to access inquiry POST" + VIEW +". Redirecting to 403.");
			return "redirect:/e/403";
		}
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
