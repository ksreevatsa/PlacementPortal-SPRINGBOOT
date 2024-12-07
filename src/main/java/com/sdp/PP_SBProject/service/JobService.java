package com.sdp.PP_SBProject.service;

import java.util.List;
import java.util.Map;

import com.sdp.PP_SBProject.model.Job;

public interface JobService 
{
    public Job addJob(Job job,int employerId);
    
    public List<Job> getJobsByEmployer(int employerId);
    
    public List<Job> getAllJobs();   
    
    public Map<String, List<Job>> filterJobsByApplicationStatus(int studentId);
}
