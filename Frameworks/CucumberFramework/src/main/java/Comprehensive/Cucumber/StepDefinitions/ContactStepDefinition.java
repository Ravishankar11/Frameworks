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

import Comprehensive.Cucumber.UiStore.Contact;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class ContactStepDefinition extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;


    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }
    
    Contact c=new Contact(driver);

    @When("user moves to footer and clicks contact us")
    public void user_moves_to_footer_and_clicks_contact_us() throws Throwable {
    	c.getContact().click();
		Thread.sleep(2000);
		log.info("Clicked on Contact at Footer");
    }

    @Then("user enters all details")
    public void user_enters_all_details() throws Throwable {
    	c.getEmail().sendKeys("user@gmail.com");
		Thread.sleep(2000);
		c.getName().sendKeys("User");
		Thread.sleep(2000);
		c.getMessage().sendKeys("hello message");
		Thread.sleep(2000);
		log.info("Entered name, email and message");
    }

    @And("confirmation is verified")
    public void confirmation_is_verified() throws Throwable {
    	Thread.sleep(2000);
		c.getSubmit().click();
		Thread.sleep(2000);
		Assert.assertTrue(c.getSuccessMessage().getText().contains("Thanks"));
		log.info("Information is submitted");
		log.info("Testcase - Contact page test is successfully passed");
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}