package cs544.eaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cs544.eaproject.controller.AppointmentController;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;
import cs544.eaproject.repository.AppointmentRepository;
import cs544.eaproject.service.AppointmentServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public final class AppointmentCancel {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private AppointmentController appointmentController;
	
	@Autowired
	AppointmentServiceImpl appointmentService;

	@Test
	void contextLoads() throws Exception {

		Appointment appointment = null;

		try {
			
			appointment=appointmentRepository.getOne((long) 4);
			appointmentController.delete(appointment.getId());
	
			verify(appointmentRepository,times(1)).delete(appointment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
	
	@Test
	void test2()throws Exception {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Appointment appointment = null;
		try {
			appointment = new Appointment(simpleDateFormat.parse("2021-03-11"), "library",null);
			appointmentController.delete(appointment.getId());
			
			verify(appointmentRepository,times(1)).deleteById(appointment.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}

	
