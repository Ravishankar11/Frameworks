package Comprehensive.Cucumber.CucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/main/java/Comprehensive/Cucumber/Features",
		glue = "StepDefinitions",
		//dryRun = true,
		monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests
{
	 
}
