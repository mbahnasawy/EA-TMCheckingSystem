package cs544.eaproject.repository;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;
 
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class AppointmentRepositoryTest {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private RoleRepository roleRepository;
     
    @Test
    public void testRepository() 
    {
		User provider = new User("Ahmed", "Yassen", "Male", "x@y.com", 
				roleRepository.findById(3L).get(), "P@ssw0rd","xyz");

		GregorianCalendar calendar = new GregorianCalendar(2021, Calendar.FEBRUARY, 20, 18, 9, 22);

		Appointment a = new Appointment(calendar.getTime(), "Lab", provider);

		appointmentRepository.save(a);

	 
		appointmentRepository.save(a);
         
        Assert.assertNotNull(a.getId());
    }
}
