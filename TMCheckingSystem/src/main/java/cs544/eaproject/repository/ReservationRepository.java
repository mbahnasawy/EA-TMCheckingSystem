package cs544.eaproject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("from Reservation r where r.appointment = :appointment")
	public List<Reservation> getReservationByAppId(Appointment appointment);

//	
//	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false End "
//			+ "from Reservation r "
//			+ "where r.getConsumer.getId = :userID"
//			+ "r.getAppointment.getId = :appointmentId")
//	public boolean checkReservationExists(long userId , long appointmentId);
	@Query("Select r from Reservation r where r.appointment.id = :appointmentId and r.consumer.id = :userId")
	public Reservation checkReservationExists(long userId, long appointmentId);

//	date(r.appointment.dateTime = date('2020-05-14')
	//@Query(value = "select * from tmchecking.reservation where date(reservation.dateTime) = date(:nowDate)", nativeQuery = true)
	@Query("from Reservation r where r.status = 'ACCEPTED'")
	public List<Reservation> getReservationsBeforeDate(Date nowDate);
}
