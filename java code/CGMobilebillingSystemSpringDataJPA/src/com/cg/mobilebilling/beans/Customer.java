package com.cg.mobilebilling.beans;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerID;
	private String firstName, lastName, emailID, dateOfBirth;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city",column=@Column(name="billingCity")),
		@AttributeOverride(name="state",column=@Column(name="billingState")),
		@AttributeOverride(name="pinCode",column=@Column(name="billingPinCode"))
	})
	private Address billingAddress;
	@Embedded
	private Address homeAddress;

	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@MapKey(name="mobileNo")
	private Map<Long,PostpaidAccount> postpaidAccount; 

	public Customer() {}

	public Customer(int customerID, String firstName, String lastName, String emailID, String dateOfBirth,
			Address billingAddress, Address homeAddress, Map<Long, PostpaidAccount> postpaidAccount) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
		this.homeAddress = homeAddress;
		this.postpaidAccount = postpaidAccount;
	}

	public Customer(String firstName, String lastName, String emailID, String dateOfBirth, Address billingAddress,
			Address homeAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
		this.homeAddress = homeAddress;
	}

	public Customer(String firstName, String lastName, String emailID, String dateOfBirth, Address billingAddress,
			Address homeAddress, Map<Long, PostpaidAccount> postpaidAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
		this.homeAddress = homeAddress;
		this.postpaidAccount = postpaidAccount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
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

	public Map<Long, PostpaidAccount> getPostpaidAccount() {
		return postpaidAccount;
	}

	public void setPostpaidAccount(Map<Long, PostpaidAccount> postpaidAccount) {
		this.postpaidAccount = postpaidAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + customerID;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((postpaidAccount == null) ? 0 : postpaidAccount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (customerID != other.customerID)
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (postpaidAccount == null) {
			if (other.postpaidAccount != null)
				return false;
		} else if (!postpaidAccount.equals(other.postpaidAccount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailID=" + emailID + ", dateOfBirth=" + dateOfBirth + ", billingAddress=" + billingAddress
				+ ", homeAddress=" + homeAddress + ", postpaidAccount=" + postpaidAccount + "]";
	}


}