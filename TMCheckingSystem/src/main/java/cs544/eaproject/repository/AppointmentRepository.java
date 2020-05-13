package cs544.eaproject.repository;

import java.security.Provider;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a where a.provider.id = ?1")
	List<Appointment> findByProvider(long provider_id);
}
