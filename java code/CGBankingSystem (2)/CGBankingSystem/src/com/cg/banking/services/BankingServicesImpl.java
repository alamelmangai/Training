package com.cg.banking.services;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Address;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.BankingDAOServicesImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	private BankingDAOServicesImpl daoServices;
	public BankingServicesImpl() {
		daoServices=new BankingDAOServicesImpl();


	}
	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String customerEmailId, String panCard,
			String localAddressCity, String localAddressState, int localAddressPinCode, String homeAddressCity,
			String homeAddressState, int homeAddressPinCode) throws BankingServicesDownException {
		return daoServices.insertCustomer(new Customer(firstName, lastName, customerEmailId, panCard, new Address(localAddressPinCode,  localAddressCity,localAddressState),
				new Address(homeAddressPinCode, homeAddressCity, homeAddressState)));
	}
	@Override
	public long openAccount(int customerId, String accountType, float initBalance) throws InvalidAmountException,
	CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException {
		return daoServices.insertAccount(customerId, new Account(accountType, initBalance));
	}
	@Override
	public float depositAmount(int customerId, long accountNo, float amount) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		daoServices.insertTransaction(customerId, accountNo, new Transaction(amount));
		getAccountDetails(customerId, accountNo).setAccountBalance(getAccountDetails(customerId, accountNo).getAccountBalance()+amount);
		return this.getAccountDetails(customerId, accountNo).getAccountBalance();
	}
	@Override
	public float withdrawAmount(int customerId, long accountNo, float amount, int pinNumber)
			throws InsufficientAmountException, CustomerNotFoundException, AccountNotFoundException,
			InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		while(getAccountDetails(customerId, accountNo)!=null&&getAccountDetails(customerId, accountNo).getPinCounter()<3){
			if(pinNumber==getAccountDetails(customerId, accountNo).getPinNumber()){ 
				if(amount<=daoServices.getAccount(customerId, accountNo).getAccountBalance()) {
					daoServices.insertTransaction(customerId, accountNo, new Transaction(amount));
					getAccountDetails(customerId, accountNo).setAccountBalance(getAccountDetails(customerId, accountNo).getAccountBalance()-amount);
					getAccountDetails(customerId, accountNo).setPinCounter(0);
					return getAccountDetails(customerId, accountNo).getAccountBalance();
				}
				getAccountDetails(customerId, accountNo).setPinCounter(getAccountDetails(customerId, accountNo).getPinCounter()+1);
			}
			else if(getAccountDetails(customerId, accountNo).getPinCounter()>=3){
				getAccountDetails(customerId, accountNo).setStatus("blocked");
				return 1;
			}
			return 0;
		}
		return 0;
	}
	@Override
	public boolean fundTransfer(int customerIdTo, long accountNoTo, int customerIdFrom, long accountNoFrom,
			float transferAmount, int pinNumber) throws InsufficientAmountException, CustomerNotFoundException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		if(pinNumber==daoServices.getAccount(customerIdFrom, accountNoFrom).getPinNumber()) 
			if(transferAmount<=daoServices.getAccount(customerIdFrom, accountNoFrom).getAccountBalance()) {
				daoServices.getAccount(customerIdTo, accountNoTo).setAccountBalance(daoServices.getAccount(customerIdTo, accountNoTo).getAccountBalance()+transferAmount);
				daoServices.getAccount(customerIdFrom, accountNoFrom).setAccountBalance(daoServices.getAccount(customerIdFrom, accountNoFrom).getAccountBalance()-transferAmount);
				return true;
			}
		return false;
	}

	@Override
	public Customer getCustomerDetails(int customerId) throws CustomerNotFoundException, BankingServicesDownException {
		return daoServices.getCustomer(customerId);
	}
	@Override
	public Account getAccountDetails(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		return daoServices.getAccount(customerId, accountNo);
	}
	@Override
	public int generateNewPin(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		return daoServices.generatePin(customerId, this.getAccountDetails(customerId, accountNo));	
	}
	@Override
	public boolean changeAccountPin(int customerId, long accountNo, int oldPinNumber, int newPinNumber)
			throws CustomerNotFoundException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException {
		if(oldPinNumber==daoServices.getAccount(customerId, accountNo).getPinNumber()) {
			oldPinNumber=newPinNumber;
			daoServices.getAccount(customerId, accountNo).setPinNumber(oldPinNumber);
			return true;
		}
		return false;
	}
	@Override
	public Customer[] getAllCustomerDetails() throws BankingServicesDownException {
		return daoServices.getCustomers();
	}
	@Override
	public Account[] getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException, CustomerNotFoundException {
		return daoServices.getAccounts(customerId);
	}
	@Override
	public Transaction[] getAccountAllTransaction(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		return daoServices.getTransactions(customerId, accountNo);
	}
	@Override
	public String accountStatus(int customerId, long accountNo) throws BankingServicesDownException,
	CustomerNotFoundException, AccountNotFoundException, AccountBlockedException {
		return daoServices.getAccount(customerId, accountNo).getStatus();
	}
	@Override
	public boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		if(daoServices.getAccount(customerId, accountNo).getAccountBalance()==0) {
			daoServices.deleteAccount(customerId, accountNo);
			return true;
		}
		return false;
	}
	@Override
	public float showBalance(int customerId, long accountNo, int pinNumber)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException,
			AccountBlockedException {
		if(customerId==daoServices.getCustomer(customerId).getCustomerId()
				&&accountNo==daoServices.getAccount(customerId, accountNo).getAccountNo()
				&&pinNumber==daoServices.getAccount(customerId, accountNo).getPinNumber());
		return daoServices.getAccount(customerId, accountNo).getAccountBalance();
	}
}
