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

import Comprehensive.Cucumber.UiStore.Wishlist;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class WishlistStepDefinition extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }
    
    Wishlist adi=new Wishlist(driver);

    @When("user clicks on any gift")
    public void user_clicks_on_any_gift() throws Throwable {
    	adi.getProduct().click();
		Thread.sleep(2000);
		log.info("Clicked on product");
    }

    @When("user adds gift to wishlist")
    public void user_adds_gift_to_wishlist() throws Throwable {
    	adi.getWishlist().click();
		Thread.sleep(2000);
		log.info("Added product to wishlist");
    }

    @When("user navigates to homepage")
    public void user_navigates_to_homepage() throws Throwable {
    	driver.navigate().back();
		Thread.sleep(2000);
		log.info("Navigated back to homepage");
    }

    @When("user clicks on wishlist")
    public void user_clicks_on_wishlist() throws Throwable {
    	adi.getMoveToWishlist().click();
		Thread.sleep(2000);
		log.info("Moved to my wishlists");
    }

    @Then("verifies the items")
    public void verifies_the_items() throws Throwable {
    	Assert.assertEquals(adi.getList(),1);
		Thread.sleep(2000);
		adi.getButton().click();
		Thread.sleep(2000);
		log.info("verifying my item in wishlist");
		log.info("item present");
		log.info("Testcase - Buying item from section and adding it to wishlist and verifying it passed successfully");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}