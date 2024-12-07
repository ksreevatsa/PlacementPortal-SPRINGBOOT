package com.sdp.PP_SBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.PP_SBProject.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer>
{
    public Employer findByEmail(String email);
    
    public Employer findByEmailAndPassword(String email,String password);
}
