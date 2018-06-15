package com.cg.project.beans;

import java.util.ArrayList;
import java.util.Collections;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName,lastName;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public Customer(int customerId, String firstName, String lastName) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
public int compareTo(Customer customer){
	return this.customerId-customer.customerId;

}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
}
