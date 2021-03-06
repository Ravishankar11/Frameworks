package Comprehensive.Cucumber.UiStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchaseFromCart {
	
public WebDriver driver;

	
	public PurchaseFromCart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By top=By.cssSelector("[data-dropdown-rel='top-50']");
	By cart=By.xpath("//a[@class='site-nav__link site-nav__link--icon site-nav__link--cart js-drawer-open-cart js-no-transition']");
	By sortby=By.id("sortBy");
	By mug=By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[11]/div/a/div[2]/div[1]");
	By addcart=By.name("add");
	By popup=By.xpath("//*[@id=\"CartDrawer\"]/form/div[2]/div[3]/a");
	By checkout=By.xpath("//*[@id=\"CartPage\"]/div/form/div[1]/button[1]");
	By items=By.className("cart__items");
	By popups=By.xpath("//*[@id=\"wa-optin-widget-main\"]/div/div/div[1]/img");
	By payment=By.id("continue_button");
	
	public WebElement getTop()
	{
		return driver.findElement(top);
	}
	public WebElement getCart()
	{
		return driver.findElement(cart);
	}
	public WebElement getSortBy()
	{
		return driver.findElement(sortby);
	}
	public WebElement getMug()
	{
		return driver.findElement(mug);
	}
	public WebElement getAddCart()
	{
		return driver.findElement(addcart);
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	public int getItems()
	{
		return driver.findElements(items).size();
	}
	public WebElement getCheckout()
	{
		return driver.findElement(checkout);
	}
	public WebElement getPopups()
	{
		return driver.findElement(popups);
	}
	public WebElement getPayment()
	{
		return driver.findElement(payment);
	}
	

}
