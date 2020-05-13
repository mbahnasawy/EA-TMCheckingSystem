package cs544.eaproject.integration;

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
public class JMSSener implements Sender, Job{
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	private SimpleMailMessage simpleMailMessage;
	
	private SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
	
	@Value("${Mail.subject}")
	private String subject;

	@Override
	public void Send() {
		// TODO Auto-generated method stub
		
	}
	//@Schedules
	@Async
	@Override
	public void createMsg(String mail, String Text) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mail);
		mailMessage.setSubject(subject);
		mailMessage.setText(Text);
		emailSenderService.sendEmail(mailMessage);
	}
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	
	

}
