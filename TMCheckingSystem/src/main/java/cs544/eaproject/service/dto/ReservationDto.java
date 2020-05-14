package cs544.eaproject.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.ReservationStatus;
import cs544.eaproject.domain.User;

public class ReservationDto {

	private long id;
	
	private ReservationStatus status;
	
	private Date dateTime;
	
	private AppointmentDto appointment;
	
	private UserResponse consumer;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public UserResponse getConsumer() {
		return consumer;
	}

	public void setConsumer(UserResponse consumer) {
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", status=" + status + ", dateTime=" + dateTime + ", consumer=" + consumer
				+ "]";
	}

	public AppointmentDto getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDto appointment) {
		this.appointment = appointment;
	}
	
	
}
