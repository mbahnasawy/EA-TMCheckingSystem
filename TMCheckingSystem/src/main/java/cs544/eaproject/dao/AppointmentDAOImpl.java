
package cs544.eaproject.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs544.eaproject.domain.Appointment;

@Transactional
@Repository("appointmentDAO")
public class AppointmentDAOImpl extends BaseDAOImpl<Appointment> implements AppointmentDAO {

	@SuppressWarnings("unchecked")
	public Set<Appointment> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT a from Appointment a");
		return new HashSet<Appointment>(query.list())
		
	}
}

