package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebankoffice.service.InvestorProfile;

public class AdvisorUserTest {
	
	private AdvisorUser user;

	@Before
	public void setUp() throws Exception {
		user = new AdvisorUser();
	}

	@Test
	public void testEmail() {
		assertNull(user.getEmail());
		user.setEmail("email");
		assertThat(user.getEmail(), is("email"));
	}



	@Test
	public void testGetId() {
		assertNull(user.getId());
	}
	
}
