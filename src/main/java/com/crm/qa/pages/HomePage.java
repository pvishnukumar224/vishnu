package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/a/span")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[5]/a/span")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[6]/a")
	WebElement tasksLink;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button/i")
	WebElement newcontactlink;
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() throws IOException
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException
	{
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTask() throws IOException
	{
		tasksLink.click();
		return new TaskPage();
	}
	public void clickOnNewContact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactlink.click();
		
	}
	
	
	
	
	
	
	
	

}
