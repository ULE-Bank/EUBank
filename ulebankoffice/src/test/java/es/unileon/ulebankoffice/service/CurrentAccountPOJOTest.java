package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountPOJOTest {
	
	private CurrentAccountPOJO cuenta;
	
	@Before
	public void setUp() throws Exception {
		cuenta = new CurrentAccountPOJO();
	}

	@Test
	public void testCreditorInterests() {
		assertNull(cuenta.getCreditorInterests());
		cuenta.setCreditorInterests(2.0);
		assertThat(cuenta.getCreditorInterests(), is(2.0));
	}

	@Test
	public void testDebtorInterestOverNegativeBalance() {
		assertNull(cuenta.getDebtorInterestOverNegativeBalance());
		cuenta.setDebtorInterestOverNegativeBalance(2.0);
		assertThat(cuenta.getDebtorInterestOverNegativeBalance(), is(2.0));
	}

	@Test
	public void testCapitalPerformanceRetention() {
		assertNull(cuenta.getCapitalPerformanceRetention());
		cuenta.setCapitalPerformanceRetention(2.0);;
		assertThat(cuenta.getCapitalPerformanceRetention(), is(2.0));
	}

	@Test
	public void testMaintenanceComission() {
		assertNull(cuenta.getMaintenanceComission());
		cuenta.setMaintenanceComission(2.0);;
		assertThat(cuenta.getMaintenanceComission(), is(2.0));
	}

	@Test
	public void testMaintenanceDeficit() {
		assertNull(cuenta.getMaintenanceDeficit());
		cuenta.setMaintenanceDeficit(2.0);;
		assertThat(cuenta.getMaintenanceDeficit(), is(2.0));
	}

	@Test
	public void testMinMaintenanceDeficit() {
		assertNull(cuenta.getMinMaintenanceDeficit());
		cuenta.setMinMaintenanceDeficit(2.0);;
		assertThat(cuenta.getMinMaintenanceDeficit(), is(2.0));
	}

	@Test
	public void testLiquidationPeriod() {
		assertThat(cuenta.getLiquidationPeriod(), is(0));
		cuenta.setLiquidationPeriod(1);;
		assertThat(cuenta.getLiquidationPeriod(), is(1));
	}

	@Test
	public void testAnnualDays() {
		assertThat(cuenta.getAnnualDays(), is(0));
		cuenta.setAnnualDays(360);;
		assertThat(cuenta.getAnnualDays(), is(360));
	}


}
