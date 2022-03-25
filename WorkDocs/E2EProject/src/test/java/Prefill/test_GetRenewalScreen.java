package Prefill;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPO;
import pageObjects.GetBenefitPO;
import pageObjects.GetRenewalPO;
import pageObjects.LoginScreenPO;
import resources.base;

public class test_GetRenewalScreen extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_GetRenewalScreen.class.getName());

	
	@Test(groups={"Renewal"})
	public void validateGetRenewal() throws IOException, InterruptedException {


		
		GetRenewalPO gb = new GetRenewalPO(driver);
		Scrollend();
		//Scrollup();
		gb.ClickRB();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"Renewal Summary");
		log.info("User has landed on Renewal Summary screen");
		

	}
}
