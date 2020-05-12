package cs544.eaproject.dao;

import org.hibernate.SessionFactory;

import cs544.eaproject.domain.Appointment;

public class AppointmentDAO implements CommonDAO {
		
		private SessionFactory sf;
		
		public void setSessionFactory(SessionFactory sf) {
			this.sf=sf;
		}

		@Override
		public void cancel(int id) {
			
			sf.getCurrentSession().delete(sf.getCurrentSession().load(Appointment.class, id));
			
		}
		

	}


