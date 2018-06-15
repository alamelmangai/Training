package com.cg.project.beans;

public class PEmployee extends Employee{
	private int hra,ta,da;

	public PEmployee() {
		super();
	}

	public PEmployee(String firstname, String lastName, int employeeId, int basicSalary) {
		super(firstname, lastName, employeeId, basicSalary);
	}
	

	public PEmployee(String firstname, String lastName, int employeeId, int basicSalary,int hra, int ta, int da) {
		super(firstname, lastName, employeeId, basicSalary);
		this.hra = hra;
		this.ta = ta;
		this.da = da;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getTa() {
		return ta;
	}

	public void setTa(int ta) {
		this.ta = ta;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int da) {
		this.da = da;
	}

	public void calculateTotalSalary() {
		this.hra=(30*this.getBasicSalary())/100;
		this.ta=(5*this.getBasicSalary())/100;
		this.da=(2*this.getBasicSalary())/100;
		this.setTotalSalary(hra+ta+da+getBasicSalary());
	}

	@Override
	public String toString() {
		return super.toString()+"hra=" + this.hra + ", ta=" +this. ta + ", da=" + this.da + "]";
	}
	
	

}
