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

import pageObjects.HHInformation_AssetPO;
import pageObjects.HHInformation_HHCircumPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.HHInformation_OAssetPO;
import pageObjects.LoginScreenPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_OAssetScreen extends base {

	public static Logger log = LogManager.getLogger(test_HHInfo_OAssetScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	 
	@Test(groups={"sanity"})
	public void validateHHinfoOAssets() throws IOException, InterruptedException {


		// Adding HH information details to the Application
		log.info("Adding Other Asset Selection details");
		HHInformation_OAssetPO hhoa = new HHInformation_OAssetPO(driver);
		hhoa.Click_TrustFund_Y();
		Thread.sleep(1000);
		hhoa.Click_TrustFund_HHM1();
		Thread.sleep(1000);
		hhoa.Click_Annuity_N();
		Thread.sleep(1000);
		hhoa.Click_LifeEstate_N();
		Thread.sleep(1000);
		hhoa.Click_PromiNote_LandContrct_N();
		Thread.sleep(1000);
		hhoa.Click_BurialF_N();
		Thread.sleep(1000);
		hhoa.ClickNext();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.getTitle(), "Household Information");
		log.info("Other Asset Selection details have been added successfully");

	}
	
	@Test(groups="SNAP", enabled = false)
	public void otherAssetSelection() throws IOException, InterruptedException {
	
		System.out.println("Other Asset Screen Does not line up for SNAP only");
		//need to skip this test
	
	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void testClass(String TCid) throws Exception {
				 
		// Adding HH information details to the Application
		log.info("Adding Other Asset Selection details");
		HHInformation_OAssetPO hhoa = new HHInformation_OAssetPO(driver);
		al = excelData.getData(TCid, "Reg-HI-OAssets", "Sno");
		hhoa.ClickHHTrustFwithMem(al.get(1));
		hhoa.ClickHHAnnuitywithMem(al.get(3));
		hhoa.ClickHHLifeEswithMem(al.get(5));
		hhoa.ClickHHPnotewithMem(al.get(7));
		hhoa.ClickHHfundplotwithMem(al.get(9));
		hhoa.ClickNext();
		Assert.assertTrue(hhoa.AssertM().contains("Income & Subsidies Selection"));
		log.info("Asset Selection details have been added successfully");
	}
	
}
