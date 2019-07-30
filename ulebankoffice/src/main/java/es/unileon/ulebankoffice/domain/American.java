package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class American extends Loan {
	
	private double initialCap; 
	private double interestRate;
	private int periods;
	private int periodType;
	
	public American(double C0, double i, int k, int p) {
		this.initialCap = C0;
		this.interestRate = i / 100.0;
		this.periods = k;
		this.periodType = p;
	}

	public List<List<String>> calculateTable() {
		int numRows = periods * periodType + 1;
		
		double interestsCons = initialCap * interestRate / periodType;
		
		double[] annuality = new double[numRows];
		double[] interest = new double[numRows];
		double[] amortization = new double[numRows];
		double[] pendingCapital = new double[numRows];
		double totalAnnuality = 0;
		double totalInterest = 0;
		double totalAmortization = 0;
		
		annuality[0] = 0;
		annuality[numRows-1] = initialCap + interestsCons;
		
		interest[0] = 0;
		interest[numRows-1] = interestsCons;
		
		amortization[0] = 0;
		amortization[numRows-1] = annuality[numRows-1] - interest[numRows-1];
		
		pendingCapital[0] = initialCap;
		
		for(int i=1; i<numRows-1; i++) {
			interest[i] = interestsCons;
			annuality[i] = interest[i];
			amortization[i] = annuality[i] - interest[i];
			pendingCapital[i] = initialCap;
		}
		
		pendingCapital[numRows-1] = pendingCapital[numRows-2] - amortization[numRows-1];
		
		List<List<String>> tabla = new ArrayList<>();
		
		List<String> itemTabla;
		for(int i=0; i<numRows; i++) {
			itemTabla = new ArrayList<>();
			
			itemTabla.add(Integer.toString(i));
			itemTabla.add(Double.toString(round(annuality[i])));
			itemTabla.add(Double.toString(round(interest[i])));
			itemTabla.add(Double.toString(round(amortization[i])));
			itemTabla.add(Double.toString(round(pendingCapital[i])));
			
			totalAnnuality += annuality[i];
			totalInterest += interest[i];
			totalAmortization += amortization[i];
			
			
			tabla.add(itemTabla);
		}
		
		itemTabla = new ArrayList<>();
		itemTabla.add(Double.toString(round(totalAnnuality)));
		itemTabla.add(Double.toString(round(totalInterest)));
		itemTabla.add(Double.toString(round(totalAmortization)));
		
		tabla.add(itemTabla);
			
		return tabla;
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
	
	public double getInitialCap() {
		return initialCap;
	}
	
	public void setInitialCap(double initialCap) {
		this.initialCap = initialCap;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100.0;
	}
	
	public int getPeriods() {
		return periods;
	}
	
	public void setPeriods(int periods) {
		this.periods = periods;
	}
	
	public int getPeriodType() {
		return periodType;
	}
	
	public void setPeriodType(int periodType) {
		this.periodType = periodType;
	}
}
