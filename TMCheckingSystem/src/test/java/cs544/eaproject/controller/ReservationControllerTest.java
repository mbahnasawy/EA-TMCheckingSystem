package cs544.eaproject.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;
import cs544.eaproject.service.ReservationService;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {
 
    @Autowired
    private MockMvc mvc;
 
    @Mock
    private ReservationService service;
    
    @Test
    public void test1()
      throws Exception {
         
       	Role roleConsumer = new Role("Consumer");
    	User user1 = new User("Ahmed", "Mostafa", "Male", "mbahnasawy@miu.edu", roleConsumer, "");
    	

    	Date date = new GregorianCalendar(2020, Calendar.MAY, 15).getTime();
        Reservation r1 = new Reservation(user1);
        
    }
    
//    @Test
//    public void testUserCreation() {
//       List<User> tempUsers = new ArrayList<>();
//       tempUsers.add(new User());
//       Mockito.when(mockedUserRepository.findByEmail(isA(String.class))).thenReturn(tempUsers);
//       try
//       {
//          userService.save(getSampleDTO());
//          Assert.isTrue(false,"email validation failed");
//       }
//       catch(CustomError exc)
//       {
//          Assert.isTrue(exc.getCode().equals(400) && exc.getMessage().contains("Email already used by another user"),"email validation successful");
//       }
//       catch(Exception exc)
//       {
//          Assert.isTrue(false,"email validation failed");
//       }
//    }

}