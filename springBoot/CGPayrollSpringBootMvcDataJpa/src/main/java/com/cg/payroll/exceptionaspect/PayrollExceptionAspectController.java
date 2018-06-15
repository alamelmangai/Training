package com.cg.payroll.exceptionaspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;

@ControllerAdvice(basePackages={"com.cg.payroll.controller"})
public class PayrollExceptionAspectController {
	
	@ExceptionHandler(AssociateDetailsNotFoundExceptions.class)
	public ModelAndView handleUserDetailsNotFoundException() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginPage");
		modelAndView.addObject("associate",new Associate());
		/*modelAndView.addObject("exceptionMsg",ex.getMessages());*/
		return modelAndView;
	}
	
	@ExceptionHandler(PayrollServicesDownExceptions.class)
	public String handleProjectServicesNotFountException(){
	return "errorPage";
	}
}



