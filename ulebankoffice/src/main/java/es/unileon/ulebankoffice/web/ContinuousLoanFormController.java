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

import es.unileon.ulebankoffice.domain.ContinuousLoan;
import es.unileon.ulebankoffice.domain.Italian;
import es.unileon.ulebankoffice.service.ContinuousLoanPOJO;
import es.unileon.ulebankoffice.service.ItalianMethodLoanPOJO;

@Controller
public class ContinuousLoanFormController {
	
	private static final String VIEW = "continuousloan";
	
	@RequestMapping(value = "/continuousloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("continuousLoan") @Valid 
    		ContinuousLoanPOJO continuousLoan, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(VIEW);
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = continuousLoan.getC0();
		double i = continuousLoan.getI();
		int k = continuousLoan.getK();
		int p = continuousLoan.getP();
		double t = continuousLoan.getT();
		
		ContinuousLoan continuous = new ContinuousLoan(C0, i, k, p, t);
		
		List<List<String>> table = continuous.calculateTable();
		
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
	
	@RequestMapping(value = "/continuousloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("continuousLoan", new ContinuousLoanPOJO());
        
        return VIEW;
    }
}

