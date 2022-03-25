package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.MD_AssetInfoPO;
import pageObjects.MD_AssetTransferInfomationPO;
import resources.base;

public class test_AssetSummaryScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_MemDetailsScreen.class.getName());

	@Test(priority = 1, groups = { "sanity", "SNAP" })
	public void validateAssetSummary() throws IOException, InterruptedException {

		log.info("Adding Member details (Asset Information) for HHM1");

		MD_AssetInfoPO ai = new MD_AssetInfoPO(driver);
		ai.Click_AcceptAssetPopup();
		Thread.sleep(1500);
		// ai.Click_A_Trust_Start();
		Thread.sleep(3000);
		// ai.Select_TypeOfTrust();
		Thread.sleep(1000);
		ai.Enter_Trust_NameofBank();
		Thread.sleep(1000);
		ai.Enter_Trust_Value();
		Thread.sleep(1000);
		ai.Click_Estab_Trust();
		Thread.sleep(1000);
		ai.Enter_DateEstab();
		Thread.sleep(1000);
		ai.Click_RecPay_Trust();
		Thread.sleep(1000);
		ai.ClickSave();
		Thread.sleep(3000);
		// ai.Click_CA_Start();
		Thread.sleep(3000);
		ai.Select_TypeOfAccount();
		Thread.sleep(1000);
		ai.Enter_CA_NameofBank();
		Thread.sleep(1000);
		ai.Enter_CA_Value();
		Thread.sleep(1000);
		ai.Click_CA_AnotherOwner();
		Thread.sleep(1000);
		ai.ClickSave();
		Thread.sleep(3000);
		ai.ClickNext();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Member Income Info");
		log.info("Member details (Asset Information) for HHM1 have been added successfully");
	}

	@Test(dataProvider = "Datapro", priority = 1, groups = "Regression")
	public void setAsset(String TCid) throws Exception {
	
	}

	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

}
