package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactPage;
	String sheetName="Sheet1";

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		contactPage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homepage.clickOnContactsLink();
	
		
	}
	@Test(priority = 1)
	public void SelectContants()
	{
		contactPage.selectContacts();
	}
	
	
	@Test(priority = 2)
	public void verifyContactsLable()
	{
		
		Assert.assertTrue(contactPage.verifyContactsLabel());
	}
	

	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
		
		
		
	
		
	
		
	}
	
	
	
	
	
	
	
	
	@Test(priority = 3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String nnname,String laastname)
	{
		
		homepage.clickOnNewContact();
		//contactPage.createNewContact("raj kiran", "R K");
		contactPage.createNewContact(nnname, laastname);
	}
	
	
	
	
	
	

	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
	

}
