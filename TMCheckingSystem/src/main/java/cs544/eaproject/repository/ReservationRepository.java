package cs544.eaproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import cs544.eaproject.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
}
