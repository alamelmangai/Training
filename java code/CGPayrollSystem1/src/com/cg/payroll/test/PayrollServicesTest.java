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
import org.omg.PortableServer.Servant;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundExceptions;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {
	public static PayrollServices payrollServices;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		payrollServices = new PayrollServicesImpl();
	}
	@Before
	public void setUp() throws Exception {
		Associate associate1 = new Associate(new Salary(20000, 1000, 1000), new BankDetails(123456789, "HDFC", "HDFC123"),PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER++, 150000, "alamel", "mangai", "JAVA", "software engg", "DFHG344","chinnu@gmail.com");
		Associate associate2 = new Associate(new Salary(16000, 1000, 1000), new BankDetails(123456790, "HDFC", "HDFC456"),PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER++, 45000, "deepak", "muraree", "JAVA", "software engg", "DFHG345","deepakproo@gmail.com");
		Associate associate3 = new Associate(new Salary(17000, 1000, 1000), new BankDetails(123456791, "HDFC", "HDFC789"),PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER++, 60000, "aishu", "patil", "JAVA", "software engg", "DFK346","aishu@gmail.com");
		PayrollDAOServicesImpl.associates.put(associate1.getAssociateID(), associate1);
		PayrollDAOServicesImpl.associates.put(associate2.getAssociateID(), associate2);
		PayrollDAOServicesImpl.associates.put(associate3.getAssociateID(), associate3);
	}
	@Test
	public void testToAcceptAssociateDetails() throws Exception{
		int actualAssociateId = payrollServices.acceptAssociateDetails("dharani", "jayaram", "JAVA", "software engg", "DFHJ344", "dharu@gmail.com", 70000, 3000, 1000, 1000, 123456793, "HDFC", "HDFC001");
		assertEquals(114,actualAssociateId);
	}
	@Test(expected=AssociateDetailsNotFoundExceptions.class)
	public void testAssociateDetailsNotFound() throws Exception{
		payrollServices.getAssociateDetails(300);
	}
	@Test
	public void testAssociateIdFound() throws Exception{
		payrollServices.getAssociateDetails(111);
	}
	@Test
	public void associateDetailsFound() throws Exception{
		Associate expectedAssociate = new Associate(new Salary(20000, 1000, 1000), new BankDetails(123456789, "HDFC", "HDFC123"),111, 150000, "alamel", "mangai", "JAVA", "software engg", "DFHG344","chinnu@gmail.com");
	    assertEquals(expectedAssociate,payrollServices.getAssociateDetails(111));
	}
	@Test
	public void  testCalculateNetSalary() throws Exception{
		float actualNetSalary=payrollServices.calculateNetSalary(111);
		assertEquals(35533.33f,actualNetSalary,33);
	}
	@Test
	public void testGetAllAssociates() throws Exception{
		//int getAllAssociate=PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER;
		//assertEquals(114,getAllAssociate);
		ArrayList<Associate>associate = new ArrayList<>(PayrollDAOServicesImpl.associates.values());
		assertEquals(associate.size(),PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER-111);
	}
	@Test
	public void testDeleteAssociate() throws Exception{
		assertTrue(payrollServices.deleteAssociate(112));
	}
	@Test(expected=AssociateDetailsNotFoundExceptions.class)
	public void testDeleteNotAssociate() throws Exception{
		assertTrue(payrollServices.deleteAssociate(116));
	}
	//@Test
	//public void testUpdateAssociate() throws Exception{
	//	assertTrue(payrollServices.updateAssociate());

	@After
	public void tearDown() throws Exception {
		PayrollDAOServicesImpl.associates.clear();
		PayrollDAOServicesImpl.ASSOCIATE_ID_COUNTER=111;	
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		payrollServices=null;
	}


	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}

}
