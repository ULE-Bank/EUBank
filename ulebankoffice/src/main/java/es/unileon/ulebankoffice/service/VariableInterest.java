/**
 * 
 */
package es.unileon.ulebankoffice.service;

/**
 * @author Razvan Raducu
 *
 */
public class VariableInterest {
	
	private double interest;
	
	public VariableInterest(){}
	
	public VariableInterest(double interest){
		
		this.interest = interest;
		
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	
	
}
