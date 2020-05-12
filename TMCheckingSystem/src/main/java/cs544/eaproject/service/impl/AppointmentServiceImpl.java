package cs544.eaproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;
import cs544.eaproject.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO appointmentDao;

	public Appointment createAppointment(Appointment appointment) {

//		appointmentDao.create(appointment);

		return appointment;
	}

	@Override
	public void cancelAppointment(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Appointment viewAppointment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAllAppointmentsByChecker(int tmCheckerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
