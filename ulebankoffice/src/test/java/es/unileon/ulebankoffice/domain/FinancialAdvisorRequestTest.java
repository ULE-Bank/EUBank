package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FinancialAdvisorRequestTest {
	
	private FinancialAdvisorRequest solicitud;
	
	@Before
	public void setUp() throws Exception {
		solicitud = new FinancialAdvisorRequest();
	}

	@Test
	public void testOfferText() {
		assertNull(solicitud.getOfferText());
		solicitud.setOfferText("texto");
		assertThat(solicitud.getOfferText(), is("texto"));
	}


	@Test
	public void testOfferUrl() {
		assertNull(solicitud.getOfferUrl());
		solicitud.setOfferUrl("ruta");
		assertThat(solicitud.getOfferUrl(), is("ruta"));
	}
	
	@Test
	public void testStatus(){
		assertNull(solicitud.getStatus());
		solicitud.setStatus("abierta");
		assertThat(solicitud.getStatus(), is("abierta"));
	}
	
	@Test
	public void testEmail() {
		assertNull(solicitud.getEmail());
		solicitud.setEmail("email");
		assertThat(solicitud.getEmail(), is("email"));
	}

	@Test
	public void testFileKey() {
		assertNull(solicitud.getFileBlobKey());
		solicitud.setFileBlobKey("blob");;
		assertThat(solicitud.getFileBlobKey(), is("blob"));
	}

	@Test
	public void testGetId() {
		assertNull(solicitud.getId());
	}

	@Test
	public void testOfferMatter() {
		assertNull(solicitud.getOfferMatter());
		solicitud.setOfferMatter("asunto");
		assertThat(solicitud.getOfferMatter(), is("asunto"));
	}

	@Test
	public void testOfferResponse() {
		assertNull(solicitud.getOfferResponse());
		solicitud.setOfferResponse("respuesta");;
		assertThat(solicitud.getOfferResponse(), is("respuesta"));
	}

	@Test
	public void testCreationDate() {
		assertNull(solicitud.getCreationDate());
		solicitud.setCreationDate("fecha");;
		assertThat(solicitud.getCreationDate(), is("fecha"));
	}

}
