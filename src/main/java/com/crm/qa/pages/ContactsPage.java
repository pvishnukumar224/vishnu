package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseclass.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstname;
	
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement lastname;
	
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savebtn;

	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[1]/div/label")
	WebElement checkbox;
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	public void selectContacts( )
	{
		checkbox.click();
	}
	public void createNewContact(String frst,String last)
	{
		//Select select=new Select((WebElement) driver);
		firstname.sendKeys(frst);
		lastname.sendKeys(last);
		savebtn.click();
	}
	
	
	

}
	