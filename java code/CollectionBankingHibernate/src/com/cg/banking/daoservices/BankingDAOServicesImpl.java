package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cg.banking.beans1.Account;
import com.cg.banking.beans1.Customer;
import com.cg.banking.beans1.Transaction;

public class BankingDAOServicesImpl implements BankingDAOServices{
	public static int CUSTOMER_ID_COUNTER=100;
	//private static int CUSTOMER_ID_COUNTER=100;
	public static long ACCOUNTNO_COUNTER=123456789;
	//private static long ACCOUNTNO_COUNTER=123456789;
	Random randomGen = new Random();
	private int pinNumber= randomGen.nextInt(9999) + 1000;
	public static HashMap<Integer,Customer> customers = new HashMap<>();
	// HashMap<Integer,Customer> customers = new HashMap<>();
	@Override
	public int insertCustomer(Customer customer) {
		customer.setCustomerId(CUSTOMER_ID_COUNTER++);
		customers.put(customer.getCustomerId(),customer);
		return customer.getCustomerId();
	}
	@Override
	public long insertAccount(int customerId, Account account) {
		customers.get(customerId).getAccounts().put(ACCOUNTNO_COUNTER, account);
		customers.get(customerId).getAccounts().get(ACCOUNTNO_COUNTER).setAccountNo(ACCOUNTNO_COUNTER++);
		customers.get(customerId).getAccounts().get(account.getAccountNo()).setStatus("active");
		return customers.get(customerId).getAccounts().get(account.getAccountNo()).getAccountNo();
	}

	@Override
	public boolean updateAccount(int customerId, Account account) {
		if(customers.get(customerId).getAccounts().containsKey(account.getAccountNo())==true);
		customers.get(customerId).getAccounts().put(account.getAccountNo(), account);
		account.setAccountNo(account.getAccountNo());
		return false;
	}

	@Override
	public int generatePin(int customerId, Account account) {
		customers.get(customerId).getAccounts().get(account.getAccountNo()).setPinNumber(pinNumber);
		return customers.get(customerId).getAccounts().get(account.getAccountNo()).getPinNumber();
	}

	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		if(getAccount(customerId, accountNo)==null)
			return false;
		int tidc = getAccount(customerId,accountNo).getTransactionIdCounter();
		customers.get(customerId).getAccounts().get(accountNo).getTransactions().put(getAccount(customerId, accountNo).getTransactionIdCounter(),transaction);
		customers.get(customerId).getAccounts().get(accountNo).getTransactions().get(getAccount(customerId, accountNo).getTransactionIdCounter()).setTransactionId(tidc++);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		customers.remove(customerId);
		return true;
	}

	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		customers.get(customerId).getAccounts().remove(accountNo);
		return false;
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customers.get(customerId);
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		return customers.get(customerId).getAccounts().get(accountNo);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList=new ArrayList<Customer>(customers.values());
		return customerList;
	}

	@Override
	public List<Account> getAccounts(int customerId) {
		List<Account> accountList=new ArrayList<Account>(customers.get(customerId).getAccounts().values());
		return accountList;
	}

	@Override
	public List<Transaction> getTransactions(int customerId, long accountNo) {
		List<Transaction> transactionList=new ArrayList<Transaction>(customers.get(customerId).getAccounts().get(accountNo).getTransactions().values());
		return transactionList;
	}

}
