package com.dew.training.dto;

public class LoginStatus {

	private String Status;
	private int userId;
	private String email;
	private final boolean loggedIn;
	private final String firstName;
	private final String lastName;
	
	
	public LoginStatus (boolean loggedIn,String email,String firstName,String lastName,int userId) {
		this.lastName=lastName;
		this.loggedIn=loggedIn;
		this.firstName=firstName;
		this.email=email;
		this.userId=userId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
}
