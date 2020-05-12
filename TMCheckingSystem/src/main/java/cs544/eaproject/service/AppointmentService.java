package cs544.eaproject.service;

import java.util.List;

import cs544.eaproject.domain.Appointment;

public interface AppointmentService {

	public Appointment createAppointment(Appointment appointment);

	public void cancelAppointment(int id);

//	public void updateAppointment(Appointment appointment);

	public Appointment viewAppointment(int id);
}
