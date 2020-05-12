package cs544.eaproject.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import cs544.eaproject.Application;

public class ReservationServiceTest {

	static ReservationService reservationService ; 
	
	@BeforeAll
	public static void setupOnce() throws Exception{
		SpringApplication.run(Application.class);
		
	}
	
	@Test
	public void testInjectionOnNull() {
		assertNotNull("Injected Service is not Null", reservationService.toString());
	}
	
	
}
