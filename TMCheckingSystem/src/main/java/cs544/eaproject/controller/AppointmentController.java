package cs544.eaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;
import cs544.eaproject.repository.UserRepository;
import cs544.eaproject.service.AppointmentService;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<Appointment> getAllAppointment() {
		return appointmentService.viewAppointments();
	}

	@GetMapping("/provider/{id}")
	public List<Appointment> getAllAppointmentByProvider(@PathVariable long id) {
		return appointmentService.viewAppointmentsByProvider(id);
	}

	@RequestMapping(value = "/delete/{appointmentId}", method = RequestMethod.DELETE)
	@Secured({ "ROLE_PROVIDER", "ROLE_ADMIN" })
	public void delete(@PathVariable long appointmentId) throws Exception {
		appointmentService.delete(appointmentId);

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	@Secured({ "ROLE_PROVIDER", "ROLE_ADMIN" })
	@ResponseBody
	public Appointment createAppointment(@RequestBody Appointment appointmentDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User current_user = userRepository.findByUserName(auth.getName());
		appointmentDTO.setProvider(current_user);
		Appointment appointment = appointmentService.createAppointment(appointmentDTO);

		return appointment;
	}

	@GetMapping("/hello")
	@Secured({ "ROLE_ADMIN" })
	public String hello() {
		return "hello";
	}

}
