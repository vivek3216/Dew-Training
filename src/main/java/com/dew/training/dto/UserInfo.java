package com.dew.training.dto;

public class UserInfo {
	
	
	private Schooling tenthStandard;
	private Schooling twelfthStandard;
	private College graduation;
	private Work workExperience;
	private Internship internship;
	
	
	
	public Schooling getTenthStandard() {
		return tenthStandard;
	}
	public void setTenthStandard(Schooling tenthStandard) {
		this.tenthStandard = tenthStandard;
	}
	public Schooling getTwelfthStandard() {
		return twelfthStandard;
	}
	public void setTwelfthStandard(Schooling twelfthStandard) {
		this.twelfthStandard = twelfthStandard;
	}
	public College getGraduation() {
		return graduation;
	}
	public void setGraduation(College graduation) {
		this.graduation = graduation;
	}
	public Work getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(Work workExperience) {
		this.workExperience = workExperience;
	}
	public Internship getInternship() {
		return internship;
	}
	public void setInternship(Internship internship) {
		this.internship = internship;
	}
}
