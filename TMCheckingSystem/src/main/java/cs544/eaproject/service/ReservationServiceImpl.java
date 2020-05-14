package cs544.eaproject.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.ReservationStatus;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;
import cs544.eaproject.integration.JMSSener;
import cs544.eaproject.integration.Sender;
import cs544.eaproject.repository.AppointmentRepository;
import cs544.eaproject.repository.ReservationRepository;
import cs544.eaproject.repository.RoleRepository;
import cs544.eaproject.repository.UserRepository;
import cs544.eaproject.service.dto.ReservationDto;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private  UserRepository userDao ; 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private  AppointmentRepository appointmentDao ; 
	
	@Autowired
	private Sender mailSender;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReservationDto createReservation(long appointmentId) throws Exception {
		// TODO Auto-generated method stub
		// Reservation reservation = reservationMapper.mapToReservation(reservationdto);
		// reservation = reservationRepository.save(reservation);
		// Reservation reservation = new Reservation(dateTime, consumer)
		// return reservationMapper.maptoReservationDto(reservation);
		// Appointment appointment = appointmentRepository.getOne(appointmentId);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User current_user = userDao.findByUserName(auth.getName());
		if(checkReservationExists(current_user.getId(),appointmentId))
			throw new Exception("you already Reserved");
		Reservation reservation = new Reservation(current_user);
		Appointment appointment = appointmentDao.findById(appointmentId).get();
		appointment.addReservation(reservation);
		reservationRepository.save(reservation);	
		
		return convertEntityToResponse(reservation);
	}

	@Override
	public boolean acceptReservation(long ReservationId) throws Exception {
		// TODO Auto-generated method stub
		Reservation reservation =reservationRepository.findById(ReservationId).orElseThrow(Exception::new);
		List<Reservation> reservationlst = reservationRepository.getReservationByAppId(reservation.getAppointment());
		reservationlst.forEach(e -> e.setStatus(ReservationStatus.DECLINED));
		reservation.setStatus(ReservationStatus.ACCEPTED);
		mailSender.createMsg(reservation.getConsumer().getEmail(), 
				"Congratulations your Reservation is approved by Mr."
		+reservation.getAppointment().getProvider().getFirstName()
		+" At : "+ reservation.getAppointment().getDateTime());
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

		return convertEntityListToResponseList(reservationRepository.findAll());
	}

	@Override
	public List<ReservationDto> convertEntityListToResponseList(List<Reservation> entityList) {
		// TODO Auto-generated method stub
		if (null == entityList)
			return null;
		else {
			return entityList.stream().map(entity -> modelMapper.map(entity, ReservationDto.class))
					.collect(Collectors.toList());
		}

	}

	@Override
	public ReservationDto convertEntityToResponse(Reservation entity) {
		// TODO Auto-generated method stub
		if (null == entity) {
			return null;
		} else {
			return modelMapper.map(entity, ReservationDto.class);
		}
	}

	@Override
	public ReservationDto getReservationbyId(long id) throws Exception {

		// TODO Auto-generated method stub
		Reservation reservation = reservationRepository.findById(id).orElseThrow(Exception::new);
		return modelMapper.map(reservation, ReservationDto.class);
	}

	@Override
	public boolean checkReservationExists(long userId , long appointmentId) {
		// TODO Auto-generated method stub
		Reservation reservation=
				reservationRepository.checkReservationExists(userId, appointmentId);
		if(reservation ==null)
			return false;
		return true;
					
	}

	@Override
	public List<ReservationDto> getReservationsByAppointment(long appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override
//	public void test() {
//		Role role = roleRepository.getOne(1L);
//		System.out.println(role);
//		User user = new User("karim", "slaah", "male", "teez", role, "5165161");
//		user.setUserName("a7a");
//		userDao.save(user);
//	}
	
}
