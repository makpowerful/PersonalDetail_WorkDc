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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AuthRepPO;
import pageObjects.ClearPickListDataPO;
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
import pageObjects.MD_ExpenseInfo_MedicalExpPO;
import pageObjects.MD_HealthInfo_BlindPO;
import pageObjects.MD_HealthInfo_LTCPO;
import pageObjects.MD_HealthInfo_MediCovPO;
import pageObjects.MD_HealthInfo_PregnancyPO;
import pageObjects.MD_IncSubInfoPO;
import pageObjects.MD_IncSubInfo_BenefitsAnoStatePO;
import pageObjects.MD_IndInfo_AIANPO;
import pageObjects.MD_IndInfo_EducationPO;
import pageObjects.MD_IndInfo_FFCPO;
import pageObjects.MD_IndInfo_NotUSCitiznPO;
import pageObjects.MD_OtherInfo_ConvictionPO;
import pageObjects.MD_OtherInfo_LAPO;
import pageObjects.MD_OtherInfo_MSFWPO;
import pageObjects.SignSubmitPO;

public class Rough2 extends base {

	public static Properties prop;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Rough2.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();

	@BeforeTest(alwaysRun = true)
	public void initialize() throws Exception {

		driver = initializeDriver();
		driver.manage().window().maximize();
		//fromMiddleReg("https://sit-maine.cs32.force.com/benefits/s/household-summary?applicationId=a0hr00000002ISHAA2&mode=Intake&sectionId=SSP_APP_HHMembersSummary&incompleteSections=REPS_Home%2CRelationships%2CHousehold_Information%2CMember_Details%2CHealthcare_Coverage%2CSign_and_Submit");
		fromMiddleReg("https://sit-maine.cs32.force.com/benefits/s/application-summary?applicationId=a0hr0000002EmHKAA0&sectionId=Household_Information&incompleteSections=Household_Information%2CMember_Details%2CHealthcare_Coverage%2CSign_and_Submit&mode=Intake");
	}
	
	
	/*
	 * @Test public void testClass() throws Exception { wait(4);
	 * HHInformation_HHCircumPO hhc = new HHInformation_HHCircumPO(driver); al =
	 * excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
	 * hhc.ClickHHFelonywithMem(al.get(1)); hhc.ClickHHFedralwithMem(al.get(3));
	 * hhc.ClickWrongSNAPTANFwithMem(al.get(5));
	 * hhc.ClickPrgViolatnwithMem(al.get(7));
	 * hhc.ClickMigorSFWwithMem(al.get(9),al.get(11));
	 * hhc.ClickEnrollSchlwithMem(al.get(12)); hhc.ClickFC18withMem(al.get(14));
	 * hhc.ClickSNAPEandTwithMem(al.get(16)); hhc.ClickNext(); wait(1);
	 * Assert.assertTrue(hhc.AssertM().contains("Assets")); }
	 */
	

	/*
	 * @DataProvider(name = "Datapro") public Object[][] testpro() throws Exception
	 * {
	 * 
	 * return new Object[][] { { "TC1" } }; }
	 */

}
