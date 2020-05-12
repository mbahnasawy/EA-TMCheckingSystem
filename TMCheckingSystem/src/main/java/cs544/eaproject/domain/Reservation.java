package cs544.eaproject.domain;

import java.time.LocalDate;

import cs544.eaproject.util.Status;

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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", status=" + status + ", date=" + date + ", appointment=" + appointment + "]";
	}
	
	
	}
