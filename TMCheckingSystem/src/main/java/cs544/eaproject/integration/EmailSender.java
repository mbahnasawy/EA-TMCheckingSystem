package cs544.eaproject.integration;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import cs544.eaproject.service.EmailSenderService;
import javassist.Loader.Simple;

@Component
public class EmailSender{
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	private SimpleMailMessage simpleMailMessage;

	@Value("${Mail.subject}")
	private String subject;
	
	@Value("${Accept.Resveration.Msg}")
	private String AcceptResvMsg;
	
	@Value("${Decline.Resveration.Msg}")
	private String DeclineResvMsg;
	
	private String AppointmentCancelMsg;
	
	
	//@Schedules
	public void createAcceptMsg(String mail,String senderName,Date date) {
		// TODO Auto-generated method stub
		String msg = AcceptResvMsg +" "+ senderName + " At  " + date.toString();
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mail);
		mailMessage.setSubject(subject);
		mailMessage.setText(msg);
		Send(mailMessage);
	}
	
	public void createDeclineMsg(String mail) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mail);
		mailMessage.setSubject(subject);
		mailMessage.setText(DeclineResvMsg);
		Send(mailMessage);
	}
	
	@Async
	private void Send(SimpleMailMessage mailMessage) {
		emailSenderService.sendEmail(mailMessage);
	}
	

}
