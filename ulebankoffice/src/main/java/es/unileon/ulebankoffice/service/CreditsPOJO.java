package es.unileon.ulebankoffice.service;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public class CreditsPOJO {

	@NotNull
	@Min(1)
	private double creditLimit;

	@NotNull
	private String openingDate;

	@NotNull
	private String expirationDate;

	@NotNull
	@Min(0)
	private double openingComission;

	@NotNull
	@Min(0)
	private double brokerage;

	@NotNull
	@Min(0)
	private double debtorInterest;

	@NotNull
	@Min(0)
	private double exceededInterest;

	@NotNull
	@Min(0)
	private double creditorInterest;

	@NotNull
	@Min(0)
	private double comissionSMND;

	private List<CreditMovementsPOJO> movements;

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getDebtorInterest() {
		return debtorInterest;
	}

	public void setDebtorInterest(double debtorInterest) {
		this.debtorInterest = debtorInterest;
	}

	public double getExceededInterest() {
		return exceededInterest;
	}

	public void setExceededInterest(double exceededInterest) {
		this.exceededInterest = exceededInterest;
	}

	public double getCreditorInterest() {
		return creditorInterest;
	}

	public void setCreditorInterest(double creditorInterest) {
		this.creditorInterest = creditorInterest;
	}

	public double getComissionSMND() {
		return comissionSMND;
	}

	public void setComissionSMND(double comissionSMND) {
		this.comissionSMND = comissionSMND;
	}

	public List<CreditMovementsPOJO> getMovements() {
		return movements;
	}

	public void setMovements(List<CreditMovementsPOJO> movements) {
		this.movements = movements;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public double getOpeningComission() {
		return openingComission;
	}

	public void setOpeningComission(double openingComission) {
		this.openingComission = openingComission;
	}

	public double getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(double brokerage) {
		this.brokerage = brokerage;
	}
}
