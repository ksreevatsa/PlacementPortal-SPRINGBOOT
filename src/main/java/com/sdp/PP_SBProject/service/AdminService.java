package com.sdp.PP_SBProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.PP_SBProject.model.Admin;
import com.sdp.PP_SBProject.model.Employer;
import com.sdp.PP_SBProject.model.Student;

public interface AdminService 
{
    public String addAdmin(Admin admin);
    
    public Admin checkAdminLogin(String email,String password);
    
    //student
    public String addStudent(Student  student,MultipartFile photo);
    public List<Student> getAllStudents();
    public String deleteById(int id);
    public ResponseEntity<Student> updateStudent(int id,Student student);

   //employer
    public String addEmployer(Employer employer);
    public List<Employer> getAllEmployers();
    public String deleteEmployersById(int id);
    public ResponseEntity<Employer> updateEmployer(int id,Employer employer);
    
    
    public boolean findEmailInStudent(String email);
    public boolean findEmailInAdmin(String email);
    public boolean findEmailInEmployer(String email);
}
