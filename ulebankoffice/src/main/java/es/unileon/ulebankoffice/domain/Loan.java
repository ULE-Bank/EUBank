package es.unileon.ulebankoffice.domain;

public abstract class Loan extends Operation {
	
	public abstract double getInterestRate();
	public abstract void setInterestRate(double interestType);
	
	public abstract double getInitialCap();
	public abstract void setInitialCap(double initialCap);
	
	public abstract int getPeriods();
	public abstract void setPeriods(int periods);
	
	public abstract int getPeriodType();
	public abstract void setPeriodType(int periodType);
	
}
