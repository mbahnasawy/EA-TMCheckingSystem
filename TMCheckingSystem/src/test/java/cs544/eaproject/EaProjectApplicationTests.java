package cs544.eaproject;



import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import cs544.eaproject.controller.AppointmentControllerTest;
import cs544.eaproject.controller.ReservationControllerTest;
import cs544.eaproject.repository.AppointmentRepositoryTest;
import cs544.eaproject.security.SecurityApplicationTest;
import cs544.eaproject.service.AppointmentServiceTest;

@RunWith(value=Suite.class) 
@SuiteClasses(value={
AppointmentControllerTest.class, 
SecurityApplicationTest.class, 
AppointmentRepositoryTest.class,
AppointmentServiceTest.class,
ReservationControllerTest.class})
class EaProjectApplicationTests {
	
}
