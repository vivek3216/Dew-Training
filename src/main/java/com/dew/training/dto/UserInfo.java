package com.dew.training.dto;

public class UserInfo {
	
	private String specialization;
	private Schooling tenthStandard;
	private Schooling twelfthStandard;
	private College graduation;
	private College postGraduation;
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
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
	public College getPostGraduation() {
		return postGraduation;
	}
	public void setPostGraduation(College postGraduation) {
		this.postGraduation = postGraduation;
	}
}
