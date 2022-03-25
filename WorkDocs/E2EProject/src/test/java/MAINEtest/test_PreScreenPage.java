package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.PreScreenPO;
import resources.base;

public class test_PreScreenPage extends base {

	public WebDriver driver;
    public static Logger log =LogManager.getLogger(test_PreScreenPage.class.getName());
    
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
	public void validatePrescreenPage() throws IOException, InterruptedException
	{
		
		
		PreScreenPO ps=new PreScreenPO(driver);
		
		//Click on Prescreening tool on Landing Page
		
		Scrollpagedown(); 
		ps.ClickPreScreen();
		Thread.sleep(5000);
		log.info("Navigating to Prescreening Tool Screen.");
		
		//Click on Verify Catpcha tool on Prescreening Page
		
		Scrollpagedown();
		Scrollpagedown();
		ps.CheckVerifyCaptcha();
		
		//Assert.assertEquals(driver.getTitle(),"Home");
		//log.info("Successfully validated Text message");
		 //System.out.println("Test completed");
		 
		}
	
	@AfterTest
	public void teardown()
	{
		//driver.close();	
	}

	

	
}
