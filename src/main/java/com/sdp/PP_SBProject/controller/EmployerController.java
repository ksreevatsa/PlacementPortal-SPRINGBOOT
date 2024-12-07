package com.sdp.PP_SBProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.service.EmployerService;

@Controller
@RequestMapping("/employer")
public class EmployerController 
{
    @Autowired
    EmployerService employeeservice;
    
    @PostMapping("/insertemployer")
    public ResponseEntity<String> insertEmpoyer(@RequestBody Employer employer)
    {
    	String email=employer.getEmail();
    	if(!employeeservice.findEmailInAdmin(email)&&!employeeservice.findEmailInStudent(email)&&!employeeservice.findEmailInEmployer(email))
		{
    	String msg=employeeservice.addEmployer(employer);
    	
    	return ResponseEntity.ok(msg);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Id Already Registered");
		}
    }
}
