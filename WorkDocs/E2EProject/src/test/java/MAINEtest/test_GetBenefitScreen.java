package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPO;
import pageObjects.GetBenefitPO;
import pageObjects.LoginScreenPO;
import resources.base;

public class test_GetBenefitScreen extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_GetBenefitScreen.class.getName());

	
	@Test(groups={"sanity","TANF", "SNAP", "Regression"})
	public void validateGetBenefit() throws IOException, InterruptedException {


		
		GetBenefitPO gb = new GetBenefitPO(driver);
		Scrollend();
		//Scrollup();
		gb.ClickSBA();
		Thread.sleep(2000);
		gb.ClicklblWelcome();
		Thread.sleep(1000);
		Scrollend();
		gb.ClickIAgree();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Primary Applicant Details");
		log.info("User has landed on Primary Applicant Details screen");
		

	}
}
