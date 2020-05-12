package cs544.eaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ReservationDto getReservation( @PathVariable long id) throws Exception {
		return reservationService.getReservationbyId(id);
	}
	
	//change to patch
	@PatchMapping("/accept/{id}")
	public void acceptReservation(@PathVariable long id)throws Exception{
		reservationService.acceptReservation(id);
	}
	
	// delete
	@DeleteMapping("/cancel/{id}")
	public void cancelReservation(@PathVariable long id)throws Exception{
		reservationService.cancelReservation(id);
	}
}
