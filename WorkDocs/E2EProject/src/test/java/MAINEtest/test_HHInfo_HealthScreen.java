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

import pageObjects.AuthRepPO;
import pageObjects.ContactPO;
import pageObjects.HHInformation_HealthPO;
import pageObjects.LoginScreenPO;
import pageObjects.ProgSelectionPO;
import pageObjects.RelationshipandTaxfillingPO;
import resources.ExcelData;
import resources.base;

public class test_HHInfo_HealthScreen extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_HHInfo_HealthScreen.class.getName());
	 HHInformation_HealthPO hhHealth= new HHInformation_HealthPO(driver);
		ExcelData excelData = new ExcelData();
		ArrayList<String> al = new ArrayList<String>();
		
	@Test(groups={"sanity","SNAP"})
	public void validateHHinfoHealthSelection() throws IOException, InterruptedException {

			
		//Adding HH information details to the Application
		log.info("Adding Household Information details");
		log.info("Adding Health Selection details");
		HHInformation_HealthPO hpo  =  new HHInformation_HealthPO(driver);
		hpo.ClickStart_HHInfo();
		Thread.sleep(5000);
		hpo.Click_Blind_Y(); // SANITY flow
		//hpo.Click_Blind_N();  // For TANF flow
		Thread.sleep(500);
		hpo.Click_Blind_HHM1();
		hpo.Click_LTC_N();
		Thread.sleep(1000);
		hpo.Click_MediCare_Benfit_N();
		Scrollpagedown();
		hpo.Click_Pregnancy_N();
		Thread.sleep(1000);
		hpo.ClickNext();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.getTitle(),"Household Information");
		log.info("Health Selection details have been added successfully");
		
	}
	@Test(groups={"TANF"})
public void validateHHinfoHealthSelectionTanf() throws IOException, InterruptedException {

	
			
		//Adding HH information details to the Application
		log.info("Adding Household Information details");
		log.info("Adding Health Selection details");
		HHInformation_HealthPO hpo  =  new HHInformation_HealthPO(driver);
		hpo.ClickStart_HHInfo();
		checkPageReady();
		Thread.sleep(2000);
		//hpo.Click_Blind_Y(); // SANITY flow
		hpo.Click_Blind_N();  // For TANF flow
		Thread.sleep(500);
		//hpo.Click_Blind_HHM1();
		hpo.Click_LTC_N();
		Thread.sleep(1000);
		hpo.Click_MediCare_Benfit_N();
		Scrollpagedown();
		hpo.Click_Pregnancy_N();
		Thread.sleep(1000);
		hpo.ClickNext();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(),"Household Information");
		log.info("Health Selection details have been added successfully");
		
	}
	
	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {

		return new Object[][] { { "TC1" } };
	}

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateHHinfoHealth(String TCid) throws Exception {
		// Adding HH information details to the Application
		log.info("Adding Household Information details");
		
		HHInformation_HealthPO hpo = new HHInformation_HealthPO(driver);
		hpo.ClickStart_HHInfo();
		checkPageReady();
		wait(1);
		Assert.assertTrue(hpo.AssertM().contains("Health"));
		log.info("Adding Health Selection details");
		al = excelData.getData(TCid, "Reg-HI-Health", "Sno");
		hpo.ClickBorDwithMem(al.get(1));
		hpo.ClickLTCwithMem(al.get(3));
		hpo.ClickMedAwithMem(al.get(5));
		hpo.ClickPregwithMem(al.get(7));
		hpo.ClickNext();
		Assert.assertTrue(hpo.AssertM().contains("Household Circumstances"));
		log.info("Health Selection details have been added successfully");

	}

}
