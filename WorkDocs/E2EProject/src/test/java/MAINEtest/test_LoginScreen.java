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
import resources.ExcelData;
import resources.base;

public class test_LoginScreen extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_LoginScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	@BeforeTest(alwaysRun = true)
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test(groups={"sanity","TANF"})
	public void validateLoginPage() throws IOException, InterruptedException {

		LoginScreenPO ls = new LoginScreenPO(driver);

		// Click on Login link on Landing Page

		ls.ClickLoginlink();
		
		log.info("Navigating to User Login Screen.");
		ls.ClickAccept();
		Thread.sleep(1000);
		// Enter Username and Password to login.
		al = excelData.getData("TC1", "Login", "Sno");
		System.out.println(al.toString());
		ls.EnterUsername(al.get(1).toString());

		Thread.sleep(1000); 
		ls.Enterpassword(al.get(2).toString());
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("scroll(0,500);");
		ls.ClickLogin();
		Thread.sleep(8000);
		Scrollend();
		ls.ClickYes_UseofWbste();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Home");
		log.info("Login has been done successfully");

	}
	
	@Test(groups= {"SNAP", "Regression"})
	public void validateloginPage() throws IOException, InterruptedException {

		LoginScreenPO ls = new LoginScreenPO(driver);

		// Click on Login link on Landing Page
		ls.ClickLoginlink();
		
		log.info("Navigating to User Login Screen.");
		ls.ClickAccept();
		Thread.sleep(1000);
		//Enter Username and Password to login.
		al = excelData.getData("TC5", "Login", "Sno");
		System.out.println(al.toString());
		ls.EnterUsername(al.get(1).toString());

		Thread.sleep(1000);
		ls.Enterpassword(al.get(2).toString());
		Thread.sleep(1000);
		ls.ClickLogin();
		Thread.sleep(7000);
		Scrollend();
		ls.ClickYes_UseofWbste();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Home");
		log.info("Login has been done successfully");

	}
	@Test(groups= {"Renewal"})
	public void validateLoginPg() throws IOException, InterruptedException {

		LoginScreenPO ls = new LoginScreenPO(driver);

		// Click on Login link on Landing Page
		ls.ClickLoginlink();
		
		log.info("Navigating to User Login Screen.");
		ls.ClickAccept();
		Thread.sleep(1000);
		//Enter Username and Password to login.
		al = excelData.getData("TC6", "Login", "Sno");
		System.out.println(al.toString());
		ls.EnterUsername(al.get(1).toString());

		Thread.sleep(1000);
		ls.Enterpassword(al.get(2).toString());
		Thread.sleep(1000);
		ls.ClickLogin();
		Thread.sleep(7000);
		Scrollend();
		ls.ClickYes_UseofWbste();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Home");
		log.info("Login has been done successfully");

	}
	

	@AfterTest
	public void teardown() {
		//driver.close();
	}

}
