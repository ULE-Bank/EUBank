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

import es.unileon.ulebankoffice.domain.FinancialLeasing;
import es.unileon.ulebankoffice.service.FinancialLeasingPOJO;

@Controller
public class FinancialLeasingFormController {

	@RequestMapping(value = "/leasing", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("financialLeasing") @Valid 
    		FinancialLeasingPOJO arrendamientoFinanciero, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("leasing");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double propertyValue = arrendamientoFinanciero.getPropertyValue();
		int contractDuration = arrendamientoFinanciero.getContractDuration();
		int feePaymentDivision = arrendamientoFinanciero.getFeePaymentDivision();
		double interestRate = arrendamientoFinanciero.getInterestRate();
		
		FinancialLeasing myFinancialLeasing = 
				new FinancialLeasing(propertyValue, contractDuration, feePaymentDivision, interestRate);
		
		List<List<String>> tabla = myFinancialLeasing.calculateTable();
		
		model.addObject("table", tabla);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;
	}
	
	@RequestMapping(value = "/leasing", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("financialLeasing", new FinancialLeasingPOJO());
        
        return "leasing";
    }
}
