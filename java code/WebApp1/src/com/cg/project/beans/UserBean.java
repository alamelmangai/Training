package com.cg.project.beans;

import java.util.List;

public class UserBean {
	private String UserName,password,firstName,lastName,email,address,gender,graduation,description;
	private List<String> communication;
	
	

	public UserBean(String userName, String password, String firstName, String lastName, String address,
			String gender, String graduation) {
		super();
		UserName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.graduation = graduation;
	}

	public UserBean(String userName, String password, String firstName, String lastName, String email, String address,
			String gender, String graduation, List<String> communication) {
		super();
		UserName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.graduation = graduation;
		this.communication = communication;
	}
	
	public UserBean(String userName, String password) {
		super();
		UserName = userName;
		this.password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getCommunication() {
		return communication;
	}

	public void setCommunication(List<String> communication) {
		this.communication = communication;
	}

	
}
