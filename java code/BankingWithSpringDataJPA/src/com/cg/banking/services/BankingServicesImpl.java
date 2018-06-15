package com.cg.banking.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans1.Account;
import com.cg.banking.beans1.Address;
import com.cg.banking.beans1.Customer;
import com.cg.banking.beans1.Transaction;
import com.cg.banking.daoservices.BankingDAOServices;
import com.cg.banking.daoservices.BankingDAOServicesAcc;
import com.cg.banking.daoservices.BankingDAOServicesTran;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Component("bankingServices")

@Transactional
public class BankingServicesImpl implements BankingServices {

	@Autowired
	private BankingDAOServices daoServices;
	@Autowired
	private BankingDAOServicesAcc daoServicesA;
	@Autowired
	private BankingDAOServicesTran daoServicesT;

	Account account;
	Customer customer;
	Transaction transaction;
	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String customerEmailId, String panCard,
			String localAddressCity, String localAddressState, int localAddressPinCode) throws BankingServicesDownException {
		Customer customer = daoServices.save(new Customer(firstName, lastName, customerEmailId, panCard, new Address(localAddressPinCode,  localAddressCity,localAddressState)));
		return customer.getCustomerId();
	}
	@Override
	public long openAccount(int customerId, String accountType, float initBalance) throws InvalidAmountException,
	CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if((accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("current"))==false)
			throw new InvalidAccountTypeException("Enter proper account type");
		if(initBalance<=0)
			throw new InvalidAmountException("amount should be greater than 0");

		customer=daoServices.findOne(customerId);
		account= new Account(accountType,initBalance);
		account.setCustomer(customer);
		account.setAccountType(accountType);
		account.setAccountBalance(initBalance);
		account.setStatus("active");
		account=daoServicesA.save(account);
		return account.getAccountNo();  
	}
	@Override
	public float depositAmount(int customerId, long accountNo, float amount) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		//getCustomerDetails(customerId);
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		//getAccountDetails(customerId, accountNo);
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(getAccountDetails(customerId, accountNo).getStatus().equals("active")){
			Account account=getAccountDetails(customerId, accountNo);
			account.setAccountBalance(account.getAccountBalance()+amount);
			daoServicesA.saveAndFlush( account);
			transaction= new Transaction(amount, "Deposit");
			transaction.setAccount(account);
			transaction=daoServicesT.save(transaction);

			return this.getAccountDetails(customerId, accountNo).getAccountBalance();
		}
		else
			throw new AccountBlockedException("the account is inactive plz try later");
	}
	@Override
	public float withdrawAmount(int customerId, long accountNo, float amount, int pinNumber)
			throws InsufficientAmountException, CustomerNotFoundException, AccountNotFoundException,
			InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServicesA.findOne( accountNo).getStatus().equals("Inactive"))
			throw new AccountBlockedException("the account is inactive plz try later");
		if(pinNumber!=getAccountDetails(customerId, accountNo).getPinNumber()&&daoServicesA.findOne(accountNo).getPinCounter()<3){
			int pc = daoServicesA.findOne(accountNo).getPinCounter();
			pc++;
			daoServicesA.findOne(accountNo).setPinCounter(pc);
			throw new InvalidPinNumberException("enter valid pin number");
		}
		if(pinNumber!=getAccountDetails(customerId, accountNo).getPinNumber()&&daoServicesA.findOne(accountNo).getPinCounter()>=3){
			daoServicesA.findOne(accountNo).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(amount>getAccountDetails(customerId, accountNo).getAccountBalance())
			throw new InsufficientAmountException("you dont have enough amount to transfer");
		while(getAccountDetails(customerId, accountNo)!=null&&getAccountDetails(customerId, accountNo).getPinCounter()<3){
			if(pinNumber==getAccountDetails(customerId, accountNo).getPinNumber()){
				if(amount<=getAccountDetails(customerId, accountNo).getAccountBalance()) {
					Account account=getAccountDetails(customerId, accountNo);
					account.setAccountBalance(account.getAccountBalance()-amount);

					daoServicesA.saveAndFlush( account);
					transaction= new Transaction(amount, "Deposit");
					transaction.setAccount(account);
					transaction=daoServicesT.save(transaction);
					
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
		if(daoServices.findOne(customerIdFrom)==null||getCustomerDetails(customerIdTo)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNoFrom)==null||getAccountDetails(customerIdTo, accountNoTo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(pinNumber!=getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()&&daoServicesA.findOne(accountNoFrom).getPinCounter()<3){
			int pc = daoServicesA.findOne(accountNoFrom).getPinCounter();
			pc++;
			daoServicesA.findOne(accountNoFrom).setPinCounter(pc);
			throw new InvalidPinNumberException("enter valid pin number");
		}
		if(pinNumber!=getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()&&daoServicesA.findOne(accountNoFrom).getPinCounter()>=3){
			daoServicesA.findOne(accountNoFrom).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(daoServicesA.findOne(accountNoFrom).getStatus()!="active"||getAccountDetails(customerIdTo, accountNoTo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		if(transferAmount>getAccountDetails(customerIdFrom, accountNoFrom).getAccountBalance())
			throw new InsufficientAmountException("you dont have enough amount to transfer");
		if(pinNumber==getAccountDetails(customerIdFrom, accountNoFrom).getPinNumber()) {
			if(transferAmount<=getAccountDetails(customerIdFrom, accountNoFrom).getAccountBalance()) {
				
				Account account=getAccountDetails(customerIdTo, accountNoTo);
				account.setAccountBalance(account.getAccountBalance()-transferAmount);
				daoServicesA.saveAndFlush(account);
				transaction= new Transaction(transferAmount, "withdraw");
				transaction.setAccount(account);
				transaction=daoServicesT.save(transaction);
				
				Account account1=getAccountDetails(customerIdFrom, accountNoFrom);
				account.setAccountBalance(account1.getAccountBalance()+transferAmount);
				daoServicesA.saveAndFlush( account1);
				transaction= new Transaction(transferAmount, "Deposit");
				transaction.setAccount(account);
				transaction=daoServicesT.save(transaction);
				
//				float totalBalanceTo=daoServicesA.findOne(accountNoTo).getAccountBalance()+transferAmount;
//				daoServicesA.findOne(accountNoTo).setAccountBalance(totalBalanceTo);
//				float totalBalanceFrom=daoServicesA.findOne(accountNoFrom).getAccountBalance()-transferAmount;
//				daoServicesA.findOne( accountNoFrom).setAccountBalance(totalBalanceFrom);
				return true;
			}
		}
		return false;
	}
	@Override
	public Customer getCustomerDetails(int customerId) throws CustomerNotFoundException, BankingServicesDownException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		return daoServices.findOne(customerId);
	}
	@Override
	public Account getAccountDetails(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		return daoServicesA.findOne( accountNo);
	
	}
	@Override
	public int generateNewPin(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		int pinNumber=1234;
		account=getAccountDetails(customerId, accountNo);
		account.setPinNumber(pinNumber);
		account=daoServicesA.saveAndFlush(account);
		return account.getPinNumber();
	}
	@Override
	public boolean changeAccountPin(int customerId, long accountNo, int oldPinNumber, int newPinNumber)
			throws CustomerNotFoundException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException {
		/*if(daoServices.getCustomer(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServices.getAccount(customerId, accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(oldPinNumber!=getAccountDetails(customerId, accountNo).getPinNumber())
			throw new InvalidPinNumberException("enter valid pin number");
		if(oldPinNumber==getAccountDetails(customerId, accountNo).getPinNumber()) {
			oldPinNumber=newPinNumber;
			getAccountDetails(customerId, accountNo).setPinNumber(oldPinNumber);
			return true;
		}*/
		return false;
	}
	@Override
	public List<Customer> getAllCustomerDetails() throws BankingServicesDownException { 
		return daoServices.findAll();
	}
	@Override
	public List<Account> getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException, CustomerNotFoundException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		
		customer = daoServices.findOne(customerId);
		Map<Long, Account> account = customer.getAccount();
		return new ArrayList<>(daoServices.findOne(customerId).getAccount().values());
	}
	@Override
	public List<Transaction> getAccountAllTransaction(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		customer = daoServices.findOne(customerId);
		account = customer.getAccount().get(accountNo);
		Map<Integer,Transaction> transaction = account.getTransaction();
		//List<Transaction> list=new ArrayList<>(daoServicesA.findOne(accountNo).getTransaction().values());
		return new ArrayList<>(daoServicesA.findOne(accountNo).getTransaction().values());
	}
	@Override
	public String accountStatus(int customerId, long accountNo) throws BankingServicesDownException,
	CustomerNotFoundException, AccountNotFoundException, AccountBlockedException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServicesA.findOne(accountNo).getPinCounter()>=3){
			daoServicesA.findOne(accountNo).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(getAccountDetails(customerId, accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		return getAccountDetails(customerId, accountNo).getStatus();
	}
	@Override
	public boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(getAccountDetails(customerId, accountNo).getAccountBalance()==0) {
			daoServicesA.delete(accountNo);
			return true;
		}
		return false;
	}
	@Override
	public float showBalance(int customerId, long accountNo, int pinNumber) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		if(daoServices.findOne(customerId)==null)
			throw new CustomerNotFoundException("this customerId doesnt exist");
		if(daoServicesA.findOne(accountNo)==null)
			throw new AccountNotFoundException("this account doent exist");
		if(daoServicesA.findOne(accountNo).getPinCounter()>=3){
			daoServicesA.findOne(accountNo).setStatus("Inactive");
			throw new AccountBlockedException("your account is blocked plz consult the bank");
		}
		if(daoServicesA.findOne(accountNo).getStatus()!="active")
			throw new AccountBlockedException("the account is inactive plz try later");
		if(customerId==daoServices.findOne(customerId).getCustomerId()
				&&accountNo==daoServicesA.findOne(accountNo).getAccountNo()
				&&pinNumber==daoServicesA.findOne(accountNo).getPinNumber())
			return daoServicesA.findOne(accountNo).getAccountBalance();
		return 0;
	}
}