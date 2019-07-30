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

import es.unileon.ulebankoffice.domain.German;
import es.unileon.ulebankoffice.service.GermanMethodLoanPOJO;

@Controller
public class GermanLoanFormController {
	
	@RequestMapping(value = "/germanloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("germanMethodLoan") @Valid 
    		GermanMethodLoanPOJO prestamoMetodoAleman, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("germanloan");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = prestamoMetodoAleman.getC0();
		double i = prestamoMetodoAleman.getI();
		int k = prestamoMetodoAleman.getK();
		int p = prestamoMetodoAleman.getP();
		
		German myAleman = new German(C0, i, k, p);
		
		List<List<String>> table = myAleman.calculateTable();
		
		/*
		 * Last element is the one of the totals, the summations, so it's inserted
		 * in another table and deleted from the original.
		 */
		
		List<String> totals = table.get(table.size()-1);
		table.remove(table.size()-1);
		
		/*
		 * I add an empty element at the beginning in order to keep the placing 
		 * of the columns of the original table where the periods are.
		 */
		
		totals.add(0, "");
		
		
        model.addObject("table", table);
        model.addObject("tableTotals", totals);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;	
	}
	
	@RequestMapping(value = "/germanloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("germanMethodLoan", new GermanMethodLoanPOJO());
        
        return "germanloan";
    }
}
