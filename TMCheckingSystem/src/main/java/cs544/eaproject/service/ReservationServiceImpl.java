package cs544.eaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.ReservationDAO;
import cs544.eaproject.domain.Reservation;
import cs544.eaproject.service.dto.ReservationDto;

@Service
public class ReservationServiceImpl implements ReservationService{

//	@Autowired
//	ReservationDAO reservstionDAO ;
	
	@Override
	public ReservationDto createReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptReservation(long ReservationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelReservation(long ReservationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReservationDto> viewReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationDto> convertEntityListToResponseList(List<Reservation> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDto convertEntityToResponse(Reservation entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public ReservationDAO getReservstionDAO() {
//		return reservstionDAO;
//	}
//
//	public void setReservstionDAO(ReservationDAO reservstionDAO) {
//		this.reservstionDAO = reservstionDAO;
//	}
}
