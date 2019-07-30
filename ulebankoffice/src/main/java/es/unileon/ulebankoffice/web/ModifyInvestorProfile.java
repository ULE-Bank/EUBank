package es.unileon.ulebankoffice.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offersconsulting/editinvestorprofile")
public class ModifyInvestorProfile {

	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@GetMapping
	public String get(ModelMap model, HttpServletRequest req, HttpServletResponse resp, Principal principal) throws IOException {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			return "editinvestorprofile";
		}else {
			logger.warn("User " + principal.getName() + " " + req.getRemoteAddr() + " has tried to access inquiry editinvestorprofile. Redirecting to 403.");
			return "redirect:/e/403";
		}
	}

	@PostMapping
	public String update(ModelMap model, Principal principal, HttpServletRequest req) {
		if (hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")) {
			int total = Integer.parseInt(req.getParameter("total"));
			StringBuilder output = new StringBuilder();
		     
			for(int i = 0; i < total; i++) {
				output.append(req.getParameter("from-" + String.valueOf(i))+ " ");
				output.append(req.getParameter("to-" + String.valueOf(i))+ " ");
				output.append(req.getParameter("profile-" + String.valueOf(i)));
				output.append('\n');
			}
			
			if(output.length() != 0) {
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("investorprofile.txt"));
				    try {
						writer.write(output.toString().substring(0, output.length() - 1));
					} catch (IOException e) {
						logger.error(e.getMessage());
					} finally {
						writer.close();
					}
				} catch (IOException e1) {
					logger.error(e1.getMessage());
				}


			}  
			return "redirect:/offersconsulting/investorprofile";
		} else {
			logger.error(req.getRemoteAddr() + " " + req.getLocalAddr() + " has tried to POST to a enquiry's id without the needed role and"
					+ " without been logged in. Someone tried to answer a query from external media.");
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
