package Comprehensive.Cucumber.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Comprehensive.Cucumber.UiStore.SearchForItem;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class SearchForItemStepDefinition extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }

    SearchForItem sf=new SearchForItem(driver);
    
    @When("user clicks on search and sends the <keyword>")
    public void user_clicks_on_search_and_sends_the(String keyword) throws Throwable {
    	sf.getSearch().sendKeys(prop.getProperty("search"));
		Thread.sleep(2000);
		log.info("Entered the keyword-cricket to search");
		sf.getSearch().sendKeys(Keys.ENTER);
    }

    @When("user adds more quantities")
    public void user_adds_more_quantities() throws Throwable {
    	Thread.sleep(2000);
		sf.getKeychain().click();
		for(int i=0;i<4;i++)
		{
			sf.getAddMore().click();
		}
		Thread.sleep(2000);
		log.info("Adding more keychains");
    }

    @Then("user adds to cart")
    public void user_adds_to_cart() throws Throwable {
    	sf.getAddToCart().click();
		Thread.sleep(2000);
		log.info("Added to cart");
		sf.getCancel().click();
		log.info("Testcase - Searching for keyword and purchasing gift is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}