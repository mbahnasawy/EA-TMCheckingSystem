
 package cs544.eaproject.dao;


import java.util.List;

import cs544.eaproject.domain.Appointment;


public interface AppointmentDAO extends CommonDAO<Appointment> {
	List<Appointment> getAll();
}

