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

import es.unileon.ulebankoffice.domain.ReverseMortgage;
import es.unileon.ulebankoffice.service.ReverseMortgagePOJO;

@Controller
public class ReverseMortgageFormController {
	
	private static final String REVERSE_MORTGAGE = "reversemortgage";
	
	@RequestMapping(value = "/reversemortgage", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("reversemortgage") @Valid 
    		ReverseMortgagePOJO hipotecaInversa, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(REVERSE_MORTGAGE);
		
		if (bindingResult.hasErrors())
			return model;
		
		double vT = hipotecaInversa.getValueValuation();
		int e = hipotecaInversa.getAge();
		double pST = hipotecaInversa.getPercentageOverValuation();
		double tIP = hipotecaInversa.getInterestLoanRate();
		double cA = hipotecaInversa.getOpeningComission();
		double rR = hipotecaInversa.getRentProfitability();
		double cT = hipotecaInversa.getValuationCost();
		double gF = hipotecaInversa.getFormalizationExpenses();
		
		ReverseMortgage myHipotecaInversa = 
				new ReverseMortgage(vT, e, pST, tIP, cA, rR, cT, gF);
		
		List<List<String>> table = myHipotecaInversa.calculateTable();
		
		model.addObject("table", table);
		
		response.addCookie(new Cookie("resultados", "1"));

        return model;
	}
	
	@RequestMapping(value = "/reversemortgage", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(REVERSE_MORTGAGE, new ReverseMortgagePOJO());
        
        return REVERSE_MORTGAGE;
    }
}
