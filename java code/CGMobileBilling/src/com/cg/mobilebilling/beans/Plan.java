package com.cg.mobilebilling.beans;

public class Plan {
	private int planID, monthlyRental, freeLocalCalls, freeStdCalls, freeLocalSMS, freeStdSMS;
	private String freeInternetDataUsageUnits,planCircle, planName;
	private float localCallRate, stdCallRate, localSMSRate, stdSMSRate, internetDataUsageRate;
	public Plan(int planID, int monthlyRental, int freeLocalCalls, int freeStdCalls, int freeLocalSMS, int freeStdSMS,
			String freeInternetDataUsageUnits, String planCircle, String planName, float localCallRate,
			float stdCallRate, float localSMSRate, float stdSMSRate, float internetDataUsageRate) {
		super();
		this.planID = planID;
		this.monthlyRental = monthlyRental;
		this.freeLocalCalls = freeLocalCalls;
		this.freeStdCalls = freeStdCalls;
		this.freeLocalSMS = freeLocalSMS;
		this.freeStdSMS = freeStdSMS;
		this.freeInternetDataUsageUnits = freeInternetDataUsageUnits;
		this.planCircle = planCircle;
		this.planName = planName;
		this.localCallRate = localCallRate;
		this.stdCallRate = stdCallRate;
		this.localSMSRate = localSMSRate;
		this.stdSMSRate = stdSMSRate;
		this.internetDataUsageRate = internetDataUsageRate;
	}
	public int getPlanID() {
		return planID;
	}
	public void setPlanID(int planID) {
		this.planID = planID;
	}
	public int getMonthlyRental() {
		return monthlyRental;
	}
	public void setMonthlyRental(int monthlyRental) {
		this.monthlyRental = monthlyRental;
	}
	public int getFreeLocalCalls() {
		return freeLocalCalls;
	}
	public void setFreeLocalCalls(int freeLocalCalls) {
		this.freeLocalCalls = freeLocalCalls;
	}
	public int getFreeStdCalls() {
		return freeStdCalls;
	}
	public void setFreeStdCalls(int freeStdCalls) {
		this.freeStdCalls = freeStdCalls;
	}
	public int getFreeLocalSMS() {
		return freeLocalSMS;
	}
	public void setFreeLocalSMS(int freeLocalSMS) {
		this.freeLocalSMS = freeLocalSMS;
	}
	public int getFreeStdSMS() {
		return freeStdSMS;
	}
	public void setFreeStdSMS(int freeStdSMS) {
		this.freeStdSMS = freeStdSMS;
	}
	public String getFreeInternetDataUsageUnits() {
		return freeInternetDataUsageUnits;
	}
	public void setFreeInternetDataUsageUnits(String freeInternetDataUsageUnits) {
		this.freeInternetDataUsageUnits = freeInternetDataUsageUnits;
	}
	public String getPlanCircle() {
		return planCircle;
	}
	public void setPlanCircle(String planCircle) {
		this.planCircle = planCircle;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public float getLocalCallRate() {
		return localCallRate;
	}
	public void setLocalCallRate(float localCallRate) {
		this.localCallRate = localCallRate;
	}
	public float getStdCallRate() {
		return stdCallRate;
	}
	public void setStdCallRate(float stdCallRate) {
		this.stdCallRate = stdCallRate;
	}
	public float getLocalSMSRate() {
		return localSMSRate;
	}
	public void setLocalSMSRate(float localSMSRate) {
		this.localSMSRate = localSMSRate;
	}
	public float getStdSMSRate() {
		return stdSMSRate;
	}
	public void setStdSMSRate(float stdSMSRate) {
		this.stdSMSRate = stdSMSRate;
	}
	public float getInternetDataUsageRate() {
		return internetDataUsageRate;
	}
	public void setInternetDataUsageRate(float internetDataUsageRate) {
		this.internetDataUsageRate = internetDataUsageRate;
	}

}