package com.cg.banking.main;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Address;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;

public class MainClass {

	public static void main(String[] args) {
		
		Address address = new Address(600045, "chennai", "tamilnadu", "india");
		Account account[] = new Account[2];
		Transaction transaction[] = new Transaction[2];
		transaction[1] = new Transaction(1001, 3000, "cheque", "12:23:33:01","Failed","withdrawal","pune");
		account[1] = new Account(35000, 10223, "savings", transaction);
		Customer customer = new Customer(1001, 22204567, 12345678, "alamel", "Mangai", "chinnu@gmail.com", "SDF12345", "12-08-1994", address, account);
		System.out.println(customer.getAccounts()[1].getAccountBalance());
	}

}
