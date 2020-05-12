package cs544.eaproject.service.mapper;

import org.springframework.stereotype.Component;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.service.dto.ReservationDto;

@Component
public class ReservationMapper {
	
	public ReservationDto maptoReservationDto(Reservation reservation) {
		ReservationDto reservationDto = new ReservationDto(reservation.getId()
				, reservation.getStatus()
				, reservation.getDateTime(),null,null);
		//reservation.getConsumer()
		//reservation.getAppointment()
		return reservationDto;
	}
	
	public Reservation mapToReservation(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation.setAppointment(reservationDto.getAppointment());
		reservation.setConsumer(reservationDto.getConsumer());
		reservation.setDateTime(reservationDto.getDateTime());
		reservation.setStatus(reservationDto.getStatus());
		
		return reservation;
	}
}
