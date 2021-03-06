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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Comprehensive.Cucumber.UiStore.BuyManchesterCrest;
import Comprehensive.Cucumber.Utilities.base;

@RunWith(Cucumber.class)
public class BuyManchesterCrestStepDefinition extends base {

	public static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;
	
    @Given("user is on home page")
    public void user_is_on_home_page() throws Throwable {
    	driver=initiateDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		log.info("Entered onto url");
    }
    
    BuyManchesterCrest bmc=new BuyManchesterCrest(driver);
    Actions a=new Actions(driver);

    @When("user moves to category options")
    public void user_moves_to_category_options() throws Throwable {
    	WebElement cat=bmc.getCategory();
		a.moveToElement(cat).build().perform();
		Thread.sleep(2000);
		log.info("Moved to Get Category Option using Actions");
    }

    @When("user moves to person options")
    public void user_moves_to_person_options() throws Throwable {
    	WebElement pers=bmc.getCategoryPerson();
		a.moveToElement(pers).build().perform();
		Thread.sleep(2000);
		log.info("Moved to Option Person");
    }

    @When("user clicks on sports")
    public void user_clicks_on_sports() throws Throwable {
    	bmc.getSports().click();
		Thread.sleep(2000);
		log.info("Clicked on sports");
    }

    @When("user clicks on manchester crest")
    public void user_clicks_on_manchester_crest() throws Throwable {
    	bmc.getUnited().click();
		Thread.sleep(2000);
		log.info("Clicked on Manchester United Crest");
    }

    @Then("manchester crest appears and title is checked")
    public void manchester_crest_appears() throws Throwable {
    	Assert.assertTrue(bmc.getTitles().getText().equalsIgnoreCase("Manchester United Engraved Wooden Crest"));
		Thread.sleep(2000);
		log.info("Verifying whether the selected gift is Manchester United Crest Using Header");
		log.info("Testcase - Buying Manchester Crest is successfully passed");
    }

  

    @And("test closes")
    public void test_closes() throws Throwable {
    	driver.close();
    }

}