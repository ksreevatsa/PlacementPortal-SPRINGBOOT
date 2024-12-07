package com.sdp.PP_SBProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.PP_SBProject.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>
{
  List<Job> findByEmployerId(int employerId);
  
}
