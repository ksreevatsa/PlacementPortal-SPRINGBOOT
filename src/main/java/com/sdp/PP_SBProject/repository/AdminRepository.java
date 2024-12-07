package com.sdp.PP_SBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdp.PP_SBProject.model.Admin;
import com.sdp.PP_SBProject.model.Student;

import java.util.List;


@Repository
public interface AdminRepository  extends JpaRepository<Admin,Integer>
{
   
//	@Query("select a from Admin a where a.email=?1 and a.password=?2")
//	public Admin checkAdminLogin(String email,String password);
	
	
	public Admin findByEmailAndPassword(String email, String password);
	
	public Admin findByEmail(String email);
}
