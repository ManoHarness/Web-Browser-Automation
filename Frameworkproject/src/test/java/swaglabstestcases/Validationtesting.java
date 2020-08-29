package swaglabstestcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectclass.Loginpage;
import objectclass.Productspage;
import resources.Base;

public class Validationtesting extends Base {
	WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void getdriver() throws IOException {
		
		driver =intializedriver();
        log.info("Driver is initialized");
		
		driver.get(p.getProperty("url"));
		log.info("Navigated to swaglabs login page");
	}
	
	@Test
	public void validatenavbar() {
		
		Loginpage l= new Loginpage(driver);
		l.enterusername().sendKeys("problem_user");
		l.enterpassword().sendKeys("secret_sauce");
		l.clickonbutton().click();
		
		log.info("Navigated to swaglabs products page");
		Productspage p = new Productspage(driver);
		
		Assert.assertTrue(p.validatenavbar().isDisplayed());
		log.info("navigation bar is displayed");
		
	}
	
	@Test
	public void verifyapptitle() {
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		log.info("app title is verified");
		log.info("test is completed");
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	

}
