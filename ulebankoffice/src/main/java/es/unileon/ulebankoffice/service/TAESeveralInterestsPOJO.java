/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.List;

/**
 * @author Razvan Raducu
 *
 */
public class TAESeveralInterestsPOJO {
	
	private List<VariableInterest> interests;
	
	private int period;
	
	public List<VariableInterest> getInterests() {
		return interests;
	}

	public void setInterests(List<VariableInterest> interests) {
		this.interests = interests;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	
	
}
