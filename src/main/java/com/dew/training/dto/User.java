package com.dew.training.dto;

import java.util.Date;

import com.dew.training.enums.Gender;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
	private String mobile;
	private boolean active;
	private String address;
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	private String email;
	private String password;
	private Integer typeOfUser;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	private String imageExtention;
	private String passportExtention;
	private String aadharExtention;
	private String resumeExtention;
	public String getImageExtention() {
		return imageExtention;
	}
	public void setImageExtention(String imageExtention) {
		this.imageExtention = imageExtention;
	}
	public String getPassportExtention() {
		return passportExtention;
	}
	public void setPassportExtention(String passportExtention) {
		this.passportExtention = passportExtention;
	}
	public String getAadharExtention() {
		return aadharExtention;
	}
	public void setAadharExtention(String aadharExtention) {
		this.aadharExtention = aadharExtention;
	}
	public String getResumeExtention() {
		return resumeExtention;
	}
	public void setResumeExtention(String resumeExtention) {
		this.resumeExtention = resumeExtention;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(Integer typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
		
}
