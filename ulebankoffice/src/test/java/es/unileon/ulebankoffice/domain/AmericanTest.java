package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AmericanTest {
	
	private American americano;
	private double delta = 0.1;
	private double noDelta = 0.0;
	
	@Before
	public void setUp() throws Exception {
		americano = new American(50000, 10, 5, 2);
	}
	
	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.10, americano.getInterestRate(), noDelta);
		americano.setInterestRate(3.25);
		assertEquals(0.0325, americano.getInterestRate(), noDelta);
	}
	
	@Test
	public void testSetAndGetCapInicial() {
		assertEquals(50000, americano.getInitialCap(), noDelta);
		americano.setInitialCap(5000);
		assertEquals(5000, americano.getInitialCap(), noDelta);
	}
	
	@Test
	public void testSetAndGetPeriodos() {
		assertEquals(5, americano.getPeriods(), noDelta);
		americano.setPeriods(3);
		assertEquals(3, americano.getPeriods(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoPeriodo() {
		assertEquals(2, americano.getPeriodType(), noDelta);
		americano.setPeriodType(6);
		assertEquals(6, americano.getPeriodType(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(52500, Double.parseDouble(americano.calculateTable().get(10).get(1)), delta);
	}
}
