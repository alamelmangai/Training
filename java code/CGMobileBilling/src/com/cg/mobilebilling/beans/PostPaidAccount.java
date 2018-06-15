package com.cg.mobilebilling.beans;

public class PostPaidAccount {
	private long mobileNo;
	private Plan plan;
	private Bill[] bill;
	public PostPaidAccount(){}
	public PostPaidAccount(long mobileNo, Plan plan, Bill[] bill) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.bill = bill;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Bill[] getBill() {
		return bill;
	}
	public void setBill(Bill[] bill) {
		this.bill = bill;
	}
	
	
}
