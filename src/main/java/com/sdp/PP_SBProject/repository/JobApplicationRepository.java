package com.sdp.PP_SBProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.PP_SBProject.model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>
{
    List<JobApplication>  findByJobId(int JobId);
    
    List<JobApplication> findByStudentId(int studentId);
}
