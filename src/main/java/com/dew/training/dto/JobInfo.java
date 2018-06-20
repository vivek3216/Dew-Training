package com.dew.training.dto;

import com.dew.training.enums.JobType;
import com.dew.training.enums.Preference;


public class JobInfo {

	
	private String bio;
	private String industry;
	private String functionalArea;
	private String role;
	private String workLocation;
	private JobType jobType;
	private Preference employmentType;
	private String skills;
	private String maritalStatus;
	
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getFunctionalArea() {
		return functionalArea;
	}
	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public Preference getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(Preference employmentType) {
		this.employmentType = employmentType;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	
}
