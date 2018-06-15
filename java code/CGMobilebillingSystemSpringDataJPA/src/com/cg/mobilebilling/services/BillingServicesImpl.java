package com.cg.mobilebilling.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.mobilebilling.beans.Address;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.BillingDAOServicesA;
import com.cg.mobilebilling.daoservices.BillingDAOServicesB;
import com.cg.mobilebilling.daoservices.BillingDAOServicesC;
import com.cg.mobilebilling.daoservices.BillingDAOServicesP;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
@Component("billingServices")
public class BillingServicesImpl implements BillingServices {
	/*private BillingDAOServices daoServices;*/
	@Autowired
	private BillingDAOServicesA daoServicesA;
	@Autowired
	private BillingDAOServicesC daoServicesC;
	@Autowired
	private BillingDAOServicesP daoServicesP;
	@Autowired
	private BillingDAOServicesB daoServicesB;
	Customer customer;
	PostpaidAccount postpaidAccount;
	Bill bill;
	Plan plan;

	@Override
	public int createPlan(){
		daoServicesP.save(new Plan(100, 100, 100, 100, 100, 100, 1f, 1.5f, 1f, 1.5f, 2f, "Cheanni", "PlanA"));
		daoServicesP.save(new Plan(200, 100, 100, 100, 100, 100, 2f, 2.5f, 2f, 2.5f, 4f, "Pune", "PlanB"));
		daoServicesP.save(new Plan(300, 100	, 100, 100, 100, 100, 4f, 4.5f, 4f, 4.5f, 8f, "Kolkata", "PlanC"));
		return 0;
	}

