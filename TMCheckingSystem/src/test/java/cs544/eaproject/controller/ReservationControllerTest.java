package cs544.eaproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import cs544.eaproject.security.SpringSecurityWebAuxTestConfig;

@SpringBootTest(classes = SpringSecurityWebAuxTestConfig.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	public ResultActions login() throws Exception {
		Object randomObj = new Object() {
			public final String username = "admin";
			public final String password = "123";
		};

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(randomObj);
		return (ResultActions) this.mockMvc
				.perform(post("/user/authenticate").contentType(MediaType.APPLICATION_JSON).content(json));
	}

	public String extractToken(MvcResult result) throws UnsupportedEncodingException {
		return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
	}

	@Test
	public void createReservationTest() {
		try {

			final String token = extractToken(login().andReturn());

			JSONObject json = new JSONObject();
			String jsonStr = "";

			jsonStr = json.toString();

			MvcResult result = this.mockMvc
					.perform(post("/reservations").param("appointmentId", "20").contentType(MediaType.APPLICATION_JSON).content(jsonStr)
							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token))
					.andExpect(status().isOk()).andReturn();

			Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

			this.mockMvc.perform(MockMvcRequestBuilders.delete("/reservations/{id}", id).header("Authorization",
					"Bearer " + token)).andExpect(status().isOk());

		} catch (Exception e) {
//			assertThat("1").isEqualTo("0");
			e.printStackTrace();
		}
	}

}
