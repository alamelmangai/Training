package com.cg.banking.beans;

public class Transaction {
		private int transactionId,amount;
		private String modeOfTransation,timeStamp,transactionStatus,transactionType,transactionLocation;
		public Transaction(int transactionId, int amount, String modeOfTransation, String timeStamp,
				String transactionStatus, String transactionType, String transactionLocation) {
			super();
			this.transactionId = transactionId;
			this.amount = amount;
			this.modeOfTransation = modeOfTransation;
			this.timeStamp = timeStamp;
			this.transactionStatus = transactionStatus;
			this.transactionType = transactionType;
			this.transactionLocation = transactionLocation;
		}
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getModeOfTransation() {
			return modeOfTransation;
		}
		public void setModeOfTransation(String modeOfTransation) {
			this.modeOfTransation = modeOfTransation;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getTransactionStatus() {
			return transactionStatus;
		}
		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public String getTransactionLocation() {
			return transactionLocation;
		}
		public void setTransactionLocation(String transactionLocation) {
			this.transactionLocation = transactionLocation;
		} 
		
}
