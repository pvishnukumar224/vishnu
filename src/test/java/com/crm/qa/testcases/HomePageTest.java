package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{  ///test cases should be independent

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactPage;
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void verifyHomePageTitle()
	{
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}
	
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws IOException
	{
		contactPage=homepage.clickOnContactsLink();
		
		
	}
	
	
	
	
	
	
	
	
	
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
