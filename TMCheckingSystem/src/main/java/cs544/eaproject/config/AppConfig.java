package cs544.eaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs544.eaproject.service.AppointmentService;
import cs544.eaproject.service.ReservationService;

@Configuration
public class AppConfig {

	@Bean
	public AppointmentService appointmentService() {
		return appointmentService();
	}

	@Bean
	public ReservationService reservationService() {
		return reservationService();
	}

}
