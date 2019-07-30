package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FinancialLeasingTest {
	
	private FinancialLeasing arrendamientoFinanciero;
	private double delta = 0.1;
	private double noDelta = 0.0;
	
	@Before
	public void setUp() throws Exception {
		arrendamientoFinanciero = new FinancialLeasing(50000, 5, 2, 10);
	}

	@Test
	public void testSetAndGetValorBien() {
		assertEquals(50000, arrendamientoFinanciero.getPropertyValue(), noDelta);
		arrendamientoFinanciero.setPropertyValue(15000);
		assertEquals(15000, arrendamientoFinanciero.getPropertyValue(), noDelta);
	}
	
	@Test
	public void testSetAndGetDuracionContrato() {
		assertEquals(5, arrendamientoFinanciero.getContractDuration(), noDelta);
		arrendamientoFinanciero.setContractDuration(4);
		assertEquals(4, arrendamientoFinanciero.getContractDuration(), noDelta);
	}
	
	@Test
	public void testSetAndGetFraccionamientoPagoCuota() {
		assertEquals(2, arrendamientoFinanciero.getFeePaymentDivision(), noDelta);
		arrendamientoFinanciero.setFeePaymentDivision(3);
		assertEquals(3, arrendamientoFinanciero.getFeePaymentDivision(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.10, arrendamientoFinanciero.getInterestRate(), noDelta);
		arrendamientoFinanciero.setInterestRate(15);
		assertEquals(0.15, arrendamientoFinanciero.getInterestRate(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(5732.80, Double.parseDouble(arrendamientoFinanciero.calculateTable().get(10).get(1)), delta);
		assertEquals(0.0, Double.parseDouble(arrendamientoFinanciero.calculateTable().get(10).get(4)), delta);
	}
}
