package objectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Productspage {
	
	WebDriver driver;
	By shirt= By.xpath("//a[@id='item_2_title_link']");
	By cart= By.xpath("//button[text()='ADD TO CART']");
	By bin= By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']");
	By bar= By.xpath("//div[@class='header_secondary_container']");
	
	
	public Productspage(WebDriver driver) {
		
		this.driver = driver;	 
	}
	
	public WebElement clickonsaucelabsboltshirt()
	{
		return driver.findElement(shirt);
	}
	
	public WebElement clickonaddtocart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement gotobin()
	{
		return driver.findElement(bin);
	}
	
	public WebElement validatenavbar()
	{
		return driver.findElement(bar);
	}
}
