package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainCLass {

	public static void main(String[] args) throws AssociateDetailsNotFoundExceptions {
		try {
			PayrollServices payrollServices = new PayrollServicesImpl();
			int associateId1=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId1);
			int associateId2=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId2);
			int associateId3=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId3);
			int associateId4=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId4);
			int associateId5=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId5);
			int associateId6=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId6);
			int associateId7=payrollServices.acceptAssociateDetails("aishu", "patil", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId7);
			int associateId8=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId8);
			int associateId9=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId9);
			int associateId10=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId10);
			int associateId11=payrollServices.acceptAssociateDetails("alamel", "mangai", "java", "software engg", "PJHY1234", "chinnu@gmail.com", 50000f, 35000f, 5000f, 4000f, 2346178, "HDFC", "HDFC12345");
			System.out.println(associateId11);
			payrollServices.calculateNetSalary(associateId1);
			System.out.println(payrollServices.getAssociateDetails(associateId1).getFirstName());
			System.out.println(payrollServices.calculateNetSalary(associateId6));
			System.out.println(payrollServices.getAssociateDetails(associateId1).getSalary().getConveyenceAllowance());
			System.out.println(payrollServices.getAssociateDetails(associateId1).getSalary().getHra());
			System.out.println(payrollServices.getAssociateDetails(associateId1).getSalary().getMonthlyTax());
			System.out.println(payrollServices.getAssociateDetails(associateId1));
			System.out.println(payrollServices.deleteAssociate(associateId6));
			payrollServices.updateAssociate(new Associate(new Salary(25000, 3000, 3000), new BankDetails(2345982, "ICICI", "ICICI00234"), 300, 70000, "deepak", "Muraree", "Mainframe", "softwareengg", "DSDFG23L", "deepakpro@gmail.com"));
			System.out.println(payrollServices.getAssociateDetails(300));
			System.out.println(payrollServices.getAssociateDetails(associateId6).getFirstName());
			System.out.println(payrollServices.getAssociateDetails(associateId6));
		} catch (AssociateDetailsNotFoundExceptions e) {
			e.printStackTrace();
		}
		catch(PayrollServicesDownExceptions e){
		e.printStackTrace();
		}
	}

}
