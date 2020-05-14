package cs544.eaproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select a from Reservation a where a.appointment.id = ?1")
	List<Reservation> findByAppointment(long appointmentId);
}
