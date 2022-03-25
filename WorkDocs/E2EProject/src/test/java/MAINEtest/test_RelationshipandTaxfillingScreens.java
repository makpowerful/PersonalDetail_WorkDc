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
import pageObjects.RelationshipandTaxfillingPO;
import resources.ExcelData;
import resources.base;

public class test_RelationshipandTaxfillingScreens extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_RelationshipandTaxfillingScreens.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	@Test(groups = { "sanity" })
	public void validateRelationandTaxfilingentries() throws IOException, InterruptedException {
		// Adding Relationship details to the Application
		RelationshipandTaxfillingPO rt = new RelationshipandTaxfillingPO(driver);
		log.info("Adding Relationship details to HHM1");
		rt.ClickStartHHM1();
		Thread.sleep(10000);
		Scrollpagedown();
		rt.SelectRelatnHHM1toHHM3();
		rt.SelectYLegalGaurdn();
		rt.SelectYPriCartaker();
		rt.SelectYMaintnHome();
		Scrollpagedown();
		rt.SelectRelatnHHM1toHHM2();
		rt.ClickNext();
		Thread.sleep(7000);
		Scrollpagedown();
		rt.SelectMarriedFilngtaxHHM1();
		rt.SelectPriCaretaxHHM1();
		rt.SelectDependOntaxHHM1();
		rt.ClickNext();
		Thread.sleep(5000);
		// Scrollpagedown();
		ScrollpagedownAxis(200);
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM1 details have been added successfully");

		log.info("Adding Relationship details to HHM2");
		rt.ClickStartHHM2();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.SelectRelatnHHM2toHHM3();
		rt.SelectNLegalGaurdn();
		rt.SelectNPriCartaker();
		rt.SelectNMaintnHome();
		rt.ClickNext();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM2 details have been added successfully");

		log.info("Adding Relationship details to HHM3");
		rt.ClickStartHHM3();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM3 details have been added successfully");

	}

	@Test(groups = { "TANF" })
	public void validateRelationandTaxfilingentriesTanf() throws IOException, InterruptedException {

		// Adding Relationship details to the Application
		RelationshipandTaxfillingPO rt = new RelationshipandTaxfillingPO(driver);
		log.info("Adding Relationship details to HHM1");
		rt.ClickStartHHM1();
		Thread.sleep(10000);
		Scrollpagedown();
		rt.SelectRelatnHHM1toHHM3();
		rt.SelectYLegalGaurdn();
		rt.SelectYPriCartaker();
		rt.SelectYMaintnHome();
		Scrollpagedown();
		rt.SelectRelatnHHM1toHHM2();
		rt.ClickNext();
		Thread.sleep(7000);
		Scrollpagedown();
		rt.SelectMarriedFilngtaxHHM1();
		rt.SelectPriCaretaxHHM1();
		rt.SelectDependOntaxHHM1();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM1 details have been added successfully");

		log.info("Adding Relationship details to HHM2");
		rt.ClickStartHHM2();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.SelectRelatnHHM2toHHM3();
		rt.SelectNLegalGaurdn();
		rt.SelectNPriCartaker();
		rt.SelectNMaintnHome();
		rt.ClickNext();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM2 details have been added successfully");

		log.info("Adding Relationship details to HHM3");
		rt.ClickStartHHM3();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM3 details have been added successfully");
	}

	@Test(groups = "SNAP")
	public void relationandTaxfilingentries() throws IOException, InterruptedException {
		RelationshipandTaxfillingPO rt = new RelationshipandTaxfillingPO(driver);
		log.info("Adding Relationship details to HHM1");
		rt.ClickStartHHM1();
		Thread.sleep(10000);
		Scrollpagedown();
		rt.SelectRelatnHHM1toHHM3();
		rt.SelectRelatnHHM1toHHM2();
		rt.ClickNext();
		Scrollpagedown();
		// Scrolldown();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM1 details have been added successfully");

		log.info("Adding Relationship details to HHM2");
		rt.ClickStartHHM2();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.SelectRelatnHHM2toHHM3();
		rt.ClickNext();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM2 details have been added successfully");

		log.info("Adding Relationship details to HHM3");
		rt.ClickStartHHM3();
		Thread.sleep(5000);
		Scrollpagedown();
		rt.ClickNext();
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("HHM3 details have been added successfully");

	}

	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {
		Object[][] data = readData(System.getProperty("user.dir") + "\\src\\main\\java\\testData\\TestData.xlsx",
				"Reg-Relationship");
		return data;
	}

	@Test(priority = 0, groups = "Regression")
	public void validateInitialRelationshipandTax() throws InterruptedException {
		RelationshipandTaxfillingPO rt = new RelationshipandTaxfillingPO(driver);
		log.info("Adding Relationship details to HHM1");
		rt.ClickStartHHMAll();

	}

	@Test(dataProvider = "Datapro", priority = 1, groups = "Regression")
	public void validateRelationshipandTax(String HHname, String I2, String I3, String I4, String I5, String I6, String I7,String I8,String I9)
			throws Exception {
		wait(1);
		RelationshipandTaxfillingPO rt = new RelationshipandTaxfillingPO(driver);
		//al = excelData.getData(HHname, "Reg-AuthRep", "HH member with");
		rt.EnterHHMRelationship(HHname);

	}
}
