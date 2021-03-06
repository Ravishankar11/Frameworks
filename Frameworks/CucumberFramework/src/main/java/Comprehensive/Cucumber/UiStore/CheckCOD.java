package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckCOD {
	
public WebDriver driver;

	public CheckCOD(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By gift=By.xpath("//a[@data-dropdown-rel='all-of-it']");
	By auto=By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[1]/div/a/div[2]/div[1]");
	By pincode=By.name("PostalCode");
	By check=By.cssSelector("[class='codbutton btn button']");
	By text=By.id("PostalCodeCheckerAvailability");
	
	public WebElement getGift()
	{
		return driver.findElement(gift);
	}
	public WebElement getAutoGift()
	{
		return driver.findElement(auto);
	}
	public WebElement getPincode()
	{
		return driver.findElement(pincode);
	}
	public WebElement getCheck()
	{
		return driver.findElement(check);
	}
	public WebElement getDetails()
	{
		return driver.findElement(text);
	}

}
