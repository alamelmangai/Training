package com.cg.banking.beans1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;
@Entity
public class Account {

	private int pinNumber,pinCounter;
	private String accountType,status;
	private float accountBalance;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	@ManyToOne
	private Customer customer; 
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL)
	@MapKey(name="transactionId")
	private Map<Integer,Transaction> transaction; 
	
	//public static HashMap<Integer,Transaction> transactions=new HashMap<>();
	//HashMap<Integer,Transaction> transactions=new HashMap<>();
	public Account() {
	}
	
	public Account(String accountType, float accountBalance, long accountNo) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}
	public Account(int pinNumber, int pinCounter, String accountType, String status, float accountBalance,
			long accountNo) {
		super();
		this.pinNumber = pinNumber;
		this.pinCounter = pinCounter;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}

	public Account(int pinNumber, int pinCounter, String accountType, String status, float accountBalance,
			long accountNo, int transactionIdCounter, HashMap<Integer, Transaction> transactions) {
		super();
		this.pinNumber = pinNumber;
		this.pinCounter = pinCounter;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
		this.transaction = transaction;
	}
	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getPinCounter() {
		return pinCounter;
	}

	public void setPinCounter(int pinCounter) {
		this.pinCounter = pinCounter;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<Integer, Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Map<Integer, Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalance);
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + pinCounter;
		result = prime * result + pinNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
			return false;
		if (accountNo != other.accountNo)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (pinCounter != other.pinCounter)
			return false;
		if (pinNumber != other.pinNumber)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [pinNumber=" + pinNumber + ", pinCounter=" + pinCounter + ", accountType=" + accountType
				+ ", status=" + status + ", accountBalance=" + accountBalance + ", accountNo=" + accountNo
				+ ", transaction=" + transaction + "]";
	}
}