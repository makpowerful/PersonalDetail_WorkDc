package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.WelcomePagePO;
import resources.ExcelData;
import resources.base;

public class test_WelcomeScreen extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_LoginScreen.class.getName());
	ExcelData excelData = new ExcelData();

	@BeforeTest(alwaysRun = true)
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test
	public void validateLoginPage() throws InterruptedException {

		WelcomePagePO wel = new WelcomePagePO(driver);
		Scrollpagedown();
		wel.Click_SignUp();
	}
}
