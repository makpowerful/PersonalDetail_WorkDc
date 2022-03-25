package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HHInformation_HHCircumPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.LoginScreenPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_HHCircumScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HHInfo_HHCircumScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	@Test(groups={"sanity","SNAP"})

	public void validateHHinfoHHCircumSelection() throws Exception {


		// Adding HH information details to the Application
		log.info("Adding Household Circumstance Selection details");
		HHInformation_HHCircumPO hhc = new HHInformation_HHCircumPO(driver);
		hhc.Click_Violating_Parole_N();

		Thread.sleep(1000);
	
		hhc.Click_February7_N();
		hhc.Click_SNAPorTANF_Benefit_N();
		hhc.Click_SNAPorTANF_Violation_N();
		hhc.Click_Seasonal_FW_Y();
		Scrollpagedown();
		hhc.Click_Seasonal_FW_HHM1();
		hhc.Click_Rec_lessthan25_FW_N();
		hhc.Click_Enrollin_School_Y();
		hhc.Click_Enrollin_School_HHM1();
		Scrollpagedown();
		hhc.Click_FosterCare_N();
		hhc.Click_SNAP_EmployandTrain_N();

		Thread.sleep(1000);
		hhc.ClickNext();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.getTitle(), "Household Information");
		log.info("Household Circumstance Selection details have been added successfully");

	}
	@Test(groups={"TANF"})
	public void validateHHinfoHHCircumSelectionTanf() throws IOException, InterruptedException {

			// Adding HH information details to the Application
		log.info("Adding Household Circumstance Selection details-- TANF flow");
		HHInformation_HHCircumPO hhc = new HHInformation_HHCircumPO(driver);
		hhc.Click_Violating_Parole_N();
		Thread.sleep(1000);
		
		hhc.Click_SNAPorTANF_Benefit_N();
		Thread.sleep(1000);
		hhc.Click_SNAPorTANF_Violation_N();
		Thread.sleep(1000);
		Scrollpagedown();
		hhc.Click_Enrollin_School_N();
		Thread.sleep(1000);
			Scrollpagedown();
			hhc.ClickNext(); 
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "Household Information");
		log.info("Household Circumstance Selection details have been added successfully");

	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateHHinfoHHCircum(String TCid) throws Exception {
		
		// Adding HH information details to the Application
		log.info("Adding Household Circumstance Selection details");
		HHInformation_HHCircumPO hhc = new HHInformation_HHCircumPO(driver);
		al = excelData.getData(TCid, "Reg-HI-HHCircum", "Sno");
		hhc.ClickHHFelonywithMem(al.get(1));
		hhc.ClickHHFedralwithMem(al.get(3));
		hhc.ClickWrongSNAPTANFwithMem(al.get(5));
		hhc.ClickPrgViolatnwithMem(al.get(7));
		hhc.ClickMigorSFWwithMem(al.get(9),al.get(11));
		hhc.ClickEnrollSchlwithMem(al.get(12));
		hhc.ClickFC18withMem(al.get(14));
		hhc.ClickSNAPEandTwithMem(al.get(16));
		hhc.ClickNext();
		wait(1);
		Assert.assertTrue(hhc.AssertM().contains("Assets"));
		log.info("Household Circumstance Selection details have been added successfully");
	}
}
