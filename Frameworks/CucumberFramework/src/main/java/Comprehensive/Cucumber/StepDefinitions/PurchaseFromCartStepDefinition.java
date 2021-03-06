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
import org.openqa.selenium.support.ui.Select;


import Comprehensive.Cucumber.UiStore.PurchaseFromCart;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class PurchaseFromCartStepDefinition extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
    	Thread.sleep(2000);
		log.info("Entered onto url");
    }

    PurchaseFromCart pc=new PurchaseFromCart(driver);
    
    @When("user clicks on top50 gifts")
    public void user_clicks_on_top50_gifts() throws Throwable {
    	pc.getTop().click();
		Thread.sleep(2000);
		log.info("Clicked on Top 50 Gifts");
    }

    @When("user sorts by best selling")
    public void user_sorts_by_best_selling() throws Throwable {
    	Select s=new Select(pc.getSortBy());
		s.selectByValue("best-selling");
		Thread.sleep(2000);
		log.info("Sorted gifts by best-selling");
    }

    @When("user clicks on mug and adds to cart")
    public void user_clicks_on_mug_and_adds_to_cart() throws Throwable {
    	pc.getMug().click();
		Thread.sleep(2000);
		log.info("Clicked on mug");
		pc.getAddCart().click();
		Thread.sleep(2000);
		log.info("Added mug to cart");
    }

    @When("user navigates to cart")
    public void user_navigates_to_cart() throws Throwable {
    	pc.getPopup().click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.bigsmall.in/cart");
		Thread.sleep(2000);
		Assert.assertEquals(pc.getItems(),2);
		Thread.sleep(2000);
		log.info("Selected item is in cart");
    }

    @When("clicks on checkout")
    public void clicks_on_checkout() throws Throwable {
    	pc.getCheckout().click();
		Thread.sleep(2000);
		log.info("Clicked on checkout");
    }

    @Then("payment page appears")
    public void payment_page_appears() throws Throwable {
    	pc.getPopups().click();
		Thread.sleep(2000);
		Assert.assertTrue(pc.getPayment().isDisplayed());
		Thread.sleep(2000);
		log.info("Verifying whether the current page is checkout page");
		log.info("Testcase - Buying gift from cart passed successfully");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}