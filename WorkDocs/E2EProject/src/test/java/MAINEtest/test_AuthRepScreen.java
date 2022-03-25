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
import pageObjects.ClearPickListDataPO;
import pageObjects.ContactPO;
import pageObjects.LoginScreenPO;
import pageObjects.ProgSelectionPO;
import resources.ExcelData;
import resources.base;

public class test_AuthRepScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_AuthRepScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	@Test(groups={"sanity", "SNAP","TANF"})

	public void validateAuthRepcreation() throws IOException, InterruptedException {

		// Adding Auth Rep details to the Application
		AuthRepPO ar = new AuthRepPO(driver);
		ar.ClickAuthRepTile();
		log.info("Adding Auth Rep Details to Application");
		Thread.sleep(5000);
		Scrollpagedown();
		ar.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Auth Rep Details have been added successfully");

	}
	
	@Test(dataProvider="Datapro",groups="Regression")
	public void validateAuthRepdetails(String TCid) throws Exception {

		
		AuthRepPO ar = new AuthRepPO(driver);
		log.info("Adding Auth Rep details");
		ar.ClickAuthRepTile();
		Thread.sleep(5000);
		log.info("Adding Auth Rep Details to Application");
		Thread.sleep(5000);
		al = excelData.getData(TCid, "Reg-AuthRep", "Sno");
		System.out.println(al.toString());
		ar.ClickAddAuthRep();
		wait(5);
		ar.AuthRep_EnterFN(al.get(1).toString());
		ar.AuthRep_EnterMN(al.get(2).toString());
		ar.AuthRep_EnterLN(al.get(3).toString());
		ar.SelectSuffix(al.get(4).toString());
		ar.AuthRep_EnterEmail(al.get(5).toString());
		ar.AuthRep_EnterPhoneN(al.get(6).toString());
		ar.AuthRep_EnterPhoneNext(al.get(7).toString());
		ar.Select_Togle_provides_you_assistance(al.get(8).toString());
		ar.AuthRep_EnterOrgName(al.get(9).toString());
		ar.AuthRep_EnterOrgId(al.get(10).toString());
		ar.ClickNext();
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearAuthorizedRepresentative();
		Assert.assertTrue(ar.AuthRep_H_Permsn().contains("Add Authorized Representative"));
		log.info("Initial Auth Rep details added successfully");
		log.info("Adding Auth Rep permission details");
		
		ar.SelectPer_Relatn(al.get(11).toString());
		ar.EnterAddr(al.get(12).toString());
		ar.EnterAddrL2(al.get(13).toString());
		ar.AuthRep_Permsns();
		ar.ClickNext();
		Assert.assertTrue(ar.AuthRepConsent_H_Permsn().contains("Authorized Representative Consent"));
		log.info("Auth Rep permission details added successfully");
		log.info("Adding Auth Rep consent details");
		
		ar.AuthRepConsent_Pri_EnterFN(al.get(16).toString());
		ar.AuthRepConsent_Pri_EnterMN(al.get(17).toString());
		ar.AuthRepConsent_Pri_EnterLN(al.get(18).toString());
		ar.SelectSuffix_Pri(al.get(19).toString());
		ar.AuthRepConsent_EnterFN(al.get(1).toString());
		ar.AuthRepConsent_EnterMN(al.get(2).toString());
		ar.AuthRepConsent_EnterLN(al.get(3).toString());
		ar.SelectSuffixConsent(al.get(4).toString());
		ar.ClickSubmitAR();
		Assert.assertEquals(driver.getTitle(), "AuthRepsAssisters Home");
		log.info("Auth Rep Details have been added successfully");
		ar.ClickNext2();
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		
	}
	
	@DataProvider(name="Datapro")
	public Object[][] testpro() throws Exception{
		
		return new Object[][] { { "TC1" } };
	}

}
