package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.repository.DocumentoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class ClientTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");
	
	@Autowired
	private DocumentoRepository repo;

	private Client cliente;
	private List<Address> direcciones;
	
	@Before
	public void setUp() throws Exception {
			
		cliente = new Client("Razvan", "Raducu", "rraduc00@estudiantes.unileon.es", "1994-12-05", "x5526828C",  "español", new Date());
	}
	
	@After
	public void afterEachTest(){
		repo.deleteAll();
	}

	@Test
	public void testGetName() {
		assertThat(cliente.getName(), is("Razvan"));
	}

	@Test
	public void testSetName() {
		cliente.setName("Razvan2");
		assertThat(cliente.getName(), is("Razvan2"));
	}

	@Test
	public void testGetLastname() {
		assertThat(cliente.getLastName(), is("Raducu"));
	}

	@Test
	public void testSetLastname() {
		cliente.setLastName("Raducu2");
		assertThat(cliente.getLastName(), is("Raducu2"));
	}

	@Test
	public void testGetEmail() {
		assertThat(cliente.getEmail(), is("rraduc00@estudiantes.unileon.es"));
	}

	@Test
	public void testSetEmail() {
		cliente.setEmail("r@s.unileon.es");
		assertThat(cliente.getEmail(), is("r@s.unileon.es"));
	}

	@Test
	public void testGetFechaNacimiento() {
		/*
		 * ATENCIÓN: Los meses en java se numeran en índice 0, es decir, de 0 - Enero a 11 - Diciembre
		 */
		Calendar fecha = new GregorianCalendar(1994, 11, 05);
		assertThat(cliente.getBirthDate(), is(fecha.getTime()));
	}

	@Test
	public void testGetDni() {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testSetDniString() throws DNIException {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
		cliente.setDni("61380818M");
		assertThat(cliente.getDni().toString(), is("61380818M"));
	}

	@Test
	public void testSetDniHandler() throws DNIException {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
		cliente.setDni(new DNIHandler("61380818M"));
		assertThat(cliente.getDni().toString(), is("61380818M"));

	}

	@Test
	public void testGetNacionalidad() {
		assertThat(cliente.getCitizenship(), is("español"));
	}

	@Test
	public void testSetNacionalidad() {
		assertThat(cliente.getCitizenship(), is("español"));
		cliente.setCitizenship("espaniol");
		assertThat(cliente.getCitizenship(), is("espaniol"));
	}

	@Test
	public void testGetFechaDeAlta() {
		Calendar fecha = new GregorianCalendar(1994, 12, 05);
		cliente.setEntryDate(fecha.getTime());
		assertThat(cliente.getEntryDate().getTime(), is(fecha.getTime().getTime()));
	}
	
	@Test
	public void testAddDocumento() throws EmptyCollectionException{
		
		Documentos docus = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(docus, "repo", repo);
		
		ReflectionTestUtils.setField(cliente, "documents", docus);
		
		assertThat(cliente.getDocuments().size(), is(0));
		cliente.addDocument(new DocumentoAdjunto("ruta11", "name11"));
		assertThat(cliente.getDocuments().size(), is(1));
		assertThat(cliente.getDocuments().get(0).getName(), is("name11"));
		
		
	}
	
	@Test
	public void getDocumentos() throws EmptyCollectionException{

		Documentos docus = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(docus, "repo", repo);
		
		ReflectionTestUtils.setField(cliente, "documents", docus);
		
		assertThat(cliente.getDocuments().size(), is(0));
		cliente.addDocument(new DocumentoAdjunto("ruta11", "name11"));
		cliente.addDocument(new DocumentoAdjunto("ruta12", "name11"));
		cliente.addDocument(new DocumentoAdjunto("ruta13", "name11"));
		cliente.addDocument(new DocumentoAdjunto("ruta14", "name11"));
		cliente.addDocument(new DocumentoAdjunto("ruta15", "name11"));
		assertThat(cliente.getDocuments().size(), is(5));
		assertThat(cliente.getDocuments().get(0).getName(), is("name11"));
	}
	
	@Test
	public void testToString(){
		assertThat(cliente.toString().contains("name=Razvan"), is(true));
		assertThat(cliente.toString().contains("lastname=Raducu"), is(true));
		assertThat(cliente.toString().contains("email=rraduc00@estudiantes.unileon.es"), is(true));
		assertThat(cliente.toString().contains("nacionalidad=español"), is(true));
		assertThat(cliente.toString().contains("dni=X5526828C"), is(true));
	}
	
	@Test
	public void testGetId(){
		assertNull(cliente.getId());
	}

}
