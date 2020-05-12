package cs544.eaproject.service.dto;

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
	private User consumer;
	private Appointment appointment;
	public ReservationDto(long id, ReservationStatus status, Date dateTime, User consumer, Appointment appointment) {
		this.id = id;
		this.status = status;
		this.dateTime = dateTime;
		this.consumer = consumer;
		this.appointment = appointment;
	}
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
	public User getConsumer() {
		return consumer;
	}
	public void setConsumer(User consumer) {
		this.consumer = consumer;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}	
	
}
