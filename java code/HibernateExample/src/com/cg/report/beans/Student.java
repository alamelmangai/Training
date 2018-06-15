package com.cg.report.beans;
import java.util.HashMap;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private float percentage,totMark;
	@Embedded
	private Address address;
	private String firstName,lastName,stream,emailId,dateOfBirth,grade,result;
	public static HashMap<Integer,Subject> subjects=new HashMap<>();
	public Student() {}
	
	public Student(Address address, String firstName, String lastName, String stream, String emailId,
			String dateOfBirth) {
		super();
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stream = stream;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

	public Student(int studentId, float percentage, float totMark, Address address, String firstName, String lastName,
			String stream, String emailId, String dateOfBirth, String grade, String result) {
		super();
		this.studentId = studentId;
		this.percentage = percentage;
		this.totMark = totMark;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stream = stream;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.grade = grade;
		this.result = result;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public float getTotMark() {
		return totMark;
	}

	public void setTotMark(float totMark) {
		this.totMark = totMark;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static HashMap<Integer, Subject> getSubjects() {
		return subjects;
	}

	public static void setSubjects(HashMap<Integer, Subject> subjects) {
		Student.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + Float.floatToIntBits(percentage);
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((stream == null) ? 0 : stream.hashCode());
		result = prime * result + studentId;
		result = prime * result + Float.floatToIntBits(totMark);
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
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Float.floatToIntBits(percentage) != Float.floatToIntBits(other.percentage))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (stream == null) {
			if (other.stream != null)
				return false;
		} else if (!stream.equals(other.stream))
			return false;
		if (studentId != other.studentId)
			return false;
		if (Float.floatToIntBits(totMark) != Float.floatToIntBits(other.totMark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", percentage=" + percentage + ", totMark=" + totMark + ", address="
				+ address + ", firstName=" + firstName + ", lastName=" + lastName + ", stream=" + stream + ", emailId="
				+ emailId + ", dateOfBirth=" + dateOfBirth + ", grade=" + grade + ", result=" + result + "]";
	}

	
}