package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AmericanMethodLoanPOJO {
	
	@NotNull @Min(1)
	private double C0;
	
	@NotNull @Min(0)
	private double i;
	
	@NotNull @Min(1)
	private int k;
	
	private int p;
	
	public double getC0() {
		return C0;
	}
	
	public void setC0(double c0) {
		C0 = c0;
	}
	
	public double getI() {
		return i;
	}
	
	public void setI(double i) {
		this.i = i;
	}
	
	public int getK() {
		return k;
	}
	
	public void setK(int k) {
		this.k = k;
	}
	
	public int getP() {
		return p;
	}
	
	public void setP(int p) {
		this.p = p;
	}
}
