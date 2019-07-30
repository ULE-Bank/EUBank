/**
 * 
 */
package es.unileon.ulebankoffice.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebankoffice.domain.TAESeveralInterests;
import es.unileon.ulebankoffice.service.TAESeveralInterestsPOJO;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
public class TAESeveralInterestsController {

	@RequestMapping(value = "/aprv", method = RequestMethod.GET)
	public String getAprvView(@ModelAttribute("taeDataSeveralInterests") TAESeveralInterestsPOJO taeSeveralInterests) {
		return "aprv";
	}

	@RequestMapping(value = "/aprv", method = RequestMethod.POST)
	public String calculateAprv(ModelMap model,
			@ModelAttribute("taeDataSeveralInterests") @Valid TAESeveralInterestsPOJO taeSeveralInterestsPOJO,
			BindingResult result, HttpServletResponse response) {
		
		/*
		 * It looks like we have to consider negative interests, so 
		 * validator class is disabled. It could be done with @Autowire and
		 * @Component in the class TAESeveralInterestsValidator
		 */

		if (result.hasErrors()) {
			return "aprv";
		}

		TAESeveralInterests tae = new TAESeveralInterests(taeSeveralInterestsPOJO.getPeriod(),
				taeSeveralInterestsPOJO.getInterests());

		String TAE = tae.calculate();

		model.addAttribute("TAE", TAE);

		response.addCookie(new Cookie("resultados", "1"));

		return "aprv";
	}
}
