package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	private Address direccion;

	@Before
	public void setUp() throws Exception {
		direccion = new Address("X5526828c", "calleEjemplo", "León", "Castilla y León", 24195, "s/N");
	}

	@Test
	public void testDireccionDomainStringStringStringStringIntString() {
		assertThat(direccion.getStreet(), is("calleEjemplo"));
		assertThat(direccion.getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testDireccionDomainStringStringStringStringHandlerInt() throws DNIException {
		Handler dni = new DNIHandler("x5526828c");
		direccion = new Address("calleEjemplo", "León", "Castilla y León", "s/N", dni, 24195);
		assertThat(direccion.getDni().toString(), is("X5526828C"));
		assertThat(direccion.getAutonomousRegion(), is("Castilla y León"));
		assertThat(direccion.getPostalCode(), is(24195));
	}

	@Test
	public void testGetCalle() {
		assertThat(direccion.getStreet(), is("calleEjemplo"));
	}

	@Test
	public void testSetCalle() {
		direccion.setStreet("nuevaCalle");
		assertThat(direccion.getStreet(), is("nuevaCalle"));
	}

	@Test
	public void testGetLocalidad() {
		assertThat(direccion.getCity(), is("León"));
	}

	@Test
	public void testSetLocalidad() {
		direccion.setCity("VillaLeón");
		assertThat(direccion.getCity(), is("VillaLeón"));
	}

	@Test
	public void testGetComunidadAutonoma() {
		assertThat(direccion.getAutonomousRegion(), is("Castilla y León"));
	}

	@Test
	public void testSetComunidadAutonoma() {
		direccion.setAutonomousRegion("CastillaLeón");
		assertThat(direccion.getAutonomousRegion(), is("CastillaLeón"));
	}

	@Test
	public void testGetNumero() {
		assertThat(direccion.getNumber(), is("s/N"));
	}

	@Test
	public void testSetNumero() {
		direccion.setNumber("5");
		assertThat(direccion.getNumber(), is("5"));
	}

	@Test
	public void testGetDni() {
		assertThat(direccion.getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testSetDniHandler() throws DNIException {
		assertThat(direccion.getDni().toString(), is("X5526828C"));
		Handler dni = new DNIHandler("Y9983055B");
		direccion.setDni(dni);
		assertThat(direccion.getDni().toString(), is("Y9983055B"));
	}

	@Test
	public void testSetDniString() throws DNIException {
		assertThat(direccion.getDni().toString(), is("X5526828C"));
		direccion.setDni("Y9983055B");
		assertThat(direccion.getDni().toString(), is("Y9983055B"));
	}

	@Test
	public void testGetCodigoPostal() {
		assertThat(direccion.getPostalCode(), is(24195));
	}

	@Test
	public void testSetCodigoPostal() {
		direccion.setPostalCode(39400);
		assertThat(direccion.getPostalCode(), is(39400));
	}
	
	@Test
	public void testGetId(){
		assertNull(direccion.getId());
	}

	@Test
	public void testToString() {
		assertThat(direccion.toString(), is(
				"DireccionDomain [id=null, calle=calleEjemplo, "
				+ "localidad=León, comunidadAutonoma=Castilla y León, "
				+ "numero=s/N, dni=X5526828C, codigoPostal=24195]"));
	}

}
