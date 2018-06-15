package com.cg.mobilebilling.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;
public class MainClass {
	public static void main(String[] args) throws BillingServicesDownException, PlanDetailsNotFoundException, CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillDetailsNotFoundException, InvalidBillMonthException{
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("projectbeans.xml");
		BillingServices billingServices=(BillingServices)applicationContext.getBean("billingServices");
		billingServices.createPlan();
	    System.out.println(billingServices.acceptCustomerDetails("alamel", "gopalan", "chinnu@gmail.com", "20-03-96", "Chennai", "TN", 600045, "Chennai", "TN", 600045));
	    System.out.println(billingServices.openPostpaidMobileAccount(1, 1));	
	    System.out.println(billingServices.getPlanAllDetails());
	    System.out.println(billingServices.getCustomerDetails(1));
	    System.err.println(billingServices.getAllCustomerDetails());
	    System.out.println(billingServices.getPostPaidAccountDetails(1, 1));
	    System.out.println(billingServices.getCustomerAllPostpaidAccountsDetails(1));
	    System.out.println(billingServices.generateMonthlyMobileBill(1, 1, "MAR", 110, 110, 110,110, 110));
	    System.out.println(billingServices.getCustomerPostPaidAccountAllBillDetails(1, 1));
	   // System.out.println(billingServices.closeCustomerPostPaidAccount(1, 1));
	   // System.out.println(billingServices.deleteCustomer(1));
	    System.out.println(billingServices.getCustomerPostPaidAccountPlanDetails(1, 1));
	    System.out.println(billingServices.getMobileBillDetails(1, 1, "MAR"));
	}
}