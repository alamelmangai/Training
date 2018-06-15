package com.cg.banking.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.banking.beans1.Account;
import com.cg.banking.beans1.Address;
import com.cg.banking.beans1.Customer;
import com.cg.banking.beans1.Transaction;
import com.cg.banking.daoservices.BankingDAOServicesImpl;
import com.cg.banking.exceptions.*;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class BankingServicesTest {
	public static BankingServicesImpl bankingServices;
	@BeforeClass
	public static void SetUpTestEnv(){
		bankingServices = new BankingServicesImpl();
	}
	@Before
	public void setTestMockData(){
		Customer customer1 = new Customer(BankingDAOServicesImpl.CUSTOMER_ID_COUNTER++, "alamel", "mangai", "chinnu@gmail.com", "SDFG344", new Address(600045, "Chennai","TN"), new Address(600055, "Chennai", "Tn"));
		Account account1 = new Account(1234, 0, "savings", "active", 1000, BankingDAOServicesImpl.ACCOUNTNO_COUNTER++);
		Transaction transaction1 = new Transaction(1, 2000, "Withdraw");
		BankingDAOServicesImpl.customers.put(customer1.getCustomerId(),customer1);
		BankingDAOServicesImpl.customers.get(customer1.getCustomerId()).getAccounts().put(account1.getAccountNo(),account1);
		BankingDAOServicesImpl.customers.get(customer1.getCustomerId()).getAccounts().get(account1.getAccountNo()).getTransactions().put(transaction1.getTransactionId(), transaction1);
		Customer customer2 = new Customer(BankingDAOServicesImpl.CUSTOMER_ID_COUNTER++, "deepak", "muraree", "deepakproo@gmail.com", "DFHR555", new Address(600033, "Kolkata","WB"), new Address(600033, "Kolkata","WB"));
		Account account2 = new Account(1245, 0, "savings", "Inactive", 1000, BankingDAOServicesImpl.ACCOUNTNO_COUNTER++);
		Transaction transaction2 = new Transaction(1, 3000, "deposit");
		BankingDAOServicesImpl.customers.put(customer2.getCustomerId(),customer2);
		BankingDAOServicesImpl.customers.get(customer2.getCustomerId()).getAccounts().put(account2.getAccountNo(),account2);
		BankingDAOServicesImpl.customers.get(customer2.getCustomerId()).getAccounts().get(account2.getAccountNo()).getTransactions().put(transaction2.getTransactionId(), transaction2);
		Customer customer3 = new Customer(BankingDAOServicesImpl.CUSTOMER_ID_COUNTER++, "aishu", "patil", "aishu@gmail.com", "JGK234", new Address(600011, "Belgauvi","K"), new Address(600011, "Belgauvi","K"));
		Account account3 = new Account(1290, 0, "savings", "active", 000, BankingDAOServicesImpl.ACCOUNTNO_COUNTER++);
		Transaction transaction3 = new Transaction(1, 3500, "Withdraw");
		BankingDAOServicesImpl.customers.put(customer3.getCustomerId(),customer3);
		BankingDAOServicesImpl.customers.get(customer3.getCustomerId()).getAccounts().put(account3.getAccountNo(),account3);
		BankingDAOServicesImpl.customers.get(customer3.getCustomerId()).getAccounts().get(account3.getAccountNo()).getTransactions().put(transaction3.getTransactionId(), transaction3);
	}
	@Test
	public void getCustomerDetailForValidData(){
		Customer actualCustomer=BankingDAOServicesImpl.customers.get(100);
		Customer expectedCustomer=new Customer(100,"alamel", "mangai", "chinnu@gmail.com", "SDFG344", new Address(600045, "Chennai","TN"), new Address(600055, "Chennai", "Tn"));
		assertEquals(expectedCustomer, actualCustomer);
	}
	@Test
	public void testToAcceptCustomerDetails()throws Exception{
		int actualCustomerId=bankingServices.acceptCustomerDetails("dharu", "jayaram", "chinnu@gmail.com", "SDFG334", "Chennai", "TN", 600045, "Chennai", "TN", 600045);
		assertEquals(103,actualCustomerId);
	}
	@Test
	public void testOpenAccountForValidData()throws Exception{
		bankingServices.getCustomerDetails(100);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testOpenAccountForInvalidCustomer()throws Exception{
		bankingServices.getCustomerDetails(111);
	}
	@Test(expected=InvalidAccountTypeException.class)
	public void testOpenAccountForInvalidAccountType()throws Exception{
		assertEquals(123456792,bankingServices.openAccount(100, "asdfkh", 1000));
	}
	@Test(expected=InvalidAmountException.class)
	public void testOpenAccountForInvalidAmount()throws Exception{
		assertEquals(123456792,bankingServices.openAccount(100, "savings", -1000));
	}
	@Test
	public void testDepositAmountForValidData()throws Exception{
		assertEquals(2000, bankingServices.depositAmount(100, 123456789, 1000),0);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testDepositAmountForInvalidCustomer()throws Exception{
		assertEquals(2000,bankingServices.depositAmount(124, 123456789, 1000),0);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testDepositAmountForAccountNotFound() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals(2000,bankingServices.depositAmount(100, 12345645, 1000),0);
	}
	@Test(expected=AccountBlockedException.class)
	public void testDepositAmountForAccountNotBlocked() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals(2000,bankingServices.depositAmount(101, 123456790, 1000),0);
	}
	@Test
	public void testShowBalanceForValidData()throws Exception{
		assertEquals(2000, bankingServices.depositAmount(100, 123456789, 1000),0);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testShowBalanceForInvalidCustomer()throws Exception{
		assertEquals(2000,bankingServices.depositAmount(124, 123456789, 1000),0);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testShowBalanceForAccountNotFound() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals(2000,bankingServices.depositAmount(100, 12345645, 1000),0);
	}
	@Test(expected=AccountBlockedException.class)
	public void testShowBalanceForAccountNotBlocked() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals(2000,bankingServices.depositAmount(101, 123456790, 1000),0);
	}
	@Test
	public void testWithdrawAmountForValidData()throws Exception{
		assertEquals(900, bankingServices.withdrawAmount(100, 123456789, 100, 1234),0);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testWithdrawAmountForInvalidCustomer()throws Exception{
		assertEquals(900,bankingServices.withdrawAmount(123, 123456789, 100, 1234),0);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testWithdrawAmountForAccountNotFound() throws Exception{
		assertEquals(900,bankingServices.withdrawAmount(100, 123456732, 100, 1234),0);
	}
	@Test(expected=AccountBlockedException.class)
	public void testWithdrawAmountForAccountNotBlocked() throws Exception{
		assertEquals(900,bankingServices.withdrawAmount(101, 123456790, 100, 1245),0);
	}
	@Test(expected=InsufficientAmountException.class)
	public void testWithdrawAmountForInsufficientAmount() throws Exception{
		assertEquals(900,bankingServices.withdrawAmount(100, 123456789, 2000, 1234),0);
	}
	@Test(expected=InvalidPinNumberException.class)
	public void testWithdrawAmountForInvalidPinNumber() throws Exception{
		assertEquals(900,bankingServices.withdrawAmount(100, 123456789, 100, 1398),0);
	}
	@Test
	public void testFundTransferForValidData()throws Exception{
		assertEquals(true, bankingServices.fundTransfer(102, 123456791, 100, 123456789, 200, 1234));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testFundTransferForInvalidCustomer()throws Exception{
		assertEquals(true,bankingServices.fundTransfer(123, 123456791, 100, 123456789, 200, 1234));
	}
	@Test(expected=AccountNotFoundException.class)
	public void testFundTransferForAccountNotFound() throws Exception{
		assertEquals(true,bankingServices.fundTransfer(102, 123456234, 100, 123456789, 200, 1234));
	}
	@Test(expected=AccountBlockedException.class)
	public void testFundTransferForAccountNotBlocked() throws Exception{
		assertEquals(true,bankingServices.fundTransfer(101, 123456790, 100, 123456789, 200, 1234));
	}
	@Test(expected=InsufficientAmountException.class)
	public void testFundTransferForInsufficientAmount() throws Exception{
		assertEquals(true,bankingServices.fundTransfer(102, 123456791, 100, 123456789, 2200, 1234));
	}
	@Test(expected=InvalidPinNumberException.class)
	public void testFundTransferForInvalidPinNumber() throws Exception{
		assertEquals(true,bankingServices.fundTransfer(102, 123456791, 100, 123456789, 200, 1256));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void generatePinForInvalidCustomerId() throws Exception {
		bankingServices.generateNewPin(187,123456789);
	}
	
	@Test(expected=AccountNotFoundException.class)
	public void generatePinForInvalidAccountNo() throws Exception {
		bankingServices.generateNewPin(100, 200234562); 
	}
	@Test
	public void testChangeAccountPinForValidData()throws Exception{
		assertEquals(true, bankingServices.changeAccountPin(100, 123456789, 1234, 9876));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testChangeAccountPinForInvalidCustomer()throws Exception{
		assertEquals(true,bankingServices.changeAccountPin(190, 123456789, 1234, 9876));
	}
	@Test(expected=AccountNotFoundException.class)
	public void testChangeAccountPinForAccountNotFound() throws Exception{
		assertEquals(true,bankingServices.changeAccountPin(100, 123456000, 1234, 9876));
	}
	@Test(expected=InvalidPinNumberException.class)
	public void testChangeAccountPinForInvalidPinNumber() throws Exception{
		assertEquals(true,bankingServices.changeAccountPin(100, 123456789, 4356, 9876));
	}
	@Test
	public void testCustomerDetailsForValidCustomer()throws Exception{
		bankingServices.getCustomerDetails(100);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testCustomerDetailsForInvalidCustomer()throws Exception{
		bankingServices.getCustomerDetails(190);
	}
	@Test
	public void AccountDetailsForValidData()throws Exception{
		 bankingServices.getAccountDetails(100, 123456789);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testAccountDetailsForInvalidCustomer()throws Exception{
		bankingServices.getAccountDetails(190, 123456789);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testAccountDetailsForAccountNotFound() throws Exception{
		bankingServices.getAccountDetails(100, 123456000);
	}@Test
	public void testCustomerAllAccountDetailsForValidCustomer()throws Exception{
		bankingServices.getcustomerAllAccountDetails(100);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testCustomerAllAccountDetailsForInvalidCustomer()throws Exception{
		bankingServices.getcustomerAllAccountDetails(190);
	}
	@Test
	public void testAccountAllTransactionForValidData()throws Exception{
		 bankingServices.getAccountAllTransaction(100, 123456789);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testgetAccountAllTransactionForInvalidCustomer()throws Exception{
		bankingServices.getAccountAllTransaction(190, 123456789);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testgetAccountAllTransactionForAccountNotFound() throws Exception{
		bankingServices.getAccountAllTransaction(100, 123456000);
	}
	@Test
	public void testAccountStatusForValidData()throws Exception{
		assertEquals("active", bankingServices.accountStatus(100, 123456789));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testAccountStatusForInvalidCustomer()throws Exception{
		assertEquals("active",bankingServices.accountStatus(124, 123456789));
	}
	@Test(expected=AccountNotFoundException.class)
	public void testAccountStatusForAccountNotFound() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals("active",bankingServices.accountStatus(100, 12345645));
	}
	@Test(expected=AccountBlockedException.class)
	public void testAccountStatusForAccountNotBlocked() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals("active",bankingServices.accountStatus(101, 123456790));
	}
	@Test
	public void testCloseAccountForValidData()throws Exception{
		assertEquals(true, bankingServices.closeAccount(102, 123456791));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testCloseAccountForInvalidCustomer()throws Exception{
		assertEquals(true,bankingServices.closeAccount(124, 123456789));
	}
	@Test(expected=AccountNotFoundException.class)
	public void testCloseAccountForAccountNotFound() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		assertEquals(true,bankingServices.closeAccount(100, 12345645));
	}
	@After
	public void tearDownMockData(){
		BankingDAOServicesImpl.customers.clear();
		BankingDAOServicesImpl.CUSTOMER_ID_COUNTER=100;
		BankingDAOServicesImpl.ACCOUNTNO_COUNTER=123456789;
	}
	@AfterClass
	public static void tearDownTestEnv(){
		bankingServices=null;
	}
	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}

}
