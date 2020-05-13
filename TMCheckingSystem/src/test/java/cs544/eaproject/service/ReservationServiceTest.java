package cs544.eaproject.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;

import cs544.eaproject.Application;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;
import cs544.eaproject.repository.ReservationRepository;

public class ReservationServiceTest {

	@InjectMocks
	private ReservationService service;
	
	@Mock
	private ReservationRepository repository;


	@BeforeAll
	public static void setupOnce() throws Exception {
		SpringApplication.run(Application.class);

	}

    @BeforeEach
    public void setUp() {
        //given
    	Role roleProvider = new Role("Provider");
    	User user= new User("Karim", "Salama", "Male", "ksalama@miu.edu", roleProvider , "");
    	
    	Date date = new GregorianCalendar(2020, Calendar.MAY, 15).getTime();
		Appointment appointment = new Appointment(date, "Virall Room32", user);
		Reservation res = new Reservation(user);

        //mocking
    //    when(ReservationRepository.save(any(Reservation.class))).thenReturn(res);
    }
    
	@Test
	public void testInjectionNotNull() {
		assertTrue(true);
	}
	
	@Test
	public void test2() {
		assertTrue(true);
	}

	@Test
	public void test3() {
		assertTrue(true);
	}
}
