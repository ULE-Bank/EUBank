package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrenchTest {
	
	private French frances;
	private double delta = 0.1;
	private double noDelta = 0.0;

	@Before
    public void setUp() throws Exception {
        frances = new French(5.0, 35000, 4, 2);
    }

	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.05, frances.getInterestRate(), noDelta);
		frances.setInterestRate(3.25);
		assertEquals(0.0325, frances.getInterestRate(), noDelta);
	}
	
	@Test
	public void testSetAndGetCapInicial() {
		assertEquals(35000, frances.getInitialCap(), noDelta);
		frances.setInitialCap(35500);
		assertEquals(35500, frances.getInitialCap(), noDelta);
	}
	
	@Test
	public void testSetAndGetPeriodos() {
		assertEquals(4, frances.getPeriods(), noDelta);
		frances.setPeriods(3);
		assertEquals(3, frances.getPeriods(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoPeriodo() {
		assertEquals(2, frances.getPeriodType(), noDelta);
		frances.setPeriodType(3);
		assertEquals(3, frances.getPeriodType(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(4881.36, Double.parseDouble(frances.calcularTabla().get(8).get(1)), delta);
		assertEquals(0, Double.parseDouble(frances.calcularTabla().get(8).get(4)), delta);
	}
}
