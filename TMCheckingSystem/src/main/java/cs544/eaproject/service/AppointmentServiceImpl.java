package cs544.eaproject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;

@Transactional
@Service("customerService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment createAppointment(Appointment appointment) {

		appointmentRepository.save(appointment);
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
	
	public void delete(long id) {
		appointmentRepository.deleteById(id);
	}

}
