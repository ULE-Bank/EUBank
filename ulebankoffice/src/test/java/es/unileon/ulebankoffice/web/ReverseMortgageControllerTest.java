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

public class ReverseMortgageControllerTest {

	@InjectMocks
    private ReverseMortgageFormController reverseMortgageController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(reverseMortgageController)
        		.setViewResolvers(vr)
        		.build();
    }

	@Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/reversemortgage"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().attributeExists("table"));
	}
	
	@Test
	public void testPostRequestValueValuationError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "0")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestAgeError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "64")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestPercentageOverValuationError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "26000")
	            .param("age", "75")
	            .param("percentageOverValuation", "-1")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestInterestLoanRateError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "-1")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestOpeningComissionError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "-1")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestRentProfitabilityError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "-1")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestValuationCostError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "-1")
	            .param("formalizationExpenses", "2896"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestFormalizationExpensesError() throws Exception {
		this.mockMvc.perform(post("/reversemortgage")
				.param("valueValuation", "260000")
	            .param("age", "75")
	            .param("percentageOverValuation", "50")
	            .param("interestLoanRate", "4.70")
	            .param("openingComission", "1.5")
	            .param("rentProfitability", "2.85")
	            .param("valuationCost", "300")
	            .param("formalizationExpenses", "-1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("reversemortgage.jsp"))
	            .andExpect(model().hasErrors());
	}

}
