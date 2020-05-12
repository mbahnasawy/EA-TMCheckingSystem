package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value ="/delete/{appointmentId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long appointmentId) throws Exception{

		appointmentService.delete(appointmentId);

	}

}
