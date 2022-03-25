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
import pageObjects.HHInformation_ExpensePO;
import pageObjects.HHInformation_HHCircumPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.HHInformation_IncomeandSubPO;
import pageObjects.LoginScreenPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_ExpenseScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HHInfo_ExpenseScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	 
	@Test(groups={"sanity","SNAP"})
	public void validateHHinfoExpense() throws IOException, InterruptedException {


		// Adding HH information details to the Application
		log.info("Adding Expense Selection details");
		HHInformation_ExpensePO hhe = new HHInformation_ExpensePO(driver);
		hhe.Click_Mbin3Mnths_Y();
		Thread.sleep(1000);
		hhe.Click_Mbin3Mnths_HHM1();
		Thread.sleep(1000);
		hhe.Click_ShelterE_Y();
		Thread.sleep(1000);
		hhe.Click_checkmemberShelter_HHM1();
		hhe.Click_UtilityE_N();
		Thread.sleep(1000);
		hhe.Click_TaxDE_N();
		Thread.sleep(1000);
		hhe.Click_Alimony_N();
		Thread.sleep(1000);
		hhe.Click_MedicalE_60above_N();
		Thread.sleep(1000);
		hhe.Click_ChildSupp_N();
		Thread.sleep(1000);
		hhe.Click_ChildC_N();
		Thread.sleep(1000);
		hhe.ClickNext();
		Thread.sleep(6000);
		//Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Expense Selection details have been added successfully");

	}
	@Test(groups={"TANF"})
	public void validateHHinfoExpenseTanf() throws IOException, InterruptedException {


		// Adding HH information details to the Application
		log.info("Adding Expense Selection details");
		HHInformation_ExpensePO hhe = new HHInformation_ExpensePO(driver);
	
		hhe.Click_ShelterE_Y();
		Thread.sleep(1000);
		hhe.Click_checkmemberShelter_HHM1();
		Thread.sleep(1000);
	
		hhe.Click_Alimony_N();
		Thread.sleep(1000);

		hhe.Click_ChildSupp_N();
		Thread.sleep(1000);
		hhe.Click_ChildC_N();
		Thread.sleep(1000);
		hhe.ClickNext();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Expense Selection details have been added successfully");

	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateHHinfoExpenses(String TCid) throws Exception {
		
		// Adding HH information details to the Application
				log.info("Adding Expense Selection details");
				HHInformation_ExpensePO hhe = new HHInformation_ExpensePO(driver);
				al = excelData.getData(TCid, "Reg-HI-Expenses", "Sno");
				hhe.ClickHHLast3monthwithMem(al.get(1));
				hhe.ClickHHSEwithMem(al.get(3));
				hhe.ClickHHUTwithMem(al.get(5));
				hhe.ClickHHtaxDecwithMem(al.get(7));
				hhe.ClickHHPayAwithMem(al.get(9));
				hhe.ClickHHAge60withMem(al.get(11));
				hhe.ClickHHChildSwithMem(al.get(13));
				hhe.ClickHHCCODCwithMem(al.get(15));
				hhe.ClickNext();
				checkPageReady();
				Assert.assertTrue(driver.getTitle().contains("Application Summary"));
				log.info("Income and subsidies details have been added successfully");
				log.info("Added Household Information details successfully");
		
	}
}
