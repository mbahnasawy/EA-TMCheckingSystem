package cs544.eaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cs544.eaproject.config.AppConfig;
import cs544.eaproject.service.ReservationService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ReservationService reservationService = context.getBean("reservationService", ReservationService.class);
		//customerService.addCustomer();
	}

}
