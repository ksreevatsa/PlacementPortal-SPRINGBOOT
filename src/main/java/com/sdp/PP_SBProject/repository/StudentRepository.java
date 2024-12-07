package com.sdp.PP_SBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdp.PP_SBProject.model.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

	
	public Student findByEmailAndPassword(String email, String password);
	public Student findByEmail(String email);
	
	@Query("SELECT s.email FROM Student s")
	public List<String> findAllEmaList();
}
