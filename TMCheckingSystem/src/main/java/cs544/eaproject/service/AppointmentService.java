package cs544.eaproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;

public class AppointmentService {
	private  AppointmentDAO appointmentDao;
	
	@Autowired
	public void setAppointmentDAO(AppointmentDAO appointmentDao) {
		this.appointmentDao=appointmentDao;
	}
	
	public void  cancelAppointment(int id) {
		appointmentDao.delete(id);
		
	}

}
