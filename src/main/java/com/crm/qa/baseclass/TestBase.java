package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
  

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() throws IOException
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\user hp\\Desktop\\Vishnu\\vishnuk\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void initialization() throws IOException
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user hp\\Desktop\\Vishnu\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		driver=e_driver;
		
		
		
		
		
		
		//for firefox driver
		/*if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.geko.driver","C:\\Users\\user hp\\Desktop\\Vishnu\\chromedriver_win32\\chromedriver.exe");
			driver=new FirefoxDriver();
			
		}*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

	}
	
	
	
	
	
	
	
	
	
	
	
}
