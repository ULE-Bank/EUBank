package es.unileon.ulebankoffice.domain;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class DocumentoAdjuntoTest {
	
	private DocumentoAdjunto documento;
	private Calendar fecha = new GregorianCalendar(1994, 12, 05);
	
	@Before
	public void setUp() throws Exception {
		
		documento = new DocumentoAdjunto("rutaEjemplo", "nombreEjemplo", fecha.getTime());
	}

	@Test
	public void testDocumentoAdjuntoDomainStringStringDate() {
		assertThat(documento.getRuta(), is("rutaEjemplo"));
		assertThat(documento.getName(), is("nombreEjemplo"));
		assertThat(documento.getFechaCreacion().getTime(), is(fecha.getTime().getTime()));
	}

	@Test
	public void testDocumentoAdjuntoDomainStringString() {
		documento = new DocumentoAdjunto("ruta","nombre");
		assertThat(documento.getFechaCreacion(), isA(Date.class));
		assertNotNull(documento.getFechaCreacion().getTime());
		assertThat((double)documento.getFechaCreacion().getTime(), closeTo(new Date().getTime(), 10.0));
	}

	@Test
	public void testSetRuta() {
		assertThat(documento.getRuta(), is("rutaEjemplo"));
		documento.setRuta("otraruta");
		assertThat(documento.getRuta(), is("otraruta"));
	}

	@Test
	public void testSetName() {
		assertThat(documento.getName(), is("nombreEjemplo"));
		documento.setName("name");
		assertThat(documento.getName(), is("name"));
	}

	@Test
	public void testToString() {
		assertThat(documento.toString(), is("DocumentoAdjuntoDomain [ruta=rutaEjemplo, name=nombreEjemplo, fechaCreacion="+fecha.getTime().toString()+"]"));
	}

}
