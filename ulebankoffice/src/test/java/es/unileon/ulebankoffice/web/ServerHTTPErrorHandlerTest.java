package es.unileon.ulebankoffice.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
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
public class ServerHTTPErrorHandlerTest {
	
	@InjectMocks
	private ServerHTTPErrorHandler controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();

	}

	@Test
	public void testError403() throws Exception {
		this.mockMvc.perform(get("/e/403"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("HttpError403.jsp"));
	}

	@Test
	public void testError404() throws Exception {
		this.mockMvc.perform(get("/e/404"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("HttpError404.jsp"));
	}

	
	@Test
	public void testError() throws Exception {
		this.mockMvc.perform(get("/e/405"))
		.andExpect(status().isNotFound());
	}
}
