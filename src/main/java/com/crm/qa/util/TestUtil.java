package com.crm.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.baseclass.TestBase;



public class TestUtil extends TestBase
{
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Workbook book;
	static Sheet sheet;		
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	public static String Excelpath="C:/Users/user hp/Desktop/Vishnu/vishnuk/src/main/java/com/crm/qa/testdata/Book1.xlsx";
	
	public void switchToFrame()
	{
		driver.switchTo().frame(0);
	}
	
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		try {
		file=new FileInputStream(Excelpath);
		}
		catch(Exception e)
		{
			System.out.println("file not found");
		}
		
		
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);

		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		

		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	public static void takeScreenshotAtEnd()
	{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	
		
		
	
		
	}
	
	
	
	

}
