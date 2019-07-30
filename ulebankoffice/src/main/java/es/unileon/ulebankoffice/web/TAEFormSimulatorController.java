package es.unileon.ulebankoffice.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.TAE;
import es.unileon.ulebankoffice.service.TAEPOJO;

@Controller
public class TAEFormSimulatorController {

	@RequestMapping(value = "/apr", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("tae") @Valid TAEPOJO tae, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("aprcalculation");
		
        if (bindingResult.hasErrors())
        	return model;
        
        TAE myTAE = new TAE(tae.getI(), tae.getP());
        
        List<List<String>> table = myTAE.calcularTabla();
        
        model.addObject("table", table);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;
    }

    @RequestMapping(value = "/apr", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("tae", new TAEPOJO());
        
        return "aprcalculation";
    }
}