package Comprehensive.Hybrid.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Comprehensive.Hybrid.Utilities.base;

public class Contact extends base{
public WebDriver driver;
	
	public Contact(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By contact=By.linkText("Contact us");
	By name=By.cssSelector("input[id='ContactFormName-page-contact-template-0']");
	By email=By.cssSelector("input[id='ContactFormEmail-page-contact-template-0']");
	By message=By.id("ContactFormMessage-page-contact-template-0");
	By submit=By.xpath("//*[@id=\"contact_form\"]/button");
	By msg=By.cssSelector("[class='note note--success']");
	
	
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}
	public WebElement getName()
	{
		return driver.findElement(name);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(msg);
	}
}


