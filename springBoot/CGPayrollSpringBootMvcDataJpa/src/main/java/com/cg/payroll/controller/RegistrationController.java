package com.cg.payroll.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServices;


@Controller
public class RegistrationController {

	@Autowired
	PayrollServices payrollServices;

	/*@RequestMapping(value="/registerUser")
	public String registerUser(@Valid @ModelAttribute("associate")Associate associate,
			BindingResult result) throws PayrollServicesDownExceptions {

		if(result.hasErrors())
			return "registrationPage";
		payrollServices.acceptAssociateDetails(associate);
		return "successPage";

	}*/
	@RequestMapping(value="/registerUser")
	public ModelAndView registerUser(@Valid @ModelAttribute("associate")Associate associate,
			BindingResult result) throws PayrollServicesDownExceptions {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("registrationPage");
			/*modelAndView.addObject("associate",associate);*/
			return modelAndView;
		}
		payrollServices.acceptAssociateDetails(associate);
		modelAndView.setViewName("successPage");
		return modelAndView;
	}
	/*@RequestMapping(value="/loginUser")
	public String loginUser(@Valid @ModelAttribute("associate")Associate associate,
			BindingResult result) throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions {
			Associate associate1=payrollServices.getAssociateDetails(associate.getAssociateID());
			if(result.hasFieldErrors("associateID")||result.hasFieldErrors("password"))
				return "loginPage";
			if(associate.getAssociateID()==associate1.getAssociateID()
					&&associate.getPassword().equals(associate1.getPassword())){

				associate.setAssociateID(associate1.getAssociateID());
			associate.setFirstName(associate1.getFirstName());
			associate.setLastName(associate1.getLastName());
			return "loginSuccessPage";
			}
			return "loginPage";
	}*/
	@RequestMapping(value="/loginUser")
	public ModelAndView loginUser(@Valid @ModelAttribute("associate")Associate associate,
			BindingResult result) throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions {

		ModelAndView modelAndView = new ModelAndView();

		if(result.hasFieldErrors("password")){
			modelAndView.setViewName("loginPage");
			return modelAndView;
		}
		Associate associate1=payrollServices.getAssociateDetails(associate.getAssociateID());
		if(associate.getAssociateID()==associate1.getAssociateID()
				&&associate.getPassword().equals(associate1.getPassword())){
			modelAndView.setViewName("loginSuccessPage");
			modelAndView.addObject("associate",associate1);
			return modelAndView;
		}
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}	

	/*@RequestMapping(value="/calculateUser")
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
	}*/
	@RequestMapping(value="/calculateUser")
	public ModelAndView calculateUser(@Valid @ModelAttribute("associate")Associate associate,
			BindingResult result) throws AssociateDetailsNotFoundExceptions, PayrollServicesDownExceptions {

		ModelAndView modelAndView = new ModelAndView();
		float netSalary = payrollServices.calculateNetSalary(associate.getAssociateID());
		Salary salary = new Salary();
		salary.setNetSalary(netSalary);
		associate.setSalary(salary);
		modelAndView.setViewName("displayPage");
		return modelAndView;
	}
}
