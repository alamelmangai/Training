package com.cg.project.beans;

public class Account {
	private static int SUCCESS,FAIL = 0;
	private volatile int balance;
	public Account(){}
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public synchronized int deposit(int amount){
		/*synchronized (this) {
		}*/
		this.notify();
		this.notifyAll();
		balance=balance+amount;
		return balance;
	}
	/*public synchronized int withdraw(int amount){
		balance=balance-amount;
		return balance;
	}*/
	public synchronized int withdraw(int amount)throws InterruptedException{
		if(balance<0||(getBalance()-amount)<0){
			FAIL++;
			System.out.println("\n\t\tWithdrawFail"+FAIL);
			this.wait(8000);
		return balance;
		}
		else{
			balance=balance-amount;
			SUCCESS++;
			System.out.println("\n\t\tWithdrawSuccess"+SUCCESS);
		return balance;
	}
}
}
