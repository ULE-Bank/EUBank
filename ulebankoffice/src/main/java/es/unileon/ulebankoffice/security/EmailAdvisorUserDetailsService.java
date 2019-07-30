package es.unileon.ulebankoffice.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;

/**
 * @author Razvan Raducu
 *
 */
@Component
public class EmailAdvisorUserDetailsService implements UserDetailsService {

	@Autowired
	private AdvisorUserRepository repo;

	private User userDetails;

	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@Override
	public UserDetails loadUserByUsername(String userName) {

		if (!userName.contains("@") || !userName.contains(".")) {
			logger.warn("Someone has tried to access the financial consultor without an email. Username tried: " 
					+ userName);
			throw new UsernameNotFoundException("An email must be searched");
		}
		
		 //If the last index of "." is before the "@", the email is wrong.

		if (userName.lastIndexOf('.') < userName.indexOf('@')) {
			logger.warn("Someone has tried to access the financial consultor with a wrong email. Tried: " 
					+ userName);
			throw new UsernameNotFoundException("The email isn't right");
		}
		
		/*
		 * At this moment is when the users are created for the first time
		 */
		AdvisorUser clientAdvisor = repo.findByEmail(userName);
		if (clientAdvisor == null) {
			logger.info("A new email has accesed the financial consultor: " + userName + ". Creating new user.");
			clientAdvisor = new AdvisorUser();
			clientAdvisor.setEmail(userName);
			repo.save(clientAdvisor);
		}

		userDetails = new User(clientAdvisor.getEmail(), "", getAuthorities());
		logger.info("Someone has tried to log in in the financial consultor with email: " + userName);
		return userDetails;
	}

	private List<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authList = new ArrayList<>();

		authList.add(new SimpleGrantedAuthority("ROLE_ADVISORUSER"));

		return authList;
	}

}
