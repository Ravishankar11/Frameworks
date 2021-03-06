package Comprehensive.Hybrid.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.PurchaseFromCart;
import Comprehensive.Hybrid.Utilities.base;

public class PurchaseFromCartTest extends base {
	
	public static Logger log=LogManager.getLogger(PurchaseFromCartTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void purchaseFromCarts() throws InterruptedException
	{
		PurchaseFromCart pc=new PurchaseFromCart(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		pc.getTop().click();
		Thread.sleep(2000);
		log.info("Clicked on Top 50 Gifts");
		Select s=new Select(pc.getSortBy());
		s.selectByValue("best-selling");
		Thread.sleep(2000);
		log.info("Sorted gifts by best-selling");
		pc.getMug().click();
		Thread.sleep(2000);
		log.info("Clicked on mug");
		pc.getAddCart().click();
		Thread.sleep(2000);
		log.info("Added mug to cart");
		pc.getPopup().click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.bigsmall.in/cart");
		Thread.sleep(2000);
		Assert.assertEquals(pc.getItems(),2);
		Thread.sleep(2000);
		log.info("Selected item is in cart");
		pc.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
		pc.getPopups().click();
		Thread.sleep(2000);
		Assert.assertTrue(pc.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying gift from cart passed successfully");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
