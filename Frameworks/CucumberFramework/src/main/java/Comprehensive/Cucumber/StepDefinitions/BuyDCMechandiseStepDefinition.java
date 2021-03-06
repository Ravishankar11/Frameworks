package Comprehensive.Cucumber.StepDefinitions;
/*
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
*/

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Comprehensive.Cucumber.UiStore.BuyDCMerchandise;
import Comprehensive.Cucumber.Utilities.base;

//@RunWith(Cucumber.class)
public class BuyDCMechandiseStepDefinition extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws IOException {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
    }

    BuyDCMerchandise dcm=new BuyDCMerchandise(driver);
    Actions a=new Actions(driver);
    
    @When("user moves to official merchandise")
    public void user_moves_to_official_merchandise() throws Throwable {
    	
		Thread.sleep(2000);
		log.info("Entered onto url");
		WebElement we=dcm.getMerchandise();
		a.moveToElement(we).build().perform();
		Thread.sleep(2000);
		log.info("Moved to BuyMerchandise option using Actions");
    }

    @When("user clicks on Official DC Merchandise")
    public void user_clicks_on_official_dc_merchandise() throws Throwable {
    	dcm.getDCMerchandise().click();
		Thread.sleep(2000);
		log.info("Clicked on Buy DC Merchandise");
    }

    @When("user selects Superman shaker bottle")
    public void user_selects_superman_shaker_bottle() throws Throwable {
    	dcm.getBottle().click();
		Thread.sleep(2000);
		log.info("Clicked on Bottle");
    }

    @When("user clicks on add to cart")
    public void user_clicks_on_add_to_cart() throws Throwable {
    	dcm.getAddtoCart().click();
		Thread.sleep(2000);
		log.info("Added to cart");
    }

    @When("user clicks on checkout")
    public void user_clicks_on_checkout() throws Throwable {
    	dcm.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
    }

    @Then("payment page appears")
    public void payment_page_appears() throws Throwable {
    	dcm.getPopup().click();
		Thread.sleep(2000);
		Assert.assertTrue(dcm.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying Bottle from Buy DC Merchandise option using Actions is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}
