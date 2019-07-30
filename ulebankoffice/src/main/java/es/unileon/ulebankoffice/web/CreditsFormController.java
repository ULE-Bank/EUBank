package es.unileon.ulebankoffice.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import es.unileon.ulebankoffice.domain.Credits;
import es.unileon.ulebankoffice.domain.CreditMovements;
import es.unileon.ulebankoffice.service.CreditsPOJO;
import es.unileon.ulebankoffice.service.CreditMovementsPOJO;

@Controller
public class CreditsFormController {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final String CURRENCY = "€";
	private static final Logger logger = Logger.getLogger("ulebankLogger");

	@RequestMapping(value = "/creditaccount", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("credits")
    		CreditsPOJO creditos, BindingResult bindingResult, HttpServletResponse response) throws ParseException {
		
		ModelAndView model = new ModelAndView("creditaccount");
		
		if (bindingResult.hasErrors())
        	return model;
		
		List<CreditMovementsPOJO> movements = creditos.getMovements();
		
		List<CreditMovements> myMovements = new ArrayList<>();
		String movementsCookie = new Gson().toJson(movements);
		
		try {
			response.addCookie(new Cookie("movements", URLEncoder.encode(movementsCookie, "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			logger.warn("Movements cookie couldn't be generated");
		}
		
		response.addCookie(new Cookie("openingDate", creditos.getOpeningDate()));
		response.addCookie(new Cookie("expirationDate", creditos.getExpirationDate()));
		
		String movementDescriptions;
		double movementValue;
		Date movementDate;
		String operation;
		DecimalFormat decimalFormatter = new DecimalFormat("#,##0.00");
		decimalFormatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.GERMAN));
	
		for(CreditMovementsPOJO movement : movements) {
			movementDate = sdf.parse(movement.getMovementDate());
			movementDescriptions = movement.getMovementDescription();
			movementValue = movement.getMovementValue();
			operation = movement.getOperation();
			myMovements.add(new CreditMovements(movementDescriptions, movementValue, movementDate,operation));
		}
		
		double creditLimit = creditos.getCreditLimit();
		Date openingDate = sdf.parse(creditos.getOpeningDate());
		Date expirationDate = sdf.parse(creditos.getExpirationDate());
		double debtorInterest = creditos.getDebtorInterest();
		double exceededInterest = creditos.getExceededInterest();
		double creditorInterest = creditos.getCreditorInterest();
		double comissionSMND = creditos.getComissionSMND();
		double openingComission = creditos.getOpeningComission();
		double brokerage = creditos.getBrokerage();
		
		Credits myCredits = new Credits(creditLimit, openingDate, expirationDate, debtorInterest, 
				exceededInterest, creditorInterest, comissionSMND, myMovements);
		
		myCredits.includeOpeningAndBrokerageComission(openingComission, brokerage);
		
		List<List<String>> table = myCredits.calculateTable();
		List<Double> totalLiquidation = myCredits.obtainLiquidation();
		
		// Last element of the table is the liquidation itself.
		
		List<String> itemTable = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(expirationDate);
		
		double debtorInterests = totalLiquidation.get(0);
		double exceededInterests = totalLiquidation.get(1);
		double creditorInterests = totalLiquidation.get(2);
		
		String totalDebtorInterests = decimalFormatter.format(debtorInterests)+ CURRENCY;
		String totalExceededInterests = decimalFormatter.format(exceededInterests)+ CURRENCY;
		String totalCreditorInterests = decimalFormatter.format(creditorInterests)+ CURRENCY;
		String comissionSMNDtoString = decimalFormatter.format(totalLiquidation.get(3))+ CURRENCY;
		String totalLiquidationToString = decimalFormatter.format(totalLiquidation.get(5))+ CURRENCY;
		String totalBalance = table.get(table.size()-1).get(4);
		
		String totalBalanceToString = totalBalance.substring(0, totalBalance.length()-1);
		totalBalanceToString = totalBalanceToString.replaceAll("\\.", "");
		totalBalanceToString = totalBalanceToString.replaceAll(",", ".");
		
		Double finalBalance = Double.parseDouble(totalBalanceToString);
		
		// In the Gregorian calendar the dates begin in 0. January is the month 0 and December is month 11. Because of this, 1 is added. 
		
		itemTable.add(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH)+1));
	
		itemTable.add("Liquidación");
		itemTable.add(totalLiquidationToString);
		itemTable.add("-");
		itemTable.add(decimalFormatter.format(finalBalance + totalLiquidation.get(5)));
		itemTable.add(String.valueOf(totalLiquidation.get(4).intValue()));
		itemTable.add(totalDebtorInterests);
		itemTable.add(totalExceededInterests);
		itemTable.add(totalCreditorInterests);
		
		table.add(itemTable);
		
		
		
		model.addObject("table", table);
		
		/* Liquidation Table */
		
		
		model.addObject("iDebtors1",decimalFormatter.format(debtorInterest) + "%");
		model.addObject("iDebtors2",decimalFormatter.format(debtorInterests*myCredits.getDebtorInterest()/360)+ CURRENCY);
		
		model.addObject("iExceeded1",decimalFormatter.format(exceededInterest) + "%");
		model.addObject("iExceeded2",decimalFormatter.format(exceededInterests*myCredits.getExceededInterest()/360)+ CURRENCY);
		
		model.addObject("iCreditors1",decimalFormatter.format(creditorInterest) + "%");
		model.addObject("iCreditors2",decimalFormatter.format(creditorInterests*myCredits.getCreditorInterest()/360)+ CURRENCY);
		
		model.addObject("CSMND1",decimalFormatter.format(comissionSMND) + "%");
		model.addObject("CSMND2",comissionSMNDtoString);
		
		model.addObject("total", totalLiquidationToString);
		
        response.addCookie(new Cookie("resultados", "1"));
        
        
        return model;
	}
	
	@RequestMapping(value = "/creditaccount", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute("credits") CreditsPOJO creditos) {
        return "creditaccount";
    }
}
