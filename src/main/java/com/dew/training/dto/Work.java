package com.dew.training.dto;

import com.dew.training.enums.Preference;
import com.dew.training.enums.Start;

public class Work {

	private Preference preference;
	private Start startDate;
	private String location;
	
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	public Start getStartDate() {
		return startDate;
	}
	public void setStartDate(Start startDate) {
		this.startDate = startDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
