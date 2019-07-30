package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CreditsTest {

	private Credits creditos;
	private double delta = 0.1;
	private double noDelta = 0.0;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		List<CreditMovements> movimientos = new ArrayList<>();
		movimientos.add(new CreditMovements("1", 55000, sdf.parse("2016-07-10"), "D"));
		movimientos.add(new CreditMovements("2", 10000, sdf.parse("2016-07-20"), "I"));
		movimientos.add(new CreditMovements("3", 46080, sdf.parse("2016-07-28"), "I"));

		creditos = new Credits(60000, sdf.parse("2016-07-01"), sdf.parse("2016-07-31"), 6, 21, 0, 1.5,
				movimientos);

		creditos.includeOpeningAndBrokerageComission(10, 3);
	}

	@Test
	public void testSetAndGetLimiteCredito() {
		assertEquals(60000, creditos.getCreditLimit(), noDelta);
		creditos.setCreditLimit(50000);
		assertEquals(50000, creditos.getCreditLimit(), noDelta);
	}

	@Test
	public void testSetAndGetFechaApertura() throws ParseException {
		assertEquals(sdf.parse("2016-07-01"), creditos.getOpeningDate());
		creditos.setOpeningDate(sdf.parse("2016-07-02"));
		assertEquals(sdf.parse("2016-07-02"), creditos.getOpeningDate());
	}

	@Test
	public void testSetAndGetFechaVencimiento() throws ParseException {
		assertEquals(sdf.parse("2016-07-31"), creditos.getExpirationDate());
		creditos.setExpirationDate(sdf.parse("2016-07-30"));
		assertEquals(sdf.parse("2016-07-30"), creditos.getExpirationDate());
	}

	@Test
	public void testSetAndGetInteresDeudor() {
		assertEquals(0.06, creditos.getDebtorInterest(), noDelta);
		creditos.setDebtorInterest(7);
		assertEquals(0.07, creditos.getDebtorInterest(), noDelta);
	}

	@Test
	public void testSetAndGetInteresExcedido() {
		assertEquals(0.21, creditos.getExceededInterest(), noDelta);
		creditos.setExceededInterest(17);
		assertEquals(0.17, creditos.getExceededInterest(), noDelta);
	}

	@Test
	public void testSetAndGetInteresAcreedor() {
		assertEquals(0.0, creditos.getCreditorInterest(), noDelta);
		creditos.setCreditorInterest(5);
		assertEquals(0.05, creditos.getCreditorInterest(), noDelta);
	}

	@Test
	public void testSetAndGetComisionSMND() {
		assertEquals(0.015, creditos.getComissionSMND(), noDelta);
		creditos.setComissionSMND(2.1);
		assertEquals(0.0021, creditos.getComissionSMND(), delta);
	}

	@Test
	public void testSetAndGetMovimientos() throws ParseException {
		assertEquals(5, creditos.getMovements().size());

		List<CreditMovements> newMovimientos = new ArrayList<CreditMovements>();
		newMovimientos.add(new CreditMovements("1", 55000, sdf.parse("2016-07-10"), "D"));

		creditos.setMovements(newMovimientos);

		assertEquals(1, creditos.getMovements().size());
	}

	@Test
	public void testCalcularTabla() {

		List<List<String>> resultado = creditos.calculateTable();
		String resultadoToString = resultado.get(4).get(4);
		resultadoToString = resultadoToString.substring(0, resultadoToString.length()-1);
		resultadoToString = resultadoToString.replaceAll("\\.", "");
		resultadoToString = resultadoToString.replaceAll(",", ".");
		assertEquals(5100.0, Double.parseDouble(resultadoToString), delta);
	}
	/**
	 * Prueba para comprobar que el método devuelve la liquidación
	 * correctamente. Se ha usado uno de los enunciados que me han enviado las
	 * chicas de Finanzas que se encargaban del proyecto en ese año (2016-2017)
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testCalcularTablaConEnunciado() throws ParseException {
		List<CreditMovements> movimientos = new ArrayList<>();
		movimientos.add(new CreditMovements("1", 30000, sdf.parse("2017-03-11"), "D"));
		movimientos.add(new CreditMovements("1", 300000, sdf.parse("2017-03-20"), "D"));
		movimientos.add(new CreditMovements("1", 600000, sdf.parse("2017-03-26"), "I"));
		movimientos.add(new CreditMovements("1", 450000, sdf.parse("2017-03-26"), "D"));
		movimientos.add(new CreditMovements("1", 1900000, sdf.parse("2017-04-10"), "D"));
		movimientos.add(new CreditMovements("1", 100000, sdf.parse("2017-04-21"), "I"));
		movimientos.add(new CreditMovements("1", 300000, sdf.parse("2017-05-12"), "I"));
		movimientos.add(new CreditMovements("1", 230000, sdf.parse("2017-05-12"), "D"));
		movimientos.add(new CreditMovements("1", 24000, sdf.parse("2017-06-07"), "I"));

		creditos = new Credits(2000000.00, sdf.parse("2017-03-10"), sdf.parse("2017-06-10"), 17, 21, 1, 0.15,
				movimientos);

		creditos.includeOpeningAndBrokerageComission(0.5, 2);

		List<List<String>> resultado = creditos.calculateTable();
				
		String resultadoToString = resultado.get(resultado.size() - 1).get(4);
		assertThat(resultadoToString, is("1.900.000,00€"));
		assertEquals(60584.7, creditos.obtainLiquidation().get(5), delta);
	}

	@Test
	public void testOrdenarMovimientosPorFecha() throws ParseException {
		assertThat(creditos.getMovements().size(), is(5));
		assertThat(creditos.getMovements().get(0).getMovementDate(), is(sdf.parse("2016-07-01")));

		creditos.getMovements().add(new CreditMovements("3", -46080, sdf.parse("2015-07-28"), "D"));
		creditos.getMovements().add(new CreditMovements("3", -46080, sdf.parse("2018-07-28"), "D"));
		creditos.getMovements().add(new CreditMovements("3", -46080, sdf.parse("2014-07-28"), "D"));

		assertThat(creditos.getMovements().size(), is(8));
		assertThat(creditos.getMovements().get(0).getMovementDate(), is(sdf.parse("2016-07-01")));
		assertThat(creditos.getMovements().get(6).getMovementDate(), is(sdf.parse("2018-07-28")));
		assertThat(creditos.getMovements().get(7).getMovementDate(), is(sdf.parse("2014-07-28")));

		creditos.calculateTable();

		assertThat(creditos.getMovements().size(), is(8));
		assertThat(creditos.getMovements().get(0).getMovementDate(), is(sdf.parse("2014-07-28")));
		assertThat(creditos.getMovements().get(7).getMovementDate(), is(sdf.parse("2018-07-28")));

	}
}
