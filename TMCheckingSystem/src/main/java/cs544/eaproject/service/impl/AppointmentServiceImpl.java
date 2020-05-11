package cs544.eaproject.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;

public class AppointmentServiceImpl {

	@Autowired
	private AppointmentDAO appointmentDao;

	public Appointment createAppointment(Appointment appointment) {

//		appointmentDao.create(appointment);

		return appointment;
	}
}
