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

import es.unileon.ulebankoffice.domain.Discounts;
import es.unileon.ulebankoffice.service.DiscountsPOJO;

@Controller
public class DiscountsFormController {
	
	private static final String DISCOUNTS = "discounts";
	
	@RequestMapping(value = "/discounts", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("discounts")
    		DiscountsPOJO descuentos, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(DISCOUNTS);
		
		if (bindingResult.hasErrors())
        	return model;
		
		double discountValue = descuentos.getDiscountValue();
		int discountPeriod = descuentos.getDiscountPeriod();
		double interestRate = descuentos.getInterestRate();
		int base = descuentos.getBase();
		double otherExpenses = descuentos.getOtherExpenses();
		double comissions = descuentos.getComissions();
		
		Discounts myDiscounts = 
				new Discounts(discountValue, discountPeriod, interestRate, base, otherExpenses, comissions);
		
		List<List<String>> table = myDiscounts.calculateTable();
		
		model.addObject("table", table);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;	
	}
	
	@RequestMapping(value = "/discounts", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(DISCOUNTS, new DiscountsPOJO());
        
        return DISCOUNTS;
    }	

}
