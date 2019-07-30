package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class SolicitudTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");
	
	@Autowired
	private DocumentoRepository repo;

	private Solicitud solicitud;
	private static Date fechaApertura;
	private static Date fechaResolucion;
	
	@BeforeClass
	public static void beforeClass(){
		Calendar fecha = new GregorianCalendar(2017, 04, 23);
		fechaApertura = fecha.getTime(); 
		fecha = new GregorianCalendar(2017, 04, 24);
		fechaResolucion = fecha.getTime();
	}
	
	@After
	public void afterEachTest(){
		repo.deleteAll();
	}
	
	@Before
	public void setUp() throws Exception {
		solicitud = new Solicitud("cerrada", fechaApertura, fechaResolucion,"productoID");
	}

	@Test
	public void testSolicitudDomain() {
		assertThat(solicitud.getEstado(), is("cerrada"));
		assertThat(solicitud.getProductId(), is("productoID"));
	}

	@Test
	public void testSetEstado() {
		solicitud.setEstado("resuelta");
		assertThat(solicitud.getEstado(), is("resuelta"));
	}

	@Test
	public void testGetFechaApertura() {
		assertThat(solicitud.getFechaApertura().equals(fechaApertura), is(true));
	}

	@Test
	public void testSetFechaApertura() {
		Calendar fecha = new GregorianCalendar(2017, 12, 05);
		solicitud.setFechaApertura(fecha.getTime());
		assertThat(solicitud.getFechaApertura().equals(fechaApertura), is(not(true)));
		Calendar fechaAux = new GregorianCalendar(2017, 12, 05);
		assertThat(solicitud.getFechaApertura().equals(fechaAux.getTime()), is(true));
	}

	@Test
	public void testGetFechaResolucion() {
		assertThat(solicitud.getFechaResolucion().equals(fechaResolucion), is(true));
	}

	@Test
	public void testSetFechaResolucion() {
		Calendar fecha = new GregorianCalendar(2017, 12, 05);
		solicitud.setFechaResolucion(fecha.getTime());
		assertThat(solicitud.getFechaResolucion().equals(fechaResolucion), is(not(true)));
		Calendar fechaAux = new GregorianCalendar(2017, 12, 05);
		assertThat(solicitud.getFechaResolucion().equals(fechaAux.getTime()), is(true));
	}

	@Test
	public void testSetProductId() {
		assertThat(solicitud.getProductId(), is("productoID"));
		solicitud.setProductId("anotherProduct");
		assertThat(solicitud.getProductId(), is("anotherProduct"));
	}
	
	@Test
	public void testAddDocument() throws EmptyCollectionException{

		Documentos docus = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(docus, "repo", repo);
		
		ReflectionTestUtils.setField(solicitud, "documentos", docus);
		
		assertThat(solicitud.getDocumentos().size(), is(0));
		solicitud.addDocument(new DocumentoAdjunto("ruta11", "name11"));
		assertThat(solicitud.getDocumentos().size(), is(1));
		assertThat(solicitud.getDocumentos().get(0).getName(), is("name11"));
	}
	
	@Test
	public void getDocumentos() throws EmptyCollectionException{

		Documentos docus = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(docus, "repo", repo);
		
		ReflectionTestUtils.setField(solicitud, "documentos", docus);
		
		assertThat(solicitud.getDocumentos().size(), is(0));
		solicitud.addDocument(new DocumentoAdjunto("ruta11", "name11"));
		solicitud.addDocument(new DocumentoAdjunto("ruta12", "name11"));
		solicitud.addDocument(new DocumentoAdjunto("ruta13", "name11"));
		solicitud.addDocument(new DocumentoAdjunto("ruta14", "name11"));
		solicitud.addDocument(new DocumentoAdjunto("ruta15", "name11"));
		assertThat(solicitud.getDocumentos().size(), is(5));
		assertThat(solicitud.getDocumentos().get(0).getName(), is("name11"));
	}
	
	@Test
	public void testToString(){	
		assertThat(solicitud.toString().contains("estado=cerrada"), is(true));
		assertThat(solicitud.toString().contains("productId=productoID"), is(true));
	}

}
