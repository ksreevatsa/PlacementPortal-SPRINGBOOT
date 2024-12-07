package com.sdp.PP_SBProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.sdp.PP_SBProject.model.Admin;
import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Student;
import com.sdp.PP_SBProject.service.AdminService;
import com.sdp.PP_SBProject.service.StudentService;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
   @Autowired
   private AdminService adminservice;
   
   
   @PostMapping("/insertadmin")
   public ResponseEntity<String> insertadmin(@RequestBody Admin admin)
   {
	   
	   String msg=adminservice.addAdmin(admin);
	   return ResponseEntity.ok(msg);
   }
   
 
   
   @GetMapping("/getAllStudents")
   public ResponseEntity<?> getAllStudents()
   {
	   List<Student> students=adminservice.getAllStudents();
	   if(students!=null)
	   {
		   return ResponseEntity.ok(students);
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No Students Registered");
	   }
   }
   
   @PostMapping("/insertstudent")
	public ResponseEntity<String> insertStudent( @RequestPart("photo") MultipartFile photo,
		    @RequestPart("student") Student student)
	{
	     String email=student.getEmail();
	     if(!adminservice.findEmailInAdmin(email)&&!adminservice.findEmailInStudent(email)&&!adminservice.findEmailInEmployer(email))
	     {
		  String msg=adminservice.addStudent(student,photo);
		   return ResponseEntity.ok(msg);
	     }
	     else
	     {
	    	 return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Id Already Registered");
	     }
		
	}
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteById(@PathVariable("id") int id)
   {
	   String msg=adminservice.deleteById(id);
	   if(msg.equals("deleted successfully")) 
	   {
		   return ResponseEntity.ok(msg);
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	   }
	   
	   
   }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<?> updateStudent(@PathVariable("id") int id,@RequestBody Student student)
   {
	   try {
	   ResponseEntity<Student> sdata=adminservice.updateStudent(id, student);
	   return sdata;
	   }
	   catch(ResponseStatusException e)
	   {
		   return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
	   }
	   catch (Exception e) 
	   {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                              .body("An unexpected error occurred: " + e.getMessage());
	   } 
   }
   
   @PostMapping("/insertemployer")
   public ResponseEntity<String> insertEmpoyer(@RequestBody Employer employer)
   {
   	String email=employer.getEmail();
   	if(!adminservice.findEmailInAdmin(email)&&!adminservice.findEmailInStudent(email)&&!adminservice.findEmailInEmployer(email))
		{
   	String msg=adminservice.addEmployer(employer);
   	
   	return ResponseEntity.ok(msg);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Id Already Registered");
		}
   }
   
   @GetMapping("/getallemployers")
   public ResponseEntity<?> getALlEmployers()
   {
   	List<Employer> employers=adminservice.getAllEmployers();
   	
   	if(employers!=null)
   	{
   		return ResponseEntity.ok(employers);
   	}
   	else
   	{
   		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no employers registered");
   	}
   }
   
   @DeleteMapping("/employer")
   public ResponseEntity<String> deleteEmployerById(@RequestParam("id") int id)
   {
   	String msg=adminservice.deleteEmployersById(id);
   	if(msg.equals("deleted successfully")) 
	   {
		   return ResponseEntity.ok(msg);
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	   }
   }
   
   @PutMapping("/employer/update/{id}")
   public ResponseEntity<?> updateEmployer(@PathVariable("id")int id,@RequestBody Employer employer)
   {
   	try {
   		ResponseEntity<Employer> edata=adminservice.updateEmployer(id, employer);
   		return edata;
   	}
   	catch(ResponseStatusException e)
	   {
		   return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
	   }
	   catch (Exception e) 
	   {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                              .body("An unexpected error occurred: " + e.getMessage());
	   } 
   }
}
