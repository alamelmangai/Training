public class MainClass1{
	public static void main(String[] str){
		
		BankDetails bankDetails1 = new BankDetails(123456,"SBI","SBI000123");
		BankDetails bankDetails2 = new BankDetails(651237,"SBI","SBI000891");
		BankDetails bankDetails3 = new BankDetails(487192,"HDFC","HDFC000456");
		BankDetails bankDetails4 = new BankDetails(462929,"SBI","SBI000455");
		BankDetails bankDetails5 = new BankDetails(247894,"ICICI","ICICI000127");

		System.out.print("Bankccountnumber: "+bankDetails5.getAccountNumber()+"Bank name: "+bankDetails5.getBankName()+"Bank ifsc:"+bankDetails5.getIfscCode());
	
		Associate associate1 = new Associate(1,140000,"alamel","mangai","java","software engineer","BPLS123F","alamel@cpagemini.com");
		Associate associate2 = new Associate(2,150000,"aishu","patil","java","software engineer","MPLS435F","aishu@cpagemini.com");
		Associate associate3 = new Associate(3,170000,"ankur","busa","java","software engineer","KJDH146F","ankur@cpagemini.com");
		Associate associate4 = new Associate(4,220000,"deepak","muraree","java","software engineer","MLSD345L","deepak@cpagemini.com");
		Associate associate5 = new Associate(5,110000,"anmol","thawker","java","software engineer","PODS761J","anmol@cpagemini.com");	
		
		System.out.print("AssociateID: "+associate2.getAssociateID()+" YearlyInvestmentUnder80C: "+associate2.getYearlyInvestmentUnder80C());	
}
}