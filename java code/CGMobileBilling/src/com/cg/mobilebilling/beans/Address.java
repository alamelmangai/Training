package com.cg.mobilebilling.beans;

public class Address {
	private String city,state,country;
	private String pinCode;
	public Address(String city, String state, String country, String pinCode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
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
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
