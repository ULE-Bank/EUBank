package es.unileon.ulebankoffice.service;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FinancialLeasingPOJO {
	
	@NotNull @Min(1)
	private double propertyValue;
	
	@NotNull @Min(1)
	private int contractDuration;
	
	private int feePaymentDivision;
	
	@NotNull @Min(0)
	private double interestRate;

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}

	public int getFeePaymentDivision() {
		return feePaymentDivision ;
	}

	public void setFeePaymentDivision(int feePaymentDivision) {
		this.feePaymentDivision  = feePaymentDivision;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
