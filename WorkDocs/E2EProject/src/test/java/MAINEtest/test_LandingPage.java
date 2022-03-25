package MAINEtest;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class test_LandingPage extends base{
	public WebDriver driver;
    public static Logger log =LogManager.getLogger(test_LandingPage.class.getName());
    
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.manage().window().maximize();
		 log.info("Driver is initialized");
			
		 driver.get(prop.getProperty("url"));
		
		 log.info("Navigated to Home page");
	}
	
	@Test(groups="sanity")
	public void validateAppTitle() throws IOException
	{
		
		//compare the text from the browser with actual text.
		Assert.assertEquals(driver.getTitle(),"Home");
		log.info("Successfully validated Text message");
		 System.out.println("Test completed");
		 
		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
	
}
