package Comprehensive.Hybrid.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyPersonalizedGift {
	
	public WebDriver driver;

	public BuyPersonalizedGift(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By personalizedgift=By.xpath("//*[@id=\"shopify-section-1601980218b6c234f6\"]/div/div/div[1]/a/div/div");
	By selectblack=By.xpath("//*[@id=\"ProductSelect-4720676241496-option-1\"]/div[6]/label");
	By buybottle=By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[5]/div/a/div[2]/div[1]");
	By customname=By.xpath("//input[@class='pplr_text pplr_monogram p_u_t cstmfy_c_required  ']");
	By addtocart=By.name("add");
	
	public WebElement getPersonalizedGift()
	{
		return driver.findElement(personalizedgift);
	}
	public WebElement getSelectBottleColor()
	{
		return driver.findElement(selectblack);
	}
	public WebElement getSelectBottle()
	{
		return driver.findElement(buybottle);
	}
	public WebElement getCustomName()
	{
		return driver.findElement(customname);
	}
	public WebElement getAddtoCart()
	{
		return driver.findElement(addtocart);
	}

}
