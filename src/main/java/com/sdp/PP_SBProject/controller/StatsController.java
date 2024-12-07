package com.sdp.PP_SBProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdp.PP_SBProject.repository.JobApplicationRepository;
import com.sdp.PP_SBProject.repository.JobRepository;

@RestController
@RequestMapping("/stats")
public class StatsController 
{
    @Autowired
    private JobRepository jobrepo;
    
    @Autowired
    private JobApplicationRepository jobapllicationrepo;
    
    @GetMapping("/job-count")
    public long getTotalJobs()
    {
    	return jobrepo.count();
    }

    
    @GetMapping("/applications-per-job")
    public List<Map<String, Object>> getApplicationsPerJob() {
        return jobrepo.findAll().stream()
                .map(job -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("jobTitle", job.getTitle());
                    map.put("applications", job.getJobapplications().size());
                    return map;
                })
                .collect(Collectors.toList());
    }
    
    @GetMapping("/jobs-by-industry")
    public Map<String,Long> getJobsByIndustry()
    {
		return jobrepo.findAll().stream().collect(Collectors.groupingBy(job->job.getEmployer().getIndustry(),Collectors.counting()));
    	
    }

}
