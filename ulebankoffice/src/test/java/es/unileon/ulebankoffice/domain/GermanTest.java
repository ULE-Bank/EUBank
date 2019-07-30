package es.unileon.ulebankoffice.domain;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GermanTest {
	
	private German aleman;
	private double delta = 0.1;
	private double noDelta = 0.0;
	private double miniDelta = 0.0001;
	
	@Before
    public void setUp() throws Exception {
        aleman = new German(100000, 8, 10, 1);
    }
	
	@Test
	public void testSetAndGetTipoInteres() {
		assertEquals(100000, aleman.getInitialCap(), noDelta);
		aleman.setInitialCap(50000);
		assertEquals(50000, aleman.getInitialCap(), noDelta);
	}
	
	@Test
	public void testSetAndGetCapInicial() {
		assertEquals(0.08, aleman.getInterestRate(), noDelta);
		aleman.setInterestRate(5.2);
		assertEquals(0.052, aleman.getInterestRate(), miniDelta);
	}
	
	@Test
	public void testSetAndGetPeriodos() {
		assertEquals(10, aleman.getPeriods(), noDelta);
		aleman.setPeriods(8);
		assertEquals(8, aleman.getPeriods(), noDelta);
	}
	
	@Test
	public void testSetAndGetTipoPeriodo() {
		assertEquals(1, aleman.getPeriodType(), noDelta);
		aleman.setPeriodType(4);
		assertEquals(4, aleman.getPeriodType(), noDelta);
	}
	
	@Test
	public void testCalcular() {
		assertEquals(14143.98, Double.parseDouble(aleman.calculateTable().get(10).get(1)), delta);
		assertEquals(0, Double.parseDouble(aleman.calculateTable().get(10).get(4)), delta);
	}
	
	@Test
	public void testGetTableHeader(){
		List <String> header = aleman.getTableHeader();
		assertThat(header, containsInAnyOrder("Capital pendiente","Periodo","Anualidad","Interés","Amortización"));
	}
}
