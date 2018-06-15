package com.cg.project.beans;

public class CEmployee extends Employee{
	private int hrs,variablePay;

	public CEmployee() {
		super();
	}

	public CEmployee(String firstname, String lastName, int employeeId,int hrs) {
		super(firstname, lastName, employeeId);
		this.hrs=hrs;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(int variablePay) {
		this.variablePay = variablePay;
	}
	
	public void contractSign() {
		System.out.println("Contract Signed");
	}
	
	public void calculateTotalSalary() {
		this.variablePay=this.hrs*2000;
	}

	@Override
	public String toString() {
		return "CEmployee "+super.toString()+" hrs=" + hrs + ", variablePay=" + this.variablePay + "]";
	}
	
	

}
