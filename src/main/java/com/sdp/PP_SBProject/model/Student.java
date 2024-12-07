package com.sdp.PP_SBProject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String phoneNumber;
    
    @Column(nullable=false)
    private String department;
    
    @Column(nullable=false)
    private String year;
    
    @JsonProperty
    @Column(nullable=false)
    private String password;
    
    @Column(nullable=false)
    private String role="Student";
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB",nullable = false)
    private byte[] profilePhoto;
    
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference("student-jobapplications") // Matches JobApplication's student reference
    private List<JobApplication> jobapplications;
    
   

	public List<JobApplication> getJobapplications() {
		return jobapplications;
	}

	public void setJobapplications(List<JobApplication> jobapplications) {
		this.jobapplications = jobapplications;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
    
    
    

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
    
    
}
