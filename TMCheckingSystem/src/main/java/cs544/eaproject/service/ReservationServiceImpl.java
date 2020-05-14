package cs544.eaproject.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.AppointmentDAO;
import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.ReservationStatus;
import cs544.eaproject.domain.User;
import cs544.eaproject.repository.AppointmentRepository;
import cs544.eaproject.repository.ReservationRepository;
import cs544.eaproject.repository.UserRepository;
import cs544.eaproject.service.dto.ReservationDto;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private  AppointmentRepository appointmentDao ; 
	
//	@Autowired
//	private AppointmentRepository appointmentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ReservationDto createReservation(long appointmentId) {
		// TODO Auto-generated method stub
		//Reservation reservation = reservationMapper.mapToReservation(reservationdto);
		//reservation = reservationRepository.save(reservation);
		//Reservation reservation = new Reservation(dateTime, consumer)
		//return reservationMapper.maptoReservationDto(reservation);
		//Appointment appointment = appointmentRepository.getOne(appointmentId);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User current_user = userRepository.findByUserName(auth.getName());

		Reservation reservation = new Reservation(current_user);
		Optional<Appointment> app = appointmentDao.findById(appointmentId);
		if(app.isPresent()) {
			Appointment appointment =  app.get();
			appointment.addReservation(reservation);
		}
		reservationRepository.save(reservation);	
		
		return convertEntityToResponse(reservation);
	}

	@Override
	public boolean acceptReservation(long ReservationId) throws Exception {
		// TODO Auto-generated method stub
		Reservation reservation =reservationRepository.findById(ReservationId).orElseThrow(Exception::new);
		reservation.setStatus(ReservationStatus.ACCEPTED);				
		return true;
	}

	@Override
	public boolean cancelReservation(long ReservationId) throws Exception {
		// TODO Auto-generated method stub
		Reservation reservation =reservationRepository.findById(ReservationId).orElseThrow(Exception::new);
		
		reservationRepository.delete(reservation);
		return true;
	}

	@Override
	public List<ReservationDto> viewReservations() {
		// TODO Auto-generated method stub
		
		return convertEntityListToResponseList(reservationRepository.findAll())	;
	}

	@Override
	public List<ReservationDto> convertEntityListToResponseList(List<Reservation> entityList) {
		// TODO Auto-generated method stub
		if(null == entityList)
			return null;
		else {
			return entityList.stream()
					.map(entity -> modelMapper.map(entity, ReservationDto.class))
					.collect(Collectors.toList());
		}
		
	}

	@Override
	public ReservationDto convertEntityToResponse(Reservation entity) {
		// TODO Auto-generated method stub
		if(null == entity) {
			return null;
		}
		else {
			return modelMapper.map(entity, ReservationDto.class) ;
		}
	}

	@Override
	public ReservationDto getReservationbyId(long id) throws Exception {
		
		// TODO Auto-generated method stub
		Reservation reservation =reservationRepository.findById(id).orElseThrow(Exception::new);
		return modelMapper.map(reservation, ReservationDto.class) ;
	}
	
}
