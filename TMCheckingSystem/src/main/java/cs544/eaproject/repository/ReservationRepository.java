package cs544.eaproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Query("from Reservation r where r.appointment = :appointment")
	public List<Reservation> getReservationByAppId(Appointment appointment);
//	
//	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false End "
//			+ "from Reservation r "
//			+ "where r.getConsumer.getId = :userID"
//			+ "r.getAppointment.getId = :appointmentId")
//	public boolean checkReservationExists(long userId , long appointmentId);
	@Query("Select r from Reservation r where r.appointment.id = :appointmentId and r.consumer.id = :userId")
	public Reservation checkReservationExists(long userId , long appointmentId);
}
