/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase controlador para manejar los posibles errores HTTP que se puedan
 * producir en la aplicación y mostrar al usuario una página personalizada
 * 
 * Controller class to manage the possible HTTP errors which could be produced
 * in the app and to show the user a customized page.
 * 
 * @author Razvan Raducu
 * @see <a href="http://royal.pingdom.com/2009/05/06/the-5-most-common-http-errors-according-to-google/" target="_top">Errores HTTP comunes </a>
 */
@Controller
@RequestMapping("/e")
public class ServerHTTPErrorHandler {
	
	@GetMapping(value="/403")
	public String error403(){
		return "HttpError403";
	}
	
	@GetMapping(value="/404")
	public String error404(){
		return "HttpError404";
	}
}
