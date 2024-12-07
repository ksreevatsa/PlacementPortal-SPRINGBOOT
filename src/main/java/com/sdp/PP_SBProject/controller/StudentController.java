package com.sdp.PP_SBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController 
{
   
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/insertstudent")
	public ResponseEntity<String> insertStudent(@RequestPart("photo") MultipartFile photo,
		    @RequestPart("student") Student student)
	{
		
		String email=student.getEmail();
	     if(!studentservice.findEmailInAdmin(email)&&!studentservice.findEmailInStudent(email)&&!studentservice.findEmailInEmployer(email))
	     {
		   String msg=studentservice.addStudent(student,photo);
		   return ResponseEntity.ok(msg);
	     }
	     else
	     {
	    	 return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Id Already Registered");
	     }
	}
	
}
