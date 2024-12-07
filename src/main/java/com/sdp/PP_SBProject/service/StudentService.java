package com.sdp.PP_SBProject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.Student;

public interface StudentService 
{

	
	public String addStudent(Student student,MultipartFile photo);
	
	 public Student checkAdminLogin(String email,String password);
	 public boolean findEmailInStudent(String email);
	    public boolean findEmailInAdmin(String email);
	    public boolean findEmailInEmployer(String email);
	    
	    
}
