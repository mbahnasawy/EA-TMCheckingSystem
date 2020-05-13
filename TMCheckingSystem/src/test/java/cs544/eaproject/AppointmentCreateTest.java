package cs544.eaproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cs544.eaproject.controller.AppointmentController;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;

@SpringBootTest
//@RunWith(SpringRunner.class)
public final class AppointmentCreateTest {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private AppointmentController appointmentController;

	@Test
	void contextLoads() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Appointment appointment = null;
		try {
			appointment = new Appointment(simpleDateFormat.parse("2028-09-09"), "classroom", null);
			Appointment response = appointmentController.createAppointment(appointment);
			Appointment result = appointmentRepository.getOne(response.getId());
			assertThat(appointment).isEqualTo(result);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			appointmentRepository.delete(appointment);
		}

	}

	@Test
	void test2() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Appointment appointment = null;
		try {
			appointment = new Appointment(simpleDateFormat.parse("2038-01-01"), "office", null);
			Appointment response = appointmentController.createAppointment(appointment);
			Appointment result = appointmentRepository.getOne(response.getId());
			assertThat(appointment).isEqualTo(result);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			appointmentRepository.delete(appointment);
		}
	}
}
