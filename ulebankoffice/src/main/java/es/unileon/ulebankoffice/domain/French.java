package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class French extends Loan {
	
	private double interestRate;
	private double initialCap;
	private int periods;
	private int periodType;
	
	public French(double i, double C0, int k, int p) {
		this.interestRate = i / 100.0;
		this.initialCap = C0;
		this.periods = k;
		this.periodType = p;
	}
	
	public List<List<String>> calcularTabla() {
		int numFilas = periods * periodType + 1;
		
		double[] annuality = new double[numFilas];
		double[] interest = new double[numFilas];
		double[] amortization = new double[numFilas];
		double[] pendingCapital = new double[numFilas];
		double totalAnnuality = 0;
		double totalInterest = 0;
		double totalAmortization = 0;
		
		
		double Ani = (1 - Math.pow(1+interestRate/periodType, periods*(-1)* (double)periodType)) / (interestRate/periodType);
		double annualityCons = initialCap / Ani;
		
		annuality[0] = 0;
		interest[0] = 0;
		amortization[0] = 0;
		pendingCapital[0] = initialCap;
		
		List<List<String>> table = new ArrayList<>();
		
		for(int i=1; i<numFilas; i++) {
			annuality[i] = annualityCons;
			interest[i] = pendingCapital[i-1] * interestRate / periodType;
			amortization[i] = annuality[i] - interest[i];
			pendingCapital[i] = pendingCapital[i-1] - amortization[i];
		}
		
		List<String> itemTable;
		for(int i=0; i<numFilas; i++) {
			itemTable = new ArrayList<>();
			
			itemTable.add(Integer.toString(i));
			itemTable.add(Double.toString(round(annuality[i])));
			itemTable.add(Double.toString(round(interest[i])));
			itemTable.add(Double.toString(round(amortization[i])));
			itemTable.add(Double.toString(round(pendingCapital[i])));
			
			totalAnnuality += annuality[i];
			totalInterest += interest[i];
			totalAmortization += amortization[i];
			
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
	public double getInterestRate() {
		return interestRate;
	}
	
	@Override
	public void setInterestRate(double interestType) {
		this.interestRate = interestType / 100.0;
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
