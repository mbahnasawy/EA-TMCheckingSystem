package cs544.eaproject.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.eaproject.service.AppointmentService;
import edu.mum.cs.cs544.attendance.controller.CourseController;
import edu.mum.cs.cs544.attendance.entity.Course;
import edu.mum.cs.cs544.attendance.service.CourseService;
import edu.mum.cs.cs544.attendance.util.Constants;
import edu.mum.cs.cs544.attendance.util.TimesheetResponse;

public class AppointmentController {
	
	private logger logger = Logger.getLogger(AppointmentController.class);

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String redirectRoot() {
		return " ";
	}
	
	
	public TimesheetResponse getAllCourses() {

		TimesheetResponse response = new TimesheetResponse();

		try {

			List<Course> courses = courseService.getAllCourses();

			response.setResult(courses);
			response.setStatus(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MESSAGE);

		} catch (Exception ex) {

			response.setStatus(Constants.ERROR_CODE);
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());

		}

		return response;
	}

	
	
}
