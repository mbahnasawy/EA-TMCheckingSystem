
  package cs544.eaproject.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.boot.model.relational.Database;

import cs544.eaproject.domain.Appointment;

public class AppointmentDAO{
	private Database db;
	
	public AppointmentDAO(Database db) {
		this.db=db;
		
	}
	public List<Appointment> findall(){

	List<Appointment> appointment=new ArrayList<Appointment>();
	ResultSet rs;
	try {
		rs = db.runSql("select * from appointment");
		while(rs.next()) {
			Integer appointmnetId=Integer.parseInt(rs.getString("id"));
			String dataTime=rs.getString("dataTime");
			String location=rs.getString("location");
			String provider=rs.getString("provider");
			
			appointment.add(new Appointment(id, dateTime, location, provider));
		}
		return appointment;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
}
}
}