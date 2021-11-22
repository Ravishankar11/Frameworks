package Comprehensive.Cucumber.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import Comprehensive.Cucumber.UiStore.CheckCOD;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class CheckCODStepDefinition extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;


    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }
    
    CheckCOD cd=new CheckCOD(driver);

    @When("user clicks on all gifts")
    public void user_clicks_on_all_gifts() throws Throwable {
    	cd.getGift().click();
		Thread.sleep(2000);
		log.info("Clicked on All Gifts");
		
    }

    @When("user selects auto rickshaw pen stand")
    public void user_selects_auto_rickshaw_pen_stand() throws Throwable {
    	cd.getAutoGift().click();
		Thread.sleep(2000);
		log.info("Clicked on Auto Penstand");
    }

    @When("user enters <pcode>")
    public void user_enters(String pincode) throws Throwable {
    	cd.getPincode().sendKeys(prop.getProperty("pcode"));
		Thread.sleep(2000);
		log.info("Entered pincode");
    }

    @Then("availability text appears")
    public void availability_text_appears() throws Throwable {
    	cd.getCheck().click();
		Thread.sleep(2000);
		Assert.assertEquals(cd.getDetails().getText(),"Cash on Delivery is available.");
		Thread.sleep(5000);
		log.info("Verifying whether the COD Option is available");
		log.info("Testcase - Verifying whether the gift is available for COD to our pincode is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}