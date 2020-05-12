
package cs544.eaproject.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;

@Transactional
@Repository
public class AppointmentDAOImpl extends CommonDAOImpl<Appointment> implements AppointmentDAO {

	@SuppressWarnings("unchecked")
	public List<Appointment> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT a from Appointment a");
		return new ArrayList<Appointment>(query.list());
		
	}
	
}

