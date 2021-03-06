package Comprehensive.Hybrid.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.CreateAccount;
import Comprehensive.Hybrid.Utilities.ExcelData;
import Comprehensive.Hybrid.Utilities.base;

public class CreateAccountTest extends base {
	
	public static Logger log=LogManager.getLogger(CreateAccountTest.class.getName());

	Map<String,String> map=new HashMap<String,String>();
	
	@BeforeTest
	public void ReadExcelData() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		
		FileInputStream fs=new FileInputStream("F:\\eclipse java\\ComprehensiveAssessment\\HybridFramework\\src\\main\\java\\Comprehensive\\Hybrid\\Resources\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		//int sheets=workbook.getNumberOfSheets();
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Iterator<Row> row=sheet.iterator();
		Row frow=row.next();
		Iterator<Cell> ce=frow.cellIterator();
		while(ce.hasNext())
		{
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("TestData"));
			while(row.hasNext())
			{
				Row r=row.next();
				Iterator<Cell> cv=r.cellIterator();
				//String cellval=r.getCell(0).getStringCellValue();
					while(cv.hasNext())
					{
						map.put(cv.next().getStringCellValue(),cv.next().getStringCellValue());
						
					}
			}
		}
	}

	
	@Test
	public void creatingAccount() throws IOException, InterruptedException
	{
		//ExcelData excel=new ExcelData();
		//excel.readExcelData();
		CreateAccount ca=new CreateAccount(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		ca.getSignin().click();
		Thread.sleep(2000);
		log.info("Clicked on Signin");
		ca.getRegister().click();
		Thread.sleep(2000);
		log.info("Clicked on create account");
		ca.getFirstName().sendKeys(map.get("FirstName"));
		ca.getLastName().sendKeys(map.get("Lastname"));
		ca.getEmail().sendKeys(map.get("email"));
		ca.getPassword().sendKeys(map.get("Password"));
		Thread.sleep(2000);
		log.info("Entered values stored from excel");
		ca.getCreate().click();
		log.info("Testcase - Registering a new account is successfully passed");
		
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

	
	
	
	
}
