package com.cg.mobilebilling.main;

import com.cg.mobilebilling.beans.Address;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostPaidAccount;

public class MainClass {

	public static void main(String[] args) {
		Address address = new Address("chennai", "TamilNadu", "India", "600045");
		Bill bill[] = new Bill[2];
		bill[0] = new Bill(1001, 200, 200, 200, 200, 12, 12, "May", "1.5GB", 1200f, 00.20f, 00.20f, 00.35f, 00.70f);
		Plan plan = new Plan(1101, 1200, 200, 200, 200, 200, "1.5GB", "Pune", "MagicCalls", 00.35f, 00.20f, 00.20f, 00.20f, 00.70f);
		PostPaidAccount postPaidAccount[] = new PostPaidAccount[2];
		postPaidAccount[1] = new PostPaidAccount(8754517534l, plan, bill);
		System.out.println(postPaidAccount[1].getMobileNo()+postPaidAccount[1].getPlan().getPlanName());
	}

}
