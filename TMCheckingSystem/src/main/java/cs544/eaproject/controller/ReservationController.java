package cs544.eaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.domain.ReservationStatus;
import cs544.eaproject.service.EmailSenderService;
import cs544.eaproject.service.ReservationService;
import cs544.eaproject.service.dto.ReservationDto;
import cs544.eaproject.util.Response;
import cs544.eaproject.util.ResponseStatus;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_checker')")
	@GetMapping
	public List<ReservationDto> getAllReservation(){
		return reservationService.viewReservations();
	}
	
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_checker')")
	@GetMapping("/{id}")
	public ReservationDto getReservation( @PathVariable long id) throws Exception {
		return reservationService.getReservationbyId(id);
	}
	
	//change to patch
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_checker')")
	@PatchMapping(value = "/{id}",params = "status")
	public void acceptReservation(@PathVariable long id,@RequestParam ReservationStatus status)throws Exception{
		if(status.equals(ReservationStatus.ACCEPTED))
			reservationService.acceptReservation(id);
	}
	
	// delete
	@DeleteMapping(value = "/{id}" )
	public void DeleteReservation(@PathVariable long id)throws Exception{
			reservationService.cancelReservation(id);
	}
	
	@RequestMapping(value = "/create", params="appointmentId", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
	"application/json" })
	public Response createReservation(@RequestParam String appointmentId)throws Exception{
		Response response = new Response();
		try {
			ReservationDto reservationDto =reservationService.createReservation(Long.parseLong(appointmentId));
			response.setResult(reservationDto);
			response.setMessage(ResponseStatus.SUCCESS_MESSAGE);
			response.setStatus(ResponseStatus.SUCCESS_CODE);
		}
		catch (Exception e) {
			// TODO: handle exception
			response.setMessage(e.getMessage());
			response.setStatus(ResponseStatus.ERROR_CODE);
		}
		return response;
	}
	
	
}
