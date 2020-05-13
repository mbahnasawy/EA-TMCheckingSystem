package cs544.eaproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.repository.AppointmentRepository;
import cs544.eaproject.service.dto.AppointmentDto;

@Transactional
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public AppointmentDto createAppointment(AppointmentDto appointmentDto) {

		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		appointmentRepository.save(appointment);
//		appointmentDao.create(appointment);

		return convertEntityToResponse(appointment);
	}

	@Override
	public void cancelAppointment(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public AppointmentDto viewAppointment(long id) {
		// TODO Auto-generated method stub
		return convertEntityToResponse(appointmentRepository.findById(id).orElseThrow());
	}

	public void delete(long id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public List<AppointmentDto> viewAppointments() {
		// TODO Auto-generated method stub
		return convertEntityListToResponseList(appointmentRepository.findAll());
	}

	@Override
	public List<AppointmentDto> viewAppointmentsByProvider(long id) {
		// TODO Auto-generated method stub
		return convertEntityListToResponseList(appointmentRepository.findByProvider(id));
	}

	public List<AppointmentDto> convertEntityListToResponseList(List<Appointment> entityList) {
		// TODO Auto-generated method stub
		if (null == entityList)
			return null;
		else {
			return entityList.stream().map(entity -> modelMapper.map(entity, AppointmentDto.class))
					.collect(Collectors.toList());
		}

	}

	public AppointmentDto convertEntityToResponse(Appointment entity) {
		// TODO Auto-generated method stub
		if (null == entity) {
			return null;
		} else {
			return modelMapper.map(entity, AppointmentDto.class);
		}
	}
}
