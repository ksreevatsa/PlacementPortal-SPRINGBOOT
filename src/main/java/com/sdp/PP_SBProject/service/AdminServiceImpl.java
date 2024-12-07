package com.sdp.PP_SBProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.sdp.PP_SBProject.model.Admin;
import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.repository.AdminRepository;
import com.sdp.PP_SBProject.repository.EmployerRepository;
import com.sdp.PP_SBProject.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployerRepository employerRepository;
	
	@Override
	public String addAdmin(Admin admin) {
		  adminRepository.save(admin);
		return "admin added successfully";
	}

	@Override
	public Admin checkAdminLogin(String email, String password)
	{
		// TODO Auto-generated method stub
		return adminRepository.findByEmailAndPassword(email, password);
	}
	
		public String addStudent(Student student,MultipartFile photo) {
		try
		{
			if(photo!=null&&!photo.isEmpty())
			{
				student.setProfilePhoto(photo.getBytes());
			}
			studentRepository.save(student);
			return "student added successfully";
		}
		catch(IOException e)
		{
			return "error uploading profile photo";
		}
	}

	@Override
	public List<Student> getAllStudents() {
	   
		
		return studentRepository.findAll();
	}

	@Override
	public String deleteById(int id) {
		if(studentRepository.existsById(id))
		{
			studentRepository.deleteById(id);
			return "deleted successfully";
		}
		else
		{
			return "Student Not Found";
		}
	}

	@Override
	public ResponseEntity<Student> updateStudent(int id, Student student) 
	{
	  Optional<Student> us=studentRepository.findById(id);
	 try {
		 
		  if(us.isPresent())
		  {
			  us.get().setName(student.getName());
			  us.get().setEmail(student.getEmail());
			  us.get().setPhoneNumber(student.getPhoneNumber());
			  us.get().setDepartment(student.getDepartment());
			  us.get().setYear(student.getYear());
			  studentRepository.save(us.get());
			  return ResponseEntity.ok(us.get());		 
		  }
		  else
		  {
			  throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found");
		  }
	 }
	 catch(ResponseStatusException e) {
	        throw e; // Re-throw to handle in the controller
	    } 
	 catch(Exception e)
	 {
		  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
	 }
   }

	
	
	@Override
	public String addEmployer(Employer employer) {
		
		employerRepository.save(employer);
		return "employer added successfully";
	}
	

	@Override
	public List<Employer> getAllEmployers() {
		return employerRepository.findAll();
	}



	@Override
	public String deleteEmployersById(int id) {
		if(employerRepository.existsById(id))
		{
			employerRepository.deleteById(id);
			return "deleted successfully";
		}
		else
		{
		return "Student Not Found";
		}
	}



	@Override
	public ResponseEntity<Employer> updateEmployer(int id, Employer employer) {
		Optional<Employer> ue=employerRepository.findById(id);
		try {
			if(ue.isPresent())
			{
				ue.get().setCompanyName(employer.getCompanyName());
				ue.get().setContactPerson(employer.getContactPerson());
				ue.get().setEmail(employer.getEmail());
				ue.get().setPhoneNumber(employer.getPhoneNumber());
				ue.get().setIndustry(employer.getIndustry());
				ue.get().setWebsite(employer.getWebsite());
				ue.get().setLocation(employer.getLocation());
				employerRepository.save(ue.get());
				return ResponseEntity.ok(ue.get());
			}
			else
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no employer found");
			}
		}
		catch(ResponseStatusException e)
		{
			throw e;
		}
		catch(Exception e)
		 {
			  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		 }
	}
	
	@Override
	public boolean findEmailInStudent(String email) {
		
		return studentRepository.findByEmail(email)!=null;
	}
      public boolean findEmailInAdmin(String email) {
		
		return adminRepository.findByEmail(email)!=null;
	}

	@Override
	public boolean findEmailInEmployer(String email) {
		return employerRepository.findByEmail(email)!=null;
	}
	

}
