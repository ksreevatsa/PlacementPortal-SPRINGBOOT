package com.sdp.PP_SBProject.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
@JsonView({Views.Student.class, Views.Employer.class})
public class Job 
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String location;
    
    @Column(nullable = false)
    private String salary;
    
    @Column(nullable=false)
    private LocalDate postedDate;
    
    
    
    
    public LocalDate getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}


	@ManyToOne
    @JoinColumn(name="employer_id",nullable = false)
    @JsonBackReference // Prevents circular reference
    private Employer employer;
    
    
    @JsonView(Views.Employer.class)
    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL)
    @JsonManagedReference("job-jobapplications")
    private List<JobApplication> jobapplications; 
    
    


	public List<JobApplication> getJobapplications() {
		return jobapplications;
	}


	public void setJobapplications(List<JobApplication> jobapplications) {
		this.jobapplications = jobapplications;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public Employer getEmployer() {
		return employer;
	}


	public void setEmployer(Employer employer) {
		this.employer = employer;
	}    
	
	public String getCompanyName()
	{
		return employer!=null? employer.getCompanyName():null;
	}
    
}
