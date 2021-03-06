package Comprehensive.Cucumber.UiStore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wishlist {
	
	public WebDriver driver;

	public Wishlist(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By product=By.xpath("//*[@id=\"CollectionSection-161855750090342625\"]/div[2]/div/div/div[2]/div/a/div[2]/div[1]");
	By prodtitle=By.xpath("//*[@id=\"ProductSection-6585716277446\"]/div/div/div[1]/div[2]/div/div[1]/h1");
	By wishlist=By.xpath("//*[@id=\"ProductSection-6585716277446\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button");
	By mvtowishlist=By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[2]");
	By list=By.id("swym-item-grid");
	By item=By.xpath("//*[@id=\"temp_1637411932948\"]/div/div/div[2]/div[1]/a");
	By button=By.id("swym-welcome-button");
	By wishlistname=By.xpath("//*[@id=\"temp_1637477518939\"]/div/div/div[2]/div[1]/a");
	
	
	public WebElement getProduct()
	{
		return driver.findElement(product);
	}
	public WebElement getWishlist()
	{
		return driver.findElement(wishlist);
	}
	public WebElement getMoveToWishlist()
	{
		return driver.findElement(mvtowishlist);
	}
	public int getList()
	{
		return driver.findElements(list).size();
		
	}
	
	
	public String getProductName()
	{
		String result="empty";
		result= driver.findElement(prodtitle).getText();
		return result;
	}
	public WebElement getButton()
	{
		return driver.findElement(button);
	}
	public WebElement getWishlistName()
	{
		return driver.findElement(wishlistname);
	}

}
