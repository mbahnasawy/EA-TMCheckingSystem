
package cs544.eaproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs544.eaproject.domain.Appointment;



@Transactional
@Repository
public class AppointmentDAOImpl extends CommonDAOImpl<Appointment> implements AppointmentDAO {

	public List<Appointment> getAll()
	{
		// TODO Auto-generated method stub
				return null;
		
	}
}

