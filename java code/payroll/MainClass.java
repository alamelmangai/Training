public class MainClass{
	public static void main(String[] str){
		Associate associate = new Associate();
		associate.setAssociateID(2351);
		associate.getYearlyInvestmentUnder80C();
		System.out.print("AssociateID: "+associate.getAssociateID()+"YearlyInvestmentUnder80C: "+associate.getYearlyInvestmentUnder80C());
	}
}