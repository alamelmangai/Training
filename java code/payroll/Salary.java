public class Salary{
	private float basicSalary,hra,conveyenceAllowance; 
	private float otherAllowance,personalAllowance,monthlyTax,epf;
	private float companyPf,gratuity,grossSalary,netSalary;
	
	public void setBasicSalary(float basicSalary){
		this.basicSalary=basicSalary;
	}
	public float getBasicSalary(){
		return this.basicSalary;
	}
	
	public void setHra(float hra){
		this.hra=hra;
	}
	public float getHra(){
		return this.hra;
	}
	
	public void setConveyenceAllowance(float conveyenceAllowance){
		this.conveyenceAllowance=conveyenceAllowance;
	}
	public float getConveyenceAllowance(){
		return this.conveyenceAllowance;
	}
	
	public void setOtherAllowance(float otherAllowance){
		this.otherAllowance=otherAllowance;
	}
	public float getOtherAllowance(){
		return this.otherAllowance;
	}
	
	public void setPersonalAllowance(float personalAllowance){
		this.personalAllowance=personalAllowance;
	}
	public float getPersonalAllowance(){
		return this.personalAllowance;
	}
	
	public void setMonthlyTax(float monthlyTax){
		this.monthlyTax=monthlyTax;
	}
	public float getMonthlyTax(){
		return this.monthlyTax;
	}
	
	public void setEpf(float epf){
		this.epf=epf;
	}
	public float getEpf(){
		return this.epf;
	}
	
	public void setCompanyPf(float companyPf){
		this.companyPf=companyPf;
	}
	public float getCompanyPf(){
		return this.companyPf;
	}
	
	public void setGratuity(float gratuity){
		this.gratuity=gratuity;
	}
	public float getGratuity(){
		return this.gratuity;
	}
	
	public void setGrossSalary(float grossSalary){
		this.grossSalary=grossSalary;
	}
	public float getGrossSalary(){
		return this.grossSalary;
	}
	
	public void setNetSalary(float netSalary){
		this.netSalary=netSalary;
	}
	public float getNetSalary(){
		return this.netSalary;
	}
	public salary(float basicSalary,float hra,float conveyenceAllowance,float otherAllowance,float personalAllowance,float monthlyTax,float epf,float companyPf,float gratuity,float grossSalary,float netSalary){
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyenceAllowance = conveyenceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllowance = personalAllowance;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;

}
}