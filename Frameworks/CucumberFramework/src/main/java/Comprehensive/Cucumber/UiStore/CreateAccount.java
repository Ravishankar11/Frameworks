package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CreateAccount {
	
	public WebDriver driver;
	
	public CreateAccount(WebDriver driver)
	{
		this.driver=driver;
	}

	

		By signin= By.xpath("//a[@class='site-nav__link site-nav__link--icon signinlink']");
		By register=By.id("customer_register_link");
		By email=By.id("Email");
		By firstname=By.id("FirstName");
		By lastname=By.id("LastName");
		By password=By.id("CreatePassword");
		By create=By.xpath("//input[@value='Create']");
		
		
		public WebElement getSignin()
		{
			return driver.findElement(signin);
		}
		public WebElement getEmail()
		{
			return driver.findElement(email);
		}
		public WebElement getRegister()
		{
			return driver.findElement(register);
		}
		public WebElement getFirstName()
		{
			return driver.findElement(firstname);
		}
		public WebElement getLastName()
		{
			return driver.findElement(lastname);
		}
		public WebElement getPassword()
		{
			return driver.findElement(password);
		}
		public WebElement getCreate()
		{
			return driver.findElement(create);
		}
		
		

}
