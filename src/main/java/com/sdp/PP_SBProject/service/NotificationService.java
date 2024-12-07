package com.sdp.PP_SBProject.service;

import java.util.List;

import com.sdp.PP_SBProject.model.Job;

public interface NotificationService 
{
     public List<String> getAllEmails();
     
     public void sendJobNotification(String toEmail,Job job,int empId);
}
