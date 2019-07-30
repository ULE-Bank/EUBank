package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TAETest {
	
	private TAE tae;
	private double delta = 0.01;
	private double noDelta = 0.0;
	
	@Before
    public void setUp() throws Exception {
        tae = new TAE(5.0, 2);
    }

	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.05, tae.getTipoInteres(), noDelta);
		tae.setTipoInteres(3.25);
		assertEquals(0.0325, tae.getTipoInteres(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoPeriodo() {
		assertEquals(2, tae.getTipoPeriodo(), noDelta);
		tae.setTipoPeriodo(3);
		assertEquals(3, tae.getTipoPeriodo(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals("5.06 %", tae.calcularTabla().get(0).get(2));
	}
}
