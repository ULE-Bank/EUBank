package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.unileon.ulebankoffice.service.VariableInterest;


public class TAESeveralInterestsTest {
	
	
	private TAESeveralInterests tae;
			
	@Test
	public void testCalcularPeriodo12() {
	
		List<VariableInterest> intereses = new ArrayList<>();
		intereses.add(new VariableInterest(1));
		intereses.add(new VariableInterest(2));
		intereses.add(new VariableInterest(3));
		intereses.add(new VariableInterest(4));
		intereses.add(new VariableInterest(5));
		intereses.add(new VariableInterest(6));
		intereses.add(new VariableInterest(7));
		intereses.add(new VariableInterest(8));
		intereses.add(new VariableInterest(9));
		intereses.add(new VariableInterest(10));
		intereses.add(new VariableInterest(11));
		intereses.add(new VariableInterest(12));
		tae = new TAESeveralInterests(1, intereses);
		assertThat(tae.calculate(), is("1.00"));
		tae.setPeriod(2);
		assertThat(tae.calculate(), is("1.50"));
		tae.setPeriod(3);
		assertThat(tae.calculate(), is("2.01"));
		tae.setPeriod(4);
		assertThat(tae.calculate(), is("2.52"));
		tae.setPeriod(6);
		assertThat(tae.calculate(), is("3.53"));
		tae.setPeriod(12);
		assertThat(tae.calculate(), is("6.63"));
	}

}
