package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginScreenPO;
import pageObjects.PreScreenPO;
import pageObjects.SFLoginPO;
import resources.ExcelData;
import resources.base;

public class test_SFLoginScreen extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_SFLoginScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("sfurl"));
		log.info("Navigated to Home page");
	}

	@Test(groups="sanity")
	public void validateLoginPage() throws IOException, InterruptedException {

		SFLoginPO sfls = new SFLoginPO(driver);

			
		log.info("Launching Salesforce User Login Screen.");
		Thread.sleep(1000);
		// Enter Username and Password to login.
		al = excelData.getData("TC2", "Login", "Sno");
		System.out.println(al.toString());
		sfls.EnterUsername(al.get(1).toString());

		Thread.sleep(1000);
		sfls.Enterpassword(al.get(2).toString());
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("scroll(0,500);");
		sfls.ClickLogin();
		Thread.sleep(7000);
		sfls.EnterSearch();
		Thread.sleep(5000);
		sfls.ClickUser();
		Thread.sleep(5000);
		sfls.Click_DelSSPM();
		Thread.sleep(2000);
		PressEnter();
		Thread.sleep(8000);
		//Assert.assertEquals(driver.getTitle(), "Home");
		log.info("Login has been done successfully");
		/*
		 * // Enter Username and Password to login.
		 * 
		 * ls.EnterUsername(); 
		 * Thread.sleep(1000); 
		 * ls.Enterpassword();
		 * Thread.sleep(1000); 
		 * ls.ClickLogin(); 
		 * Thread.sleep(6000); 
		 * Scrollend();
		 * ls.ClickYes_UseofWbste(); 
		 * Thread.sleep(5000);
		 * Assert.assertEquals(driver.getTitle(),"Home");
		 * log.info("Login has been done successfully");
		 */

	}

	@AfterTest
	public void teardown() {
		//driver.close();
	}

}
