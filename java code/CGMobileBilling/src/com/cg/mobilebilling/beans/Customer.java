package com.cg.mobilebilling.beans;

public class Customer {
	private int customerId,mobileNo,adharNo;
	private String firstName,lastName,emailId,pancardNo,dateOfBirth;
	private Address billingAddress,homeAddress;
	private PostPaidAccount[] postPaidAccounts;
	public Customer(){}
	public Customer(int customerId, int mobileNo, int adharNo, String firstName, String lastName, String emailId,
			String pancardNo, String dateOfBirth, Address billingAddress, Address homeAddress,
			PostPaidAccount[] postPaidAccounts) {
		super();
		this.customerId = customerId;
		this.mobileNo = mobileNo;
		this.adharNo = adharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.pancardNo = pancardNo;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
		this.homeAddress = homeAddress;
		this.postPaidAccounts = postPaidAccounts;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public PostPaidAccount[] getPostPaidAccounts() {
		return postPaidAccounts;
	}
	public void setPostPaidAccounts(PostPaidAccount[] postPaidAccounts) {
		this.postPaidAccounts = postPaidAccounts;
	}
	
	
}
