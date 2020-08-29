package objectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Finalcheckoutpage {
	
WebDriver driver;
	
	@FindBy(xpath="//a[text()='FINISH']")
	WebElement finish;
	
	public Finalcheckoutpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public WebElement enterfinish()
	{
		return finish;
	}
	



}
