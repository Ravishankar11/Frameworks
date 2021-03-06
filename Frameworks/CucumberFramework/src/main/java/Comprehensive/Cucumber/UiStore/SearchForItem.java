package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForItem {
	
	public WebDriver driver;

	public SearchForItem(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search=By.name("q");
	By keychain=By.xpath("//*[@id=\"snize-product-6888145649862\"]/a/div/span/span[1]");
	By addmore=By.cssSelector("[class='js--qty-adjuster js--add']");
	By addtocart=By.name("add");
	By cart=By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[4]");
	By cancel=By.xpath("//*[@id=\"CartDrawer\"]/form/div[2]/div[3]/a");
	
	
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getKeychain()
	{
		return driver.findElement(keychain);
	}
	public WebElement getAddMore()
	{
		return driver.findElement(addmore);
	}
	public WebElement getAddToCart()
	{
		return driver.findElement(addtocart);
	}
	public WebElement getCart()
	{
		return driver.findElement(cart);
	}
	public WebElement getCancel()
	{
		return driver.findElement(cancel);
	}

}
