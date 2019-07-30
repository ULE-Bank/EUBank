package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TAESeveralInterestsPOJOTest {
	
	private TAESeveralInterestsPOJO tae;
	
	@Before
	public void setUp() throws Exception {
		tae = new TAESeveralInterestsPOJO();
	}

	@Test
	public void testInterests() {
		assertNull(tae.getInterests());
		tae.setInterests(new ArrayList<VariableInterest>());
		assertThat(tae.getInterests().size(), is(0));
	}

	@Test
	public void testPeriod() {
		assertThat(tae.getPeriod(), is(0));
		tae.setPeriod(8);
		assertThat(tae.getPeriod(), is(8));
	}


}
