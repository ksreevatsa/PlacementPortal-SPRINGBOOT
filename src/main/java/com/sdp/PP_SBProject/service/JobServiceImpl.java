package com.sdp.PP_SBProject.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Job;
import com.sdp.PP_SBProject.model.JobApplication;
import com.sdp.PP_SBProject.repository.EmployerRepository;
import com.sdp.PP_SBProject.repository.JobApplicationRepository;
import com.sdp.PP_SBProject.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService
{

	 @Autowired
	 private JobRepository jobrepository;
	
	 @Autowired
	 private EmployerRepository employerrepository;
	 
	 @Autowired
	 private JobApplicationRepository jobapplicationrepository;
	
	@Override
	public Job addJob(Job job, int employerId) {
		
		Employer employer=employerrepository.findById(employerId).orElseThrow(()->new RuntimeException("employer not found with id:"+employerId));
		
		job.setEmployer(employer);
		job.setPostedDate(LocalDate.now());
		
		return jobrepository.save(job);
	}

	@Override
	public List<Job> getJobsByEmployer(int employerId) {
		
		return jobrepository.findByEmployerId(employerId);
	}

	@Override
	public List<Job> getAllJobs() {
	
		return jobrepository.findAll();
	}

	@Override
	public Map<String, List<Job>> filterJobsByApplicationStatus(int studentId) {
		
		List<Job> allJobs=jobrepository.findAll();
		List<JobApplication> appliedApplications=jobapplicationrepository.findByStudentId(studentId);
		
		//collect applied job IDs
		Set<Integer> appliedJobIds=appliedApplications.stream().map(app->app.getJob().getId()).collect(Collectors.toSet());
		
		//separate jobs into "Applied" and "NotApplied"
		List<Job> appliedJobs=allJobs.stream().filter(job->appliedJobIds.contains(job.getId())).collect(Collectors.toList());
		
		List<Job> notAppliedJobs=allJobs.stream().filter(job->!appliedJobIds.contains(job.getId())).collect(Collectors.toList());
		
		Map<String, List<Job>> r=new HashMap<>();
		
		r.put("Applied", appliedJobs);
		r.put("Not Applied", notAppliedJobs);
		
		return r;
	}
	
	

}
