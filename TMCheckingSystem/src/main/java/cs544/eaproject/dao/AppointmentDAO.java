package cs544.eaproject.dao;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import cs544.eaproject.domain.Appointment;


@Transactional
@Repository
public class AppointmentDAO implements CommonDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void delete(long id) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(Appointment.class, id));

	}

}
