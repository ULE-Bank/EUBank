package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class CurrentAccountMovementTest {
	
	private CurrentAccountMovement movimiento;
	private Calendar fecha;

	@Before
	public void setUp() throws Exception {
		fecha = new GregorianCalendar(2017, 04, 23);
		movimiento = new CurrentAccountMovement(150.00, "Ingreso", fecha.getTime(), "I");
	}
	
	@Test
	public void emptyConstructor(){
		movimiento = new CurrentAccountMovement();
		assertNull(movimiento.getConcept());
	}

	@Test
	public void testMovimientoCuentaCorrienteDomain() {
		assertThat(movimiento.getValue(), is(150d));
	}

	@Test
	public void testGetConcepto() {
		assertThat(movimiento.getConcept(), is("Ingreso"));
	}
	
	@Test
	public void testSetConcepto(){
		assertThat(movimiento.getConcept(), is("Ingreso"));
		movimiento.setConcept("Extracto");
		assertThat(movimiento.getConcept(), is("Extracto"));
	}

	@Test
	public void testGetFechaValor() {
		assertThat(movimiento.getValueDate().getTime(), is(fecha.getTime().getTime()));
	}
	
	@Test 
	public void testSetFechaValor(){
		assertThat(movimiento.getValueDate().getTime(), is(fecha.getTime().getTime()));
		movimiento.setValueDate(new Date());
		assertThat(movimiento.getValueDate().getTime(), is(not(fecha.getTime().getTime())));
		
	}
	
	@Test
	public void testGetImporte(){
		assertThat(movimiento.getValue(), is(150d));
	}
	
	@Test
	public void testSetImporte(){
		assertThat(movimiento.getValue(), is(150d));
		movimiento.setValue(150000d);
		assertThat(movimiento.getValue(), is(150000d));
	}
	
	@Test
	public void testGetOperacion(){
		assertThat(movimiento.getOperation(), is("I"));
	}
	
	@Test
	public void testSetOperacion(){
		assertThat(movimiento.getOperation(), is("I"));
		movimiento.setOperation("D");
		assertThat(movimiento.getOperation(), is("D"));
	}

}
