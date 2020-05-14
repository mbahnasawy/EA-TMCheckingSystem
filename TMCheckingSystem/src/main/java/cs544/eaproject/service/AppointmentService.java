package cs544.eaproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;
import cs544.eaproject.service.dto.AppointmentDto;

public interface AppointmentService {

	public AppointmentDto createAppointment(AppointmentDto appointment);

	public void cancelAppointment(long id);

//	public void updateAppointment(Appointment appointment);

	public AppointmentDto viewAppointment(long id);

	public void delete(long id);

	public List<AppointmentDto> viewAppointments();

	public List<AppointmentDto> viewAppointmentsByProvider(long id);
}
