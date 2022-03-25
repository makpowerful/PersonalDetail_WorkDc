package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPO;
import pageObjects.GetBenefitPO;
import pageObjects.LoginScreenPO;
import pageObjects.PrimaryAppDetailPO;
import resources.ExcelData;
import resources.base;

public class test_PrimaryAppDetailScreen extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_PrimaryAppDetailScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	@Test(groups={"sanity","TANF", "SNAP"})
	public void validatePriAppDetail() throws IOException, InterruptedException {

		
		PrimaryAppDetailPO pad = new PrimaryAppDetailPO(driver);
		
		Thread.sleep(1500);
		Scrollpagedown();
		pad.ClickNext(); 
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(),"programSelection");
		log.info("User has landed on Program Selection Details screen");
		

	}
	
	@Test(groups={"Regression"})
	public void validatePriAppDetailReg() throws Exception {

		
		PrimaryAppDetailPO pad = new PrimaryAppDetailPO(driver);
		//pad.PickListClearAll();
		pad.PickListCheck();
		pad.ClickNext(); 
		Thread.sleep(3500);
		Assert.assertEquals(driver.getTitle(),"programSelection");
		log.info("User has landed on Program Selection Details screen");
		

	}
	
}
