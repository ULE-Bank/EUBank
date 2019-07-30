package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DiscountsPOJO {
	
	@NotNull @Min(1)
	private double discountValue;
	
	@NotNull @Min(1)
	private int discountPeriod;
	
	@NotNull @Min(0)
	private double interestRate;
	
	private int base;
	
	@NotNull @Min(0)
	private double otherExpenses;
	
	@NotNull @Min(0)
	private double comissions;

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public int getDiscountPeriod() {
		return discountPeriod;
	}

	public void setDiscountPeriod(int discountPeriod) {
		this.discountPeriod = discountPeriod;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(double otrosExpenses) {
		this.otherExpenses = otrosExpenses;
	}

	public double getComissions() {
		return comissions;
	}

	public void setComissions(double comissions) {
		this.comissions = comissions;
	}
}
