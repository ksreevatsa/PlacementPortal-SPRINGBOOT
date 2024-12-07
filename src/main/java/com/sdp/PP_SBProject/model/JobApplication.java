package com.sdp.PP_SBProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job_application")
@JsonView({Views.Student.class, Views.Employer.class})
public class JobApplication 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	
	@Column(nullable = false)
	private String university;
	
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String yearInUnversity;
	
	@Column(nullable = false)
	private String status="NotApplied";
	
	@Lob
	@Column(columnDefinition ="MEDIUMBLOB",nullable = false)
	private byte[] resume;
	
	@ManyToOne
	@JoinColumn(name="student_id",nullable = false)
	@JsonBackReference("student-jobapplications")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="job_id",nullable = false)
	@JsonBackReference("job-jobapplications")
	private Job job;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getYearInUnversity() {
		return yearInUnversity;
	}

	public void setYearInUnversity(String yearInUnversity) {
		this.yearInUnversity = yearInUnversity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}
}
