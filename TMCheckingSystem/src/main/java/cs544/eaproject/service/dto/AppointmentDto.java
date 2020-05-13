package cs544.eaproject.service.dto;

import java.util.Date;

public class AppointmentDto {
	
	private String location;
	private Date dateTime;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
