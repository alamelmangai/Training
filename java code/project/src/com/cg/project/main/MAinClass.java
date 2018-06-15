package com.cg.project.main;

import com.cg.project.beans.CEmployee;
import com.cg.project.beans.Developer;
import com.cg.project.beans.Employee;
import com.cg.project.beans.PEmployee;
import com.cg.project.beans.SalesManager;

public class MAinClass {

	public static void main(String[] args) {
		Employee employee=new Employee("alamel", "mangai", 1234, 150000);
		employee.calculateTotalSalary();
		System.out.println(employee.toString());
		
		PEmployee pEmployee=new PEmployee("deepak", "muraree", 1235, 160000);
		pEmployee.calculateTotalSalary();
		System.out.println(pEmployee.toString());
		
		CEmployee cEmployee=new CEmployee("aishu", "patil", 7680, 600);
		cEmployee.contractSign();
		cEmployee.calculateTotalSalary();
		System.out.println(cEmployee.toString());
		
		Developer developer=new Developer("ankur", "busa", 3456, 200000, 3);
		developer.projectsDone();
		developer.calculateTotalSalary();
		System.out.println(developer.toString());
		
		SalesManager salesmanager=new SalesManager("anmol", "thawker", 1234, 250000, 36000);
		salesmanager.doASale();
		salesmanager.calculateTotalSalary();
		System.out.println(salesmanager.toString());

	}

}
