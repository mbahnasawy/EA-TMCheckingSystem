package cs544.eaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.dao.ReservationDAO;
import cs544.eaproject.dao.UserDAO;
import cs544.eaproject.service.AppointmentService;
import cs544.eaproject.service.ReservationService;
import cs544.eaproject.service.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		UserService userService = new UserService();
		// TODO set DI
		return userService;
	}
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}

	@Bean
	public AppointmentService appointmentService() {
		AppointmentService appointmentService = new AppointmentService();
		// TODO set DI
		return appointmentService;
	}
	
	@Bean
	public AppointmentDAO appointmentDAO() {
		return new AppointmentDAO();
	}
	
	@Bean
	public ReservationService reservationService() {
		ReservationService reservationService = new ReservationService();
		// TODO set DI
		return reservationService;
	}
	
	@Bean
	public ReservationDAO reservationDAO() {
		return new ReservationDAO();
	}


}
