package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.service.AppointmentService;
import cs544.eaproject.util.Response;
import cs544.eaproject.util.ResponseStatus;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Response createAppointment(@RequestBody Appointment appointmentDTO) {
		Response response = new Response();

		try {
			Appointment appointment = appointmentService.createAppointment(appointmentDTO);
			response.setResult(appointment);
			response.setMessage(ResponseStatus.SUCCESS_MESSAGE);
			response.setStatus(ResponseStatus.SUCCESS_CODE);

		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseStatus.ERROR_CODE);
		}

		return response;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
