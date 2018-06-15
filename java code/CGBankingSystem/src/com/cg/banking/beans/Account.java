package com.cg.banking.beans;

public class Account {
		private int accountBalance,accountNo;
		private String accountType;
		private Transaction[] transactions;
		public Account(){}
		public Account(int accountBalance, int accountNo, String accountType, Transaction[] transactions) {
			super();
			this.accountBalance = accountBalance;
			this.accountNo = accountNo;
			this.accountType = accountType;
			this.transactions = transactions;
		}
		public int getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(int accountBalance) {
			this.accountBalance = accountBalance;
		}
		public int getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(int accountNo) {
			this.accountNo = accountNo;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public Transaction[] getTransactions() {
			return transactions;
		}
		public void setTransactions(Transaction[] transactions) {
			this.transactions = transactions;
		}
		
}