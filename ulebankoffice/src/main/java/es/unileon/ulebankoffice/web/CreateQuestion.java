package es.unileon.ulebankoffice.web;

import java.util.Collection;
import java.util.Date;
import java.security.Principal;

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

import es.unileon.ulebankoffice.domain.Compound;
import es.unileon.ulebankoffice.domain.OptionHandler;
import es.unileon.ulebankoffice.domain.Options;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.domain.QuestionStore;
import es.unileon.ulebankoffice.domain.Simple;
import es.unileon.ulebankoffice.domain.Test;
import es.unileon.ulebankoffice.repository.QuestionStoreRepository;
import es.unileon.ulebankoffice.repository.TestRepository;
@Controller
@RequestMapping(value = "/offersconsulting/createquestion")
public class CreateQuestion {
	
	@Autowired
	TestRepository testRepository;
		
	@Autowired
	QuestionStoreRepository questionStoreRepository;
	
    private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String VIEW = "createquestion";

    @GetMapping
    public String getCreateQuestion(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
	        return VIEW;
		}else {
			logger.error(req.getRemoteAddr() + " " + req.getLocalAddr() + " has tried to POST to a enquiry's id without the needed role and"
					+ " without permission.");
			return "redirect:/e/403";
		}
    }

    @PostMapping
    public String survey(ModelMap model, Principal principal, HttpServletRequest req, HttpServletResponse resp) {    	
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			int totalSimple = Integer.parseInt(req.getParameter("total-simple"));
	    	int totalCompound = Integer.parseInt(req.getParameter("total-compound"));
	    	
	    	Question question = new Question(req.getParameter("question-text"));
	    	long timestamp = new Date().getTime();
	    	int marks = 1;
	    	
	    	for(int i = 0; i < totalSimple; i++) {
	    		Simple simple = new Simple(req.getParameter("option-simple-" + i), Float.parseFloat(req.getParameter("option-simple-" + i + "-value")), new OptionHandler(timestamp + marks));
	    		question.add(simple);
	    		marks += 1;
	    	}
	    	
	    	for(int i = 0; i < totalCompound; i++) {
	    		Compound compound = new Compound(req.getParameter("option-compound-" + i), new Options(), new OptionHandler(timestamp + marks));
	    		marks += 1;
	    		
	    		for(int j = 0; j < Integer.parseInt(req.getParameter("total-simple-compound-" + i)); j++) {
	        		Simple simple = new Simple(req.getParameter("option-compound-" + i + "-simple-" + j), 
	        									Float.parseFloat(req.getParameter("option-compound-" + i + "-simple-" + j + "-value")),
	        									new OptionHandler(timestamp + marks));
	        		compound.add(simple);
	        		marks += 1;

	    		}
	    		question.add(compound);
	    		marks += 1;

	    	}
	    	QuestionStore.populateSingleton(questionStoreRepository);
	    	QuestionStore questionStore = QuestionStore.getInstance();
	    	questionStore.add(question);
	    	questionStoreRepository.save(questionStore);
	    	
	    	Test.populateSingleton(testRepository);
	    	Test test = Test.getInstance();
	    	test.add(question);
	    	testRepository.save(test);
	    	
			return "redirect:/offersconsulting/editsurvey";
		}else {
			logger.error(req.getRemoteAddr() + " " + req.getLocalAddr() + " has tried to POST to a enquiry's id without the needed role and"
					+ " without permission.");
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