package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CreditMovementsTest {

	private CreditMovements movimiento;
	private Date fecha;

	@Before
	public void setUp() throws Exception {
		fecha = new SimpleDateFormat("yy-MM-dd").parse("1994-12-05");
		movimiento = new CreditMovements("descripción", 150d, fecha, "D");
	}

	@Test
	public void testDescripcionMovimiento() {
		assertThat(movimiento.getMovementDescription(), is("descripción"));
		movimiento.setMovementDescription("otraD");
		assertThat(movimiento.getMovementDescription(), is("otraD"));
	}

	@Test
	public void testImporteMovimiento() {
		assertThat(movimiento.getMovementValue(), is(150d));
		movimiento.setMovementValue(2500d);
		assertThat(movimiento.getMovementValue(), is(2500d));
	}

	@Test
	public void testFechaMovimiento() throws ParseException {
		assertThat(movimiento.getMovementDate(), is(fecha));
		movimiento.setMovementDate(new SimpleDateFormat("yy-MM-dd").parse("1995-12-05"));
		assertThat(movimiento.getMovementDate(), is(new SimpleDateFormat("yy-MM-dd").parse("1995-12-05")));
	}

	@Test
	public void testProcesado() {
		assertThat(movimiento.isProcessed(), is(false));
		movimiento.setProcessed(true);
		assertThat(movimiento.isProcessed(), is(true));
	}

	@Test
	public void testOperacion() {
		assertThat(movimiento.getOperation(), is("D"));
		movimiento.setOperation("I");
		assertThat(movimiento.getOperation(), is("I"));
	}

}
