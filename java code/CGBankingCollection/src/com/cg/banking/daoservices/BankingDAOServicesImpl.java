package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;

public class BankingDAOServicesImpl implements BankingDAOServices {
	HashMap<Integer,Customer> customers=new HashMap<>();
	private static int CUSTOMER_ID_COUNTER=1;
	private static long ACCOUNT_NO_COUNTER=20000001l;
	

	@Override
	public int insertCustomer(Customer customer) {
		customer.setCustomerId(CUSTOMER_ID_COUNTER++);
		customers.put(customer.getCustomerId(),customer);
		return customer.getCustomerId();
		}

	@Override
	public long insertAccount(int customerId, Account account) {
		customers.get(customerId).getAccounts().put(ACCOUNT_NO_COUNTER, account);
		customers.get(customerId).getAccounts().get(ACCOUNT_NO_COUNTER).setAccountNo(ACCOUNT_NO_COUNTER++);
		
		return customers.get(customerId).getAccounts().get(account.getAccountNo()).getAccountNo();
	}

	@Override
	public boolean updateAccount(int customerId, Account account) {
		if(customers.get(customerId).getAccounts().containsKey(account.getAccountNo())==true){
			customers.get(customerId).getAccounts().put(account.getAccountNo(),account);
			account.setAccountNo(account.getAccountNo());
			return true;
		}
		return false;
	}

	@Override
	public int generatePin(int customerId, Account account) {
		Random generatePin=new Random();
		int pinNum=generatePin.nextInt(9999) + 1000;
		customers.get(customerId).getAccounts().get(account.getAccountNo()).setPinNumber(pinNum);
		return pinNum;
	}
		

	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		if(getAccount(customerId, accountNo)==null)
			return false;

		int id=getAccount(customerId, accountNo).getTransactionIdCounter();
		customers.get(customerId).getAccounts().get(accountNo).getTransactions().put(getAccount(customerId, accountNo).getTransactionIdxCounter(), transaction);
		customers.get(customerId).getAccounts().get(accountNo).getTransactions().get(getAccount(customerId, accountNo).getTransactionIdxCounter()).setTransactionId(id++);
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
		return true;
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customers.get(customerId);
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		Account a=customers.get(customerId).getAccounts().get(accountNo);
		if(a==null)
			return null;
		return a;
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
