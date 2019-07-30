package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: David Fernandez Gonzalez
 */

public class ContinuousLoan extends Loan {
	
	private double initialCap;
	private double interestRate;
	private int periods;
	private int periodType;
	private double ratio;
	
	public ContinuousLoan(double C0, double i, int k, int p, double t) {
		this.initialCap = C0;
		this.interestRate = i / 100.0;
		this.periods = k;
		this.periodType = p;
		this.ratio = t / 100.0;
	}
	
	public List<List<String>> calculateTable() {
		
		List<List<String>> table = new ArrayList<>();

		double prevAnnuality, currentAnnuality, interest, amortization, currentCap;
		double totalAnnuality = 0, totalInterest = 0, totalAmortization = 0;
		double i, q;
		
		List<String> currentItemTable = new ArrayList<>();
		currentItemTable.add("0");
		currentItemTable.add("");
		currentItemTable.add("");
		currentItemTable.add("");
		currentItemTable.add(Double.toString(round(initialCap)));
		table.add(currentItemTable);
		
		currentItemTable = new ArrayList<>();
		i = this.interestRate / this.periodType;
		q = this.ratio / this.periodType;
		currentAnnuality = initialCap * ((i-q)/(1- Math.pow(((1+q)/(1+i)), (periods*periodType))));
		interest = this.initialCap * this.interestRate / this.periodType;
		amortization = currentAnnuality - interest;
		currentCap = this.initialCap - amortization;
		
		currentItemTable.add("1");
		currentItemTable.add(Double.toString(round(currentAnnuality)));
		currentItemTable.add(Double.toString(round(interest)));
		currentItemTable.add(Double.toString(round(amortization)));
		currentItemTable.add(Double.toString(round(currentCap)));
		totalAnnuality += currentAnnuality;
		totalInterest += interest;
		totalAmortization += amortization;
		prevAnnuality = currentAnnuality;
		table.add(currentItemTable);

		//First annuality is calculated from the first (big) formula
		//Consecutive ones are calculated from the an = an-1 * 1,0*ratio
		
		for(int j = 2; j <= (periods*periodType); j++) {
			currentItemTable = new ArrayList<>();
			currentAnnuality = prevAnnuality * (1 + q);
			interest = currentCap * this.interestRate / this.periodType;
			amortization = currentAnnuality - interest;
			currentCap = currentCap - amortization;
			
			currentItemTable.add(Integer.toString(j));
			currentItemTable.add(Double.toString(round(currentAnnuality)));
			currentItemTable.add(Double.toString(round(interest)));
			currentItemTable.add(Double.toString(round(amortization)));
			currentItemTable.add(Double.toString(round(currentCap)));
			totalAnnuality += currentAnnuality;
			totalInterest += interest;
			totalAmortization += amortization;
			prevAnnuality = currentAnnuality;
			table.add(currentItemTable);

		}
		
		currentItemTable = new ArrayList<>();
		currentItemTable.add("TOTALS");
		currentItemTable.add(Double.toString(round(totalAnnuality)));
		currentItemTable.add(Double.toString(round(totalInterest)));
		currentItemTable.add(Double.toString(round(totalAmortization)));
		table.add(currentItemTable);

		table.get(table.size()-1).remove(0);
		return table;
	}

	@Override
	public double getInitialCap() {
		return initialCap;
	}

	@Override
	public void setInitialCap(double initialCap) {
		this.initialCap = initialCap;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100.0;
	}

	@Override
	public int getPeriods() {
		return periods;
	}

	@Override
	public void setPeriods(int periods) {
		this.periods = periods;
	}

	@Override
	public int getPeriodType() {
		return periodType;
	}

	@Override
	public void setPeriodType(int periodType) {
		this.periodType = periodType;
	}
	
	public double getRatio() {
		return this.ratio;
	}
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}
