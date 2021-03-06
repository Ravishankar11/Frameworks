package Comprehensive.Hybrid.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comprehensive.Hybrid.UiStore.SearchForItem;
import Comprehensive.Hybrid.Utilities.base;

public class SearchForItemTest extends base {
	
	public static Logger log=LogManager.getLogger(SearchForItemTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ItemSearch() throws InterruptedException
	{
		SearchForItem sf=new SearchForItem(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		sf.getSearch().sendKeys(prop.getProperty("search"));
		Thread.sleep(2000);
		log.info("Entered the keyword-cricket to search");
		sf.getSearch().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		sf.getKeychain().click();
		for(int i=0;i<4;i++)
		{
			sf.getAddMore().click();
		}
		Thread.sleep(2000);
		log.info("Adding more keychains");
		sf.getAddToCart().click();
		Thread.sleep(2000);
		log.info("Added to cart");
		sf.getCancel().click();
		log.info("Testcase - Searching for keyword and purchasing gift is successfully passed");
		
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}


}
