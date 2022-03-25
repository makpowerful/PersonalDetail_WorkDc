package Prefill;

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

import io.restassured.path.json.JsonPath;
import pageObjects.AuthRepPO;
import pageObjects.ContactPO;
import pageObjects.HHMemberPO;
import pageObjects.LoginScreenPO;
import pageObjects.ProgSelectionPO;
import pageObjects.RelationshipandTaxfillingPO;
import pageObjects.RenewalSummaryPO;
import pageObjects.ValidateHHMDetailsPO;
import resources.ExcelData;
import resources.base;

public class test_HHMembersSummary extends base {

	public static Logger log = LogManager.getLogger(test_HHMembersSummary.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	RenewalSummaryPO rs;
	ValidateHHMDetailsPO vd;
	HHMemberPO hhmem;
	String response = null;
	static int i=0;

	@Test(priority = 1, groups = {"Renewal" })
	public void clickStartHM() throws Exception {
		rs = new RenewalSummaryPO(driver);
		rs.ClickStartHM();
	}
	
	@Test(priority = 2, groups = {"Renewal" })
	public void FetchHM() throws Exception {
		vd = new ValidateHHMDetailsPO();
		log.info("Fetching HHM details");
		al = excelData.getData("TC1_HH", "Renewal-HHMemberDetails", "Sno");
		String IndvidualId= al.get(1).toString();
		this.response=vd.validateHOHDetails(IndvidualId);
	}
	
	@Test(priority = 3, dataProvider="Member Details for Renewal", groups = {"Renewal" })
	public void validateHM(String TCid) throws Exception {
		al = excelData.getData(TCid, "Renewal-HHMemberDetails", "Sno");
		JsonPath js = new JsonPath(this.response);
		String jsonIndex=al.get(21).toString();
		
		//Validate Firstname
		String Firstname=js.getString("Payload.SSP_Member__c["+jsonIndex+"].FirstName__c");
		String FN =al.get(2).toString();
		Assert.assertEquals(Firstname, FN);
		
		//Validate MiddleName
		String MiddleInt=js.getString("Payload.SSP_Member__c["+jsonIndex+"].MiddleInitial__c");
		String MN =al.get(3).toString();
		if(!MN.equals("null"))
			Assert.assertEquals(MiddleInt, MN);
		else
			Assert.assertNull(MiddleInt);
		
		//Validate LastName
		String Lastname=js.getString("Payload.SSP_Member__c["+jsonIndex+"].LastName__c");
		String LN =al.get(4).toString();
		Assert.assertEquals(Lastname, LN);
		
		//Validate Suffix
		String Suffix=js.getString("Payload.SSP_Member__c["+jsonIndex+"].SuffixCode__c");
		String Sf =al.get(5).toString();
		if(!Sf.equals("null"))
			Assert.assertEquals(Suffix, Sf);
		else
			Assert.assertNull(Suffix);
		
		//Validate Gender
		String Gender=js.getString("Payload.SSP_Member__c["+jsonIndex+"].GenderCode__c");
		String Gd =al.get(6).toString();
		Assert.assertEquals(Gender, Gd);
		
		//Validate DOB
		String DOB=js.getString("Payload.SSP_Member__c["+jsonIndex+"].BirthDate__c");
		String DB =al.get(7).toString();
		Assert.assertEquals(DOB, DB);
		
		//Validate SSN
		String SSN_Num=js.getString("Payload.SSP_Member__c["+jsonIndex+"].SSN__c");
		String SSN =al.get(9).toString();
		if(!SSN.equals("null"))
			Assert.assertEquals(SSN_Num, SSN);
		else
		{
			String SSN_rsncd=js.getString("Payload.SSP_Member__c["+jsonIndex+"].NoReasonSSNCode__c");
			String SSN_rsn =al.get(10).toString();
			Assert.assertEquals(SSN_rsncd, SSN_rsn);
		}
		
	}
		
	@Test(priority = 4, groups = {"Renewal" })
	public void clickNextOnHMS() throws Exception {
		hhmem = new HHMemberPO(driver);
		Scrollpagedown();
//		hhmem.ClickCancel();
//		Scrollpagedown();
		hhmem.ClickNext();
		Assert.assertEquals(driver.getTitle(), "Renewal Summary");
		log.info("All HH Member Details have been validated successfully");
	}


	  @DataProvider(name = "Member Details for Renewal") public Object[][]
			  dpMethod() { return new Object[][] { { "TC1_HH" }, { "TC1_SM1" }, { "TC1_SM2" } }; }
	 

}
