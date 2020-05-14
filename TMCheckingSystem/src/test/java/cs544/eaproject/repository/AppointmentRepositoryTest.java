package cs544.eaproject.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
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
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testRepository() {
		Role role = new Role("Test");

		User provider = new User("Ahmed", "Yassen", "Male", "x@y.com", role, "P@ssw0rd", "xyz");

		GregorianCalendar calendar = new GregorianCalendar(2021, Calendar.FEBRUARY, 20, 18, 9, 22);

		Appointment a = new Appointment(calendar.getTime(), "Lab", provider);

		userRepository.save(provider);
		appointmentRepository.save(a);

		Assert.assertNotNull(a.getId());
	}

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Role role = new Role("Test");

		User provider = new User("Ahmed", "Yassen", "Male", "x@y.com", role, "P@ssw0rd", "xyz");

		GregorianCalendar calendar = new GregorianCalendar(2021, Calendar.FEBRUARY, 20, 18, 9, 22);

		Appointment a = new Appointment(calendar.getTime(), "Lab", provider);

		Long id = (Long)entityManager.persistAndGetId(a);
		entityManager.flush();

		// when
		Appointment found = appointmentRepository.findById(id).get();

		// then
		assertThat(found.getLocation()).isEqualTo("Lab");
	}
}
