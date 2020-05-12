package cs544.eaproject.domain;

import java.time.LocalDate;
import java.util.List;

public class Appointment {

	private int Id;
	
	 private LocalDate date;
	 
	 private User tmcheckr;
	 
	 private List<Reservation> reservation;

	public Appointment(int id, LocalDate date, User tmcheckr, List<Reservation> reservation) {
		super();
		Id = id;
		this.date = date;
		this.tmcheckr = tmcheckr;
		this.reservation = reservation;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getTmcheckr() {
		return tmcheckr;
	}

	public void setTmcheckr(User tmcheckr) {
		this.tmcheckr = tmcheckr;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Appointment [Id=" + Id + ", date=" + date + ", tmcheckr=" + tmcheckr + ", reservation=" + reservation
				+ "]";
	}
	 
	 
	 
}
