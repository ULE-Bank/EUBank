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

public class FinancialLeasingControllerTest {
	
	@InjectMocks
    private FinancialLeasingFormController financialLeasingController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        // It's necessary to declare the viewresolver to avoid circular path
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(financialLeasingController)
        		.setViewResolvers(viewResolver)
        		.build();
    }

    @Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/leasing"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("leasing.jsp"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/leasing")
				.param("propertyValue", "12000")
	            .param("contractDuration", "5")
	            .param("feePaymentDivision", "3")
	            .param("interestRate", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("leasing.jsp"))
	            .andExpect(model().attributeExists("table"));
	}
	
	@Test
	public void testPostRequestPropertyValueError() throws Exception {
		this.mockMvc.perform(post("/leasing")
				.param("propertyValue", "0")
	            .param("contractDuration", "5")
	            .param("feePaymentDivision", "3")
	            .param("interestRate", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("leasing.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestContractDurationError() throws Exception {
		this.mockMvc.perform(post("/leasing")
				.param("propertyValue", "12000")
	            .param("contractDuration", "0")
	            .param("feePaymentDivision", "3")
	            .param("interestRate", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("leasing.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestInterestRateError() throws Exception {
		this.mockMvc.perform(post("/leasing")
				.param("propertyValue", "12000")
	            .param("contractDuration", "5")
	            .param("feePaymentDivision", "3")
	            .param("interestRate", "-1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("leasing.jsp"))
	            .andExpect(model().hasErrors());
	}
}
