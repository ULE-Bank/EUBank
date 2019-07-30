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

import es.unileon.ulebankoffice.domain.Italian;
import es.unileon.ulebankoffice.service.ItalianMethodLoanPOJO;

@Controller
public class ItalianLoanFormController {
	
	@RequestMapping(value = "/italianloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("italianMethodLoan") @Valid 
    		ItalianMethodLoanPOJO italianMethodLoan, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("italianloan");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = italianMethodLoan.getC0();
		double i = italianMethodLoan.getI();
		int k = italianMethodLoan.getK();
		int p = italianMethodLoan.getP();
		
		Italian myItalian = new Italian(C0, i, k, p);
		
		List<List<String>> table = myItalian.calculateTable();
		
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
	
	@RequestMapping(value = "/italianloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("italianMethodLoan", new ItalianMethodLoanPOJO());
        
        return "italianloan";
    }
}

