package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = { "/", "/index","/inicio" })
	public String emptyController() {
		return "index";
	}
	
}
