package objectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	
WebDriver driver;

    @FindBy(xpath="//a[text()='CHECKOUT']")
    WebElement out;
	
	@FindBy(id="first-name")
	WebElement fname;
	
	@FindBy(id="last-name")
	WebElement lname;
	
	@FindBy(id="postal-code")
	WebElement code;
	
	@FindBy(xpath="//input[@class='btn_primary cart_button']")
	WebElement button;
	
	@FindBy(xpath="//div[@class='bm-burger-button']")
	WebElement logout;

	
	public Checkoutpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement clickoncheckout()
	{
		return out;
	}

	public WebElement enterfirstname()
	{
		return fname;
	}
	
	public WebElement enterlastname()
	{
		return lname;
	}
	
	public WebElement enterzipcode()
	{
		return code;
	}
	
	public WebElement entercontinue()
	{
		return button;
	}

}
