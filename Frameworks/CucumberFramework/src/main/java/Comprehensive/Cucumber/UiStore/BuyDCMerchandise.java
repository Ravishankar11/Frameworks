package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Comprehensive.Cucumber.Utilities.base;

public class BuyDCMerchandise {
	
public WebDriver driver;

	
	public BuyDCMerchandise(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By merchandise=By.xpath("//a[@data-dropdown-rel='official-merchandise']");
	By dcmerchandise=By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[8]/ul/li[3]/a");
	By bottle=By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[2]/div/a/div[2]/div[1]");
	By addtocart=By.name("add");
	By checkout=By.cssSelector("[name='checkout']");
	By popup=By.xpath("//*[@id=\"wa-optin-widget-main\"]/div/div/div[1]/img");
	By payment=By.id("continue_button");
	
	
	public WebElement getMerchandise()
	{
		return driver.findElement(merchandise);
	}
	public WebElement getDCMerchandise()
	{
		return driver.findElement(dcmerchandise);
	}
	public WebElement getBottle()
	{
		return driver.findElement(bottle);
	}
	public WebElement getAddtoCart()
	{
		return driver.findElement(addtocart);
	}
	public WebElement getCheckout()
	{
		return driver.findElement(checkout);
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	public WebElement getPayment()
	{
		return driver.findElement(payment);
	}


}
