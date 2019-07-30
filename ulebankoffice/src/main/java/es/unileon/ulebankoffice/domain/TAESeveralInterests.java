package es.unileon.ulebankoffice.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.ss.formula.functions.Irr;

import es.unileon.ulebankoffice.service.VariableInterest;

/**
 * @author Razvan Raducu
 *
 */
public class TAESeveralInterests {

	private double amount;
	private int period;
	private List<VariableInterest> interests;

	/**
	 * In order to calculate the tae related to several different interests,
	 * it's necessary to specify all those interests and the number of periods.
	 * The number of interests must be the same as the number of periods.
	 * If it doesn't match, the list would only reach index. (index < period)
	 * 
	 * @param period
	 * @param interests
	 */
	public TAESeveralInterests(int period, List<VariableInterest> interests) {
		// Amount isn't necessary. TAE is independent from the amount.
		// It's only used to obtain the solution
		this.amount = 100;
		this.period = period;
		this.interests = interests;
	}

	
	/**
	 * The period and the specified interests must be kept in mind 
	 * when the calculation is made
	 * 
	 * @return
	 */
	public String calculate() {
		
		new Irr();
		double irr;
		double tae;

		// 1 must be added because the amount must be introduced
		// in the flows.
		
		double[] flows = new double[period + 1];

		flows[0] = -amount;
		for (int i = 0; i < period; i++) {

			flows[i + 1] = (interests.get(i).getInterest() / (100)) * amount / period;

		}

		// Initial quantity must be added again.
		flows[flows.length - 1] += amount;

		
		irr = Irr.irr(flows, 0.1d);

		tae = (Math.pow(1.0 + irr, period) - 1.0) * 100;
		
		/*
		 * After all the operations and before adding to the table, I round the
		 * values.
		 * 
		 * The IRR, TAE and final result
		 * are in the last two positions of the table.
		 * 
		 * This positions are deleted to print the table with a 'foreach'
		 * in the view. This is handled by the controller.
		 */
		
		return new BigDecimal(Double.toString(tae)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public List<VariableInterest> getInterests() {
		return interests;
	}

	public void setInterests(List<VariableInterest> interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "TAEVariosInteresesDomain [cantidad=" + amount + ", periodo=" + period + ", intereses=" + interests
				+ "]";
	}

}
