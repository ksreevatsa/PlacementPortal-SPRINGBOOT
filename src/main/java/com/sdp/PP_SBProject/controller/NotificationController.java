package com.sdp.PP_SBProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.PP_SBProject.model.Job;
import com.sdp.PP_SBProject.service.NotificationService;

@Controller
@RequestMapping("/notification")
public class NotificationController 
{
	
	@Autowired
	private NotificationService notificationservice;
	
	
      @PostMapping("/sendemailNotification/{empId}")
      public ResponseEntity<?> sendNotification(@RequestBody Job job,@PathVariable("empId") int empId)
      {
    	  
    	  try 
    	  {
              // Retrieve all email addresses
              List<String> emailList = notificationservice.getAllEmails();
              
             

              // Send email notifications by calling service
              for (String email : emailList) 
              {
                  notificationservice.sendJobNotification(email, job,empId);
              }

              return ResponseEntity.ok("Email notifications sent successfully!");
          } 
    	  catch (Exception e) 
    	  {
              return ResponseEntity.status(500).body("Error while sending email notifications: " + e.getMessage());
          }
    	  
      }
}
