package cs544.eaproject.dao;

public interface AppointmentDAO extends BaseDAO<Appointment>{
	List<Appointment> getAll();

}
