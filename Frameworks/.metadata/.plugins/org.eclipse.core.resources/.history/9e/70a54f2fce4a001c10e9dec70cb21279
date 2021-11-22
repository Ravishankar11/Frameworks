package Comprehensive.Hybrid.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyManchesterCrest {

public WebDriver driver;

	public BuyManchesterCrest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By category=By.xpath("//a[@data-dropdown-rel='shop-by-category']");
	By person=By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[9]/ul/li[1]/a");
	By sports=By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[9]/ul/li[1]/ul/li[5]/a");
	By united=By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[2]/div/a/div[2]/div[1]");
	By title=By.xpath("//h1[@class='h1 product-single__title']");
	
	
	public WebElement getCategory()
	{
		return driver.findElement(category);
	}
	public WebElement getCategoryPerson()
	{
		return driver.findElement(person);
	}
	public WebElement getSports()
	{
		return driver.findElement(sports);
	}
	public WebElement getUnited()
	{
		return driver.findElement(united);
	}
	public WebElement getTitles()
	{
		return driver.findElement(title);
	}
}
