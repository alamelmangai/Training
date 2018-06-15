package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	org.hibernate.Transaction tx;
	//public static HashMap<Integer,Customer> customers = new HashMap<>();

	@Override
	public int insertCustomer(Customer customer) {

		try{
			session =  sessionFactory.openSession();
			tx = session.beginTransaction();
			Integer CustomerId = (Integer) session.save(customer);
			tx.commit();
			return CustomerId;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}


	@Override
	public long insertAccount(int customerId, Account account) {	

		try{
			session =  sessionFactory.openSession();
			tx= session.beginTransaction();

			Customer customer = getCustomer(customerId);
			account.setCustomer(customer);
			account.setStatus("active");
			long AccountNo = (long) session.save(account);
			session.flush();
			tx.commit();
			return AccountNo;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}


	@Override
	public boolean updateAccount(int customerId, Account account) {

		try{
			tx = session.beginTransaction();
			if(account.getCustomer().getCustomerId()==customerId){
				session.update(account);
				session.flush();
				tx.commit();
				return true;
			}
			else
				return false;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}

	@Override
	public int generatePin(int customerId, Account account) {	
		/*Random randomGen = new Random();
			int pinNumber= randomGen.nextInt(9999) + 1000;*/
		int pinNumber= 1234;
		account.setPinNumber(pinNumber);
		updateAccount(customerId, account);
		return pinNumber;
	}
	@Override
	public boolean insertTransaction(int customerId, long accountNo, com.cg.banking.beans1.Transaction transaction) {

		try{
			session= sessionFactory.openSession();
			tx = session.beginTransaction();
			Account account = getAccount(customerId, accountNo);
			transaction.setAccount(account);
			Integer TransactionId = (Integer) session.save(transaction);
			session.flush();
			tx.commit();
			return true;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Session session =  sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		try{
			Customer customer=(Customer) session.get(Customer.class, customerId);
			session.delete(customer);
			tx.commit();
			return true;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}

	@Override
	public boolean deleteAccount(int customerId, long accountNo) {

		try{
			session =  sessionFactory.openSession();
			tx = session.beginTransaction();
			Account account=(Account) session.get(Account.class, accountNo);
			session.delete(account);
			session.flush();
			tx.commit();
			return true;
		}
		catch (HibernateException e) {
			tx.rollback();
			throw e;}
		finally {
			session.close();
		}
	}

	@Override
	public Customer getCustomer(int customerId) {
		session=sessionFactory.openSession();
		return (Customer) session.get(Customer.class, customerId);
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		session=sessionFactory.openSession();
		return (Account) session.get(Account.class, accountNo);

	}

	@Override
	public List<Customer> getCustomers() {
		session=sessionFactory.openSession();
		return session.createQuery("FROM Customer").list();
	}

	@Override
	public List<Account> getAccounts(int customerId) {
		session=sessionFactory.openSession();
		return session.createQuery("FROM Account").list();
	}

	@Override
	public List<com.cg.banking.beans1.Transaction> getTransactions(int customerId, long accountNo) {
		session=sessionFactory.openSession();
		return session.createQuery("FROM com.cg.banking.beans1.Transaction").list();
	}

}