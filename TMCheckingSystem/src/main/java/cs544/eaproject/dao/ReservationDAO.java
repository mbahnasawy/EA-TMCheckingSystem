package cs544.eaproject.dao;


import java.util.List;



import cs544.eaproject.domain.Reservation;

public interface ReservationDAO extends CommonDAO<Reservation> {
	
		List<Reservation> getAll();
	}



