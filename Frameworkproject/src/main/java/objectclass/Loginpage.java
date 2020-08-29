package objectclass;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement uname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement button;
	

	public Loginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement enterusername()
	{
		return uname;
	}
	
	public WebElement enterpassword()
	{
		return pass;
	}
	
	public WebElement clickonbutton()
	{
		return button;
	}
}