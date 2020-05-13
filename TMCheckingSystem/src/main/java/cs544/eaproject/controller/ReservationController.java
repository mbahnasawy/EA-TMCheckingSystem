package cs544.eaproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.service.ReservationService;
import cs544.eaproject.service.dto.ReservationDto;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<ReservationDto> getAllReservation(){
		return reservationService.viewReservations();
	}
	
	@GetMapping("/{id}")
	@Secured({"ROLE_CONSUMER","ROLE_ADMIN"})
	public ReservationDto getReservation( @PathVariable long id) throws Exception {
		return reservationService.getReservationbyId(id);
	}
	
	//change to patch
	@PatchMapping("/accept/{id}")
	@Secured({"ROLE_PROVIDER","ROLE_ADMIN"})
	public void acceptReservation(@PathVariable long id)throws Exception{
		reservationService.acceptReservation(id);
	}
	
	// delete
	@DeleteMapping("/cancel/{id}")
	@Secured({"ROLE_CONSUMER","ROLE_ADMIN"})
	public void cancelReservation(@PathVariable long id)throws Exception{
		reservationService.cancelReservation(id);
	}
	
	@RequestMapping(value = "/create", params="appointmentId", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
	"application/json" })
	@Secured({"ROLE_CONSUMER","ROLE_ADMIN"})
	public ReservationDto createReservation(@RequestParam String appointmentId)throws Exception{

		return reservationService.createReservation(Long.parseLong(appointmentId));
	}
	
	
}
