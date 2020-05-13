package cs544.eaproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import cs544.eaproject.controller.AppointmentController;
import cs544.eaproject.controller.UserController;
import cs544.eaproject.dao.UserDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;
import cs544.eaproject.service.AppointmentService;
import cs544.eaproject.service.response.AuthResponse;
import io.jsonwebtoken.lang.Assert;

@SpringBootTest
@AutoConfigureMockMvc
public final class AppointmentCreateTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AppointmentController appointmentController;

	private String token;

	@Autowired
	private UserDAO userDAO;

//	@Autowired
//	private RestTemplate restTemplate;

//	@Test
//	void createAppointmentTest1() {
//		try {
//			User user = userDAO.findByEmail("admin");
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Appointment appointment = appointmentController.createAppointment(
//					new Appointment(simpleDateFormat.parse("2029-09-09 14:15:00"), "TEST LAB", user));
//
//			Appointment result = appointmentService.viewAppointment(appointment.getId());
//
//			assertThat(appointment).isEqualTo(result);
//
//			appointmentService.delete(appointment.getId());
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			assertThat("1").isEqualTo("0");
//		}
//	}

//	protected ResultActions login() throws Exception {
//		Object randomObj = new Object() {
//			public final String username = "admin";
//			public final String password = "123";
//		};
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json = objectMapper.writeValueAsString(randomObj);
//		return (ResultActions) this.mockMvc.perform(post("/user/authenticate").contentType(MediaType.APPLICATION_JSON)
//				.content(json));
//
//	}
//
//	protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
//		return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
//	}

//	@Test
	void authenticate() {
		try {
			JSONObject json = new JSONObject();
			String jsonStr = "";

			json.put("email", "admin");
			json.put("password", "123");
			jsonStr = json.toString();

			MvcResult result = (MvcResult) this.mockMvc.perform(post("/user/authenticate").content(jsonStr)
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
			token = JsonPath.read(result.getResponse().getContentAsString(), "$.token");

		} catch (Exception e) {
			e.printStackTrace();
			assertThat("1").isEqualTo("0");
		}
	}

//	@Test
	void createAppointmentTest1() {
		try {
			if (token.isEmpty()) {
				authenticate();
			}

			JSONObject json = new JSONObject();
			String jsonStr = "";

			json.put("location", "TEST TEST CONFERENCE");
			json.put("dateTime", "2029-11-11 10:00:00");
			jsonStr = json.toString();

//			System.out.println("token = " + token);
//			token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTQyMjM0MSwiaWF0IjoxNTg5Mzg2MzQxfQ.9Je1z506kLHKkuL5e8QUuUOLoKkvxLJeii6XIrRC0KE";

			Appointment appointment = (Appointment) this.mockMvc
					.perform(post("/appointments/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)
							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token))
					.andExpect(status().isOk()).andReturn();

//			appointmentService.delete(appointment.getId());

		} catch (Exception e) {
			assertThat("1").isEqualTo("0");
			e.printStackTrace();
		}
	}

//	@Test
//	void createAppointmentTest2_old() {
//		try {
//
//			JSONObject json = new JSONObject();
//			String jsonStr = "";
//
//			json.put("location", "TEST OFFICE");
//			json.put("dateTime", "2021-9-9 10:00:00");
//			jsonStr = json.toString();
//
//			String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTM0ODAxMSwiaWF0IjoxNTg5MzEyMDExfQ.DRkRlJXUUitMd_MEfHN6gw1FKyyjiPMBKnyf71gPcM4";
//
//			this.mockMvc
//					.perform(post("/appointments/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)
//							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token))
//					.andExpect(status().isOk());
//
//		} catch (Exception e) {
//			assertThat("1").isEqualTo("0");
//			e.printStackTrace();
//		}
//	}
}
