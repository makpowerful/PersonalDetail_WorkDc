package MAINEtest;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateNewAccountPO;
import pageObjects.LoginScreenPO;
import pageObjects.ResetPasswordPO;
import pageObjects.WelcomePagePO;
import resources.ExcelData;
import resources.NewAccountUtility;
import resources.base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class test_CreateNewAccount extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_LoginScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	String email;

	@BeforeTest(alwaysRun = true, groups="SNAP")
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		al = excelData.getData("TC1", "Create New Account", "Sno");
		System.out.println(al.toString());
		System.out.println(al.size());
		email = al.get(1).toString() + generateRandomNumber() + "@mailinator.com";
		System.out.println(email);
	}

	@Test(priority = 1, groups="SNAP")
	public void goToCreateNewAccount() throws InterruptedException {

		WelcomePagePO wel = new WelcomePagePO(driver);
		Scrollpagedown();
		wel.Click_Accept();
		wel.Click_SignUp();
		Assert.assertEquals(driver.getTitle(), "Create New Account");
		log.info("Navigated to Create New Account page");
	}

	@Test(priority = 2, groups="SNAP")
	public void enterDetails() throws InterruptedException, IOException {

		CreateNewAccountPO create = new CreateNewAccountPO(driver);

		create.EnterFirstName(al.get(1).toString());
		create.EnterMiddleName(al.get(2).toString());
		create.EnterLastName(al.get(3).toString());
		create.SelectSuffix(al.get(4).toString());
		Scrolldown();
		create.EnterDOB(al.get(5).toString());
		create.Click_Toggle1(al.get(6).toString());
		create.EnterSSN(al.get(7).toString());
		create.EnterCfmSSN(al.get(8).toString());
		create.EnterClientIdno(al.get(9).toString());
		Scrolldown();
		create.EnterEmail(email);
		create.EnterCfmEmail(email);
		create.Click_Toggle2(al.get(10).toString());
		Scrollpagedown();
		create.Click_PreferredMethod(al.get(11).toString());
		create.Click_TermsOfAgreement();
		create.Click_TermsANDCondition();
		create.Click_Next();
		create.Click_ContinueWithoutReview();
		Assert.assertEquals(driver.getTitle(), "Create New Account");
		log.info("Lands on Activate Your Account Screen");

	}

	@Test(priority = 3, groups="SNAP")
	public void mailinator() throws InterruptedException, IOException, AWTException {
		openNewTab("https://www.mailinator.com/");
		NewAccountUtility account = new NewAccountUtility(driver);
		account.navigateMailinator();
		account.accessMail(email);
		account.openLatestMail();
		switchTab();
		Scrollend();
		account.clickIAccept();
		Assert.assertEquals(driver.getTitle(), "SSP Citizen Login Flow v5");
		log.info("Lands on Reset Password Screen");

	}	

}
