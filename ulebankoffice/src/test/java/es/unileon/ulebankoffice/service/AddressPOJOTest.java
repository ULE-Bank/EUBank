package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AddressPOJOTest {
	
	private AddressPOJO direccion;
	
	@Before
	public void setUp() throws Exception {
		direccion = new AddressPOJO();
	}

	@Test
	public void testStreet() {
		assertNull(direccion.getStreet());
		direccion.setStreet("calle");
		assertThat(direccion.getStreet(), is("calle"));
	}


	@Test
	public void testNumber() {
		assertNull(direccion.getNumber());
		direccion.setNumber("sinNumero");
		assertThat(direccion.getNumber(), is("sinNumero"));
	}

	@Test
	public void testPostalCode() {
		assertNotNull(direccion.getPostalCode());
		assertThat(direccion.getPostalCode(), is(0));
		direccion.setPostalCode(20007);
		assertThat(direccion.getPostalCode(), is(20007));
	}


	@Test
	public void testCity() {
		assertNull(direccion.getCity());
		direccion.setCity("localidad");
		assertThat(direccion.getCity(), is("localidad"));
	}


	@Test
	public void testAutonomousRegion() {
		assertNull(direccion.getAutonomousRegion());
		direccion.setAutonomousRegion("comunidad");
		assertThat(direccion.getAutonomousRegion(), is("comunidad"));
	}

	@Test
	public void testToString() {
		assertThat(direccion.toString(), is("Direccion [calle=null, numero=null, codigoPostal=0, localidad=null, comunidadAutonoma=null]"));
	}

}
