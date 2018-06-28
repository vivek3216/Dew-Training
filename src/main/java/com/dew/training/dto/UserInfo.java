package com.dew.training.dto;

public class UserInfo {
	
	private int user_profile_id;
	private int user_id;
	private College graduation;
	private Schooling tenthStandard;
	private Schooling twelfthStandard;
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
	public int getUser_profile_id() {
		return user_profile_id;
	}
	public void setUser_profile_id(int user_profile_id) {
		this.user_profile_id = user_profile_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
