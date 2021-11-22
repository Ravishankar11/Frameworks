package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Comprehensive.Cucumber.Utilities.base;


public class BuyGiftCard {
	
public WebDriver driver;
	
	public BuyGiftCard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By giftcard=By.xpath("//i[@class='fa fa-gift']");
	By addcard=By.xpath("//*[@id=\"AddToCartForm-738195636312\"]/div[3]/div/span[1]");
	By submit=By.name("add");
	By checkout=By.xpath("//*[@id=\"CartDrawer\"]/form/div[2]/div[3]/button");
	By popup=By.xpath("//*[@id=\"wa-optin-widget-main\"]/div/div/div[1]/img");
	By payment=By.id("continue_button");
	
	
	public WebElement getGiftCard()
	{
		return driver.findElement(giftcard);
	}
	public WebElement getAddCard()
	{
		return driver.findElement(addcard);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	public WebElement getCheckout()
	{
		return driver.findElement(checkout);
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public WebElement getPayment()
	{
		return driver.findElement(payment);
	}

}
