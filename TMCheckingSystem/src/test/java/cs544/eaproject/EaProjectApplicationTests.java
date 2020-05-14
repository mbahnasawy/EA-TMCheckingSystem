package cs544.eaproject;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cs544.eaproject.controller.AppointmentControllerTest;
import cs544.eaproject.controller.ReservationControllerTest;
import cs544.eaproject.repository.AppointmentRepositoryTest;
import cs544.eaproject.security.SecurityApplicationTest;

@RunWith(value=Suite.class) 
@SuiteClasses(value={
AppointmentControllerTest.class, 
SecurityApplicationTest.class, 
AppointmentRepositoryTest.class,
ReservationControllerTest.class})
class EaProjectApplicationTests {
	
}
