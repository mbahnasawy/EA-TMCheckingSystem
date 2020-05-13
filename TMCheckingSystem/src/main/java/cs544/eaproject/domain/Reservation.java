package cs544.eaproject.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	// person requesting the reservation
	private Date dateTime;
	@NotNull
	@ManyToOne
	private User consumer;
	@NotNull
	@ManyToOne
	private Appointment appointment;

	public Reservation(User consumer) {
		this.dateTime = Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant());
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", status=" + status + ", dateTime=" + dateTime + ", consumer=" + consumer
				+ ", appointment=" + appointment + "]";
	}
	
	

}