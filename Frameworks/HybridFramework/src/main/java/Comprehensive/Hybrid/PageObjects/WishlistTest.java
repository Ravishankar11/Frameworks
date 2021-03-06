package Comprehensive.Hybrid.PageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.Wishlist;
import Comprehensive.Hybrid.Utilities.base;

public class WishlistTest extends base {
	
	public static Logger log=LogManager.getLogger(WishlistTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void wishlisting() throws InterruptedException
	{
		Wishlist adi=new Wishlist(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		adi.getProduct().click();
		Thread.sleep(2000);
		log.info("Clicked on product");
		adi.getWishlist().click();
		Thread.sleep(2000);
		log.info("Added product to wishlist");
		driver.navigate().back();
		Thread.sleep(2000);
		log.info("Navigated back to homepage");
		adi.getMoveToWishlist().click();
		Thread.sleep(2000);
		log.info("Moved to my wishlists");
		Assert.assertEquals(adi.getList(),1);
		Thread.sleep(2000);
		adi.getButton().click();
		Thread.sleep(2000);
		log.info("verifying my item in wishlist");
		log.info("item present");
		log.info("Testcase - Buying item from section and adding it to wishlist and verifying it passed successfully");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}


}
