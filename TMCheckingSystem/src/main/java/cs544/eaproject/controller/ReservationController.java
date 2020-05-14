package cs544.eaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.service.ReservationService;
import cs544.eaproject.service.dto.ReservationDto;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping
	@Secured({"ROLE_ADMIN" })
	public List<ReservationDto> getAllReservation() {
		return reservationService.viewReservations();
	}

	@GetMapping("/{id}")
	@Secured({ "ROLE_CONSUMER", "ROLE_ADMIN" })
	public ReservationDto getReservation(@PathVariable long id) throws Exception {
		return reservationService.getReservationbyId(id);
	}

	// change to patch
	@PatchMapping("/{id}")
	@Secured({ "ROLE_PROVIDER", "ROLE_ADMIN" })
	public ReservationDto acceptReservation(@PathVariable long id) throws Exception {
		return reservationService.acceptReservation(id);
	}

	// delete
	@DeleteMapping("/{id}")
	@Secured({ "ROLE_CONSUMER", "ROLE_ADMIN" })
	public ReservationDto cancelReservation(@PathVariable long id) throws Exception {
		return reservationService.cancelReservation(id);
	}

	@RequestMapping(params = "appointmentId", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	@Secured({ "ROLE_CONSUMER", "ROLE_ADMIN" })
	public ReservationDto createReservation(@RequestParam String appointmentId) throws Exception {

		return reservationService.createReservation(Long.parseLong(appointmentId));
	}

	@GetMapping("/appointments/{appointmentId}")
	@Secured({ "ROLE_ADMIN", "ROLE_PROVIDER" })
	public List<ReservationDto> getReservationsByAppointment(@PathVariable long appointmentId) throws Exception {
		return reservationService.getReservationsByAppointment(appointmentId);
	}
	
}
