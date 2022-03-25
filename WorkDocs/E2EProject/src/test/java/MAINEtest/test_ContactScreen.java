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

import pageObjects.ContactPO;
import pageObjects.LoginScreenPO;
import pageObjects.ProgSelectionPO;
import resources.ExcelData;
import resources.base;

public class test_ContactScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_ContactScreen.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();

	@Test(groups = { "sanity", "TANF", "SNAP" })
	public void validateContactSelection() throws Exception {

		// Adding Contact details to members
		ContactPO cs = new ContactPO(driver);

		cs.ClickStartHHM1();
		Thread.sleep(3000);
		log.info("Adding Contact details for HHM1");
		Thread.sleep(10000);
		cs.ClickEmailRdbtn();
		Thread.sleep(1000);
		cs.ClickNext();
		Thread.sleep(3500);
		cs.ClickSameAddYes();
		cs.ClickNext();
		Thread.sleep(5000);
		log.info("Contact details successfully added for HHM1");
		log.info("Adding Contact details for HHM2");
		cs.ClickStartHHM2();
		Thread.sleep(5000);
		cs.ClickSameAsPriChk("Yes");
		cs.SelectPrefLangHHM2();
		Thread.sleep(1000);
		cs.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Contact Details have been added successfully for all members");

	}

	

	@Test(groups = { "Regression" }, priority = 1)
	public void validateprimaryContactInformation() throws Exception {
		ContactPO cs = new ContactPO(driver);
		
		  cs.ClickStartHHM1(); log.info("Adding Contact details for HHM1");
		  Thread.sleep(1000); cs.setContactDetailsPrimaryIndv();
		 
		// cs.setAddressInformationPrimaryIndv();
		cs.setPhysicalAddress_Reg("TC1");
		al = excelData.getData("TC1", "R_AddressInformation", "Sno");
		cs.setSameAddressToggle(al.get(9).toString()); // same address toggle question
		cs.ClickNext();

	}

	@Test(groups = { "Regression" }, dataProvider = "TestCaseID", priority = 2)
	public void secondaryContactInformation(String TCid) throws Exception {
		ContactPO cs = new ContactPO(driver);
		al2 = excelData.getData(TCid, "R_ContactInformation", "Sno");
		System.out.println(al2.toString());
		cs.clickStartButton();
		log.info("Adding Contact details for Household Members");
		Thread.sleep(8000);
		if (cs.getContactInfo().length() != 0) {
			cs.setSameContactInfoCheckBox(al2.get(12).toString());
			cs.setPrimaryPhoneType_picklist(al2.get(3).toString());
			cs.setPrimaryPhoneNumber_input(al2.get(4).toString());
			cs.setSecondaryPhoneType_picklist(al2.get(6).toString(), TCid);
			cs.setSecondaryPhoneNumber_input(al2.get(7).toString(), TCid);
			cs.setPreferredContactToggle(al2.get(9).toString());
			cs.setPreferredContactMethod(al2.get(10).toString());
			cs.setPreferredLanguagePicklist(al2.get(11).toString());
			cs.ClickNext();
			Thread.sleep(1000);
			al = excelData.getData(TCid, "R_AddressInformation", "Sno");
			System.out.println(al.toString());
			String checkSameaddress = al.get(9).toString();
			if (checkSameaddress.equalsIgnoreCase("Yes")) {
				cs.setSameAddressInfo(al.get(9).toString());
			} else {
				
				cs.setPhysicalAddress_Reg(TCid);
			}
			cs.ClickNext();
		} else {
			log.info("Contact Information screen did not queue");
			al = excelData.getData(TCid, "R_AddressInformation", "Sno");
			System.out.println(al.toString());
			String checkSameaddress = al.get(9).toString();
			if (checkSameaddress.equalsIgnoreCase("Yes")) {
				cs.setSameAddressInfo(al.get(9).toString());
			} else {
				
				cs.setPhysicalAddress_Reg(TCid);
			}
			cs.ClickNext();
		}
	}

	@DataProvider(name = "TestCaseID")
	public Object[][] dpMethod() {
		return new Object[][] { { "TC2" }, { "TC3" }, { "TC4" }, { "TC5" }, { "TC6" }, { "TC7" } };
	}
}
