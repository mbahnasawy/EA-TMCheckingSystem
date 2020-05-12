package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.service.AppointmentService;

@Controller
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value="appointment/delete/{appointmentId}", method=RequestMethod.DELETE)
	public void cancel(@PathVariable int appointmentId) {
		appointmentService.cancelAppointment(appointmentId);
	}

}
