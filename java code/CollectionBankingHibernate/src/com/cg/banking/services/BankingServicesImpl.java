package com.cg.banking.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans1.Account;
import com.cg.banking.beans1.Address;
import com.cg.banking.beans1.Customer;
import com.cg.banking.beans1.Transaction;
import com.cg.banking.daoservices.BankingDAOServices;
import com.cg.banking.daoservices.BankingDAOServicesImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Component(value="bankingServices")
public class BankingServicesImpl implements BankingServices {
	@Autowired
	private BankingDAOServices daoServices;
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
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if((accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("current"))==false)
			throw new InvalidAccountTypeException("Enter proper account type");
		if(initBalance<=0)
			throw new InvalidAmountException("amount should be greater than 0");
		return daoServices.insertAccount(customerId, new Account(accountType, initBalance));  

	}
	@Override
	public float depositAmount(int customerId, long accountNo, float amount) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		getCustomerDetails(customerId);
		//if(getCustomerDetails(customerId)==null)
		//	throw new CustomerNotFoundException("this customerId doesnt exist");
		getAccountDetails(customerId, accountNo);
		//if(daoServices.getAccount(customerId, accountNo)==null)
		//	throw new AccountNotFoundException("this account doent exist");
		if(getAccountDetails(customerId, accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		daoServices.insertTransaction(customerId, accountNo, new Transaction(amount, "Deposit"));
		this.getAccountDetails(customerId, accountNo).setAccountBalance(getAccountDetails(customerId, accountNo).getAccountBalance()+amount);
		return this.getAccountDetails(customerId, accountNo).getAccountBalance();
	}
	@Override
	public float withdrawAmount(int customerId, long accountNo, float amount, int pinNumber)
			throws InsufficientAmountException, CustomerNotFoundException, AccountNotFoundException,
			InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServices.getAccount(customerId, accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		if(pinNumber!=getAccountDetails(customerId, accountNo).getPinNumber()&&daoServices.getAccount(customerId, accountNo).getPinCounter()<3){
			int pc = daoServices.getAccount(customerId, accountNo).getPinCounter();
			pc++;
			daoServices.getAccount(customerId, accountNo).setPinCounter(pc);
			throw new InvalidPinNumberException("enter valid pin number");
		}
			if(pinNumber!=getAccountDetails(customerId, accountNo).getPinNumber()&&daoServices.getAccount(customerId, accountNo).getPinCounter()>=3){
				daoServices.getAccount(customerId, accountNo).setStatus("Inactive");
				throw new AccountBlockedException("your account is blocked plz consult the bank");
			}
			if(amount>getAccountDetails(customerId, accountNo).getAccountBalance())
				throw new InsufficientAmountException("you dont have enough amount to transfer");
			while(getAccountDetails(customerId, accountNo)!=null&&getAccountDetails(customerId, accountNo).getPinCounter()<3){
				if(pinNumber==getAccountDetails(customerId, accountNo).getPinNumber()){
					if(amount<=getAccountDetails(customerId, accountNo).getAccountBalance()) {
						daoServices.insertTransaction(customerId, accountNo, new Transaction(amount, "Withdrawal"));
						this.getAccountDetails(customerId, accountNo).setAccountBalance(getAccountDetails(customerId, accountNo).getAccountBalance()-amount);
						return this.getAccountDetails(customerId, accountNo).getAccountBalance();
					}
					getAccountDetails(customerId, accountNo).setPinCounter(getAccountDetails(customerId, accountNo).getPinCounter()+1);
				}
				else if(getAccountDetails(customerId, accountNo).getPinCounter()>=3)
					getAccountDetails(customerId, accountNo).setStatus("Your Account is Blocked");
				return 1;
			}	
			return 0;
	}

	@Override
	public boolean fundTransfer(int customerIdTo, long accountNoTo, int customerIdFrom, long accountNoFrom,
			float transferAmount, int pinNumber) throws InsufficientAmountException, CustomerNotFoundException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		if(daoServices.getCustomer(customerIdFrom)==null||getCustomerDetails(customerIdTo)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerIdFrom, accountNoFrom)==null||getAccountDetails(customerIdTo, accountNoTo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(pinNumber!=getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()&&daoServices.getAccount(customerIdFrom, accountNoFrom).getPinCounter()<3){
			int pc = daoServices.getAccount(customerIdFrom, accountNoFrom).getPinCounter();
			pc++;
			daoServices.getAccount(customerIdFrom, accountNoFrom).setPinCounter(pc);
			throw new InvalidPinNumberException("enter valid pin number");
		}
		if(pinNumber!=getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()&&daoServices.getAccount(customerIdFrom, accountNoFrom).getPinCounter()>=3){
			daoServices.getAccount(customerIdFrom, accountNoFrom).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(daoServices.getAccount(customerIdFrom, accountNoFrom).getStatus()!="active"||getAccountDetails(customerIdTo, accountNoTo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		if(transferAmount>getAccountDetails(customerIdFrom, accountNoFrom).getAccountBalance())
			throw new InsufficientAmountException("you dont have enough amount to transfer");
		if(pinNumber==getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()) {
			if(transferAmount<=getAccountDetails(customerIdFrom, accountNoFrom).getAccountBalance()) {
				float totalBalanceTo=daoServices.getAccount(customerIdTo, accountNoTo).getAccountBalance()+transferAmount;
				daoServices.getAccount(customerIdTo, accountNoTo).setAccountBalance(totalBalanceTo);
				float totalBalanceFrom=daoServices.getAccount(customerIdFrom, accountNoFrom).getAccountBalance()-transferAmount;
				daoServices.getAccount(customerIdFrom, accountNoFrom).setAccountBalance(totalBalanceFrom);
				daoServices.insertTransaction(customerIdTo, accountNoTo, new Transaction(totalBalanceTo, "Deposit"));
				daoServices.insertTransaction(customerIdFrom, accountNoFrom, new Transaction(totalBalanceFrom, "Withdrawal"));
				return true;
			}
		}
		return false;
	}
	@Override
	public Customer getCustomerDetails(int customerId) throws CustomerNotFoundException, BankingServicesDownException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		return daoServices.getCustomer(customerId);
	}
	@Override
	public Account getAccountDetails(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		return daoServices.getAccount(customerId, accountNo);
	}
	@Override
	public int generateNewPin(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		return daoServices.generatePin(customerId, this.getAccountDetails(customerId, accountNo));
	}
	@Override
	public boolean changeAccountPin(int customerId, long accountNo, int oldPinNumber, int newPinNumber)
			throws CustomerNotFoundException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(oldPinNumber!=getAccountDetails(customerId, accountNo).getPinNumber())
			throw new InvalidPinNumberException("enter valid pin number");
		if(oldPinNumber==getAccountDetails(customerId, accountNo).getPinNumber()) {
			oldPinNumber=newPinNumber;
			getAccountDetails(customerId, accountNo).setPinNumber(oldPinNumber);
			return true;
		}
		return false;
	}
	@Override
	public List<Customer> getAllCustomerDetails() throws BankingServicesDownException {
		return daoServices.getCustomers();
	}
	@Override
	public List<Account> getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException, CustomerNotFoundException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		return daoServices.getAccounts(customerId);
	}
	@Override
	public List<Transaction> getAccountAllTransaction(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		return daoServices.getTransactions(customerId, accountNo);
	}
	@Override
	public String accountStatus(int customerId, long accountNo) throws BankingServicesDownException,
	CustomerNotFoundException, AccountNotFoundException, AccountBlockedException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServices.getAccount(customerId, accountNo).getPinCounter()>=3){
			daoServices.getAccount(customerId, accountNo).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(getAccountDetails(customerId, accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		return getAccountDetails(customerId, accountNo).getStatus();
	}
	@Override
	public boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(getAccountDetails(customerId, accountNo).getAccountBalance()==0) {
			daoServices.deleteAccount(customerId, accountNo);
			return true;
		}
		return false;
	}
	@Override
	public float showBalance(int customerId, long accountNo, int pinNumber) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServices.getAccount(customerId, accountNo).getPinCounter()>=3){
			daoServices.getAccount(customerId, accountNo).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(daoServices.getAccount(customerId, accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		if(customerId==daoServices.getCustomer(customerId).getCustomerId()
				&&accountNo==daoServices.getAccount(customerId, accountNo).getAccountNo()
				&&pinNumber==daoServices.getAccount(customerId, accountNo).getPinNumber())
			return daoServices.getAccount(customerId, accountNo).getAccountBalance();
		return 0;
	}
}