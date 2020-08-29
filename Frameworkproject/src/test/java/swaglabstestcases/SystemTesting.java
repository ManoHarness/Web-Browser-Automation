package swaglabstestcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectclass.Checkoutpage;
import objectclass.Finalcheckoutpage;
import objectclass.Loginpage;
import objectclass.Productspage;
import resources.Base;


public class SystemTesting extends Base {
	
	WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void getdriver() throws IOException
	{
		driver =intializedriver();
		log.info("Driver is initialized");
		
		driver.get(p.getProperty("url"));
		log.info("Navigated to swaglabs login page");
	}
	

	@Test
	public void buyproductscenario() throws IOException 
	{
		Loginpage l = new Loginpage(driver);
		l.enterusername().sendKeys("problem_user");
		l.enterpassword().sendKeys("secret_sauce");
		l.clickonbutton().click();
		
		log.info("Navigated to swaglabs products page");
		Productspage p = new Productspage(driver);
		p.clickonsaucelabsboltshirt().click();
		p.clickonaddtocart().click();
		p.gotobin().click();
		
		log.info("Navigated to checkout page");
		Checkoutpage c= new Checkoutpage(driver);
		c.clickoncheckout().click();
		c.enterfirstname().sendKeys("jkhb");
		c.enterlastname().sendKeys("bnvn");
		c.enterzipcode().sendKeys("1234");
		c.entercontinue().click();
		
		log.info("Navigated to final checkout page");
		Finalcheckoutpage f = new Finalcheckoutpage(driver);
		f.enterfinish().click();
		
		log.info("test complete");
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
