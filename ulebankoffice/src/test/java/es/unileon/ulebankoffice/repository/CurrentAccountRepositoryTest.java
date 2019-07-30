package es.unileon.ulebankoffice.repository;
/**
 * @author Razvan Raducu
 *
 */

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.domain.CurrentAccount;
import es.unileon.ulebankoffice.domain.DNIException;
import es.unileon.ulebankoffice.domain.DNIHandler;
import es.unileon.ulebankoffice.domain.Handler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class CurrentAccountRepositoryTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	private static Handler dni;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private CurrentAccountRepository repo;

	@BeforeClass
	public static void beforeClass() throws DNIException {
		dni = new DNIHandler("x5526828c");
	}

	@After
	public void afterEachMethod() {
		repo.deleteAll();
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindAll() throws ParseException, DNIException {
		assertEquals(3, repo.findAll().size());
		CurrentAccount cuenta = new CurrentAccount(new Date(), 2d, 1d, 25d, 20d, 20d, 20d, new Date(),
				150d, 0d, "abierta", dni, 360, 6);
		repo.save(cuenta);
		cuenta = new CurrentAccount(new Date(), 2d, 1d, 25d, 20d, 20d, 20d, new Date(), 150d, 0d, "abierta", dni,
				360, 6);
		repo.save(cuenta);
		assertEquals(5, repo.findAll().size());
	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDni() {
		List<CurrentAccount> cuentasR = repo.findByDni("X5526828C");
		List<CurrentAccount> cuentasO = repo.findByDni("X4975127C");
		List<CurrentAccount> cuentasW = repo.findByDni("X5526828D");

		// Hamcrest notation
		assertThat(cuentasR.size(), is(2));
		assertThat(cuentasO.size(), is(1));
		assertThat(cuentasW.size(), is(0));

	}

	@Test
	public void testFindByDniNonExistent() {
		List<CurrentAccount> cuentas = repo.findByDni("X5526828D");
		assertNotNull(repo.findByDni("X5526828D"));
		assertThat(cuentas.size(), is(0));
		cuentas = repo.findAll();
		assertThat(cuentas.size(), is(0));
	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteByDni() {

		assertThat(repo.findAll().size(), is(3));

		repo.deleteByDni("X5526828C");
		assertThat(repo.findAll().size(), is(1));

	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete() {

		List<CurrentAccount> cuentas = repo.findAll();
		assertThat(cuentas.size(), is(3));

		assertThat(cuentas.get(0).getDni().toString(), is("X5526828C"));
		assertThat(repo.findByDni("X5526828C").size(), is(2));

		repo.delete(cuentas.get(0));
		assertThat(repo.findByDni("X5526828C").size(), is(1));
		repo.deleteByDni("X5526828C");

		cuentas = repo.findAll();
		assertThat(cuentas.size(), is(1));

	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {

		List<CurrentAccount> cuentasR = repo.findByDni("X5526828C");

		CurrentAccount cuenta = cuentasR.get(0);

		cuenta.depositBalance(500.00);

		repo.save(cuenta);

		cuenta = repo.findOne(cuenta.getId());

		assertThat(cuenta.getTotalBalance(), is(600.00));

		List<CurrentAccount> cuentas = repo.findByDni("X4975127C");
		assertThat(cuentas.get(0).getStatus(), is("abierta"));

		cuentas.get(0).setStatus("cerrada");
		repo.save(cuentas.get(0));
		cuentas = repo.findByDni("X4975127C");
		assertThat(cuentas.get(0).getStatus(), is("cerrada"));

	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void tesInsert() throws DNIException, ParseException {
		List<CurrentAccount> cuentasR = repo.findByDni("X5526828C");

		// Hamcrest notation
		assertThat(cuentasR.size(), is(2));

		CurrentAccount nuevaCuenta = new CurrentAccount(new Date(), 2d, 1d, 25d, 20d, 20d, 20d,
				new Date(), 150d, 0d, "abierta", dni, 360, 6);
		repo.save(nuevaCuenta);

		cuentasR = repo.findByDni("X5526828C");
		assertThat(cuentasR.size(), is(3));

	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void tesFindByNumeroDeCuenta() throws DNIException, ParseException {
		CurrentAccount cuenta = repo.findByAccountNumber("abc001");

		assertThat(cuenta.getStatus(), is("abierta"));
		assertThat(cuenta.getDni().toString(), is("X5526828C"));

	}

	@Test
	@UsingDataSet(locations = {
			"/testing/currentAccountsRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void tesFindByNumeroDeCuentaNonExistent() throws DNIException, ParseException {
		CurrentAccount cuenta = repo.findByAccountNumber("abc002");

		assertNull(cuenta);

	}
}
