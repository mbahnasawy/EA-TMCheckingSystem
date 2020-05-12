
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import cs544.eaproject.domain.Appointment;


public  class AppointmentDAO  {

//	private SessionFactory sessionFactory;
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//	@Override
//	public void delete(long id) {
//
//		Session session = sessionFactory.getCurrentSession();
//		session.delete(session.load(Appointment.class, id));
//
//	}


import java.util.List;

import cs544.eaproject.domain.Appointment;


public interface AppointmentDAO extends CommonDAO<Appointment> {
	List<Appointment> getAll();
}

