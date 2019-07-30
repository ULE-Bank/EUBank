package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TAEPOJO {
	
	@NotNull @Min(0)
	private double i;
	
	private int p;
	
	public double getI() {
		return i;
	}
	public void setI(double i) {
		this.i = i;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
}
