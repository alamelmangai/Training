package com.cg.payroll.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndexPage(){
		return "indexPage";
	}
	@RequestMapping(value="/login")
	public String getLoginPage(){
		return "loginPage";
	}
	@RequestMapping(value="/registration")
	public String getRegistrationPage(){
		return "registrationPage";
	}
	@RequestMapping(value="/calculation")
	public String getCalculatePage(){
		return "calculationPage";
	}
	@ModelAttribute("associate")
	public Associate getAssociate(){
		return new Associate();
	}
	/*@ModelAttribute("salary")
	public Salary getCalculateNetSalary(){
		return new Salary();
	}*/
}
