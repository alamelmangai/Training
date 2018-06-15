package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.xml.bind.annotation.XmlID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.property.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans1.*;
import com.cg.banking.services.BankingServices;


@Component("BankingDAOServices")
public class BankingDAOServicesImpl implements BankingDAOServices{
	@Autowired(required=true)
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	@Override
	public int insertCustomer(Customer customer) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return customer.getCustomerId();
	}
	@Override
	public long insertAccount(int customerId, Account account) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Customer customer = getCustomer(customerId);
		account.setCustomer(customer);
		account.setStatus("active"); 
		
		entityManager.persist(account);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return account.getAccountNo();
	}
	@Override
	public boolean updateAccount(int customerId, Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		account=entityManager.merge(account);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	@Override
	public int generatePin(int customerId, Account account) {
	
		int pinNumber=1234;
		account.setPinNumber(pinNumber);
	    updateAccount(customerId, account);
		return pinNumber;
	}
	@Override
	public boolean insertTransaction(int customerId, long accountNo, com.cg.banking.beans1.Transaction transaction) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Account account = getAccount(customerId, accountNo);
		transaction.setAccount(account);
		entityManager.persist(transaction);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}
	@Override
	public boolean deleteCustomer(int customerId) {
		entityManager = entityManagerFactory.createEntityManager();
		Customer customer= entityManager.find(Customer.class, customerId);
		entityManager.getTransaction().begin();
		if(customer!=null){
		entityManager.remove(customer);
		entityManager.flush();
		entityManager.getTransaction().commit();
		}
		entityManager.close();
		return false;
	}
	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		entityManager = entityManagerFactory.createEntityManager();
		Account account = entityManager.find(Account.class, accountNo);
		entityManager.getTransaction().begin();
		if(account!=null){
		entityManager.remove(account);
		entityManager.flush();
		entityManager.getTransaction().commit();
		}
		entityManager.close();
		return true;
	}
	@Override
	public Customer getCustomer(int customerId) {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();              
		return entityManager.find(Customer.class,customerId);
	}
	@Override
	public Account getAccount(int customerId, long accountNo) {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager.find(Account.class, accountNo);
	}
		
	@Override
	public List<Customer> getCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Customer> query = entityManager.createQuery("Select a from Customer a",Customer.class);
		return query.getResultList();
	}
	@Override
	public List<Account> getAccounts(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Account> query = entityManager.createQuery("Select a from Account a where customer_customerId=:customerId ",Account.class);
		query.setParameter("customerid", customerId);
		return query.getResultList();
	}
	@Override
	public List<com.cg.banking.beans1.Transaction> getTransactions(int customerId, long accountNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<com.cg.banking.beans1.Transaction> query = entityManager.createQuery("Select a from com.cg.banking.beans1.Transaction a where account_accountNo=:accountNo",com.cg.banking.beans1.Transaction.class);
		query.setParameter("accountNo", accountNo);
		return query.getResultList();
	}

}