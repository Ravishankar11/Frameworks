package Comprehensive.Hybrid.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.CheckCOD;
import Comprehensive.Hybrid.Utilities.base;

public class CheckCODTest extends base {
	
	public static Logger log=LogManager.getLogger(CheckCODTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void checkForCOD() throws InterruptedException
	{
		CheckCOD cd=new CheckCOD(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		cd.getGift().click();
		Thread.sleep(2000);
		log.info("Clicked on All Gifts");
		cd.getAutoGift().click();
		Thread.sleep(2000);
		log.info("Clicked on Auto Penstand");
		cd.getPincode().sendKeys(prop.getProperty("pcode"));
		Thread.sleep(2000);
		log.info("Entered pincode");
		cd.getCheck().click();
		Thread.sleep(2000);
		Assert.assertEquals(cd.getDetails().getText(),"Cash on Delivery is available.");
		Thread.sleep(5000);
		log.info("Verifying whether the COD Option is available");
		log.info("Testcase - Verifying whether the gift is available for COD to our pincode is successfully passed");
		
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}


}
