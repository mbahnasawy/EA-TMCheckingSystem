package cs544.eaproject.domain;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;



@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Change to localDate
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	private Date dateTime;

	@NotNull
	@Column(nullable = false)
	private String location;

	@OneToMany(mappedBy = "appointment",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private Set<@Valid Reservation> reservations;

	@NotNull
	@ManyToOne
	private User provider;

	public Appointment() {
	}

	public Appointment(Date dateTime, String location, User provider) {
		this.dateTime = dateTime;
		this.location = location;
		this.provider = provider;
	}

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

	public void setReservations(Set<Reservation> reservations) {
		this.reservations.addAll(reservations);
	}

	public void addReservation(Reservation reservation) {
		// add this
		reservation.setAppointment(this);
		reservations.add(reservation);
	}
}
