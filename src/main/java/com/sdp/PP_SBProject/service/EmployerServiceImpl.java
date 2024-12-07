package com.sdp.PP_SBProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.repository.AdminRepository;
import com.sdp.PP_SBProject.repository.EmployerRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;

@Service
public class EmployerServiceImpl implements EmployerService
{
	
	@Autowired
	EmployerRepository employerrepository;
	@Autowired
	AdminRepository adminrepository;
	@Autowired
	StudentRepository studentrepository;

	@Override
	public String addEmployer(Employer employer) {
		
		employerrepository.save(employer);
		return "employer added successfully";
	}
	
	
	
	@Override
	public boolean findEmailInStudent(String email) {
		
		return studentrepository.findByEmail(email)!=null;
	}
      public boolean findEmailInAdmin(String email) {
		
		return adminrepository.findByEmail(email)!=null;
	}

	@Override
	public boolean findEmailInEmployer(String email) {
		return employerrepository.findByEmail(email)!=null;
	}



	@Override
	public Employer checkEmployerLogin(String email, String password) {
		
		return employerrepository.findByEmailAndPassword(email, password);
	}
    
}