	@Override
	public List<Plan> getPlanAllDetails() throws BillingServicesDownException {
		return daoServicesP.findAll();

	}

	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String emailID, String dateOfBirth,
			String billingAddressCity, String billingAddressState, int billingAddressPinCode, String homeAddressCity,
			String homeAddressState, int homeAddressPinCode) throws BillingServicesDownException {
		Customer customer =daoServicesC.save(new Customer(firstName, lastName, emailID, dateOfBirth, new Address(billingAddressPinCode, billingAddressCity, billingAddressState), new Address(homeAddressPinCode, homeAddressCity, homeAddressState)));
		return customer.getCustomerID();		
	}

	@Override
	public long openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesP.findOne(planID)==null)
			throw new PlanDetailsNotFoundException("Plz select a Plan");
		plan=daoServicesP.findOne(planID);
		customer=daoServicesC.findOne(customerID);
		postpaidAccount = new  PostpaidAccount(plan);
		postpaidAccount.setCustomer(customer);
		postpaidAccount.setPlan(plan);
		postpaidAccount=daoServicesA.save(postpaidAccount);
		return postpaidAccount.getMobileNo();
	}

	@Override
	public int generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
					throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
					BillingServicesDownException, PlanDetailsNotFoundException {
		if(daoServicesC.findOne(customerID)==null)
			throw new CustomerDetailsNotFoundException("CustomerID : "+customerID+" not found.");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("Invalid Mobile Number.");
		if(daoServicesA.findOne(mobileNo).getPlan()==null)
			throw new PlanDetailsNotFoundException("No such plan found.");
		if(!"JAN".equals(billMonth)&&!"FEB".equals(billMonth)&&
				!"MAR".equals(billMonth)&&!"APR".equals(billMonth)&&
				!"MAY".equals(billMonth)&&!"JUN".equals(billMonth)&&
				!"JUL".equals(billMonth)&&!"AUG".equals(billMonth)&&
				!"SEP".equals(billMonth)&&!"OCT".equals(billMonth)&&
				!"NOV".equals(billMonth)&&!"DEC".equals(billMonth))
			throw new InvalidBillMonthException("Enter Correct Month. (Format 'JAN','FEB' and so on!)");
		int extraLocalCalls;
		int extraStdCalls;
		int extraLocalSMS;
		int extraStdSMS;
		int extraInternetUsage;
		float billEstimate;
		if(daoServicesC.findOne(customerID).getPostpaidAccount().get(mobileNo)!=null){
			bill=new Bill(noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits, billMonth);
			int planId=daoServicesA.findOne(mobileNo).getPlan().getPlanID();
			plan=daoServicesP.findOne(planId);
			postpaidAccount=daoServicesA.findOne(mobileNo);
			if(plan.getFreeLocalCalls()<noOfLocalCalls)
				extraLocalCalls=noOfLocalCalls-plan.getFreeLocalCalls();
			else
				extraLocalCalls=0;
			/*System.out.println(extraLocalCalls);*/
			bill.setLocalCallAmount(extraLocalCalls*plan.getLocalCallRate());
			if(plan.getFreeStdCalls()<noOfStdCalls)
				extraStdCalls=noOfStdCalls-plan.getFreeStdCalls();
			else
				extraStdCalls=0;
			bill.setStdCallAmount(extraStdCalls*plan.getStdCallRate());
			if(plan.getFreeLocalSMS()<noOfLocalSMS)
				extraLocalSMS=noOfLocalSMS-plan.getFreeLocalSMS();
			else
				extraLocalSMS=0;
			bill.setLocalSMSAmount(extraLocalSMS*plan.getLocalSMSRate());
			if(plan.getFreeStdSMS()<noOfStdSMS)
				extraStdSMS=noOfStdSMS-plan.getFreeStdSMS();
			else
				extraStdSMS=0;
			bill.setStdSMSAmount(extraStdSMS*plan.getLocalSMSRate());
			if(plan.getFreeInternetDataUsageUnits()<internetDataUsageUnits)
				extraInternetUsage=internetDataUsageUnits-plan.getFreeInternetDataUsageUnits();
			else
				extraInternetUsage=0;
			bill.setInternetDataUsageAmount(extraInternetUsage*plan.getInternetDataUsageRate());
			billEstimate=plan.getMonthlyRental()+bill.getInternetDataUsageAmount()+bill.getLocalCallAmount()+bill.getLocalSMSAmount()
			+bill.getStdCallAmount()+bill.getStdSMSAmount();
			bill.setServicesTax((billEstimate*14)/100);
			bill.setVat((billEstimate*9)/100);
			bill.setTotalBillAmount(billEstimate+bill.getServicesTax()+bill.getVat());
			bill.setPostpaidAccount(postpaidAccount);
			System.out.println(bill.getTotalBillAmount());
			daoServicesB.save(bill);
			return bill.getBillID();
		}
		return 0;
	}

	@Override
	public Customer getCustomerDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		if(daoServicesC.findOne(customerID)==null)
			throw new CustomerDetailsNotFoundException("this customerId doesnt exist");
		return daoServicesC.findOne(customerID);
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws BillingServicesDownException {
		return daoServicesC.findAll();
	}

	@Override
	public PostpaidAccount getPostPaidAccountDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("This postpaidAccount does not exist");

		return daoServicesC.findOne(customerID).getPostpaidAccount().get(mobileNo);
	}

	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		customer=daoServicesC.findOne(customerID);
		Map<Long, PostpaidAccount> postpaidAccount = customer.getPostpaidAccount();
		return new ArrayList<>(daoServicesC.findOne(customerID).getPostpaidAccount().values());
	}

	@Override
	public Bill getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException, BillingServicesDownException {
		if(daoServicesC.findOne(customerID)==null)
			throw new CustomerDetailsNotFoundException("CustomerID : "+customerID+" not found.");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("Invalid Mobile Number.");
		if(daoServicesA.findOne(mobileNo).getBill()==null)
			throw new BillDetailsNotFoundException("Bill details not found.");
		if(!"JAN".equals(billMonth)&&!"FEB".equals(billMonth)&&
				!"MAR".equals(billMonth)&&!"APR".equals(billMonth)&&
				!"MAY".equals(billMonth)&&!"JUN".equals(billMonth)&&
				!"JUL".equals(billMonth)&&!"AUG".equals(billMonth)&&
				!"SEP".equals(billMonth)&&!"OCT".equals(billMonth)&&
				!"NOV".equals(billMonth)&&!"DEC".equals(billMonth))
			throw new InvalidBillMonthException("Enter Correct Month. (Format 'JAN','FEB' and so on!)");
		bill=(Bill) daoServicesC.findOne(customerID).getPostpaidAccount().get(mobileNo).getBill();
		/*System.out.println(bill.getBillID());*/
		/*return (Bill) daoServicesA.findOne(mobileNo).getBill();*/
		return bill;

	}

	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			BillDetailsNotFoundException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("This postpaidAccount does not exist");
		if(daoServicesA.findOne(mobileNo).getBill()==null)
			throw new BillDetailsNotFoundException("The bill detail is not presend for this ID");
		if(daoServicesC.findOne(customerID).getPostpaidAccount().get(mobileNo)!=null){
			customer=daoServicesC.findOne(customerID);
			postpaidAccount=customer.getPostpaidAccount().get(mobileNo);
			Map<Integer, Bill> bill = postpaidAccount.getBill();
			return new ArrayList<>(daoServicesA.findOne(mobileNo).getBill().values());
		}
		return null;
	}
	@Override
	public boolean changePlan(int customerID, long mobileNo, int planID) throws CustomerDetailsNotFoundException,
	PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("This postpaidAccount does not exist");
		//if(daoServicesA.findOne(mobileNo).getPlan()==null)
		daoServicesA.delete(mobileNo);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerID)
			throws BillingServicesDownException, CustomerDetailsNotFoundException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesC.exists(customerID)){
			daoServicesC.delete(customerID);
			return true; }
		else
			return false;
	}

	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			PlanDetailsNotFoundException {
		if(daoServicesC.findOne(customerID)==null)
			throw  new CustomerDetailsNotFoundException("This customer Id doesnot exist");
		if(daoServicesA.findOne(mobileNo)==null)
			throw new PostpaidAccountNotFoundException("This postpaidAccount does not exist");
		//if(customer==daoServicesC.findOne(customerID)&&postpaidAccount==daoServicesA.findOne(mobileNo))
		return daoServicesA.findOne(mobileNo).getPlan();
		//return null;


	}

}