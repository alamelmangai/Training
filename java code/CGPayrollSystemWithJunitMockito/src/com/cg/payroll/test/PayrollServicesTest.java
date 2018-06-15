package com.cg.payroll.test;
import static org.junit.Assert.*;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.omg.PortableServer.Servant;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {
	public static PayrollServices payrollServices;
	public static PayrollDAOServices mockDAOServices;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mockDAOServices=Mockito.mock(PayrollDAOServices.class);
		payrollServices=new PayrollServicesImpl(mockDAOServices); 
	}
	@Before
	public void setUp() throws Exception {
		Associate associate1 = new Associate(new Salary(20000, 1000, 1000), new BankDetails(123456789, "HDFC", "HDFC123"),100, 150000, "alamel", "mangai", "JAVA", "software engg", "DFHG344","chinnu@gmail.com");
		Associate associate2 = new Associate(new Salary(16000, 1000, 1000), new BankDetails(123456790, "HDFC", "HDFC456"),102, 45000, "deepak", "muraree", "JAVA", "software engg", "DFHG345","deepakproo@gmail.com");
		Associate associate3 = new Associate(new Salary(17000, 1000, 1000), new BankDetails(123456791, "HDFC", "HDFC789"),103, 60000, "aishu", "patil", "JAVA", "software engg", "DFK346","aishu@gmail.com");
		//Associate associate4 = new Associate(new Salary(15000, 1000, 1000), new BankDetails(123456789, "HDFC", "HDFC123"), 65000, "priya", "gopalan", "java", "software engg", "DHEIK45", "priya@gmail.com");
		Mockito.when(mockDAOServices.getAssociate(100)).thenReturn(associate1);
		Mockito.when(mockDAOServices.getAssociate(102)).thenReturn(associate2);
		Mockito.when(mockDAOServices.getAssociate(103)).thenReturn(associate3);
		Mockito.when(mockDAOServices.getAssociate(167)).thenReturn(null);
		ArrayList<Associate> associateList = new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);
		associateList.add(associate3);
		//Mockito.when(mockDAOServices.getAssociates()).thenReturn(associateId);
		Mockito.when(mockDAOServices.insertAssociate(new Associate(new Salary(15000, 1000, 1000), new BankDetails(123456789, "HDFC", "HDFC123"), 65000, "priya", "gopalan", "java", "software engg", "DHEIK45", "priya@gmail.com"))).thenReturn(104);
	}
	@Test
	public void testToAcceptAssociateDetails() throws Exception{
		payrollServices.getAssociateDetails(100);
		Mockito.verify(mockDAOServices).getAssociate(100);
	}
	@Test(expected=AssociateDetailsNotFoundExceptions.class)
	public void testAssociateDetailsNotFound() throws Exception{
		payrollServices.deleteAssociate(102);
		Mockito.verify(mockDAOServices).getAssociate(102);
	}
	@Test
	public void testAssociateIdFound() throws Exception{
		
	}
	@Test
	public void associateDetailsFound() throws Exception{
		
	   
	}
	@Test
	public void  testCalculateNetSalary() throws Exception{
	
	
	}
	@Test
	public void testGetAllAssociates() throws Exception{
		
	}
	@Test
	public void testDeleteAssociate() throws Exception{
	
	}
	@Test(expected=AssociateDetailsNotFoundExceptions.class)
	public void testDeleteNotAssociate() throws Exception{
		payrollServices.getAssociateDetails(600);
		Mockito.verify(mockDAOServices).getAssociate(600);
	}
	@After
	public void tearDown() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}


	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}

}
