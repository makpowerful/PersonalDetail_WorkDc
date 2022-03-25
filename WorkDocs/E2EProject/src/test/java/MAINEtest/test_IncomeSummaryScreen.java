package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.MD_IncSubInfoPO;
import resources.ExcelData;
import resources.base;

public class test_IncomeSummaryScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_MemDetailsScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	@Test(priority = 1, groups = { "sanity", "SNAP" })
	public void validateIncomeSummary() throws IOException, InterruptedException {
		
		log.info("Adding Member details (Income and subsidies Information) for HHM1");
		MD_IncSubInfoPO is = new MD_IncSubInfoPO(driver);
		is.Click_AcceptIncomePopup();
		Thread.sleep(2000);
		//is.Click_IncSub_Start();
		Thread.sleep(3000);
		is.Select_TypeofJob();
		Thread.sleep(1000);
		is.Enter_Empl_Name();
		Thread.sleep(1000);
		is.Enter_EmpAddr();
		Thread.sleep(1000);
		is.Enter_EmpAddrL2();
		Thread.sleep(1000);
		is.Enter_PriPN();
		Thread.sleep(1000);
		is.Enter_IncomeSourceDate();
		Thread.sleep(1000);
		is.Select_IncFreq();
		Thread.sleep(1000);
		is.Enter_GrossTaxAverage();
		Thread.sleep(1000);
		is.Enter_HrsWorked();
		Thread.sleep(1000);
		is.Click_IncSource_Y();
		Thread.sleep(1000);
		is.ClickSave();
		Thread.sleep(3000);
		is.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Member Expense Info");
		log.info("Member details (Income and subsidies Information) for HHM1 have been added successfully");
	}
	
	@Test(dataProvider="Datapro",groups = "Regression")
	public void testClass(String TCid) throws Exception {
		
		al = excelData.getData(TCid, "Test", "Sno");
		MD_IncSubInfoPO infopo=new MD_IncSubInfoPO(driver);
		infopo.AllIncomeSummary_Reg(TCid);
	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}
}
