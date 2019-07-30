package es.unileon.ulebankoffice.web;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.hamcrest.Matchers.*;

import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;
import es.unileon.ulebankoffice.repository.FinancialAdvisorRequestsRepository;
import es.unileon.ulebankoffice.service.FinancialAdvisorRequestPOJO;

public class NewQueryFormControllerTest {

	@InjectMocks
	private NewQueryFormController newQueryFormController;

	@Mock
    private FinancialAdvisorRequestsRepository financialAdvisorRepo;
	
	@Mock 
	private AdvisorUserRepository repoUser;

	private MockMvc mockMvc;
	

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders.standaloneSetup(newQueryFormController)
        		.setViewResolvers(vr)
        		.build();
    }
    
    @Test
 	public void testGetRequest() throws Exception {
 		this.mockMvc.perform(get("/offersconsulting/newquery"))
 	            .andExpect(status().isOk())
 	            .andExpect(forwardedUrl("newquery.jsp"));
 	}    
    
    @Test
    public void testPost() throws Exception {
    	FinancialAdvisorRequestPOJO test = new FinancialAdvisorRequestPOJO();
    	test.setOfferText("text");
    	test.setOfferMatter("reason");
    	test.setFiles(new ArrayList<MultipartFile>());
    	test.setOfferUrl("url");
    	
    	AdvisorUser mockedUser = new AdvisorUser();
    	when(repoUser.findByEmail(anyString())).thenReturn(mockedUser);
    	
        User user = new User("user","", AuthorityUtils.createAuthorityList("ROLE_EMPLEADO"));
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(user,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        /** PENDIENTE DE REALIZAR
    	this.mockMvc.perform(post("/offersconsulting/newquery")
    			.principal(testingAuthenticationToken)
    			.flashAttr("newQuestion", test))
    			.andExpect(status().isOk())
    			.andExpect(model().attribute("newQuestion", hasProperty("offerText", is("text"))))
    			.andExpect(model().attribute("newQuestion", hasProperty("offerMatter", is("reason"))))
    			.andExpect(model().attribute("newQuestion", hasProperty("offerUrl", is("url"))));
	    */ 			
    }
    
}
