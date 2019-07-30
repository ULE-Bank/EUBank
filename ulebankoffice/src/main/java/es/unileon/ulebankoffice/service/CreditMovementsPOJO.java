package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */
public class CreditMovementsPOJO {

	@NotBlank
	private String movementDescription;

	@Min(0)
	private double movementValue;

	@NotBlank
	private String movementDate;

	// I -> Deposit. D -> Provision
	private String operation;

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

	public String getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(String movementDate) {
		this.movementDate = movementDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
