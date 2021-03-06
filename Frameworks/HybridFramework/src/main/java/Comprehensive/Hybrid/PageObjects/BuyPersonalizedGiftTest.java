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

import Comprehensive.Hybrid.UiStore.BuyPersonalizedGift;
import Comprehensive.Hybrid.Utilities.base;

public class BuyPersonalizedGiftTest extends base {
	
	public static Logger log=LogManager.getLogger(BuyPersonalizedGiftTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void buyPersonalizedBottle() throws InterruptedException
	{
		BuyPersonalizedGift bpg=new BuyPersonalizedGift(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		bpg.getPersonalizedGift().click();
		Thread.sleep(2000);
		log.info("Clicked on Personalized gifts");
		bpg.getSelectBottle().click();
		Thread.sleep(2000);
		log.info("Clicked on Customizable bottle");
		bpg.getSelectBottleColor().click();
		Thread.sleep(2000);
		log.info("Changed bottle color to black");
		bpg.getCustomName().sendKeys(prop.getProperty("customname"));
		Thread.sleep(2000);
		log.info("Entered custom name");
		bpg.getAddtoCart().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().contains("cart"), true);
		log.info("Verifying whether landed on cart page");
		log.info("Testcase - Buying Personalized bottle with customized name is successfully passed");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
