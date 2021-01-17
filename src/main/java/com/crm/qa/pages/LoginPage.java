package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class LoginPage extends TestBase{
	
	
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
				//this means current class object
				//instead of this we can write LoginPage.class also
	}

	//page Libraries
	@FindBy(name="email")
	WebElement username;
	

	@FindBy(name="password")
	WebElement password;
	

	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbutton;
	

	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[3]/a")
	WebElement signinbutton;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/span[2]")
	WebElement crmLogo;
	
	//intialize all these OR with help of page factory
	
	
	//diffent actions of login page
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	public boolean validateCrmImage()
	{
		return crmLogo.isDisplayed();
	}
	
	
	
	public HomePage login(String un,String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
	}
}
