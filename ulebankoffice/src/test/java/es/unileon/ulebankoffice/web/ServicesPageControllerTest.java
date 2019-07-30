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
public class ServicesPageControllerTest {
	
	@InjectMocks
	private ServicesPageController controller;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
		
	}

	@Test
	public void testReturnServicesPage() throws Exception {
		this.mockMvc.perform(get("/services"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("servicespage.jsp"));
	}

}
