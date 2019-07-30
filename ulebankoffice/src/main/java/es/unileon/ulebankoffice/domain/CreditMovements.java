package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public class CreditMovements {

	private String movementDescription;
	private double movementValue;
	private Date movementDate;
	private String operation;

	private boolean processed = false;

	/**
	 * @param movementDescription
	 * @param movementValue
	 * @param movementDate
	 * @param operation
	 */
	public CreditMovements(String movementDescription, double movementValue, Date movementDate,
			String operation) {
		this.movementDescription = movementDescription;
		this.movementValue = movementValue;
		this.movementDate = movementDate;
		this.operation = operation;
	}

	public String getMovementDescription() {
		return movementDescription;
	}

	public void setMovementDescription(String movementDescription) {
		this.movementDescription = movementDescription;
	}

	public double getMovementValue() {
		return movementValue;
	}

	public void setMovementValue(double movementValue) {
		this.movementValue = movementValue;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	/**
	 * Returns the sign of the operation
	 * 
	 * @return D - Provision, I - Deposit
	 */
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
