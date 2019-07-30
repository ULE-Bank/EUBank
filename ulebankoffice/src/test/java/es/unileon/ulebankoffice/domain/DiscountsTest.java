package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DiscountsTest {
	
	private Discounts descuentos;
	private double delta = 0.1;
	private double noDelta = 0.0;
	
	@Before
	public void setUp() throws Exception {
		descuentos = new Discounts(300000, 14, 5.25, 360, 0.75, 0.4);
	}
	
	@Test
	public void testSetAndGetImporteDescuento() {
		assertEquals(300000, descuentos.getDiscountValue(), noDelta);
		descuentos.setDiscountValue(13500);
		assertEquals(13500, descuentos.getDiscountValue(), noDelta);
	}
	
	@Test
	public void testSetAndGetPeriodoDescuento() {
		assertEquals(14, descuentos.getDiscountPeriod(), noDelta);
		descuentos.setDiscountPeriod(50);
		assertEquals(50, descuentos.getDiscountPeriod(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(0.0525, descuentos.getInterestRate(), noDelta);
		descuentos.setInterestRate(6.75);
		assertEquals(0.0675, descuentos.getInterestRate(), noDelta);
	}
	
	@Test
	public void testSetAndGetOtrosGastos() {
		assertEquals(0.75, descuentos.getOtherExpenses(), noDelta);
		descuentos.setOtherExpenses(600);
		assertEquals(600, descuentos.getOtherExpenses(), noDelta);
	}
	
	@Test
	public void testSetAndGetComisiones() {
		assertEquals(0.004, descuentos.getComissions(), noDelta);
		descuentos.setComissions(15);
		assertEquals(0.015, descuentos.getComissions(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(298186.75, Double.parseDouble(descuentos.calculateTable().get(0).get(3)), delta);
	}
}
