package cs544.eaproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cs544.eaproject.Application;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ReservationRepository reservationRepository;
 
	@BeforeAll
	public static void setupOnce() throws Exception{
		SpringApplication.run(Application.class);
		
	}
	
 
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
    	Role roleConsumer = new Role("Consumer");
    	Set<Role> rolesUser1 = new HashSet<>();
    	rolesUser1.add(roleConsumer);
    	User user1 = new User("Ahmed", "Mostafa", "Male", "mbahnasawy@miu.edu", roleConsumer, "","admin");
    	
    	Role roleProvider = new Role("Provider");
    	Set<Role> rolesUser2 = new HashSet<>();
    	rolesUser2.add(roleProvider);
    	User user2 = new User("Karim", "Salama", "Male", "ksalama@miu.edu", roleProvider , "","consumer");
    	
    	Date date = new GregorianCalendar(2020, Calendar.MAY, 15).getTime();
		Appointment a1 = new Appointment(date, "Virall Room32", user2);
       // Reservation r1 = new Reservation(user1);
       // a1.addReservation(r1);
        
       // entityManager.persist(r1);
        entityManager.persist(a1);
        entityManager.persist(roleConsumer);
        entityManager.persist(roleProvider);
        entityManager.persist(rolesUser1);
        entityManager.persist(rolesUser2);
        
        entityManager.flush();
     
        // when
       // Optional<Reservation> found = reservationRepository.findById(r1.getId());
     
        // then
      //  assertThat(found.get().getAppointment().getLocation())
      //    .isEqualTo(a1.getLocation());
    }
 
}