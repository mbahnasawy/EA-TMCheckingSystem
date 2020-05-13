package cs544.eaproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.dao.CommonDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;

public interface AppointmentService {

	public Appointment createAppointment(Appointment appointment);

	public void cancelAppointment(int id);

//	public void updateAppointment(Appointment appointment);

	public Appointment viewAppointment(int id);

	public void delete(long id);

	public List<Appointment> viewAppointments();

	public List<Appointment> viewAppointmentsByProvider(long id);
}
