package com.cg.project.main;
import com.cg.project.beans.Customer;
public class MainClass {

	public static void main(String[] args) {
		Thread th1 = new Thread(new Customer(),"rahul");
		Thread th2 = new Thread(new Customer(),"anil");
		Thread th3 = new Thread(new Customer(),"aishu");
		th1.start();
		th2.start();
		th3.start();
	}

}
