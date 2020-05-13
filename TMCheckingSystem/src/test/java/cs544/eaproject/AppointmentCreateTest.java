package cs544.eaproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import cs544.eaproject.controller.UserController;
import cs544.eaproject.domain.Appointment;
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

	private String token;
	
	@Autowired
	private EntityManager entityManager;

//	@Autowired
//	private UserController userController;

//	@Test
	void authenticate() {
		try {
			JSONObject json = new JSONObject();
			String jsonStr = "";

			json.put("email", "admin");
			json.put("password", "123");
			jsonStr = json.toString();

//			ResponseEntity res = userController.generateToken(null);
			ResponseEntity response = (ResponseEntity) this.mockMvc
					.perform(post("/authenticate").content(jsonStr).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();

			token = ((AuthResponse) response.getBody()).getToken();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void createAppointmentTest1() {
		try {
			JSONObject json = new JSONObject();
			String jsonStr = "";

			json.put("location", "TEST CLASSROOM");
			json.put("dateTime", "2029-11-11 10:00:00");
			jsonStr = json.toString();

			String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTM0ODAxMSwiaWF0IjoxNTg5MzEyMDExfQ.DRkRlJXUUitMd_MEfHN6gw1FKyyjiPMBKnyf71gPcM4";

			Appointment appointment = (Appointment) this.mockMvc
					.perform(post("/appointments/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)
							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token))
					.andExpect(status().isOk()).andReturn();

//			appointmentService.delete(appointment.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(appointment);
			entityManager.flush();
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			assertThat("1").isEqualTo("0");
			e.printStackTrace();
		}

	}

//	@Test
	void createAppointmentTest2() {
		try {

			JSONObject json = new JSONObject();
			String jsonStr = "";

			json.put("location", "TEST OFFICE");
			json.put("dateTime", "2021-9-9 10:00:00");
			jsonStr = json.toString();

			String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTM0ODAxMSwiaWF0IjoxNTg5MzEyMDExfQ.DRkRlJXUUitMd_MEfHN6gw1FKyyjiPMBKnyf71gPcM4";

			this.mockMvc
					.perform(post("/appointments/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)
							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token))
					.andExpect(status().isOk());

		} catch (Exception e) {
			assertThat("1").isEqualTo("0");
			e.printStackTrace();
		}
	}
}
