package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class FinancialLeasing extends Operation {
	
	private double propertyValue, interestRate;
	private int contractDuration, feePaymentDivision;
		
	public FinancialLeasing(double propertyValue, int contractDuration, int feePaymentDivision, double interestRate) {
		this.propertyValue = propertyValue;
		this.contractDuration = contractDuration;
		this.feePaymentDivision = feePaymentDivision;
		this.interestRate = interestRate / 100.0;
	}
	
	public List<List<String>> calculateTable() {
		double aux = 1 + (interestRate / feePaymentDivision);
		double up = Math.pow(aux, (contractDuration*feePaymentDivision)) * (interestRate / feePaymentDivision);
		double down = Math.pow(aux, ((contractDuration*feePaymentDivision)+1)) - 1;
		
		double fee = propertyValue * (up / down);
		
		int totalPeriods = contractDuration * feePaymentDivision + 1;
		
		double[] pendingCapital = new double[totalPeriods];
		double[] interests = new double[totalPeriods];
		double[] amortization = new double[totalPeriods];
		double[] totalAmortized = new double[totalPeriods];
		
		List<List<String>> table = new ArrayList<List<String>>();
		
		List<String> itemTable;
		for(int i=0; i<totalPeriods; i++) {
			itemTable = new ArrayList<String>();
			
			if(i == 0) {
				interests[i] = 0;
				amortization[i] = fee - interests[i];
				totalAmortized[i] = amortization[i];
				pendingCapital[i] = propertyValue - amortization[i];
			}
			else {
				interests[i] = pendingCapital[i-1] * interestRate / feePaymentDivision;
				amortization[i] = fee - interests[i];
				totalAmortized[i] = totalAmortized[i-1] + amortization[i];
				pendingCapital[i] = propertyValue - totalAmortized[i];
			}
			
			itemTable.add(Integer.toString(i));
			itemTable.add(Double.toString(round(fee)));
			itemTable.add(Double.toString(round(interests[i])));
			itemTable.add(Double.toString(round(amortization[i])));
			itemTable.add(Double.toString(round(pendingCapital[i])));
			
			table.add(itemTable);
		}
		
		return table;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100.0;
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}

	public int getFeePaymentDivision() {
		return feePaymentDivision;
	}

	public void setFeePaymentDivision(int feePaymentDivision) {
		this.feePaymentDivision = feePaymentDivision;
	}
}
