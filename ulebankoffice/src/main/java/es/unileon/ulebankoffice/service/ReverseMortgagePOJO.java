package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReverseMortgagePOJO {
	
	@NotNull @Min(1)
	private double valueValuation;
	
	@NotNull @Min(65) @Max(89)
	private int age;
	
	@NotNull @Min(0)
	private double percentageOverValuation;
	
	@NotNull @Min(0)
	private double interestLoanRate;
	
	@NotNull @Min(0)
	private double openingComission;
	
	@NotNull @Min(0)
	private double rentProfitability;
	
	@NotNull @Min(0)
	private double valuationCost;
	
	@NotNull @Min(0)
	private double formalizationExpenses;

	public double getValueValuation() {
		return valueValuation;
	}

	public void setValueValuation(double valueValuation) {
		this.valueValuation = valueValuation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPercentageOverValuation() {
		return percentageOverValuation;
	}

	public void setPercentageOverValuation(double percentageOverValuation) {
		this.percentageOverValuation = percentageOverValuation;
	}

	public double getInterestLoanRate() {
		return interestLoanRate;
	}

	public void setInterestLoanRate(double interestLoanRate) {
		this.interestLoanRate = interestLoanRate;
	}

	public double getOpeningComission() {
		return openingComission;
	}

	public void setOpeningComission(double openingComission) {
		this.openingComission = openingComission;
	}

	public double getRentProfitability() {
		return rentProfitability;
	}

	public void setRentProfitability(double rentProfitability) {
		this.rentProfitability = rentProfitability;
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
}
