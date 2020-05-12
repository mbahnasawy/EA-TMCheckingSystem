package cs544.eaproject.service.mapper;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.service.dto.ReservationDto;

public class ReservationMapper {
	
	public static ReservationDto maptoReservationDto(Reservation reservation) {
		ReservationDto reservationDto = new ReservationDto(reservation.getId()
				, reservation.getStatus()
				, reservation.getDateTime(),
			reservation.getConsumer()
			, reservation.getAppointment());
		
		return reservationDto;
	}
	
	public static Reservation mapToReservation(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation.setAppointment(reservationDto.getAppointment());
		reservation.setConsumer(reservationDto.getConsumer());
		reservation.setDateTime(reservationDto.getDateTime());
		reservation.setStatus(reservationDto.getStatus());
		
		return reservation;
	}
}
