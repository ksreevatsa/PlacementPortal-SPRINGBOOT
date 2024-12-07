package com.sdp.PP_SBProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.JobApplication;
import com.sdp.PP_SBProject.service.JobApplicationService;

@Controller
@RequestMapping("/application")
public class JobApplicationController
{
    @Autowired
    JobApplicationService jobapplicationservice;
    
    @PostMapping("/apply")
    public ResponseEntity<?> applyForJob(@RequestParam("studentId") int studentId,
            @RequestParam("jobId") int jobId,
            @RequestParam("name") String name,
            @RequestParam("university") String university,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("yearInUniversity") String yearInUniversity,
            @RequestParam("resume") MultipartFile resume) 
    {
		return jobapplicationservice.applyForJob(studentId, jobId, name, university, email, phoneNumber, yearInUniversity, resume);
    	
    }
    
    @GetMapping("/getapplicationsbyid/{jobId}")
    public  ResponseEntity<?> getApplicationById(@PathVariable("jobId") int jobId)
    {
    	List<JobApplication> applications=jobapplicationservice.jobApplications(jobId);
    	return ResponseEntity.ok(applications);
    }
}
