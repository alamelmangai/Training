package com.cg.project.beans;

public class SalesManager extends PEmployee{
	private int salesAmt,comission;

	public SalesManager() {
		super();
	}

	public SalesManager(String firstname, String lastName, int employeeId, int basicSalary,int salesAmt) {
		super(firstname, lastName, employeeId, basicSalary);
		this.salesAmt=salesAmt;
	}
	

	public int getSalesAmt() {
		return salesAmt;
	}
	
	public void doASale() {
		System.out.println("Sales has done");
	}
	public void setSalesAmt(int salesAmt) {
		this.salesAmt = salesAmt;
	}
	
	
	public int getComission() {
		return comission;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	public void calculateTotalSalary() {
		super.calculateTotalSalary();
		this.comission=1*this.salesAmt/100;
	}
	
	@Override
	public String toString() {
		return "SalesManager "+super.toString()+" [salesAmt=" + salesAmt + ", comission=" + comission + "]";
	}

	

}
