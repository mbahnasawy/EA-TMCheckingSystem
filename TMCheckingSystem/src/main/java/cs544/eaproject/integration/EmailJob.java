package cs544.eaproject.integration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.repository.ReservationRepository;
import cs544.eaproject.service.dto.ReservationDto;

@Configuration
@EnableScheduling
@Transactional
public class EmailJob {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	ModelMapper mapper;
	
	//minute (0 - 59)hour (0 - 23) day of the month (1 - 31)month (1 - 12)day of the week
	
	@Scheduled(cron = "5 * * * * *")
	public void emailTask() {
		System.out.println("Starting Email job");
		Date date =Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant());
		List<Reservation> reservations = reservationRepository.getReservationsBeforeDate(date);
		reservations.forEach(r -> sendMail(mapper.map(r, ReservationDto.class)));
		System.out.println("Ending Email job");
	}
	
	public void sendMail(ReservationDto resv) {
		Date date =Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = format.format(date);
		String AppDate =format.format(resv.getAppointment().getDateTime());
		//System.out.println(nowDate +" " + AppDate);
		System.out.println("Sending Emails");
		if(nowDate.equals(AppDate )) {
			String Name = resv.getConsumer().getLastName()+" "+resv.getConsumer().getFirstName();
			emailSender.createNotfication(resv.getConsumer().getEmail(),Name , resv.getAppointment().getDateTime());
		}
	}

}
