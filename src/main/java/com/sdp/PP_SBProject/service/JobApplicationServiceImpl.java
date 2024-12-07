package com.sdp.PP_SBProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.Job;
import com.sdp.PP_SBProject.model.JobApplication;
import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.repository.JobApplicationRepository;
import com.sdp.PP_SBProject.repository.JobRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService
{
	
	@Autowired
	private JobApplicationRepository jobapplicationrepository;
	
	@Autowired
	private JobRepository jobrepository;
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public ResponseEntity<?> applyForJob(int studentId, int jobId, String name, String university, String email,
			String phoneNumber, String yearInUniversity, MultipartFile resume) 
	{
		try {
			Job job=jobrepository.findById(jobId).orElseThrow(()-> new IllegalArgumentException("Invalid Job Id"));
			
			Student student=studentrepository.findById(studentId).orElseThrow(()->new IllegalArgumentException("Invalid Student Id"));
			
			JobApplication application=new JobApplication();
			
			application.setName(name);
			application.setUniversity(university);
			application.setEmail(email);
			application.setYearInUnversity(yearInUniversity);
			application.setPhoneNumber(phoneNumber);
			application.setStatus("PENDING");
			application.setResume(resume.getBytes());
			application.setJob(job);
			application.setStudent(student);
			
			jobapplicationrepository.save(application);
			
			return new ResponseEntity<>("Job Application Submitted Successfully",HttpStatus.CREATED);
			
		}
		catch (IOException e) 
		{
            // Return error response
            return new ResponseEntity<>("Error while uploading resume", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
		catch (IllegalArgumentException e) {
            // Return error response if job or student not found
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}

	@Override
	public List<JobApplication> jobApplications(int jobId) {
		
		return jobapplicationrepository.findByJobId(jobId);
	}

}
