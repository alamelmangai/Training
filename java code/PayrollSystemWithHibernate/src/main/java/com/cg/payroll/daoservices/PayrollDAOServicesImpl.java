package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.utility.AssociateMapper;
import com.cg.payroll.utility.PayrollUtility;
@Component(value="DAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*private static final String associateID = null;
	private Connection con = null;
	public PayrollDAOServicesImpl() throws PayrollServicesDownExceptions{
		con = PayrollUtility.getDBConnection();
	}*/
	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		String sql = "insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId) value(?,?,?,?,?,?,?)";
		int associateId = jdbcTemplate.update(sql, new Object[] {associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId()});
		String sql1="select max(associateId) from associate";
		List<Associate>a = jdbcTemplate.query(sql1, new AssociateMapper());
		int b=a.get(0).getAssociateID();
		String sql2 = "insert into Salary(associateId,basicSalary,epf,companyPf) value(?,?,?,?)";
		jdbcTemplate.update(sql2, new Object[] {b,associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf()});
		String sql3 = "insert into BankDetails(associateId,accountNumber,bankName,ifscCode) value(?,?,?,?)";
		jdbcTemplate.update(sql3, new Object[] {b,associate.getBankDetail().getAccountNumber(),associate.getBankDetail().getBankName(),associate.getBankDetail().getIfscCode()});
		return associateId;
	}		
	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		String sql1="update Associate set yearlyInvestmentUnder80C=?,firstName=?,lastName=?,department=?,designation=?,pancard=?,emailId=? where associateID=?";
		jdbcTemplate.update(sql1, new Object[] {associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId(),associate.getAssociateID()}); 
		String sql2="update Salary set basicSalary=?, hra=?, conveyenceAllowance=?, otherAllowance=?,personalAllowance=?,monthlyTax=?,epf=?, companyPf=?,gratuity=?,grossSalary=?,netSalary=? where associateID=?";
		jdbcTemplate.update(sql2, new Object[] {associate.getSalary().getBasicSalary(),associate.getSalary().getHra(),associate.getSalary().getConveyenceAllowance(),associate.getSalary().getOtherAllowance(),associate.getSalary().getPersonalAllowance(),associate.getSalary().getMonthlyTax(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf(),associate.getSalary().getGratuity(),associate.getSalary().getGrossSalary(),associate.getSalary().getNetSalary(),associate.getAssociateID()});
		String sql3="update BankDetails set accountNumber=?, bankName=?,ifscCode=? where associateID=?";
		jdbcTemplate.update(sql3,new Object[] {associate.getBankDetail().getAccountNumber(),associate.getBankDetail().getBankName(),associate.getBankDetail().getIfscCode(),associate.getAssociateID()});
		return true;
}
	public boolean deleteAssociate(int associateID) throws SQLException {
		try {
			String sqlDeleteQuery = "DELETE FROM Associate where associateID=?";
			jdbcTemplate.update(sqlDeleteQuery, new Object[] {associateID});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 

	@Override
	public Associate getAssociate(int associateID) throws SQLException  {
		/*	PreparedStatement pstmt=con.prepareStatement("select a.associateID,a.yearlyInvestmentUnder80C,a.firstName,a.lastName,a.department,a.designation,a.pancard,a.emailId,b.accountNumber,b.bankName,b.ifscCode,s.basicSalary, s.hra, s.conveyenceAllowance, s.otherAllowance,s.personalAllowance,s.monthlyTax,s.epf,s.companyPf,s.gratuity,s.grossSalary,s.netSalary\r\n" + 
				"from Associate a inner join BankDetails b inner join Salary s \r\n" + 
				"on a.associateId=b.associateId and a.associateID=s.associateID\r\n" + 
				"where a.associateID=? ");
		pstmt.setInt(1, associateID);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return new Associate(new Salary(rs.getFloat("basicSalary"), rs.getFloat("hra"),rs.getFloat( "conveyenceAllowance"), rs.getFloat("otherAllowance"), rs.getFloat("personalAllowance"), rs.getFloat("monthlyTax"), rs.getFloat("epf"), rs.getFloat("companyPf"), rs.getFloat("gratuity"), rs.getFloat("grossSalary"), rs.getFloat("netSalary")), new BankDetails(rs.getInt("accountNumber"), rs.getString("bankName"), rs.getString("ifscCode")),associateID,rs.getInt("yearlyInvestmentUnder80C"), rs.getString("firstName"),rs.getString("lastName"), rs.getString("department"), rs.getString("designation"),rs.getString("pancard"),rs.getString("emailId"));
		}*/
		return null;
	}
	@Override
	public List<Associate> getAssociates() {
		/*try {
			PreparedStatement pstmt=con.prepareStatement("select a.associateID,a.yearlyInvestmentUnder80C,a.firstName,a.lastName,a.department,a.designation,a.pancard,a.emailId,b.accountNumber,b.bankName,b.ifscCode,s.basicSalary, s.hra, s.conveyenceAllowance, s.otherAllowance,s.personalAllowance,s.monthlyTax,s.epf,s.companyPf,s.gratuity,s.grossSalary,s.netSalary\r\n" + 
					"from Associate a inner join BankDetails b inner join Salary s \r\n" + 
					"on a.associateId=b.associateId and a.associateID=s.associateID ");
			ResultSet rs=pstmt.executeQuery();
			List<Associate> associates=new ArrayList<>();
			while(rs.next()) {
				associates.add(new Associate(new Salary(rs.getFloat("basicSalary"), rs.getFloat("hra"), rs.getFloat("conveyenceAllowance"), rs.getFloat("otherAllowance"), rs.getFloat("personalAllowance"), rs.getFloat("monthlyTax"), rs.getFloat("epf"), rs.getFloat("companyPf"), rs.getFloat("gratuity"), rs.getFloat("grossSalary"), rs.getFloat("netSalary")), new BankDetails(rs.getInt("accountNumber"), rs.getString("bankName"), rs.getString("ifscCode")), rs.getInt("associateID"), rs.getInt("yearlyInvestmentUnder80C"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("department"), rs.getString("designation"), rs.getString("pancard"), rs.getString("emailId")));
			}
			return associates;
		} catch (SQLException e) {

			e.printStackTrace();
		}*/
		return null;
	}


}
