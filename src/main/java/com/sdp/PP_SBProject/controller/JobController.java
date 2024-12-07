package com.sdp.PP_SBProject.controller;

import java.util.List;
import java.util.Map;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.sdp.PP_SBProject.model.Job;
import com.sdp.PP_SBProject.model.Views;
import com.sdp.PP_SBProject.service.JobService;

@Controller
@RequestMapping("/jobs")

public class JobController 
{
   @Autowired
   private JobService jobservice;
   
   @PostMapping("/addjob/{employerId}")
   public ResponseEntity<?> addJob(@RequestBody Job job,@PathVariable("employerId") int employerId)
   {
	   Job savedJob=jobservice.addJob(job, employerId);
	   return ResponseEntity.ok("Job Added Successfully");
   }
   
   @GetMapping("/getJobsByEmployer/{employerId}")
   @JsonView(Views.Employer.class)
   public ResponseEntity<List<Job>> getJobsByEmployer(@PathVariable("employerId") int employerId)
   {
	   List<Job> jobs=jobservice.getJobsByEmployer(employerId);
	   return ResponseEntity.ok(jobs);
   }
   
   @GetMapping("/getall")
   @JsonView(Views.Student.class)
   public ResponseEntity<List<Job>> getAllJobs()
   {
	   List<Job> jobs=jobservice.getAllJobs();
	   return ResponseEntity.ok(jobs);
   }
   
   @GetMapping("/filter")
   @JsonView(Views.Student.class)
   public ResponseEntity<Map<String,List<Job>>> filterjobs(@RequestParam int studentId)
   {
	   return ResponseEntity.ok(jobservice.filterJobsByApplicationStatus(studentId));
   }
   
}
