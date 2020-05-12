package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.service.AppointmentService;

@RestController
public class AppointmentController {
	// private Logger logger = Logger.getLogger(AppointmentController.class);

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = "/appointment/{appointmentId}", method = RequestMethod.DELETE)
	public void cancel(@PathVariable long appointmentId) {

		appointmentService.cancelAppointment(appointmentId);

	}

}
