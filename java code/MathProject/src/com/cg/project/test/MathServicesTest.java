package com.cg.project.test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.project.exceptions.InValidNoRangeException;
import com.cg.project.services.MathServicesImpl;
import com.cg.project.services.MathServices;
public class MathServicesTest {
	private static MathServices services;
	int validNum1,validNum2,inValidNum1,inValidNum2,expectedAns;
	@BeforeClass
	public static void setUpTestEnv(){
		services=new MathServicesImpl();
	}
	@Before
	public void setUpMockData(){
		validNum1=10;
		validNum2=30;
		inValidNum1=-21;
		inValidNum2=-16;
		expectedAns=0;
	}
	@After
	public void tearDownMockData(){
		validNum1=10;
		validNum2=30;
		inValidNum1=-21;
		inValidNum2=-16;
		expectedAns=0;
	}
	@Test(expected=InValidNoRangeException.class)
	public void testInvalidNo1Add()throws InValidNoRangeException {
		services.add(inValidNum1, validNum2);
	}
	@Test(expected=InValidNoRangeException.class)
	public void testInvalidNo2Add()throws InValidNoRangeException {
		services.add(validNum1, inValidNum2);
	}
	@Test
	public void testValidNosAdd() throws InValidNoRangeException{
		expectedAns=40;
		Assert.assertEquals(expectedAns, services.add(validNum1, validNum2));
	}
	@Test(expected=InValidNoRangeException.class)
	public void testInvalidNo1Sub()throws InValidNoRangeException {
		services.sub(inValidNum1, validNum2);
	}
	@Test(expected=InValidNoRangeException.class)
	public void testInvalidNo2Sub()throws InValidNoRangeException {
		services.sub(validNum1, inValidNum2);
	}
	@Test
	public void testValidNosSub() throws InValidNoRangeException{
		Assert.assertEquals(-20, services.sub(validNum1, validNum2));
	}
	@AfterClass
	public static void tearDownTestEnv(){
		services=null;
	}
}

