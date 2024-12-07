package com.sdp.PP_SBProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.repository.AdminRepository;
import com.sdp.PP_SBProject.repository.EmployerRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private AdminRepository adminrepository;
	@Autowired
	private EmployerRepository employerrepository;

	@Override
	public String addStudent(Student student,MultipartFile photo) {
		
		try
		{
			if(photo!=null&&!photo.isEmpty())
			{
				student.setProfilePhoto(photo.getBytes());
			}
			studentrepository.save(student);
			return "student added successfully";
		}
		catch(IOException e)
		{
			return "error uploading profile photo";
		}
		
	}

	@Override
	public Student checkAdminLogin(String email, String password) {

		return studentrepository.findByEmailAndPassword(email, password);
	}

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
	

}
