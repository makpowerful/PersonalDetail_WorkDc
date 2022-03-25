package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HHInformation_AssetPO;
import pageObjects.HHInformation_ExpensePO;
import pageObjects.HHInformation_HHCircumPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.HHInformation_IncomeandSubPO;
import pageObjects.HealthCareCoverPO;
import pageObjects.LoginScreenPO;
import pageObjects.MD_AssetInfoPO;
import pageObjects.MD_ExpenseInfo_MedicalExpPO;
import pageObjects.MD_HealthInfo_BlindPO;
import pageObjects.MD_IncSubInfoPO;
import pageObjects.MD_IndInfo_AIANPO;
import pageObjects.MD_IndInfo_EducationPO;
import pageObjects.MD_OtherInfo_LAPO;
import pageObjects.MD_OtherInfo_MSFWPO;
import pageObjects.SignSubmitPO;
import resources.ExcelData;
import resources.base;

public class test_SignSubmitScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_SignSubmitScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	/*
	 * @BeforeTest public void initialize() throws IOException {
	 * 
	 * driver = initializeDriver(); driver.manage().window().maximize();
	 * log.info("Driver is initialized"); }
	 */

	@Test(groups= {"sanity", "SNAP"}) 
	public void validateSignSubmit() throws IOException, InterruptedException {

			// Submitting the Intake Application
		log.info("Submitting the Intake Application");
		SignSubmitPO ss= new SignSubmitPO(driver);
		ss.ClickSignSubmitTile_Start();
		Thread.sleep(5000);
		ss.Click_RandA_ASOU();
		Thread.sleep(1000);
		ss.Click_RandA_SNAPRR();
		Thread.sleep(1000);
		ss.Click_RandA_TANFFC();
		Thread.sleep(1000);
		
		al = excelData.getData("TC1", "Primary Applicant", "Sno");
		System.out.println(al.toString()); 
		ss.EnterFN(al.get(1).toString());
		Thread.sleep(1000);
		
		ss.EnterMN(al.get(2).toString()); 
		Thread.sleep(1000);
		
		ss.EnterLN(al.get(3).toString()); 
		Thread.sleep(1000);
		
		ss.Select_Suffix_II();
		Thread.sleep(800);
		
		ss.Click_SBA();
		Thread.sleep(12000);
		//Assert.assertEquals(driver.getTitle(), "Eligibility Results");
		log.info("Intake has been submitted successfully");
		Thread.sleep(3500);
	}
	@Test(groups="TANF")
	public void validateSignSubmitPage() throws IOException, InterruptedException {

		// Submitting the Intake Application
		log.info("Submitting the Intake Application");
		SignSubmitPO ss= new SignSubmitPO(driver);
		ss.ClickSignSubmitTile_Start();
		Thread.sleep(5000);
		ss.Click_RandA_ASOU();
		Thread.sleep(1000);
		ss.Click_RandA_TANFFC();
		Thread.sleep(1000);
		
		al = excelData.getData("TC1", "Primary Applicant", "Sno");
		System.out.println(al.toString()); 
		ss.EnterFN(al.get(1).toString());
		Thread.sleep(1000);
		
		ss.EnterMN(al.get(2).toString()); 
		Thread.sleep(1000);
		
		ss.EnterLN(al.get(3).toString()); 
		Thread.sleep(1000);
		
		ss.Select_Suffix_II();
		Thread.sleep(800);
		
		ss.Click_SBA();
		Thread.sleep(10000);
		//Assert.assertEquals(driver.getTitle(), "Eligibility Results");
		log.info("Intake has been submitted successfully");
		Thread.sleep(3500);
	}
	
	@Test(groups= {"Regression"}) 
	public void validateSignSubmitReg() throws IOException, InterruptedException {

			// Submitting the Intake Application
		log.info("Submitting the Intake Application");
		SignSubmitPO ss= new SignSubmitPO(driver);
		ss.ClickSignSubmitTile_Start();
		Thread.sleep(7000);
		ss.Click_RandA_ASOU();
		Thread.sleep(1000);
		ss.Click_RandA_SNAPRR();
		Thread.sleep(1000);
		ss.Click_RandA_TANFFC();
		Thread.sleep(1000);
		ss.Click_RandA_MA34();
		Thread.sleep(1000);
		
		al = excelData.getData("TC1", "HHMemDetailsRegression", "Sno");
		System.out.println(al.toString()); 
		ss.EnterFN(al.get(1).toString());
		Thread.sleep(1000);
		
		ss.EnterMN(al.get(2).toString()); 
		Thread.sleep(1000);
		
		ss.EnterLN(al.get(3).toString()); 
		Thread.sleep(1000);
		
		ss.EnterSuffix(al.get(4).toString()); 
		Thread.sleep(1000);
		
		ss.Click_SBA();
		checkPageReady();
		Thread.sleep(12000);
		Assert.assertEquals(driver.getTitle(), "Eligibility Results");
		log.info("Intake has been submitted successfully");
		Thread.sleep(3500);
	}
	
		
		@AfterTest(alwaysRun = true)
		public void teardown() {
			driver.quit();
		}
	
}
