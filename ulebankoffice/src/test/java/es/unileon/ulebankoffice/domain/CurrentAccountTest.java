package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class CurrentAccountTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");
	
	@Autowired
	private DocumentoRepository repo;
	
	private CurrentAccount cuenta;
	private SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");

	@Before
	public void setUp() throws Exception {
		cuenta = new CurrentAccount(df.parse("2017-03-01"), 1d, 23d, 20d, 25d, 3d, 50d, df.parse("2017-03-01"),
				150d, 0.0, "activa", new DNIHandler("x5526828C"), 360, 4);
		cuenta.setMovementes(new ArrayList<CurrentAccountMovement>());
		cuenta.addMovement(new CurrentAccountMovement(100d, "Apertura cuenta", df.parse("2017-03-01"), "I"));
		cuenta.addMovement(new CurrentAccountMovement(1200d, "Nómina", df.parse("2017-03-30"), "I"));
		cuenta.addMovement(
				new CurrentAccountMovement(720d, "Tarjeta de crédito", df.parse("2017-03-31"), "D"));
		cuenta.addMovement(new CurrentAccountMovement(600d, "Recibo hipoteca", df.parse("2017-04-02"), "D"));
		cuenta.addMovement(new CurrentAccountMovement(1200d, "Nómina", df.parse("2017-04-30"), "I"));
		cuenta.addMovement(new CurrentAccountMovement(300d, "Ingreso IRPF", df.parse("2017-06-18"), "I"));
	}
	
	@After
	public void afterEachTest(){
		repo.deleteAll();
	}

	@Test
	public void testCuentaCorrienteDomainDateDoubleDoubleDoubleDoubleDoubleDoubleDateDateDateDoubleStringHandlerListOfMovimientoCuentaCorrienteDomainDocumentosIntInt() throws ParseException, DNIException {
		List <CurrentAccountMovement> listaMovimientos = new ArrayList<>();
		listaMovimientos.add(new CurrentAccountMovement(100d, "Apertura cuenta", df.parse("2017-03-01"), "I"));
		listaMovimientos.add(new CurrentAccountMovement(1200d, "Nómina", df.parse("2017-03-30"), "I"));
		listaMovimientos.add(new CurrentAccountMovement(720d, "Tarjeta de crédito", df.parse("2017-03-31"), "D"));
		listaMovimientos.add(new CurrentAccountMovement(600d, "Recibo hipoteca", df.parse("2017-04-02"), "D"));
		listaMovimientos.add(new CurrentAccountMovement(1200d, "Nómina", df.parse("2017-04-30"), "I"));
		listaMovimientos.add(new CurrentAccountMovement(300d, "Ingreso IRPF", df.parse("2017-06-18"), "I"));
		
		cuenta = new CurrentAccount(df.parse("2017-03-01"), 1d, 23d, 20d, 25d, 3d, 50d, df.parse("2017-03-01"), null, null, 150d, 0.0, "activa", new DNIHandler("x5526828C"), listaMovimientos, new Documentos(new ArrayList<String>()), 360, 4);
		
		assertThat(cuenta.getStatus(), is("activa"));
		assertThat(cuenta.getDni().toString(), is("X5526828C"));
		
	}

	@Test
	public void testRealizarLiquidacion() throws ParseException {
		assertThat(cuenta.getMovements().size(), is(6));
		List<List<String>> resultado = cuenta.makeLiquidation(df.parse("2017-03-01"), df.parse("2017-06-30"), true);
		assertThat(resultado.get(resultado.size() - 1).get(3), is("73,56€"));
		assertThat(resultado.get(resultado.size() - 1).get(4), is("1.406,44€"));
		assertThat(resultado.get(resultado.size() - 1).get(5), is("121"));
	}

	@Test
	public void testGetFechaSolicitud() throws ParseException {
		assertThat(cuenta.getApplicationDate(), is(df.parse("2017-03-01")));
	}

	@Test
	public void testSetFechaSolicitud() throws ParseException {
		assertThat(cuenta.getApplicationDate(), is(df.parse("2017-03-01")));
		cuenta.setApplicationDate(df.parse("1994-12-05"));
		assertThat(cuenta.getApplicationDate(), is(df.parse("1994-12-05")));
	}

	@Test
	public void testGetFechaResolucion() {
		assertNull(cuenta.getResolutionDate());
	}

	@Test
	public void testSetFechaResolucion() throws ParseException {
		assertNull(cuenta.getResolutionDate());
		cuenta.setResolutionDate(df.parse("1994-12-05"));
		assertThat(cuenta.getResolutionDate(), is(df.parse("1994-12-05")));
	}

	@Test
	public void testGetFechaFinalizacion() {
		assertNull(cuenta.getFinalizationDate());
	}

	@Test
	public void testSetFechaFinalizacion() throws ParseException {
		assertNull(cuenta.getFinalizationDate());
		cuenta.setFinalizationDate(df.parse("1994-12-05"));
		assertThat(cuenta.getFinalizationDate(), is(df.parse("1994-12-05")));
	}

	@Test
	public void testGetSaldo() {
assertThat(cuenta.getTotalBalance(), is(150d));
	}

	@Test
	public void testSetSaldo() {
		assertThat(cuenta.getTotalBalance(), is(150d));
		cuenta.setTotalBalance(150150d);
		assertThat(cuenta.getTotalBalance(), is(150150d));
	}

	@Test
	public void testGetEstado() {
		assertThat(cuenta.getStatus(), is("activa"));
	}

	@Test
	public void testSetEstado() {
		assertThat(cuenta.getStatus(), is("activa"));
		cuenta.setStatus("congeladaPorElFBI");
		assertThat(cuenta.getStatus(), is("congeladaPorElFBI"));
	}

	@Test
	public void testGetDni() {
		assertThat(cuenta.getDni(), isA(Handler.class));
		assertThat(cuenta.getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testSetDni() throws DNIException {
		assertThat(cuenta.getDni(), isA(Handler.class));
		assertThat(cuenta.getDni().toString(), is("X5526828C"));
		cuenta.setDni(new DNIHandler("41914614N"));
		assertThat(cuenta.getDni().toString(), is("41914614N"));
	}

	@Test
	public void testGetMovimientos() {
		assertThat(cuenta.getMovements().size(), is(6));

	}

	@Test
	public void testSetMovimientos() {
		assertThat(cuenta.getMovements().size(), is(6));
		cuenta.setMovementes(null);
		assertNull(cuenta.getMovements());
	}

	@Test
	public void testIngresarSaldo() {
		assertThat(cuenta.getTotalBalance(), is(150d));
		cuenta.depositBalance(150d);
		assertThat(cuenta.getTotalBalance(), is(300d));
	}

	@Test
	public void testExtraerSaldo() {
		assertThat(cuenta.getTotalBalance(), is(150d));
		cuenta.extractBalance(150d);
		assertThat(cuenta.getTotalBalance(), is(0.0));
	}

	@Test
	public void testAddMovimiento() throws ParseException {
		assertThat(cuenta.getMovements().size(), is(6));
		cuenta.addMovement(new CurrentAccountMovement(1200d, "Nómina", df.parse("2017-03-30"), "I"));
		assertThat(cuenta.getMovements().size(), is(7));
	}

	@Test
	public void testAddDocumento() throws EmptyCollectionException {
		Documentos documentos = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(documentos, "repo", repo);
		
		ReflectionTestUtils.setField(cuenta, "documents", documentos);
		
		assertThat(cuenta.getDocuments().size(), is(0));
		cuenta.addDocument(new DocumentoAdjunto("ruta", "name"));
		assertThat(cuenta.getDocuments().size(), is(1));
		
	}

	@Test
	public void testGetDocumentos() throws EmptyCollectionException {
		Documentos documentos = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(documentos, "repo", repo);
		
		ReflectionTestUtils.setField(cuenta, "documents", documentos);
		
		assertThat(cuenta.getDocuments().size(), is(0));
		
	}

	@Test
	public void testGetFechaApertura() throws ParseException {
		assertThat(cuenta.getOpeningDate(), is(df.parse("2017-03-01")));
	}

	@Test
	public void testSetFechaApertura() throws ParseException {
		assertThat(cuenta.getOpeningDate(), is(df.parse("2017-03-01")));
		cuenta.setOpeningDate(df.parse("2017-03-02"));
		assertThat(cuenta.getOpeningDate(), is(df.parse("2017-03-02")));
	}

	@Test
	public void testGetInteresesAcreedores() {
		assertThat(cuenta.getCreditorInterests(), is(1d));
	}

	@Test
	public void testSetInteresesAcreedores() {
		assertThat(cuenta.getCreditorInterests(), is(1d));
		cuenta.setCreditorInterests(2d);
		assertThat(cuenta.getCreditorInterests(), is(2d));
	}

	@Test
	public void testGetInteresDeudorSobreSaldosNegativos() {
		assertThat(cuenta.getDebtorInterestOverNegativeBalance(), is(23d));
	}

	@Test
	public void testSetInteresDeudorSobreSaldosNegativos() {
		assertThat(cuenta.getDebtorInterestOverNegativeBalance(), is(23d));
		cuenta.setDebtorInterestOverNegativeBalance(24d);
		assertThat(cuenta.getDebtorInterestOverNegativeBalance(), is(24d));
	}

	@Test
	public void testGetRetencionRendimientosCapital() {
		assertThat(cuenta.getCapitalPerformanceRetention(), is(20d));
	}

	@Test
	public void testSetRetencionRendimientosCapital() {
		assertThat(cuenta.getCapitalPerformanceRetention(), is(20d));
		cuenta.setCapitalPerformanceRetention(1850d);
		assertThat(cuenta.getCapitalPerformanceRetention(), is(1850d));
	}

	@Test
	public void testGetComisionMantenimiento() {
		assertThat(cuenta.getMaintenanceComission(), is(25d));
	}

	@Test
	public void testSetComisionMantenimiento() {
		assertThat(cuenta.getMaintenanceComission(), is(25d));
		cuenta.setMaintenanceComission(250d);
		assertThat(cuenta.getMaintenanceComission(), is(250d));
	}

	@Test
	public void testGetComisionDescubierto() {
		assertThat(cuenta.getMaintenanceDeficit(), is(3d));
	}

	@Test
	public void testSetComisionDescubierto() {
		assertThat(cuenta.getMaintenanceDeficit(), is(3d));
		cuenta.setMaintenanceDeficit(201d);
		assertThat(cuenta.getMaintenanceDeficit(), is(201d));
	}

	@Test
	public void testGetMinimoComisionDescubierto() {
		assertThat(cuenta.getMinMaintenanceDeficit(), is(50d));
	}

	@Test
	public void testSetMinimoComisionDescubierto() {
		assertThat(cuenta.getMinMaintenanceDeficit(), is(50d));
		cuenta.setMinMaintenanceDeficit(55d);
		assertThat(cuenta.getMinMaintenanceDeficit(), is(55d));
	}

	@Test
	public void testGetDiasAnuales() {
		assertThat(cuenta.getAnnualDays(), is(360));
	}

	@Test
	public void testSetDiasAnuales() {
		assertThat(cuenta.getAnnualDays(), is(360));
		cuenta.setAnnualDays(365);
		assertThat(cuenta.getAnnualDays(), is(365));
	}

	@Test
	public void testGetPeriodoLiquidacion() {
		assertThat(cuenta.getLiquidationPeriod(), is(4));
	}

	@Test
	public void testSetPeriodoLiquidacion() {
		assertThat(cuenta.getLiquidationPeriod(), is(4));
		cuenta.setLiquidationPeriod(5);
		assertThat(cuenta.getLiquidationPeriod(), is(5));
	}
	
}
