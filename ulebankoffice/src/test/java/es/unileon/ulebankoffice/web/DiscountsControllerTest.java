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

public class DiscountsControllerTest {
	
	@InjectMocks
    private DiscountsFormController discountsController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(discountsController)
        		.setViewResolvers(viewResolver)
        		.build();
    }

    @Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/discounts"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"));
	}

    @Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "1000")
	            .param("discountPeriod", "2")
	            .param("interestRate", "2.55")
	            .param("base", "365")
	            .param("otherExpenses", "160")
	            .param("comissions", "3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().attributeExists("table"));
	}
    
    @Test
	public void testPostRequestDiscountValueError() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "0")
	            .param("discountPeriod", "2")
	            .param("interestRate", "2.55")
	            .param("base", "365")
	            .param("otherExpenses", "160")
	            .param("comissions", "3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().hasErrors());
	}
    
    @Test
	public void testPostRequestDiscountPeriodError() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "1000")
	            .param("discountPeriod", "0")
	            .param("interestRate", "2.55")
	            .param("base", "365")
	            .param("otherExpenses", "160")
	            .param("comissions", "3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().hasErrors());
	}
    
    @Test
	public void testPostRequestInterestTypeError() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "1000")
	            .param("discountPeriod", "2")
	            .param("interestRate", "-2.56")
	            .param("base", "365")
	            .param("otherExpenses", "160")
	            .param("comissions", "3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().hasErrors());
	}
    
    @Test
	public void testPostRequestOtherExpensesError() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "1000")
	            .param("discountPeriod", "2")
	            .param("interestRate", "2.55")
	            .param("base", "365")
	            .param("otherExpenses", "-100")
	            .param("comissions", "3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().hasErrors());
	}
    
    @Test
	public void testPostRequestComissionsError() throws Exception {
		this.mockMvc.perform(post("/discounts")
				.param("discountValue", "1000")
	            .param("discountPeriod", "2")
	            .param("interestRate", "2.55")
	            .param("base", "365")
	            .param("otherExpenses", "160")
	            .param("comissions", "-3"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("discounts.jsp"))
	            .andExpect(model().hasErrors());
	}
}
