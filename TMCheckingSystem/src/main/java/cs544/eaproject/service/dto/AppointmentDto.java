package cs544.eaproject.service.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.User;

public class AppointmentDto {
	private long id;

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

	public UserResponse getProvider() {
		return provider;
	}

	public void setProvider(UserResponse provider) {
		this.provider = provider;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateTime;

	private String location;

	private UserResponse provider;
	
	



}
