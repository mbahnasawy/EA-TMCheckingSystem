package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.dao.UserDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.User;
import cs544.eaproject.service.AppointmentService;
import cs544.eaproject.util.Response;
import cs544.eaproject.util.ResponseStatus;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {
	

	@RequestMapping(value ="/delete/{appointmentId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long appointmentId) throws Exception{

		appointmentService.delete(appointmentId);

	}

	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	UserDAO userDao; 

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Response createAppointment(@RequestBody Appointment appointmentDTO) {
		Response response = new Response();

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
			User current_user = userDao.findByEmail(auth.getName());

//			if(!((Role) current_user.getUserRole()).getRoleName().equals("CHECKER")) {
//				throw new Exception("");
//			}
			
			appointmentDTO.setProvider(current_user);
			Appointment appointment = appointmentService.createAppointment(appointmentDTO);
			response.setResult(appointment);
			response.setMessage(ResponseStatus.SUCCESS_MESSAGE);
			response.setStatus(ResponseStatus.SUCCESS_CODE);

		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseStatus.ERROR_CODE);
		}

		return response;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
