package com.dew.training.dto;

import java.util.Date;

public class Internship {

	private String company;
	private Date duration_start;
	private Date duration_end;
	private String details;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getDuration_start() {
		return duration_start;
	}
	public void setDuration_start(Date duration_start) {
		this.duration_start = duration_start;
	}
	public Date getDuration_end() {
		return duration_end;
	}
	public void setDuration_end(Date duration_end) {
		this.duration_end = duration_end;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
