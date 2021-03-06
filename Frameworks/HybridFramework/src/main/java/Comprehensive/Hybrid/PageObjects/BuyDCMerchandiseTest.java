package Comprehensive.Hybrid.PageObjects;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.BuyDCMerchandise;
import Comprehensive.Hybrid.Utilities.base;


import org.apache.logging.log4j.*;


public class BuyDCMerchandiseTest extends base {
	
	public static Logger log=LogManager.getLogger(BuyDCMerchandiseTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void buyMerchandise() throws InterruptedException, IOException
	{
		BuyDCMerchandise dcm=new BuyDCMerchandise(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		Actions a=new Actions(driver);
		WebElement we=dcm.getMerchandise();
		a.moveToElement(we).build().perform();
		Thread.sleep(2000);
		log.info("Moved to BuyMerchandise option using Actions");
		dcm.getDCMerchandise().click();
		Thread.sleep(2000);
		log.info("Clicked on Buy DC Merchandise");
		dcm.getBottle().click();
		Thread.sleep(2000);
		log.info("Clicked on Bottle");
		dcm.getAddtoCart().click();
		Thread.sleep(2000);
		log.info("Added to cart");
		dcm.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
		dcm.getPopup().click();
		Thread.sleep(2000);
		Assert.assertTrue(dcm.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying Bottle from Buy DC Merchandise option using Actions is successfully passed");	
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
	

}
