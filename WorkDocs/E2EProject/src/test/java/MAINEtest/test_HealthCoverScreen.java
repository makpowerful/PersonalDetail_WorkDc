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
import resources.ExcelData;
import resources.base;

public class test_HealthCoverScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HealthCoverScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	@Test(groups={"sanity"})
	public void validateHeathCoverSelection() throws IOException, InterruptedException {

	

		// Adding HealthCare Coverage Details on the Case
		log.info("Adding Health Coverage details");
		HealthCareCoverPO hcc= new HealthCareCoverPO(driver);
		hcc.ClickHealthCTile_Start();
		Thread.sleep(5000);
		hcc.Click_IsEnrolled_HC_N();
		Thread.sleep(1000);
		hcc.Click_IsNotEnrolled_HC_N();
		Thread.sleep(1000);		
		hcc.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Health Coverage details have been added");

	}
	
	@Test(dataProvider="Datapro",groups="Regression")
	public void validateHealthCovReg(String TCid) throws Exception {
		HealthCareCoverPO hcc= new HealthCareCoverPO(driver);
		hcc.ClickHealthCTile_Start();
		Assert.assertEquals(driver.getTitle(), "Healthcare Coverage");
		log.info("Adding Healthcare Coverage");
		al = excelData.getData(TCid, "Reg-HealthCareCov", "Sno");
		System.out.println(al.toString());
		hcc.Click_EnrollinHC(al.get(1));
		hcc.Click_HC_NotEnrolled(al.get(2));
		hcc.ClickNext();
		hcc.Click_HC_Start();
		Assert.assertEquals(driver.getTitle(), "Enrollment Details");
		log.info("Adding Enrollment Details");
		hcc.Click_EmpOffer_HC(al.get(3));
		hcc.Enter_CompName(al.get(4));
		hcc.EnterAddr(al.get(5));
		hcc.EnterAddrL2(al.get(6));
		hcc.EnterPID(al.get(7));
		hcc.EnterGID(al.get(8));
		hcc.SelectHM_EnrldP(al.get(9));
		hcc.SelectPH(al.get(10));
		hcc.SelectHMEnrolled();
		hcc.ClickSave();
		Assert.assertEquals(driver.getTitle(), "Healthcare Coverage");
		log.info("Added Enrollment Details successfully");
		log.info("Adding Details for Policy Holder");
		hcc.ClickStart_PH();
		hcc.EnterNOE(al.get(16));
		hcc.EnterAddrPH(al.get(17));
		hcc.EnterAddrL2PH(al.get(18));
		hcc.ClickSave();
		//Assert.assertEquals(driver.getTitle(), "Healthcare Coverage");
		log.info("Added Details for Policy Holder successfully");
		log.info("Adding Details for all Covered Individuals");
		hcc.EnterCoveredInd("Ind1");
		hcc.EnterCoveredInd("Ind2");
		hcc.EnterCoveredInd("Ind3");
		log.info("Added Details for all Covered Individuals successfully");
		hcc.ClickNext();
		wait(2);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Added Healthcare Coverage successfully");
	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {
		return new Object[][] {{ "TC1" }};
	}

}
