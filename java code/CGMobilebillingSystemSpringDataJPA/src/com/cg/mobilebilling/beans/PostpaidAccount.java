package com.cg.mobilebilling.beans;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class PostpaidAccount {
	@Id
	@GeneratedValue
	private long mobileNo;
	@OneToOne
	private Plan plan;
	/*private  HashMap<Integer, Bill> bills;	*/

	@ManyToOne
	private Customer customer; 
	
	@OneToMany(mappedBy="postpaidAccount", cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@MapKey(name="billID")
	private Map<Integer,Bill> bill;
	
	public PostpaidAccount() {}
	
	/*public PostpaidAccount(long mobileNo, Plan plan, Map<Integer, Bill> bills) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.bills = bills;
	}
*/
	public PostpaidAccount(long mobileNo, Plan plan, HashMap<Integer, Bill> bills) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.bill = bills;
	}
	public PostpaidAccount(Plan plan) {
		super();
		this.plan = plan;
		this.bill=new HashMap<>();
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<Integer, Bill> getBill() {
		return bill;
	}

	public void setBill(Map<Integer, Bill> bill) {
		this.bill = bill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (mobileNo ^ (mobileNo >>> 32));
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
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
		PostpaidAccount other = (PostpaidAccount) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (mobileNo != other.mobileNo)
			return false;
		if (plan == null) {
			if (other.plan != null)
				return false;
		} else if (!plan.equals(other.plan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostpaidAccount [mobileNo=" + mobileNo + ", plan=" + plan + ", bill=" + bill
				+ "]";
	}
	
	
}