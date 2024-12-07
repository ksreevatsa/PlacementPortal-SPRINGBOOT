package com.sdp.PP_SBProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Job;
import com.sdp.PP_SBProject.repository.EmployerRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationServiceImpl implements NotificationService
{

	  @Autowired
	  private StudentRepository studentrepository;
	  
	  @Autowired
	  private JavaMailSender mailSender;
	  
	  @Autowired
	  private EmployerRepository employerRepository;
	  
	  
	@Override
	public List<String> getAllEmails() {
		
		return studentrepository.findAllEmaList();
	}
	@Override
	public void sendJobNotification(String toEmail, Job job,int eId)
	{
		try
		{
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		
			
			  Employer employer = employerRepository.findById(eId)
			            .orElseThrow(() -> new RuntimeException("Employer not found"));
			  job.setEmployer(employer);
			  
			helper.setTo(toEmail);
			
			helper.setSubject("New Job Opportunity: " + job.getTitle());
			
			helper.setFrom("placementpulse7@gmail.com");
			
			String content= "<h3>New Job Posted</h3>" +
	                "<p><strong>Company Name:</strong> " + job.getCompanyName() + "</p>" +
	                "<p><strong>Title:</strong> " + job.getTitle() + "</p>" +
	                "<p><strong>Description:</strong> " + job.getDescription() + "</p>" +
	                "<p><strong>Location:</strong> " + job.getLocation() + "</p>" +
	                "<p><strong>Salary:</strong> " + job.getSalary() + "</p>" +
	                "<p><br>Thank you,<br>PlacementPulse Team</p>";
			helper.setText(content,true);
			mailSender.send(mimeMessage);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
