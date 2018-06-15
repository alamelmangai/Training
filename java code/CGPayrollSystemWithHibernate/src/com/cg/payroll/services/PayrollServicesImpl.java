package com.cg.payroll.services;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
@Component("PayrollServices")
public class PayrollServicesImpl implements PayrollServices {
@Autowired
	private PayrollDAOServices daoServices;
	/*public PayrollServicesImpl() throws PayrollServicesDownExceptions{
		daoServices = new PayrollDAOServicesImpl();
	}*/
@Override
public int acceptAssociateDetails(String firstName, String lastName, String department, String designation,
		String pancard, String emailId, float yearlyInvestmentUnder80C, float basicSalary, float epf, float companyPf,
		int accountNumber, String bankName, String ifscCode) throws PayrollServicesDownExceptions {
	try {
		return daoServices.insertAssociate(new Associate(new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode), yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId));
	} catch (SQLException e) {
		throw new PayrollServicesDownExceptions("Payroll services are down...try again later", e);
	}
}
@Override
public float calculateNetSalary(int associateID)
		throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions{
	try {
		Associate associate=this.getAssociateDetails(associateID);
		if(associate!=null){
			associate.getSalary().setOtherAllowance((float)(0.1)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setConveyenceAllowance((float)(0.2)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setPersonalAllowance((float)(0.3)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setGratuity((float)(0.05)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setHra((float)(0.25)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setGrossSalary((float)(associate.getSalary().getOtherAllowance()
					+associate.getSalary().getConveyenceAllowance()
					+associate.getSalary().getPersonalAllowance()
					+associate.getSalary().getHra()+associate.getSalary().getCompanyPf()
					+associate.getSalary().getBasicSalary()));
			float annualSalary=associate.getSalary().getGrossSalary()*12;
			float investmentValue=associate.getYearlyInvestmentUnder80C()
					+associate.getSalary().getEpf()+associate.getSalary().getCompanyPf();
			float taxCalculated=0;
			if(investmentValue>150000)
				investmentValue=150000;
			if(annualSalary<250000)
				taxCalculated=0;
			else if(annualSalary>250000&&annualSalary<500000){
				if((annualSalary-250000-investmentValue)<0)
					taxCalculated=0;
				else
					taxCalculated=(float) ((annualSalary-250000-investmentValue)*0.1);
			}
			else if(annualSalary>500000&&annualSalary<1000000)
				taxCalculated=(float) ((250000-investmentValue)*0.1+(annualSalary-500000)*0.2);
			else if(annualSalary>1000000)
				taxCalculated=(float) ((250000-investmentValue)*0.1+500000*0.2+(annualSalary-1000000)*0.3);
			associate.getSalary().setMonthlyTax(taxCalculated/12);
			float netSalary=associate.getSalary().getGrossSalary()-associate.getSalary().getMonthlyTax()
					-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf();
			daoServices.updateAssociate(associate);
			associate.getSalary().setNetSalary(netSalary);
			return netSalary;
		}
		return 0;
	} catch (SQLException e) {
		throw new PayrollServicesDownExceptions("Payroll services are down...try again later", e);
	}
}

@Override
public boolean deleteAssociate(int associateID)throws PayrollServicesDownExceptions{
	return daoServices.deleteAssociate(associateID);
}
@Override
public boolean updateAssociate(Associate associate) throws PayrollServicesDownExceptions {
	try {
		return daoServices.updateAssociate(associate);
	} catch (SQLException e) {
		throw new PayrollServicesDownExceptions("Payroll services are down...try again later", e);
	}
}


public Associate getAssociateDetails(int associateID)
		throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions{
	Associate associate=daoServices.getAssociate(associateID);
	if(associate==null){
		AssociateDetailsNotFoundExceptions ex=
				new AssociateDetailsNotFoundExceptions("Associate details not found for "+associateID);
		throw ex;
	}
	return associate;
}

@Override
public List<Associate> getAllAssociateDetails()throws PayrollServicesDownExceptions{
	return daoServices.getAssociates();
}




}
