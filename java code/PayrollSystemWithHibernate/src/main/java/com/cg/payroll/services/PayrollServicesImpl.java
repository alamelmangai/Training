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
@Component(value="Services")
public class PayrollServicesImpl implements PayrollServices {
@Autowired
	private PayrollDAOServices daoServices;
	/*public PayrollServicesImpl() throws PayrollServicesDownExceptions{
		daoServices = new PayrollDAOServicesImpl();
	}*/
	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String department, 
			String designation,String pancard, String emailId,float yearlyInvestmentUnder80C,
			float basicSalary, float epf, float companyPf,
			int accountNumber,String bankName,String ifscCode) throws PayrollServicesDownExceptions{
		try {
			return daoServices.insertAssociate(new Associate(new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode), yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownExceptions("PayrollService are down");
		}
	}
	@Override
	public float calculateNetSalary(int associateId) throws AssociateDetailsNotFoundExceptions,PayrollServicesDownExceptions{
		return 0;
	}

	@Override
	public boolean deleteAssociate(int associateID)throws PayrollServicesDownExceptions{
		try {
			return daoServices.deleteAssociate(associateID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownExceptions("PayrollService are down");
		}
	}
	
	public Associate getAssociateDetails(int associateID)
			throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions{
		Associate associate;
		try {
			associate = daoServices.getAssociate(associateID);
			if(associate==null){
				AssociateDetailsNotFoundExceptions ex=
						new AssociateDetailsNotFoundExceptions("Associate details not found for "+associateID);
			throw ex;
			}
				return associate;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Associate> getAllAssociateDetails()throws PayrollServicesDownExceptions{
		try {
			return daoServices.getAssociates();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownExceptions("PayrollService are down");
		}
	}
	
	@Override
	public boolean updateAssociate(Associate associate) throws PayrollServicesDownExceptions {
		try {
			return daoServices.updateAssociate(associate);
		} catch (SQLException e) {
			throw new PayrollServicesDownExceptions("Services are down now",e);
		}
	}
	
}
