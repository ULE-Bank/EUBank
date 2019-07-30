/**
 * 
 */
package es.unileon.ulebankoffice.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Razvan Raducu
 *
 */
public class TAESeveralInterestsControllerTest {

	@InjectMocks
	private TAESeveralInterestsController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
	}

	@Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/aprv"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("aprv.jsp"));
	}

	@Test
	public void testPost() throws Exception {
		this.mockMvc.perform(post("/aprv")
				.param("period","2")
				.param("interests[0].interest", "2")
				.param("interests[1].interest", "3"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("aprv.jsp"))
				.andExpect(model().attributeExists("taeDataSeveralInterests"));
				
	}
	
	@Test
	public void testPostErrors() throws Exception {
		this.mockMvc.perform(post("/aprv")
				.param("period","a")
				.param("interests[0].interest", "2")
				.param("interests[1].interest", "3"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("aprv.jsp"))
				.andExpect(model().hasErrors());
				
	}

}
