package es.unileon.ulebankoffice.web;

import es.unileon.ulebankoffice.domain.UleBankEmployee;
import es.unileon.ulebankoffice.repository.UleBankEmployeeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping(value="/o/login")
public class LoginController {

	@Autowired
	private UleBankEmployeeRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
		@GetMapping
		public String controllerLogin(){
			
			checkAndCreateOfficeAdmin();
			
			return "login";
		}

		private void checkAndCreateOfficeAdmin() {
			logger.debug("Checking if admin exists...");
			if(repo.findByUserName("cjrulebank") == null){
				
				repo.save(new UleBankEmployee("cjrulebank", bcrypt.encode("ulebank*"), "admin"));
				logger.info("Login page has been accessed for the first time. Admin user created.");
			}
			
		}
}
