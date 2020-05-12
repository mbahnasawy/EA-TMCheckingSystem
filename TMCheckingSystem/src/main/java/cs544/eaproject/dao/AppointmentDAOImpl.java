package cs544.eaproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import cs544.eaproject.domain.Appointment;

public class AppointmentDAOImpl extends BaseDAOImpl<Appointment> implements AppointmentDAO {
	
	public List<Appointment> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT a from Appointment a");
		return new ArrayList<Appointment>(query.list());
	}
	

}
