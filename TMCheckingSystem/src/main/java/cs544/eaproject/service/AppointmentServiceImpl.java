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
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment createAppointment(Appointment appointment) {

		appointmentRepository.save(appointment);
//		appointmentDao.create(appointment);

		return appointment;
	}

	@Override
	public void cancelAppointment(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Appointment viewAppointment(long id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id).orElseThrow();
	}

	public void delete(long id) {
		appointmentRepository.deleteById(id);
	}
	
	@Override
	public List<Appointment> viewAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> viewAppointmentsByProvider(long id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByProvider(id);
	}

}
