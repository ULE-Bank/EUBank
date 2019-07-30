package es.unileon.ulebankoffice.service;

import javax.validation.constraints.NotNull;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountPOJO {
	
	@NotNull
	private Double creditorInterests;
	@NotNull
	private Double debtorInterestOverNegativeBalance;
	@NotNull
	private Double capitalPerformanceRetention;
	@NotNull
	private Double maintenanceComission;
	@NotNull
	private Double maintenanceDeficit;
	@NotNull
	private Double minMaintenanceDeficit;
	@NotNull
	private int liquidationPeriod;
	@NotNull
	private int annualDays;
		
	public Double getCreditorInterests() {
		return creditorInterests;
	}

	public void setCreditorInterests(Double creditorInterests) {
		this.creditorInterests = creditorInterests;
	}

	public Double getDebtorInterestOverNegativeBalance() {
		return debtorInterestOverNegativeBalance;
	}

	public void setDebtorInterestOverNegativeBalance(Double debtorInterestOverNegativeBalance) {
		this.debtorInterestOverNegativeBalance = debtorInterestOverNegativeBalance;
	}

	public Double getCapitalPerformanceRetention() {
		return capitalPerformanceRetention;
	}

	public void setCapitalPerformanceRetention(Double capitalPerformanceRetention) {
		this.capitalPerformanceRetention = capitalPerformanceRetention;
	}

	public Double getMaintenanceComission() {
		return maintenanceComission;
	}

	public void setMaintenanceComission(Double maintenanceComission) {
		this.maintenanceComission = maintenanceComission;
	}

	public Double getMaintenanceDeficit() {
		return maintenanceDeficit;
	}

	public void setMaintenanceDeficit(Double maintenanceDeficit) {
		this.maintenanceDeficit = maintenanceDeficit;
	}

	public Double getMinMaintenanceDeficit() {
		return minMaintenanceDeficit;
	}

	public void setMinMaintenanceDeficit(Double minMaintenanceDeficit) {
		this.minMaintenanceDeficit = minMaintenanceDeficit;
	}

	public int getLiquidationPeriod() {
		return liquidationPeriod;
	}

	public void setLiquidationPeriod(int liquidationPeriod) {
		this.liquidationPeriod = liquidationPeriod;
	}

	public int getAnnualDays() {
		return annualDays;
	}

	public void setAnnualDays(int annualDays) {
		this.annualDays = annualDays;
	}

}
