package com.sdp.PP_SBProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sdp.PP_SBProject.model.Employer;

public interface EmployerService 
{
    public String addEmployer(Employer employer);
    public Employer checkEmployerLogin(String email,String password);
    
    public boolean findEmailInStudent(String email);
    public boolean findEmailInAdmin(String email);
    public boolean findEmailInEmployer(String email);
}
