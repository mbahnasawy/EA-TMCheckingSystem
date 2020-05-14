package cs544.eaproject.service;

import java.util.List;
import java.util.Set;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.service.dto.ReservationDto;

public interface ReservationService {

	public ReservationDto getReservationbyId(long id)throws Exception  ;
	
	public ReservationDto createReservation(long appointmentId)throws Exception;
	
	public ReservationDto acceptReservation(long ReservationId)throws Exception;
	
	public ReservationDto cancelReservation(long ReservationId)throws Exception;
	
	public List<ReservationDto> viewReservations();
	
	List<ReservationDto> convertEntityListToResponseList(List<Reservation> entityList);
	
	ReservationDto convertEntityToResponse(Reservation entity);
	
	public boolean checkReservationExists(long userId , long appointmentId);
//	public void test();
	
	public List<ReservationDto> getReservationsByAppointment(long appointmentId);
}
