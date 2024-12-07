package com.sdp.PP_SBProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.JobApplication;

public interface JobApplicationService 
{
    public ResponseEntity<?> applyForJob(int studentId,int jobId, String name, String university, String email, 
            String phoneNumber, String yearInUniversity, MultipartFile resume);
    
    public List<JobApplication>jobApplications(int jobId);
}
