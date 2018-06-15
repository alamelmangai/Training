package com.cg.project.bean;

public class Associate {
private String firstName,lastName;
private int associateId;
private Address address;

public Associate(){
	
}
public Associate(String firstName, String lastName, int associateId, Address address) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.associateId = associateId;
	this.address = address;
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
public int getAssociateId() {
	return associateId;
}
public void setAssociateId(int associateId) {
	this.associateId = associateId;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + associateId;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
	Associate other = (Associate) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (associateId != other.associateId)
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	return true;
}
@Override
public String toString() {
	return "Associate [firstName=" + firstName + ", lastName=" + lastName + ", associateId=" + associateId
			+ ", address=" + address + "]";
}

}
