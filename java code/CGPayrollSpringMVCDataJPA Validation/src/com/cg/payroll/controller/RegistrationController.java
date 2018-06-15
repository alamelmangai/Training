package com.cg.payroll.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServices;

@Controller
public class RegistrationController {
	
	@Autowired
	PayrollServices payrollServices;
	
	@RequestMapping(value="/registerUser")
	public String registerUser(@Valid @ModelAttribute("associate")Associate associate) {
	
			try {
				payrollServices.acceptAssociateDetails(associate);
				return "successPage";
			} catch (PayrollServicesDownExceptions e) {
				return "errorPage";
			}
		}
	@RequestMapping(value="/loginUser")
	public String loginUser(@Valid @ModelAttribute("associate")Associate associate) {
	
			try {
				payrollServices.acceptAssociateDetails(associate);
				return "successPage";
			} catch (PayrollServicesDownExceptions e) {
				return "errorPage";
			}
		}
	@RequestMapping(value="/calculateUser")
	public String calculateUser(@ModelAttribute("associate")Associate associate) {
	
			
				try {
					
					float netSalary = payrollServices.calculateNetSalary(associate.getAssociateID());
					Salary salary = new Salary();
					salary.setNetSalary(netSalary);
					associate.setSalary(salary);
					return "displayPage";
				} catch (AssociateDetailsNotFoundExceptions | PayrollServicesDownExceptions e) {
					return "errorPage";
				}	
	}
	
	
}
