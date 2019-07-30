package es.unileon.ulebankoffice.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ItalianTest {

	private Italian italiano;
	private double delta = 0.1;
	private double noDelta = 0.0;

	@Before
    public void setUp() throws Exception {
		italiano = new Italian(35000, 5.0, 4, 2);
    }
	
	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.05, italiano.getInterestRate(), noDelta);
		italiano.setInterestRate(3.25);
		assertEquals(0.0325, italiano.getInterestRate(), noDelta);
	}
	
	@Test
	public void testSetAndGetCapInicial() {
		assertEquals(35000, italiano.getInitialCap(), noDelta);
		italiano.setInitialCap(35500);
		assertEquals(35500, italiano.getInitialCap(), noDelta);
	}
	
	@Test
	public void testSetAndGetPeriodos() {
		assertEquals(4, italiano.getPeriods(), noDelta);
		italiano.setPeriods(3);
		assertEquals(3, italiano.getPeriods(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoPeriodo() {
		assertEquals(2, italiano.getPeriodType(), noDelta);
		italiano.setPeriodType(3);
		assertEquals(3, italiano.getPeriodType(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(4484.38, Double.parseDouble(italiano.calculateTable().get(8).get(1)), delta);
		assertEquals(0, Double.parseDouble(italiano.calculateTable().get(8).get(4)), delta);
	}
}
