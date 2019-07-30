package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class ReverseMortgage extends Operation {
	
	private double valueValuation; 
	private double percentageOverValuation; 
	private double interestLoanRate; 
	private double openingComission; 
	private double rentProfitability; 
	private double valuationCost; 
	private double formalizationExpenses;
	
	private int age;
	
	private static final int MAXAGE = 90;
	
	public ReverseMortgage(double vV, int a, double pOV, double iLT, double oC,
			double rP, double vC, double fE) {
		
		this.valueValuation = vV;
		this.age = a;
		this.percentageOverValuation = pOV / 100.0;
		this.interestLoanRate = iLT / 100.0;
		this.openingComission = oC / 100.0;
		this.rentProfitability = rP / 100.0;
		this.valuationCost = vC;
		this.formalizationExpenses = fE;
	}
	
	public List<List<String>> calculateTable() {
		double loanValue = valueValuation * percentageOverValuation;
		double openingComm = loanValue * openingComission;
		
		double totalExpenses = valuationCost + openingComm + formalizationExpenses;
		
		double availableValue = loanValue - totalExpenses;
		
		int difAge = MAXAGE - age;
		
		double dividend = rentProfitability * Math.pow(1+rentProfitability, difAge) * ((-1)*availableValue);
		double divisor = Math.pow(1+rentProfitability, difAge) - 1;
		double rentAnnuality = (-1) * (dividend / divisor);
		
		double loanInterests = loanValue * interestLoanRate;
		
		double monthlyValue = rentAnnuality / 12;
		double monthlyInterests = loanInterests / 12;
		
		double freeDisposal = monthlyValue - monthlyInterests;
		
		List<List<String>> table = new ArrayList<>();
		List<String> itemTable = new ArrayList<>();
		
		itemTable.add(Double.toString(round(loanValue)));
		itemTable.add(Double.toString(round(totalExpenses)));
		itemTable.add(Double.toString(round(monthlyValue)));
		itemTable.add(Double.toString(round(monthlyInterests)));
		itemTable.add(Double.toString(round(freeDisposal)));
		
		table.add(itemTable);
		
		return table;
	}

	public double getValueValuation() {
		return valueValuation;
	}

	public void setValueValuation(double valueValuation) {
		this.valueValuation = valueValuation;
	}

	public double getPercentageOverValuation() {
		return percentageOverValuation;
	}

	public void setPercentageOverValuation(double percentageOverValuation) {
		this.percentageOverValuation = percentageOverValuation / 100.0;
	}

	public double getInterestLoanRate() {
		return interestLoanRate;
	}

	public void setInterestLoanRate(double interestLoanRate) {
		this.interestLoanRate = interestLoanRate / 100.0;
	}

	public double getOpeningComission() {
		return openingComission;
	}

	public void setOpeningComission(double openingComission) {
		this.openingComission = openingComission / 100.0;
	}

	public double getRentProfitability() {
		return rentProfitability;
	}

	public void setRentProfitability(double rentProfitability) {
		this.rentProfitability = rentProfitability / 100.0;
	}

	public double getValuationCost() {
		return valuationCost;
	}

	public void setValuationCost(double valuationCost) {
		this.valuationCost = valuationCost;
	}

	public double getFormalizationExpenses() {
		return formalizationExpenses;
	}

	public void setFormalizationExpenses(double formalizationExpenses) {
		this.formalizationExpenses = formalizationExpenses;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
