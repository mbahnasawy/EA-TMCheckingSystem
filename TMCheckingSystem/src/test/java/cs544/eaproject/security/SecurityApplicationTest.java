package cs544.eaproject.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;


@SpringBootTest( classes = SpringSecurityWebAuxTestConfig.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityApplicationTest {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get("/appointments/hello"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void loginUser() throws Exception {
    	Object randomObj = new Object() {
            public final String username = "admin";
            public final String password = "123";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
        this.mockMvc.perform(post("/user/authenticate").contentType(MediaType.APPLICATION_JSON)
        	    .content(json)
        	    .characterEncoding("utf-8"))
        	    .andExpect(status().isOk())
        	    .andExpect(jsonPath("$.token").exists())
        	    .andReturn();
    }
    
    protected ResultActions login() throws Exception {
    	Object randomObj = new Object() {
            public final String username = "admin";
            public final String password = "123";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
        return (ResultActions) this.mockMvc.perform(post("/user/authenticate").contentType(MediaType.APPLICATION_JSON)
        	    .content(json));
    }
    
    
    protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
        return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
    }
    
    @Test
    @WithUserDetails("admin")
    public void givenAdminUser_whenGetHello_thenOk() throws Exception
    {
    	final String token = extractToken(login().andReturn());
    	System.out.println(token);
    	System.out.println();
        mockMvc.perform(MockMvcRequestBuilders.get("/appointments/hello")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }
    
    @Test
    @WithUserDetails("provider")
    public void givenProviderUser_whenGetHello_thenOk() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/appointments/hello")
                .accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }
    
    /*
    @Test
    @WithUserDetails("consumer")
    public void givenConsumerUser_whenCancelReservation_thenOk() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.delete("/reservations/cancel/1")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }
    */
}
