public class Associate{
	private int associateID,yearlyInvestmentUnder80C;
	private String firstName,lastName,department,designation,pancard,emailId;
	
	public void setAssociateID(int associateID){
		this.associateID=associateID;
	}
	public int getAssociateID(){
		return this.associateID;
	}
	
	public void setYearlyInvestmentUnder80C(int yearlyInvestmentUnder80C){
		this.yearlyInvestmentUnder80C=yearlyInvestmentUnder80C;
	}
	public int getYearlyInvestmentUnder80C(){
		return this.yearlyInvestmentUnder80C;
	}
	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return this.department;
	}
	
	public void setDesignation(String designation){
		this.designation=designation;
	}
	public String getDesignation(){
		return this.designation;
	}
	
	public void setPancard(String pancard){
		this.pancard=pancard;
	}
	public String getPancard(){
		return this.pancard;
	}
	
	public void setEmailId(String emailId){
		this.emailId=emailId;
	}
	public String getEmailid(){
		return this.emailId;
	}
	public Associate(int associateID,int yearlyInvestmentUnder80C,String firstName,String lastName,String department,String designation,String pancard,String emailId){
		this.associateID = associateID;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName=lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
}
	
}