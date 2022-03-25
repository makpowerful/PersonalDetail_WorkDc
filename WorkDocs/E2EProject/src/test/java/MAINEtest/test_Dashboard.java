package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPO;
import pageObjects.LoginScreenPO;
import resources.base;

public class test_Dashboard extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_Dashboard.class.getName());
	
	
	@Test(groups={"sanity","TANF", "SNAP", "Regression"})
	public void validateWelcomeScreen() throws IOException, InterruptedException {

		DashboardPO db = new DashboardPO(driver);
		Scrollpagedown();
		Scrollpagedown();
		Thread.sleep(1500);
		db.ClickAFB();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(),"getStartedBenefits");
		log.info("User has landed on Get Started on the Benefits Application screen");

	}
	
	public void validateContinueApplication()
	{
		DashboardPO db = new DashboardPO(driver);
		
	}
}
