/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;

/**
 * @author Razvan Raducu 
 * 
 * ATENCIÓN!!! A fecha de 16 de Octubre de 2017 este
 *         controlador no se está usando pues las consultas se crean desde
 *         NewQuestionFormController y desde ahí se devuelve directamente la
 *         vista question-verification. Nunca se va a acceder al enlace
 *         /offersconsulting/queryok. Sólo se usa para ver el resultado de 
 *         la página al hacer modificaciones.
 */
@Controller
@RequestMapping(value = "/offersconsulting/queryok")
public class QueryOKController {

	@GetMapping
	public String controllerVacio(ModelMap model, Principal principal) {
		return "question-verification";
	}

}
