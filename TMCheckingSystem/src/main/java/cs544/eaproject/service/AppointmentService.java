package cs544.eaproject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.dao.CommonDAO;
import cs544.eaproject.domain.Appointment;

@Transactional
@Service
public class AppointmentService {
	@Autowired
	private  AppointmentDAO appointmentDao;
	
	
	public void cancelAppointment(long id) {
		appointmentDao.delete(id);
	}
}
