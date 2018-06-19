package com.dew.training.dto;

import com.dew.training.enums.EducationType;

public class College {
	private String name;
	private String marks;
	private String universityName;
	private int yearOfPassing;
	private EducationType educationType;
	private String specialization;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public int getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	public EducationType getEducationType() {
		return educationType;
	}
	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}
