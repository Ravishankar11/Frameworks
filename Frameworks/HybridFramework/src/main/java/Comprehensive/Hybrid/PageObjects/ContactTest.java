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

import Comprehensive.Hybrid.UiStore.Contact;
import Comprehensive.Hybrid.Utilities.base;

public class ContactTest extends base {
	
	public static Logger log=LogManager.getLogger(ContactTest.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initiateDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void contactOwner() throws InterruptedException
	{
		Contact c=new Contact(driver);
		Thread.sleep(2000);
		log.info("Entered onto url");
		c.getContact().click();
		Thread.sleep(2000);
		log.info("Clicked on Contact at Footer");
		c.getEmail().sendKeys("user@gmail.com");
		Thread.sleep(2000);
		c.getName().sendKeys("User");
		Thread.sleep(2000);
		c.getMessage().sendKeys("hello message");
		Thread.sleep(2000);
		log.info("Entered name, email and message");
		Thread.sleep(2000);
		c.getSubmit().click();
		Thread.sleep(2000);
		Assert.assertTrue(c.getSuccessMessage().getText().contains("Thanks"));
		log.info("Information is submitted");
		log.info("Testcase - Contact page test is successfully passed");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
