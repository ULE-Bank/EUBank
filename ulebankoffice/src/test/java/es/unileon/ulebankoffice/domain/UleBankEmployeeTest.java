package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UleBankEmployeeTest {
	
	private UleBankEmployee user;

	@Before
	public void setUp() throws Exception {
		user = new UleBankEmployee("name", "pass", "admin");
	}

	@Test
	public void testUleBankEmployeeDomain() {
		assertThat(user.getUserName(), is("name"));
	}

	@Test
	public void testUserName() {
		assertThat(user.getUserName(), is("name"));
		user.setUserName("anotherName");
		assertThat(user.getUserName(), is("anotherName"));
	}

	@Test
	public void testPassword() {
		assertThat(user.getPassword(), is("pass"));
		user.setPassword("pass2");
		assertThat(user.getPassword(), is("pass2"));
	}


	@Test
	public void testRole() {
		assertThat(user.getRole(), is("admin"));
		user.setRole("role");
		assertThat(user.getRole(), is("role"));
	}

	@Test
	public void testGetId() {
		assertNull(user.getId());
	}

}
