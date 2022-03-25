package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AuthRepPO;
import pageObjects.HHInformation_AssetPO;
import pageObjects.HHInformation_ExpensePO;
import pageObjects.HHInformation_HHCircumPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.HHInformation_IncomeandSubPO;
import pageObjects.HHInformation_OAssetPO;
import pageObjects.HealthCareCoverPO;
import pageObjects.RelationshipandTaxfillingPO;

import pageObjects.ContactPO;
import pageObjects.LoginScreenPO;
import pageObjects.MD_AssetInfoPO;
import pageObjects.MD_AssetTransferInfomationPO;
import pageObjects.MD_ExpenseInfo_MedicalExpPO;
import pageObjects.MD_HealthInfo_BlindPO;
import pageObjects.MD_HealthInfo_LTCPO;
import pageObjects.MD_HealthInfo_MediCovPO;
import pageObjects.MD_HealthInfo_PregnancyPO;
import pageObjects.MD_IncSubInfoPO;
import pageObjects.MD_IndInfo_FFCPO;
import pageObjects.MD_OtherInfo_ConvictionPO;
import pageObjects.MD_OtherInfo_LAPO;
import pageObjects.MD_OtherInfo_MSFWPO;
import pageObjects.MD_OutOfHouseholdPO;
import pageObjects.SignSubmitPO;

public class Rough extends base {

	public static Properties prop;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Rough.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();

	@BeforeTest(alwaysRun = true)
	public void initialize() throws Exception {

		driver = initializeDriver();
		driver.manage().window().maximize();
		fromMiddleReg(
				"https://sit-maine.cs32.force.com/benefits/s/application-summary?applicationId=a0hr00000001wSjAAI&mode=intake");

	}
	
	
	
	  
	  @Test(priority = 1, groups = "Regression") 
	  public void setAsset() throws Exception {

		  System.out.println("starting");
		
	  }
		/*
		 * @DataProvider(name = "Datapro") public Object[][] testpro() throws Exception
		 * {
		 * 
		 * return new Object[][] { { "TC7" } }; }
		 */
	 
		 
}
