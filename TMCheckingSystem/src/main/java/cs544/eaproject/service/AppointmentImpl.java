package cs544.eaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.CourseDAO;
import edu.mum.cs.cs544.attendance.entity.Course;
import edu.mum.cs.cs544.attendance.service.CourseService;

public interface AppointmentImpl {

	
	@Transactional
	@Service
	public class CourseServiceImpl implements CourseService {

		@Autowired
		private AppointmentDAO appointmentDao;

		
		public Course addCourse(Course course) {
			return courseDao.add(course);
		}
		
		public Course updateCourse(Course course) {
			return courseDao.update(course);
		}
		
		public boolean deleteCourseById(int id) {

			return courseDao.delete(id);
		}
		
		public Course getCourseById(int id) {
			return courseDao.get(id);
		}
		
		public List<Course> getAllCourses() {
			return courseDao.getAll();
		}
		
		public boolean saveAll(List<Course> courses) {

			return false;
		}

	
	
}
