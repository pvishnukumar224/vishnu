package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		super();//it will call super class construtor
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		
	}
	
	
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");

	}
	
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpage.validateCrmImage();
		Assert.assertTrue(flag);			
	}
	
	
	@Test(priority = 3)
	public void loginTest() throws IOException
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
				
	}
	
	
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	

}
