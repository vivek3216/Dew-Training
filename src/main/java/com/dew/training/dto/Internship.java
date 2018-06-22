package com.dew.training.dto;

import java.util.Date;

public class Internship {

	private String company;
	private int duration_start;
	private int duration_end;
	private String details;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getDuration_start() {
		return duration_start;
	}
	public void setDuration_start(int duration_start) {
		this.duration_start = duration_start;
	}
	public int getDuration_end() {
		return duration_end;
	}
	public void setDuration_end(int duration_end) {
		this.duration_end = duration_end;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
