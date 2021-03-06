package Comprehensive.Cucumber.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Comprehensive.Cucumber.UiStore.BuyGiftCard;
import Comprehensive.Cucumber.Utilities.base;

//@RunWith(Cucumber.class)
public class BuyGiftCardStepDefinition extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
        
    }
    
    BuyGiftCard gc=new BuyGiftCard(driver);

    @When("user clicks on giftcards")
    public void user_clicks_on_giftcards() throws Throwable {
    	gc.getGiftCard().click();
		Thread.sleep(2000);
		log.info("Clicked on giftcard from navigation bar");
        
    }

    @When("user adds two giftcards")
    public void user_adds_two_giftcards() throws Throwable {
    	gc.getAddCard().click();
		Thread.sleep(2000);
		log.info("selected two gift cards");
    }

    @When("user clicks on add to cart")
    public void user_clicks_on_add_to_cart() throws Throwable {
    	gc.getSubmit().click();
		Thread.sleep(2000);
		log.info("Clicked on add to cart");
    }

    @When("user clicks on checkout")
    public void user_clicks_on_checkout() throws Throwable {
    	gc.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
    }

    @Then("payment page appears")
    public void payment_page_appears() throws Throwable {
    	gc.getPopup().click();
		Thread.sleep(2000);
		Assert.assertTrue(gc.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying two giftcards is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}