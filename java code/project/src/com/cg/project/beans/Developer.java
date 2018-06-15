package com.cg.project.beans;

public class Developer extends PEmployee {
	private int noOfProjects,incentives;

	public Developer() {
		super();
	}

	public Developer(String firstname, String lastName, int employeeId, int basicSalary,int noOfprojects) {
		super(firstname, lastName, employeeId, basicSalary);
		this.noOfProjects=noOfprojects;
		
	}

	public int getNoOfProjects() {
		return noOfProjects;
	}

	public void setNoOfProjects(int noOfProjects) {
		this.noOfProjects = noOfProjects;
	}

	public int getIncentives() {
		return incentives;
	}

	public void setIncentives(int incentives) {
		this.incentives = incentives;
	}
	public void projectsDone() {
		System.out.println("Projects is done");
	}
	public void calculateTotalSalary() {
		super.calculateTotalSalary();
		incentives=this.noOfProjects*5000;
	}

	@Override
	public String toString() {
		return "Developer "+super.toString()+" [noOfProjects=" + noOfProjects + ", incentives=" + incentives + "]";
	}
	
	

}
