package com.cg.project;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.beans.RegistrationPage;



public class RegistrationPageTest {

	static WebDriver driver;
	private RegistrationPage regPage;

	@BeforeClass
	public static void setUpDriverEnv() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Before
	public void setUptestEnv() {
		driver.get("https://github.com/join?source=header-home");
		regPage=new RegistrationPage();
		PageFactory.initElements(driver, regPage);
	}


	@Test
	public void testForBlankUserNameEmailAndPassword() {
		regPage.setUsername("");
		regPage.setPassword("");
		regPage.setEmail("");
		regPage.clickSubmitButton();
		String actualErrorMessage1=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd[2]")).getText();
		String actualErrorMessage2=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[2]/dl/dd[2]")).getText();
		String actualErrorMessage3=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[3]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage1);
		System.out.println("error Message:-"+actualErrorMessage2);
		System.out.println("error Message:-"+actualErrorMessage3);
		System.out.println("error Message:-"+actualErrorMessage);
		String message = "There were problems creating your account.";
		String message1 = "Login can't be blank";
		String message2 = "Email can't be blank";
		String message3 = "Password can't be blank and is too short (minimum is 7 characters)";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage1, message1);
		assertEquals(actualErrorMessage2, message2);
		assertEquals(actualErrorMessage3, message3);

	}
	@Test
	public void testForInValidUserNameAndValidPasswordEmail(){
		regPage.setUsername(getInvalidUsername());
		regPage.setPassword(getValidPassword());
		regPage.setEmail(getValidEmail());
		regPage.clickSubmitButton();
		String actualErrorMessage1=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage);
		System.out.println("error Message:-"+actualErrorMessage1);
		String message = "There were problems creating your account.";
		String message1 = "Login is already taken";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage1, message1);
	}
	@Test
	public void testForInValidPasswordAndValidUserNameEmail(){
		regPage.setUsername(getValidUsername());
		regPage.setPassword(getInvalidPassword());
		regPage.setEmail(getValidEmail());
		regPage.clickSubmitButton();
		String actualErrorMessage3=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[3]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage3);
		System.out.println("error Message:-"+actualErrorMessage);
		String message = "There were problems creating your account.";
		String message3 = "Password is too short (minimum is 7 characters) and needs at least one number";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage3, message3);
	}
	@Test
	public void testForInValidEmailAndValidPasswordUserName(){
		regPage.setUsername(getValidUsername());
		regPage.setPassword(getValidPassword());
		regPage.setEmail(getInvalidEmail());
		regPage.clickSubmitButton();
		String actualErrorMessage2=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[2]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage2);
		System.out.println("error Message:-"+actualErrorMessage);
		String message = "There were problems creating your account.";
		String message2 = "Email is invalid or already taken";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage2, message2);
	}
	@Test
	public void testForInvalidEmailUserNameAndValidPassword(){
		regPage.setUsername(getInvalidUsername());
		regPage.setPassword(getValidPassword());
		regPage.setEmail(getInvalidEmail());
		regPage.clickSubmitButton();
		String actualErrorMessage2=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[2]/dl/dd[2]")).getText();
		String actualErrorMessage1=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage2);
		System.out.println("error Message:-"+actualErrorMessage);
		System.out.println("error Message:-"+actualErrorMessage1);
		String message = "There were problems creating your account.";
		String message2 = "Email is invalid or already taken";
		String message1 = "Login is already taken";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage1, message1);
		assertEquals(actualErrorMessage2, message2);
	}
	@Test
	public void testForInvalidEmailUserNameAndPassword(){
		regPage.setUsername(getInvalidUsername());
		regPage.setPassword(getInvalidPassword());
		regPage.setEmail(getInvalidEmail());
		regPage.clickSubmitButton();
		String actualErrorMessage1=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd[2]")).getText();
		String actualErrorMessage2=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[2]/dl/dd[2]")).getText();
		String actualErrorMessage3=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[3]/dl/dd[2]")).getText();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		System.out.println("error Message:-"+actualErrorMessage1);
		System.out.println("error Message:-"+actualErrorMessage2);
		System.out.println("error Message:-"+actualErrorMessage3);
		System.out.println("error Message:-"+actualErrorMessage);
		String message = "There were problems creating your account.";
		String message2 = "Email is invalid or already taken";
		String message1 = "Login is already taken";
		String message3 = "Password is too short (minimum is 7 characters), needs at least one number, and can't be your username";
		assertEquals(actualErrorMessage, message);
		assertEquals(actualErrorMessage1, message1);
		assertEquals(actualErrorMessage2, message2);
		assertEquals(actualErrorMessage3, message3);
	}
	/*@Test
	public void testForValidUserNameAndPassword() {
		regPage.setUsername(getValidUsername());
		regPage.setPassword(getValidPassword());
		regPage.setEmail(getValidEmail());
		regPage.clickSubmitButton();
	}*/
	private String getValidEmail() {
		return "chinnugopalan226@gmail.com";
	}

	private String getValidPassword(){
		return "Priya09";
	}
	private String getValidUsername(){
		return "chinnugopalan";
	}
	private String getInvalidPassword(){
		return "xyz";
	}
	private String getInvalidUsername(){
		return "xyz";
	}
	private String getInvalidEmail(){
		return "xyz";
	}
	@After
	public  void tearDownTestEnv(){
		regPage=null;
	}
	@AfterClass
	public static void tearDownDriverEnv() {
		driver.close();
		driver=null;

	}
}
