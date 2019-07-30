package es.unileon.ulebankoffice.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class that abstracts the shared behaviour between the different movements
 * which could be made in the different financial products.
 * 
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public abstract class Operation {

	/**
	 * Returns the double value that is closest in value to the argument and is
	 * equal to a mathematical integer.
	 * 
	 * <b>>Edit</b 10.05.2017 (dd-MM-yy)
	 * I've changed the method so it rounds with 2 figures.
	 * BigDecimal must be used. Float and double are inexact.
	 * 
	 * @param r
	 * @return The double number rounded.
	 */
	public double round(double r) {
		return BigDecimal.valueOf(Math.rint(r * 100) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

}
