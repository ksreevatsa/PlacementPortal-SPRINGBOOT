package com.sdp.PP_SBProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employer")
public class Employer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	 @Column(nullable=false)
	   private String companyName;
	 
	 @Column(nullable=false)
	    private String contactPerson;
	 
	 @Column(nullable=false)
	    private String email;
	 
	 @Column(nullable=false)
	    private String phoneNumber;
	 
	 @Column(nullable=false)
	    private String industry;
	 
	 @Column(nullable=false)
	    private String location;
	 
	 @Column(nullable=false)
	    private String website;
	 
	 @JsonProperty
	    @Column(nullable=false)
	    private String password;
	
	 
	 @Column(nullable=false)
	    private String role="Employer";
	 
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
}
