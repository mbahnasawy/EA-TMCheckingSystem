package cs544.eaproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs544.eaproject.domain.Reservation;


	@Transactional
	@Repository
	public class ReservationDAOImpl extends CommonDAOImpl<Reservation> implements ReservationDAO {

		@SuppressWarnings("unchecked")
		public List<Reservation> getAll() {
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT r from Reservation r");
			return new ArrayList<Reservation>(query.list());
			
		}
		
	}
		

	


