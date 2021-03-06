package Comprehensive.Hybrid.PageObjects;

import java.io.IOException;

import java.util.Iterator;
import java.util.Set;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.BuyGiftCard;
import Comprehensive.Hybrid.Utilities.base;

public class BuyGiftCardTest extends base {
	
	public static Logger log=LogManager.getLogger(BuyGiftCardTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void buyGiftCard() throws InterruptedException
	{
		BuyGiftCard gc=new BuyGiftCard(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		gc.getGiftCard().click();
		Thread.sleep(2000);
		log.info("Clickedon giftcard from navigation bar");
		gc.getAddCard().click();
		Thread.sleep(2000);
		log.info("selected two gift cards");
		gc.getSubmit().click();
		Thread.sleep(2000);
		log.info("Clicked on add to cart");
		gc.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
		gc.getPopup().click();
		Thread.sleep(2000);
		Assert.assertTrue(gc.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying two giftcards is successfully passed");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
