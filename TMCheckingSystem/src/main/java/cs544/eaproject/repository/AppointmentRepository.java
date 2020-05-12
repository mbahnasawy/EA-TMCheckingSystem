package cs544.eaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
