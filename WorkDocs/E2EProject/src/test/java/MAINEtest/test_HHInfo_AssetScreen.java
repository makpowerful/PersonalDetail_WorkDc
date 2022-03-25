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
import pageObjects.LoginScreenPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_AssetScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HHInfo_AssetScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	 
	@Test(groups={"sanity","TANF","SNAP"})
	public void validateHHinfoHHAssetSelection() throws IOException, InterruptedException {


		// Adding HH information details to the Application
		log.info("Adding Asset Selection details");
		HHInformation_AssetPO hha = new HHInformation_AssetPO(driver);
		hha.Click_CA_SA_IDA_Y();
		Thread.sleep(1000);
		hha.Click_CA_SA_IDA_HHM1();
		Thread.sleep(800);
		hha.Click_StocksOrBonds_N();
		Thread.sleep(1000);
		hha.Click_Liquid_N();
		Thread.sleep(1000);
		hha.Click_Vehicle_N();
		Thread.sleep(1000);
		hha.Click_RealEstate_N();
		Thread.sleep(1000);
		hha.Click_LifeInsurance_N();
		Thread.sleep(1000);
		hha.ClickNext();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.getTitle(), "Household Information");
		log.info("Asset Selection details have been added successfully");

	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateHHinfoAssets(String TCid) throws Exception {
		
		// Adding HH information details to the Application
		log.info("Adding Asset Selection details");
		HHInformation_AssetPO hha = new HHInformation_AssetPO(driver);
		al = excelData.getData(TCid, "Reg-HI-Assets", "Sno");
		hha.ClickHHCA_SAwithMem(al.get(1));
		hha.ClickHHStckorBndwithMem(al.get(3));
		hha.ClickHHLiqwithMem(al.get(5));
		hha.ClickHHVehiclewithMem(al.get(7));
		hha.ClickReakEstatwithMem(al.get(9));
		hha.ClickLifeInswithMem(al.get(11));
		hha.ClickNext();
		Assert.assertTrue(hha.AssertM().contains("Other Assets"));
		log.info("Asset Selection details have been added successfully");
		
	}
}
