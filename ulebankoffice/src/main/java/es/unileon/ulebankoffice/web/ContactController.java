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
public class ContactController {
 @RequestMapping(value="/contact")
 public String formularioContacto(){
	 
	 return "contact";
 }
}
