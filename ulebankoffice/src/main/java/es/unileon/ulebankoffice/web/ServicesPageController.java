/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class ServicesPageController {
	
	@RequestMapping(value="/services")
	public String returnServicesPage(){
		return "servicespage";
	}

}
