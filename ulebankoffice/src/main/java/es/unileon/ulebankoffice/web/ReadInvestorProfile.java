package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.unileon.ulebankoffice.service.InvestorProfile;

@Controller
@RequestMapping("/offersconsulting/investorprofile")
public class ReadInvestorProfile {

	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@GetMapping
	public String get(ModelMap model, HttpServletRequest req, HttpServletResponse resp, Principal principal) throws IOException {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			InvestorProfile investorProfile = new InvestorProfile();
			model.addAttribute("investorProfile", investorProfile);
			return "investorprofile";
		}else {
			logger.warn("User " + principal.getName() + " " + req.getRemoteAddr() + " has tried to access inquiry " +". Redirecting to 403.");
			return "redirect:/e/403";	
		}
		
	}

	private boolean hasRole(String role) {
		@SuppressWarnings("unchecked")
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
