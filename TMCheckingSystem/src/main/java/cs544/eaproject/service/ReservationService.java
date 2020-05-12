package cs544.eaproject.service;

import java.util.List;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.service.dto.ReservationDto;

public interface ReservationService {

	
	public ReservationDto createReservation(Reservation reservation);
	public boolean acceptReservation(long ReservationId);
	public boolean cancelReservation(long ReservationId);
	public List<ReservationDto> viewReservations();
	
	List<ReservationDto> convertEntityListToResponseList(List<Reservation> entityList);
	
	ReservationDto convertEntityToResponse(Reservation entity);
	public ReservationDto getReservationbyId(long id);
	
	
}
