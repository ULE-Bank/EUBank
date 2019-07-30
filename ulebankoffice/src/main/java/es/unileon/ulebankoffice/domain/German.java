package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * Class which manages the business logic related to the German method loan
 * 
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public class German extends Loan {
	
	private double initialCap;
	private double interestRate;
	private int periods;
	private int periodType;
	
	/**
	 * 
	 * @param C0
	 * @param i
	 * @param k
	 * @param p
	 */
	public German(double C0, double i, int k, int p) {
		this.initialCap = C0;
		this.interestRate = i / 100.0;
		this.periods = k;
		this.periodType = p;
	}
	
	public List<List<String>> calculateTable() {
		int numFilas = (periods * periodType) + 1;
		
		double[] annuality = new double[numFilas];
		double[] amortization = new double[numFilas];
		double[] interest = new double[numFilas];
		double[] pendingCapital = new double[numFilas];
		double totalAnnuality = 0;
		double totalInterest = 0;
		double totalAmortization = 0;
		
		interest[0] = initialCap * interestRate / periodType;
		
		annuality[0] = interest[0];
		
		double annualityCons = initialCap * (interestRate/periodType) / (1-(Math.pow(1-(interestRate/periodType), (double)periods*periodType)));
		
		for(int i=1; i<annuality.length; i++)
			annuality[i] = annualityCons;
		
		amortization[numFilas-1] = annualityCons;
		amortization[0] = 0;
		
		for(int i=amortization.length-2; i>0; i--)
			amortization[i] = amortization[i+1] * (1 - (interestRate/periodType));
		
		for(int i=1; i<interest.length; i++)
			interest[i] = annuality[i] - amortization[i];
		
		pendingCapital[0] = initialCap;
		
		for(int i=1; i<pendingCapital.length; i++)
			pendingCapital[i] = pendingCapital[i-1] - amortization[i];
		
		List<List<String>> table = new ArrayList<>();
		
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
	public void setInterestRate(double interestType) {
		this.interestRate = interestType / 100.0;
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
