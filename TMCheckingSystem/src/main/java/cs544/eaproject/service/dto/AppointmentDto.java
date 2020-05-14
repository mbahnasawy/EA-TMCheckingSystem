package cs544.eaproject.service.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.User;

public class AppointmentDto {
	private long id;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateTime;

	private String location;

	private Set<Reservation> reservations;

	private User provider;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}
}
