package cs544.eaproject.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private long id;
	private ReservationStatus status;

	// person requesting the reservation
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dateTime;
	@ManyToOne
	private User consumer;
	@ManyToOne
	private Appointment appointment;

	public Reservation(LocalDate dateTime, User consumer) {
		this.dateTime = dateTime;
		this.consumer = consumer;
		this.status = ReservationStatus.PENDING;
	}

	public Reservation() {
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
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

	public long getId() {
		return id;
	}

}
