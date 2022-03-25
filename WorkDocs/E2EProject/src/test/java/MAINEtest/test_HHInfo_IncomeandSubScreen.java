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
import pageObjects.HHInformation_IncomeandSubPO;
import pageObjects.LoginScreenPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_IncomeandSubScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HHInfo_IncomeandSubScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	 
	@Test(groups={"sanity", "TANF", "SNAP"})
	public void validateHHinfoIncomeandSubsidies() throws IOException, InterruptedException {

		
	

		// Adding HH information details to the Application
		log.info("Adding Income and subsidies details");
		HHInformation_IncomeandSubPO hhis = new HHInformation_IncomeandSubPO(driver);
		hhis.Click_Jobin3Mnths_Y();
		Thread.sleep(1000);
		hhis.Click_Jobin3Mnths_HHM1();
		Thread.sleep(1000);
		hhis.Click_JobonStrike_N();
		Thread.sleep(1000);
		hhis.Click_WH60days_N();
		Thread.sleep(1000);
		hhis.Click_SelfEInc_N();
		Thread.sleep(1000);
		hhis.Click_SSI_VA_N();
		Thread.sleep(1000);
		hhis.Click_Retire_Pension_N();
		Thread.sleep(1000);
		hhis.Click_MaintIncome_Alimny_N();
		Thread.sleep(1000);
		hhis.Click_WorkerCompen_N();
		Thread.sleep(1000);
		hhis.Click_Divid_Interest_N();
		Thread.sleep(1000);
		hhis.Click_Goods_Service_N();
		Thread.sleep(1000);
		hhis.Click_HA_FA_CA_N();
		Thread.sleep(1000);
		hhis.Click_HEAP_N();
		Thread.sleep(1000);
		hhis.ClickNext();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.getTitle(), "Household Information");
		log.info("Income and subsidies details have been added successfully");

	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateHHinfoIncandSub(String TCid) throws Exception {
		
		// Adding HH information details to the Application
		log.info("Adding Income and subsidies details");
		HHInformation_IncomeandSubPO hhis = new HHInformation_IncomeandSubPO(driver);
		al = excelData.getData(TCid, "Reg-HI-Incme&sub", "Sno");
		hhis.ClickHH3MontswithMem(al.get(1), al.get(3), al.get(5));
		hhis.ClickHHSelfIncwithMem(al.get(7));
		hhis.ClickHHSSIwithMem(al.get(9));
		hhis.ClickHHAnnuorTrustwithMem(al.get(11));
		hhis.ClickHHRoyalwithMem(al.get(13));
		hhis.ClickHHMaintIncwithMem(al.get(15));
		hhis.ClickHHWorkerCwithMem(al.get(17));
		hhis.ClickHHGSPwithMem(al.get(19));
		hhis.ClickHHMSTwithMem(al.get(21));
		hhis.ClickHH12monthswithMem(al.get(23));
		hhis.ClickNext();
		wait(1);
		Assert.assertTrue(hhis.AssertM().contains("Expenses"));
		log.info("Income and subsidies details have been added successfully");
	}
}
