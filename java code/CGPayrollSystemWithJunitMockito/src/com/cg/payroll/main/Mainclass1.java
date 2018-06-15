package com.cg.payroll.main;
import java.util.List;
import java.util.Scanner;
import com.cg.payroll.beans.*;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServicesImpl;
public class Mainclass1 {
	public static void main(String[] args) throws PayrollServicesDownExceptions {
		try {
			PayrollServicesImpl payrollServices=new PayrollServicesImpl();
			int associateID;
			int key=0;
			Scanner sc=new Scanner(System.in);
			while(key!=7){
				System.out.println("Enter 1 : Insert New employee"+"\n"+
						"2 : update Associate Details"+"\n"+
						"3 : To get Associate Details of employee"+"\n"+
						"4 : To get  All Associate Details of employee/"+"\n"+
						"5 : To Calculate salary of employee"+"\n"+
						"6 : To delete an employee"+"\n"+
						"7: Exit");
				key=sc.nextInt();
				switch (key) {
				case 1: System.out.println("enter first Name");
				String firstName=sc.next();
				System.out.println("enter last Name");
				String lastName=sc.next();
				System.out.println("enter designation");
				String designation=sc.next();
				System.out.println("enter department");
				String department=sc.next();
				System.out.println("enter pancard number");
				String pancard=sc.next();
				System.out.println("enter EmailId");
				String emailId=sc.next();
				System.out.println("enter YearlyInvestment");
				int yearlyInvestmentUnder80C=sc.nextInt();
				System.out.println("enter Basic Salary");
				float basicSalary=sc.nextFloat();
				System.out.println("enter epf");
				float epf=sc.nextFloat();
				System.out.println("enter cpf");
				float companyPf=sc.nextFloat();
				System.out.println("Enter Account number");
				int accountNumber=sc.nextInt();
				System.out.println("Enter Bank Name");
				String bankName=sc.next();
				System.out.println("enter IFSC Code");
				String ifscCode=sc.next();
				associateID= payrollServices.acceptAssociateDetails(firstName, lastName, department, designation, pancard,  emailId, yearlyInvestmentUnder80C, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);
				System.out.println(payrollServices.getAssociateDetails(associateID));
				break;
				case 2: System.out.println("Enter the Details to be Updated");
				System.out.println("enter associateid");
				int associateIdup=sc.nextInt();
				System.out.println("enter first Name");
				String firstName1=sc.next();
				System.out.println("enter last Name");
				String lastName1=sc.next();
				System.out.println("enter designation");
				String designation1=sc.next();
				System.out.println("enter department");
				String department1=sc.next();
				System.out.println("enter pancard number");
				String pancard1=sc.next();
				System.out.println("enter EmailId");
				String emailId1=sc.next();
				System.out.println("enter YearlyInvestment");
				int yearlyInvestmentUnder80C1=sc.nextInt();
				System.out.println("enter Basic Salary");
				float basicSalary1=sc.nextFloat();
				System.out.println("enter epf");
				float epf1=sc.nextFloat();
				System.out.println("enter cpf");
				float companyPf1=sc.nextFloat();
				System.out.println("Enter Account number");
				int accountNumber1=sc.nextInt();
				System.out.println("Enter Bank Name");
				String bankName1=sc.next();
				System.out.println("enter IFSC Code");
				String ifscCode1=sc.next();
				payrollServices.updateAssociate(new Associate(new Salary(basicSalary1, epf1, companyPf1), new BankDetails(accountNumber1, bankName1, ifscCode1), associateIdup, yearlyInvestmentUnder80C1, firstName1, lastName1, department1, designation1, pancard1, emailId1));
				System.out.println("updated values are:");
				System.out.println(payrollServices.getAssociateDetails(associateIdup));
				break;
				case 3: System.out.println("Enter the AssociateId of employee to get the Details");
				associateID=sc.nextInt();
				Associate associate2;
				associate2 = payrollServices.getAssociateDetails(associateID);
				System.out.println(associate2.toString());
				break;
				case 4: System.out.println("Following are the Employee details of Entire Array");
				List<Associate> associate=payrollServices.getAllAssociateDetails();
				for(com.cg.payroll.beans.Associate associate1:associate)
					System.out.println(associate1);
				break;
				case 5: System.out.println("Enter the AssociateId of employee to calculate the salary");
				associateID=sc.nextInt();
				System.out.println(payrollServices.calculateNetSalary(associateID));
				break;
				case 6: System.out.println("Enter the AssociateId of employee to be deleted");
				associateID=sc.nextInt();
				System.out.println(payrollServices.deleteAssociate(associateID));
				case 7: System.out.println("Exit");
				break;
				default:
					break;
				}
			}
		} catch (AssociateDetailsNotFoundExceptions e) {
			e.printStackTrace();
		}
		catch(PayrollServicesDownExceptions e){
			e.printStackTrace();
		}

	}
}