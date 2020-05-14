package cs544.eaproject.repository;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTest {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void testRepository() {
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(3L).get());
		User provider = new User("Ahmed", "Yassen", "Male", "x@y.com", roles, "P@ssw0rd", "xyz");

		GregorianCalendar calendar = new GregorianCalendar(2021, Calendar.FEBRUARY, 20, 18, 9, 22);

		Appointment a = new Appointment(calendar.getTime(), "Lab", provider);

		appointmentRepository.save(a);

		appointmentRepository.save(a);

		Assert.assertNotNull(a.getId());
	}
}
