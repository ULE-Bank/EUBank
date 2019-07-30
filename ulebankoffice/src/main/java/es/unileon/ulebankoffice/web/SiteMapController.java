/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
public class SiteMapController {

	@RequestMapping(value="/sitemap")
	public String controllerVacio(){
		return "sitemap";
	}
	
	
}
