package com.cg.payroll.services;
import java.util.ArrayList;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
public class PayrollServicesImpl implements PayrollServices {

	private PayrollDAOServices daoServices;
	public PayrollServicesImpl(){
		daoServices = new PayrollDAOServicesImpl();
	}
	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String department, 
			String designation,String pancard, String emailId,float yearlyInvestmentUnder80C,
			float basicSalary, float epf, float companyPf,
			int accountNumber,String bankName,String ifscCode) throws PayrollServicesDownExceptions{
		return daoServices.insertAssociate(new Associate(new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode), yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId));
	}
	@Override
	public float calculateNetSalary(int associateId) throws AssociateDetailsNotFoundExceptions,PayrollServicesDownExceptions{
		Associate associate = this.getAssociateDetails(associateId);
		if(associate!=null){
			associate.getSalary().setOtherAllowance((float)(0.1)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setConveyenceAllowance((float)(0.2)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setPersonalAllowance((float)(0.3)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setGratuity((float)(0.05)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setHra((float)(0.25)*(associate.getSalary().getBasicSalary()));
			associate.getSalary().setGrossSalary((float)(associate.getSalary().getOtherAllowance()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getPersonalAllowance()+associate.getSalary().getHra()+associate.getSalary().getBasicSalary()+associate.getSalary().getCompanyPf()));
			float annualSalary = (float) (12*(associate.getSalary().getGrossSalary()));
			float sum = ((float)(12*associate.getSalary().getCompanyPf()+12*associate.getSalary().getEpf()+associate.getYearlyInvestmentUnder80C()));
			float yearlyTax = 0;
			if(sum>150000)
				sum=150000;
			if(annualSalary<250000)
				yearlyTax=(float)((0.0*250000));
			if(annualSalary>250000 && annualSalary<500000){
				if((annualSalary-250000-sum)<0)
					yearlyTax=0;
				else
					yearlyTax=(float)((0.0*250000)+(0.10*(annualSalary-250000-sum)));
			}
			if(annualSalary>500000 && annualSalary<1000000)
				yearlyTax=(float)((0.0*250000)+(0.10*(250000-sum))+(0.20*(annualSalary-500000)));
			if(annualSalary>1000000)
				yearlyTax=(float)((0.0*250000)+(0.10*(250000-sum))+(0.20*500000)+(0.30*(annualSalary-1000000)));

			associate.getSalary().setMonthlyTax((float)(yearlyTax/12));
			associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary()-associate.getSalary().getMonthlyTax()-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf());
			daoServices.updateAssociate(associate);
			return associate.getSalary().getNetSalary();
		}
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundExceptions,PayrollServicesDownExceptions{
		Associate associate=daoServices.getAssociate(associateId);
		if(associate==null)
			throw new AssociateDetailsNotFoundExceptions("Associate details of associateId"+associateId+"not found");
		return associate;
	}

	@Override
	public List<Associate> getAllAssociateDetails() throws PayrollServicesDownExceptions{
		return daoServices.getAssociate();

	}
	public boolean deleteAssociate(int associateId) throws PayrollServicesDownExceptions, AssociateDetailsNotFoundExceptions{
		if(getAssociateDetails(associateId)==null)
			throw new AssociateDetailsNotFoundExceptions("The AssociateId you want to delete is not present");
		return daoServices.deleteAssociate(associateId);
	}
	@Override
	public boolean updateAssociate(Associate associate) throws PayrollServicesDownExceptions, AssociateDetailsNotFoundExceptions {
		if(getAssociateDetails(associate.getAssociateID())==null)
			throw new AssociateDetailsNotFoundExceptions("the AssociateId you want to update not present");
		return daoServices.updateAssociate(associate);
	}
}
