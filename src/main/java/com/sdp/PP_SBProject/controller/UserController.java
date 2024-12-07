package com.sdp.PP_SBProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.PP_SBProject.model.Admin;
import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.repository.AdminRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;
import com.sdp.PP_SBProject.service.AdminService;
import com.sdp.PP_SBProject.service.EmployerService;
import com.sdp.PP_SBProject.service.StudentService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
    private StudentService studentservice;
	
      @Autowired
      private AdminService adminservice;
      
      @Autowired
      private EmployerService employerservice;
	
	
	@PostMapping("/checklogin")
	public ResponseEntity<?> AuthenticateLogin(@RequestBody Map<String,String> credentials)
	   {
			String email=credentials.get("email");
		   String password=credentials.get("password");
		   
		   Student student=studentservice.checkAdminLogin(email, password);
		   
		   if(student!=null)
		   {
			   return ResponseEntity.ok(student);
		   }
		   Admin admin=adminservice.checkAdminLogin(email, password);
			   if(admin!=null)
			   {
				   return ResponseEntity.ok(admin);
			   }
			 Employer employer=employerservice.checkEmployerLogin(email, password);
			 {
				 if(employer!=null)
				 {
					 return ResponseEntity.ok(employer);
				 }
			 }
			   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		   
	   }
   
}
