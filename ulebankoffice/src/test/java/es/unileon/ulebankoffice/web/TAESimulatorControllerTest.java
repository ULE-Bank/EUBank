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

public class TAESimulatorControllerTest {

	@InjectMocks
    private TAEFormSimulatorController taeController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(taeController)
        		.setViewResolvers(vr)
        		.build();
    }

	@Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/apr"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("aprcalculation.jsp"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/apr")
				.param("i", "2.59")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("aprcalculation.jsp"))
	            .andExpect(model().attributeExists("table"));
	}
	
	@Test
	public void testPostRequestInterestRateError() throws Exception {
		this.mockMvc.perform(post("/apr")
				.param("i", "-1")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("aprcalculation.jsp"))
	            .andExpect(model().hasErrors());
	}

}
