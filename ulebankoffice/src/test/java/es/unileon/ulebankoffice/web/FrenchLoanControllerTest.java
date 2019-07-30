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

public class FrenchLoanControllerTest {
	
	@InjectMocks
    private FrenchLoanConstFeeFormController frenchController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(frenchController)
        		.setViewResolvers(vr)
        		.build();
    }

	@Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/frenchloan"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("frenchloan.jsp"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/frenchloan")
				.param("C0", "100000")
	            .param("i", "5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("frenchloan.jsp"))
	            .andExpect(model().attributeExists("table"));
	}
	
	@Test
	public void testPostRequestInitialCapError() throws Exception {
		this.mockMvc.perform(post("/frenchloan")
				.param("C0", "0")
	            .param("i", "5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("frenchloan.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestInterestRateError() throws Exception {
		this.mockMvc.perform(post("/frenchloan")
				.param("C0", "100000")
	            .param("i", "-5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("frenchloan.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestPeriodsError() throws Exception {
		this.mockMvc.perform(post("/frenchloan")
				.param("C0", "100000")
	            .param("i", "5")
	            .param("k", "0")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("frenchloan.jsp"))
	            .andExpect(model().hasErrors());
	}
}
