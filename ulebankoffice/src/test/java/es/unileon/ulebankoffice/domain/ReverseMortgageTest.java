package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReverseMortgageTest {
	
	private ReverseMortgage hipotecaInversa;
	private double delta = 0.1;
	private double noDelta = 0.0;
	
	@Before
	public void setUp() throws Exception {
		hipotecaInversa = new ReverseMortgage(260000, 75, 70, 4.70, 0.50, 3.15, 300, 3871);
	}

	@Test
	public void testSetAndGetValorTasacion() {
		assertEquals(260000, hipotecaInversa.getValueValuation(), noDelta);
		hipotecaInversa.setValueValuation(158000);
		assertEquals(158000, hipotecaInversa.getValueValuation(), noDelta);
	}
	
	@Test
	public void testSetAndGetEdad() {
		assertEquals(75, hipotecaInversa.getAge());
		hipotecaInversa.setAge(72);
		assertEquals(72, hipotecaInversa.getAge());
	}
	
	@Test
	public void testSetAndGetPorcentajeSobreTasacion() {
		assertEquals(0.7, hipotecaInversa.getPercentageOverValuation(), noDelta);
		hipotecaInversa.setPercentageOverValuation(64);
		assertEquals(0.64, hipotecaInversa.getPercentageOverValuation(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoInteresPrestamo() {
		assertEquals(0.047, hipotecaInversa.getInterestLoanRate(), delta);
		hipotecaInversa.setInterestLoanRate(3.90);
		assertEquals(0.039, hipotecaInversa.getInterestLoanRate(), delta);
	}
	
	@Test
	public void testSetAndGetComisionApertura() {
		assertEquals(0.005, hipotecaInversa.getOpeningComission(), delta);
		hipotecaInversa.setOpeningComission(0.62);
		assertEquals(0.0062, hipotecaInversa.getOpeningComission(), delta);
	}
	
	@Test
	public void testSetAndGetRentabilidadRenta() {
		assertEquals(0.0315, hipotecaInversa.getRentProfitability(), delta);
		hipotecaInversa.setRentProfitability(2.95);
		assertEquals(0.0295, hipotecaInversa.getRentProfitability(), delta);
	}
	
	@Test
	public void testSetAndGetCosteTasacion() {
		assertEquals(300, hipotecaInversa.getValuationCost(), noDelta);
		hipotecaInversa.setValuationCost(295);
		assertEquals(295, hipotecaInversa.getValuationCost(), noDelta);
	}
	
	@Test
	public void testSetAndGetGastosFormalizacion() {
		assertEquals(3871, hipotecaInversa.getFormalizationExpenses(), noDelta);
		hipotecaInversa.setFormalizationExpenses(3658);
		assertEquals(3658, hipotecaInversa.getFormalizationExpenses(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(535.60, Double.parseDouble(hipotecaInversa.calculateTable().get(0).get(4)), delta);
	}
}