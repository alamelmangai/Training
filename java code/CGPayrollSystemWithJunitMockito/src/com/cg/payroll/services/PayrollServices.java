package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;

public interface PayrollServices {

	int acceptAssociateDetails(String firstName, String lastName, String department, String designation, String pancard,
			String emailId, float yearlyInvestmentUnder80C, float basicSalary, float epf, float companyPf,
			int accountNumber, String bankName, String ifscCode) throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions;

	float calculateNetSalary(int associateId) throws AssociateDetailsNotFoundExceptions,PayrollServicesDownExceptions;

	Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundExceptions,PayrollServicesDownExceptions;

	List<Associate> getAllAssociateDetails()throws PayrollServicesDownExceptions;
	
	boolean deleteAssociate(int associateId)throws PayrollServicesDownExceptions, AssociateDetailsNotFoundExceptions;
	
	boolean updateAssociate(Associate associate)throws PayrollServicesDownExceptions ,AssociateDetailsNotFoundExceptions;
}