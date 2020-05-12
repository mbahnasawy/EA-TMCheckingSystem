package cs544.EAPoroject;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import cs544.eaproject.dao.AppointmentDAO;

import cs544.eaproject.service.AppointmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EaProjectApplicationTests {
	
	@Autowired
	AppointmentService appointmentSerive;
	
	@MockBean
	private AppointmentDAO appointmentdao;
	
	
	@Test
	public void cancelAppointment(long id) {
		
	}
	
	@Test
	void contextLoads() {
	}

}
