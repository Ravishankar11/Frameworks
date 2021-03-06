package Comprehensive.Hybrid.PageObjects;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.BuyManchesterCrest;
import Comprehensive.Hybrid.Utilities.base;

public class BuyManchesterCrestTest extends base {
	
	public static Logger log=LogManager.getLogger(BuyManchesterCrestTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void buyManchesterUnitedCrester() throws InterruptedException
	{
		BuyManchesterCrest bmc=new BuyManchesterCrest(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		Actions a=new Actions(driver);
		WebElement cat=bmc.getCategory();
		a.moveToElement(cat).build().perform();
		Thread.sleep(2000);
		log.info("Moved to Get Category Option using Actions");
		WebElement pers=bmc.getCategoryPerson();
		a.moveToElement(pers).build().perform();
		Thread.sleep(2000);
		log.info("Moved to Option Person");
		bmc.getSports().click();
		Thread.sleep(2000);
		log.info("Clicked on sports");
		bmc.getUnited().click();
		Thread.sleep(2000);
		log.info("Clicked on Manchester United Crest");
		Assert.assertTrue(bmc.getTitles().getText().equalsIgnoreCase("Manchester United Engraved Wooden Crest"));
		Thread.sleep(2000);
		log.info("Verifying whether the selected gift is Manchester United Crest Using Header");
		log.info("Testcase - Buying Manchester Crest is successfully passed");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
