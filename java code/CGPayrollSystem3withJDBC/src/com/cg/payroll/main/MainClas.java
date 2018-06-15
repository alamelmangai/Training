package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;

public class MainClas {
	
	public static void main(String[] args) {
    String searchFirstName="Satish";
    int searchBasicSalary=35000;
	Associate associate = searchAssociate(searchFirstName);
    if(associate!=null)
	System.out.println(associate.getFirstName()+" "+associate.getLastName());
    else
    	System.out.println("Associate details not found");
	}
	public static Associate searchAssociate(String FirstName){
		Associate [] associates=new Associate[3];
		associates[1] = new Associate(new Salary(36000, 100, 1000, 100, 100, 100, 200, 200, 100, 30000, 60000),new BankDetails(23451, "HDFC", "HDFC0004"), 1101, 220000, "alamel", "Mangai", "Developer", "Analyst", "100233", "chinnu@gmail.com");
		associates[2] = new Associate(new Salary(20000, 100, 200, 200, 200, 300, 400, 1000, 400, 30000, 40000), new BankDetails(45915, "ICICI", "ICICI0004"), 1103, 55000, "satish", "kulkarni", "Developer", "Analyst", "100233", "aishu@gmail.com");
		for(Associate associate:associates){
			if(associate!=null && associate.getFirstName()==FirstName && associate.getYearlyInvestmentUnder80C()>50000 && associate.getSalary().getBasicSalary()>35000);
				return associate;
		}
		return null;
	}
}