/**
 * 
 */
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

import es.unileon.ulebankoffice.domain.UleBankEmployee;
import es.unileon.ulebankoffice.repository.UleBankEmployeeRepository;

/**
 * @author Razvan Raducu
 *
 */
@Component
public class MongoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UleBankEmployeeRepository repo;
		
	private User userDetails;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		
		UleBankEmployee empleado = getUser(userName);
		if(empleado == null){
			logger.info("Someone has tried to log in with username: " + userName + ". It doesn't exist in the office.");
			throw new UsernameNotFoundException("Wrong credentials");
		}
		
		logger.info("Someone has tried to log in with username: " + userName + ". It exists.");
		userDetails = new User(empleado.getUserName(), empleado.getPassword(), getAuthorities(empleado.getRole()));
		
		return userDetails;
	}

	private List<GrantedAuthority> getAuthorities(String role) {
		
		List<GrantedAuthority> authList = new ArrayList<>();
		String empleado = "empleado";
		String supervisor = "supervisor";
		String admin = "admin";
		
		if(role.equals(empleado)){
			authList.add(new SimpleGrantedAuthority("ROLE_EMPLEADO"));
		} else if(role.equals(supervisor)){
			authList.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
		} else if(role.equals(admin)){
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return authList;
	}
	
	private UleBankEmployee getUser(String userName){
		return repo.findByUserName(userName);
	}
}
