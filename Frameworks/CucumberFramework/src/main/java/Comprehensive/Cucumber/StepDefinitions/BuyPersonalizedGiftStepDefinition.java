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

import Comprehensive.Cucumber.UiStore.BuyPersonalizedGift;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class BuyPersonalizedGiftStepDefinition extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }

    BuyPersonalizedGift bpg=new BuyPersonalizedGift(driver);
    
    @When("user clicks on personalized gifts")
    public void user_clicks_on_personalized_gifts() throws Throwable {
    	bpg.getPersonalizedGift().click();
		Thread.sleep(2000);
		log.info("Clicked on Personalized gifts");
    }

    @When("user selects customizable bottle")
    public void user_selects_customizable_bottle() throws Throwable {
    	bpg.getSelectBottle().click();
		Thread.sleep(2000);
		log.info("Clicked on Customizable bottle");
    }

    @When("user changes bottle color")
    public void user_changes_bottle_color() throws Throwable {
    	bpg.getSelectBottleColor().click();
		Thread.sleep(2000);
		log.info("Changed bottle color to black");
    }

    @When("user enters <customname>")
    public void user_enters(String customname) throws Throwable {
    	bpg.getCustomName().sendKeys(prop.getProperty("customname"));
		Thread.sleep(2000);
		log.info("Entered custom name");
    }

    @When("user adds to cart")
    public void user_adds_to_cart() throws Throwable {
    	bpg.getAddtoCart().click();
		Thread.sleep(2000);
		log.info("Adds to cart");
    }

    @Then("user checks for current url")
    public void user_checks_for_current_url() throws Throwable {
    	Assert.assertEquals(driver.getCurrentUrl().contains("cart"), true);
		log.info("Verifying whether landed on cart page");
		log.info("Testcase - Buying Personalized bottle with customized name is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}