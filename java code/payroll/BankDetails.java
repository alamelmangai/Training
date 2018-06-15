public class BankDetails{
	private int accountNumber;
	private String bankName,ifscCode;
	
	public void setAccountNumber(int accountNumber){
		this.accountNumber=accountNumber;
	}
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public void setBankName(String bankName){
		this.bankName=bankName;
	}
	public String getBankName(){
		return this.bankName;
	}
	
	public void setIfscCode(String ifscCode){
		this.ifscCode=ifscCode;
	}
	public String getIfscCode(){
		return this.ifscCode;
	}
	public BankDetails(int accountNumber,String bankName,String ifscCode){
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
}
}