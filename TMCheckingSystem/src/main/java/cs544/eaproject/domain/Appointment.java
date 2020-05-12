package cs544.eaproject.domain;

import java.time.LocalDate;


public class Appointment {
	private int id;
	private String location;
	private LocalDate date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	} 
	
	

}
