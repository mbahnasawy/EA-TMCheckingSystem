package cs544.eaproject.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	
	private Integer id;
	
	private Status status;
	
	private LocalDate date;
	
	private Appointment appointment;

	public Reservation(Integer id, Status status, LocalDate date, Appointment appointment) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.appointment = appointment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private ReservationStatus status;

	// person requesting the reservation
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	@ManyToOne
	private User consumer;
	@ManyToOne
	private Appointment appointment;

	public Reservation(Date dateTime, User consumer) {
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

}
