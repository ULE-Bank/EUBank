package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class Italian extends Loan {
	
	private double initialCap;
	private double interestRate;
	private int periods;
	private int periodType;
	
	public Italian(double C0, double i, int k, int p) {
		this.initialCap = C0;
		this.interestRate = i / 100.0;
		this.periods = k;
		this.periodType = p;
	}
	
	public List<List<String>> calculateTable() {
		double amortizationCons = initialCap / (periods * periodType);
		
		int numRows = (periods * periodType) + 1;
		
		double[] remainingCap = new double[numRows];
		double[] interestsColumn = new double[numRows];
		double[] annuality = new double[numRows];
		double totalAnnuality = 0;
		double totalInterest = 0;
		double totalAmortization = 0;
		
		remainingCap[0] = initialCap;
		
		for(int i=1; i<remainingCap.length; i++)
			remainingCap[i] = remainingCap[i-1] - amortizationCons;
		
		for(int i=1; i<interestsColumn.length; i++)
			interestsColumn[i] = remainingCap[i-1] * interestRate / periodType;
		
		for(int i=1; i<annuality.length; i++)
			annuality[i] = interestsColumn[i] + amortizationCons;
		
		List<List<String>> table = new ArrayList<>();
		
		List<String> itemTable;
		for(int i=0; i<numRows; i++) {
			itemTable = new ArrayList<>();
			
			if(i == 0) {
				itemTable.add(Integer.toString(i));
				itemTable.add("0");
				itemTable.add("0");
				itemTable.add("0");
				itemTable.add(Double.toString(round(remainingCap[i])));
			}
			else {
				itemTable.add(Integer.toString(i));
				itemTable.add(Double.toString(round(annuality[i])));
				itemTable.add(Double.toString(round(interestsColumn[i])));
				itemTable.add(Double.toString(round(amortizationCons)));
				itemTable.add(Double.toString(round(remainingCap[i])));
				
				totalAnnuality += annuality[i];
				totalInterest += interestsColumn[i];
				totalAmortization += amortizationCons;
			}
			
			table.add(itemTable);
		}
		
		itemTable = new ArrayList<>();
		itemTable.add(Double.toString(round(totalAnnuality)));
		itemTable.add(Double.toString(round(totalInterest)));
		itemTable.add(Double.toString(round(totalAmortization)));
		
		table.add(itemTable);
		
		
		return table;
	}
	
	public List<String> getTableHeader() {
		List<String> header = new ArrayList<>();
		
		header.add("Periodo");
		header.add("Anualidad");
		header.add("Interés");
		header.add("Amortización");
		header.add("Capital pendiente");
		
		return header;
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
}
