package com.cg.project.beans;

public class Employee {
	private String firstname,lastName;
	private int employeeId,basicSalary,totalSalary;
	public Employee() {
		super();
	}
	
	public Employee(String firstname, String lastName, int employeeId) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.employeeId = employeeId;
	}

	public Employee(String firstname, String lastName, int employeeId, int basicSalary) {
		this();
		this.firstname = firstname;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public void calculateTotalSalary() {
		this.totalSalary=basicSalary;
	}
	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastName=" + lastName + ", employeeId=" + employeeId
				+ ", basicSalary=" + basicSalary + ", totalSalary=" + totalSalary + "]";
	}

	
}
