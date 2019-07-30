package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class Discounts extends Operation {
	
	private double discountValue;
	private double interestRate;
	private double otherExpenses;
	private double comissions;
	private int discountPeriod;
	private int base;
	
	public Discounts(double discountValue, int discountPeriod, double interestRate, int base, double otherExpenses, double comissions) {
		this.discountValue = discountValue;
		this.discountPeriod = discountPeriod;
		this.interestRate = interestRate / 100.0;
		this.base = base;
		this.otherExpenses = otherExpenses;
		this.comissions = comissions / 100.0;
	}
	
	public List<List<String>> calculateTable() {
		double interests = (discountValue * discountPeriod * interestRate) / base;
		double comissionsValue = comissions * discountValue;
		double totalExpenses = interests + comissionsValue + otherExpenses;
		
		double cash = discountValue - totalExpenses;
		
		List<List<String>> table = new ArrayList<>();
		List<String> itemTable = new ArrayList<>();
		
		itemTable.add(Double.toString(round(interests)));
		itemTable.add(Double.toString(round(comissionsValue)));
		itemTable.add(Double.toString(round(totalExpenses)));
		itemTable.add(Double.toString(round(cash)));
		
		table.add(itemTable);
		
		return table;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100.0;
	}

	public double getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(double otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public double getComissions() {
		return comissions;
	}

	public void setComissions(double comissions) {
		this.comissions = comissions / 1000.0;
	}

	public int getDiscountPeriod() {
		return discountPeriod;
	}

	public void setDiscountPeriod(int discountPeriod) {
		this.discountPeriod = discountPeriod;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
}
