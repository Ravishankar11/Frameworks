package Comprehensive.Cucumber.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Comprehensive.Cucumber.UiStore.CreateAccount;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class CreateAccountStepDefinition extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;
	Map<String,String> map=new HashMap<String,String>();

    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		log.info("Entered onto url");
    }

    CreateAccount ca=new CreateAccount(driver);
    
    @When("user clicks on signin")
    public void user_clicks_on_signin() throws Throwable {
    	ca.getSignin().click();
		Thread.sleep(2000);
		log.info("Clicked on Signin");
    }

    @When("user clicks on create account")
    public void user_clicks_on_create_account() throws Throwable {
    	ca.getRegister().click();
		Thread.sleep(2000);
		log.info("Clicked on create account");
    }

    @Then("user enters all details")
    public void user_enters_all_details() throws Throwable {
    	ca.getFirstName().sendKeys(map.get("FirstName"));
		ca.getLastName().sendKeys(map.get("Lastname"));
		ca.getEmail().sendKeys(map.get("email"));
		ca.getPassword().sendKeys(map.get("Password"));
		Thread.sleep(2000);
		log.info("Entered values stored from excel");
    }

    @And("user clicks on create account button")
    public void user_clicks_on_create_account_button() throws Throwable {
    	ca.getCreate().click();
		log.info("Testcase - Registering a new account is successfully passed");
		
    }

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}