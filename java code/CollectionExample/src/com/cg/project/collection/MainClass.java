package com.cg.project.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.cg.project.beans.Customer;
import com.cg.project.beans.CustomerComparator;
public class MainClass {

	public static void main(String[] args) {
		ArrayList<Customer> customerList=new ArrayList<>();
		customerList.add(new Customer(111, "alamel", "mangai"));
		customerList.add(new Customer(112, "deepak", "kumar"));
		customerList.add(new Customer(113, "aishu", "patil"));
		customerList.add(new Customer(114, "priya", "gopalan"));
		Collections.sort(customerList);
		for (Customer customer : customerList) 
		System.out.println(customer);
		
		
		Collections.sort(customerList,new CustomerComparator());
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}
	

}
