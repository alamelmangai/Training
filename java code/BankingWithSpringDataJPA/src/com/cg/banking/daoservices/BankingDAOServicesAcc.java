package com.cg.banking.daoservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans1.Account;
import com.cg.banking.beans1.Customer;
import com.cg.banking.beans1.Transaction;


public interface BankingDAOServicesAcc extends JpaRepository<Account,Long>{
	/*int insertCustomer(Customer customer);
	long insertAccount(int customerId,Account account);
	boolean updateAccount(int customerId,Account account);
	int generatePin(int customerId,Account account);
	boolean insertTransaction(int customerId,long accountNo,Transaction transaction);
	boolean deleteCustomer(int customerId);
	boolean deleteAccount(int customerId,long accountNo);
	Customer getCustomer(int customerId);
	Account getAccount(int customerId,long accountNo);
	List<Customer> getCustomers();
	List<Account> getAccounts(int customerId);
	List<Transaction> getTransactions(int customerId,long accountNo);*/
}

