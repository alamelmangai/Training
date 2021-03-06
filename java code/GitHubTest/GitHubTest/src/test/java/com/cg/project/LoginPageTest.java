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

import com.cg.project.beans.LoginPage;



public class LoginPageTest {

	static WebDriver driver;
	private LoginPage loginPage;

	@BeforeClass
	public static void setUpDriverEnv() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Before
	public void setUptestEnv() {
		driver.get("https://github.com/login");
		loginPage=new LoginPage();
		PageFactory.initElements(driver, loginPage);
	}


	@Test
	public void testForBlankUserNameAndPassword() {
		loginPage.setUsername("");
		loginPage.setPassword("");
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();
		System.out.println("error Message:-"+actualErrorMessage);
		String message="Incorrect username or password.";
		assertEquals(actualErrorMessage, message);

	}
	@Test
	public void testForInValidUserNameAndValidPassword(){
		loginPage.setUsername(getInvalidUsername());
		loginPage.setPassword(getValidPassword());
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();
		System.out.println("error Message:-" +actualErrorMessage);
		String message="Incorrect username or password.";
		assertEquals(actualErrorMessage, message);
	}
	@Test
	public void testForValidUserNameAndInValidPassword(){
		loginPage.setUsername( getValidUsername());
		loginPage.setPassword(getInvalidPassword());
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();
		System.out.println("error Message:-" +actualErrorMessage);
		String message="Incorrect username or password.";
		assertEquals(actualErrorMessage, message);
	}
	@Test
	public void testForInValidUserNameAndInValidPassword(){
		loginPage.setUsername(getInvalidUsername());
		loginPage.setPassword(getInvalidPassword());
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();
		System.out.println("error Message:-" +actualErrorMessage);
		String message="Incorrect username or password.";
		assertEquals(actualErrorMessage, message);
	}
	@Test
	public void testForValidUserNameAndPassword() {
		loginPage.setUsername(getValidUsername());
		loginPage.setPassword(getValidPassword());
		loginPage.clickSubmitButton();
	}
	private String getValidPassword(){
		return "Chinnu@22";
	}
	private String getValidUsername(){
		return "alamelmangai";
	}
	private String getInvalidPassword(){
		return "xyz";
	}
	private String getInvalidUsername(){
		return "xyz";
	}
	@After
	public  void tearDownTestEnv(){
		loginPage=null;
	}
	@AfterClass
	public static void tearDownDriverEnv() {
		driver.close();
		driver=null;

	}
}
