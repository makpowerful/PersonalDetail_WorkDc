package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AuthRepPO;
import pageObjects.ContactPO;
import pageObjects.HHMemberPO;
import pageObjects.LoginScreenPO;
import pageObjects.ProgSelectionPO;
import pageObjects.RelationshipandTaxfillingPO;
import resources.ExcelData;
import resources.base;

public class test_AddingHHMembers extends base {

	public static Logger log = LogManager.getLogger(test_AddingHHMembers.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	HHMemberPO hhmem;

	@Test(priority = 1, groups = {"sanity", "TANF", "SNAP", "Regression" })
	public void clickStartHM() throws Exception {

		hhmem = new HHMemberPO(driver);
		hhmem.ClickStartHHM();
		hhmem.ClickStartHHM1();
	}
	
	@Test(priority = 2, dataProvider="Member Details for Sanity", groups = {"sanity", "TANF", "SNAP"})
	public void validateAddingHHmembers(String TCid) throws Exception {

		hhmem = new HHMemberPO(driver);
		log.info("Adding HH Member details for HH member1");
		al = excelData.getData(TCid, "HHMemDetails", "Sno");
		System.out.println(al.toString());
		hhmem.EnterFN(al.get(1).toString());
		hhmem.EnterMN(al.get(2).toString());
		hhmem.EnterLN(al.get(3).toString());
		hhmem.Suffix(al.get(4).toString());
		//Scrollpagedown();
		hhmem.SelectGender(al.get(5).toString());
		hhmem.EnterDob(al.get(6).toString());
		hhmem.Has_SSN(al.get(7).toString(), al.get(8).toString(), al.get(9).toString());
		Scrollpagedown();
		hhmem.Select_US_Citizen(al.get(10).toString());
		hhmem.Select_US_Miltary(al.get(11).toString());
		hhmem.Select_Resid_Maine(al.get(12).toString());
		hhmem.Select_Race(al.get(13).toString());
		//Scrollpagedown();
		hhmem.Select_HispLatino(al.get(14).toString());
		hhmem.Select_MaritalStatus(al.get(15).toString());
		//Scrollpagedown();
		hhmem.Select_PassedAway_chk(al.get(16).toString());
		hhmem.Enter_DOD(al.get(17).toString());
		hhmem.Select_Prg_MainCareCubCare();
		hhmem.Select_Prg_TANF();
		hhmem.Select_SubPrg(al.get(18).toString());
		//Scrollpagedown();
		hhmem.ClickSave();
		hhmem.ClickContinueAny();
		Assert.assertEquals(driver.getTitle(), "Household Summary");
		log.info("HHM1 Details have been added successfully");
		System.out.println("household member added");
		hhmem.ClickAddHHMem();
		Thread.sleep(1200);
	}
	
	@Test(priority = 2, dataProvider="Member Details for Regression", groups = {"Regression"})
	public void validateAddingHHmembersForRegression(String TCid) throws Exception {

		hhmem = new HHMemberPO(driver);
		log.info("Adding HH Member details for HH member1");
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		
		hhmem.EnterFN(al.get(1).toString());
		hhmem.EnterMN(al.get(2).toString());
		hhmem.EnterLN(al.get(3).toString());
		hhmem.Suffix(al.get(4).toString());
		Scrollpagedown();
		hhmem.SelectGender(al.get(5).toString());
		hhmem.EnterDob(al.get(6).toString());
		hhmem.Has_SSN(al.get(7).toString(), al.get(8).toString(), al.get(9).toString());
		Scrollpagedown();
		hhmem.Select_US_Citizen(al.get(10).toString());
		hhmem.Select_US_Miltary(al.get(11).toString());
		hhmem.Select_Resid_Maine(al.get(12).toString());
		hhmem.Select_Race(al.get(13).toString());
		Scrollpagedown();
		hhmem.Select_HispLatino(al.get(14).toString());
		hhmem.Select_MaritalStatus(al.get(15).toString());
		Scrollpagedown();
		hhmem.Select_PassedAway_chkReg(al.get(16).toString(),al.get(17).toString());
		System.out.println("Value going in: "+TCid);
		hhmem.ProgramSelectionReg(TCid);
		Scrollpagedown();
		hhmem.ClickSave();
		hhmem.ClickContinueAny();
		Assert.assertEquals(driver.getTitle(), "Household Summary");
		log.info("HHM Details have been added successfully");
		System.out.println("household member added");
		hhmem.ClickAddHHMem();
		Thread.sleep(1200);
	}
	
	@Test(priority = 3, groups = {"sanity", "TANF", "SNAP", "Regression" })
	public void clickNextOnHMS() throws Exception {
		hhmem = new HHMemberPO(driver);
		Scrollpagedown();
		hhmem.ClickCancel();
		Scrollpagedown();
		hhmem.ClickNext();
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("All HH Member Details have been added successfully");
	}
	
	@DataProvider(name = "Member Details for Sanity")
	public Object[][] dpMethod() {
		return new Object[][] { { "TC1" }, { "TC2" }, { "TC3" } };
	}
	
	
	  @DataProvider(name = "Member Details for Regression") public Object[][]
	  dpMethod2() { return new Object[][] { { "TC1" }, { "TC2" }, { "TC3" }, {
	  "TC4" }, { "TC5" }, { "TC6" }, { "TC7" } }; }
	 

}
