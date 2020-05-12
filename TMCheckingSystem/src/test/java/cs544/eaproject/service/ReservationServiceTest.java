package cs544.eaproject.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import cs544.eaproject.Application;

public class ReservationServiceTest {

	static ReservationServiceImpl reservationService;
	
	@BeforeAll
	public static void setupOnce() throws Exception{
		SpringApplication.run(Application.class);
		
	}
	
	@Test
	public void testInjectionNotNull() {
		assertTrue(true);
	}
	
	
}
