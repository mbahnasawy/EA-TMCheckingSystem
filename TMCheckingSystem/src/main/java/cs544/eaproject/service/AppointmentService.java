package cs544.eaproject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.dao.CommonDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;

@Transactional
@Service
public class AppointmentService {
	@Autowired
	private  AppointmentRepository appointmentDao;
	
	
	public void delete(long id) {
		appointmentDao.deleteById(id);
	}
}
