package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pageObjects.MD_AssetInfoPO;
import pageObjects.MD_AssetTransferInfomationPO;
import pageObjects.MD_ExpenseInfo_MedicalExpPO;
import pageObjects.MD_HealthInfo_BlindPO;
import pageObjects.MD_HealthInfo_LTCPO;
import pageObjects.MD_HealthInfo_MediCovPO;
import pageObjects.MD_HealthInfo_PregnancyPO;
import pageObjects.MD_IncSubInfoPO;
import pageObjects.MD_IncSubInfo_BenefitsAnoStatePO;
import pageObjects.MD_IndInfo_AIANPO;
import pageObjects.MD_IndInfo_AlienNumPO;
import pageObjects.MD_IndInfo_EducationPO;
import pageObjects.MD_IndInfo_FFCPO;
import pageObjects.MD_IndInfo_NotUSCitiznPO;
import pageObjects.MD_OtherInfo_ConvictionPO;
import pageObjects.MD_OtherInfo_LAPO;
import pageObjects.MD_OtherInfo_MSFWPO;
import pageObjects.MD_OutOfHouseholdPO;
import resources.ExcelData;
import resources.base;

public class test_MemDetailsScreen extends base {
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_MemDetailsScreen.class.getName());

	@Test(dataProvider = "Datapro", groups = "Regression")
	public void validateMemdetails(String TCid) throws Exception {

		// Not a US Citizen
		al = excelData.getData(TCid, "Reg-MD-NonUSCtzn", "Sno");
		MD_IndInfo_NotUSCitiznPO mdNUSC = new MD_IndInfo_NotUSCitiznPO(driver);
		mdNUSC.EnterNotUSCitizen(TCid);

		// Alien Number
		al = excelData.getData(TCid, "Reg-MD-NonUSCtzn", "Sno");
		MD_IndInfo_AlienNumPO mdAN = new MD_IndInfo_AlienNumPO(driver);
		mdAN.EnterAlienNum(TCid);

		// Adding Education and Current Education details
		al = excelData.getData(TCid, "Reg-MD-Education", "Sno");
		MD_IndInfo_EducationPO mdEPO = new MD_IndInfo_EducationPO(driver);
		mdEPO.EnterEduandCurrentEduD(TCid);

		// Adding American Indian and Alaskan Native
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		MD_IndInfo_AIANPO mdAIANPO = new MD_IndInfo_AIANPO(driver);
		mdAIANPO.EnterAmerIndorAlsNatv(TCid);

		// Adding Out of Household details
		MD_OutOfHouseholdPO ooh = new MD_OutOfHouseholdPO(driver);
		ooh.Enter_OOHdetails_Reg(TCid);

		// Adding Former Foster Care
		al = excelData.getData(TCid, "Reg-MD-FrmerFosterC", "Sno");
		MD_IndInfo_FFCPO mdFFC = new MD_IndInfo_FFCPO(driver);
		mdFFC.EnterFFC(TCid);

		// Adding Pregnancy details
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		MD_HealthInfo_PregnancyPO mdPPO = new MD_HealthInfo_PregnancyPO(driver);
		mdPPO.EnterPregnancy(TCid);

		// Adding Blind or Disabled
		al = excelData.getData(TCid, "Reg-MD-Disab|blind", "Sno");
		MD_HealthInfo_BlindPO mdBD = new MD_HealthInfo_BlindPO(driver);
		mdBD.EnterDisandBlind(TCid);

		// Adding LTC
		al = excelData.getData(TCid, "Reg-MD-LTC", "Sno");
		MD_HealthInfo_LTCPO mdLTC = new MD_HealthInfo_LTCPO(driver);
		mdLTC.EnterLTC(TCid);

		// Adding Medicare Coverage
		al = excelData.getData(TCid, "Reg-MD-MediCov", "Sno");
		MD_HealthInfo_MediCovPO mdMCov = new MD_HealthInfo_MediCovPO(driver);
		mdMCov.EnterMediCov(TCid);

		// Adding Living Arrangment
		al = excelData.getData(TCid, "Reg-MD-LivingA", "Sno");
		MD_OtherInfo_LAPO mdLAPO = new MD_OtherInfo_LAPO(driver);
		mdLAPO.EnterLivingArr(TCid);

		// Adding Conviction
		al = excelData.getData(TCid, "Reg-MD-Convictn", "Sno");
		MD_OtherInfo_ConvictionPO mdConv = new MD_OtherInfo_ConvictionPO(driver);
		mdConv.EnterConviction(TCid);

		// Adding Migrant or Seasonal Farmworker
		al = excelData.getData("TC1", "Reg-MD-MigrSF", "Sno");
		MD_OtherInfo_MSFWPO mdMSFW = new MD_OtherInfo_MSFWPO(driver);
		mdMSFW.EnterMigrSFW(TCid);

		// Adding Asset Summary
		// Adding Other Asset Summary
		MD_AssetInfoPO asset = new MD_AssetInfoPO(driver);
		System.out.println(driver.getTitle().toString());
		wait(2);
		asset.fillAssetDetails(TCid);
		
		// Adding Income Summary
		al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
		MD_IncSubInfoPO infopo = new MD_IncSubInfoPO(driver);
		infopo.AllIncomeSummary_Reg(TCid);

	
		// Adding Expense Summary

		MD_ExpenseInfo_MedicalExpPO ex = new MD_ExpenseInfo_MedicalExpPO(driver);
		ex.Click_AcceptExpensePopup();
		List<WebElement> elements = driver.findElements(By.xpath("//span/p[1]")); // get all the record elements on
																					// screen
		List<String> types = new ArrayList<String>();
		for (WebElement e : elements) {
			types.add(e.getText());
		}
		Scrolldown();
		if ((types != null) && !types.isEmpty()) {
			for (String type : types) {
				ex.Enter_Expense_Reg(TCid, type);
			}
			Scrollend();
			ex.ClickNext();
		} else {
			Scrollend();
			ex.ClickNext();
			log.info("Expense record is not displayed");
			System.out.println("Expense record is not displayed");
		}

		// Adding Medical Expense 3 months
		MD_ExpenseInfo_MedicalExpPO me = new MD_ExpenseInfo_MedicalExpPO(driver);
		me.Select_MedicalBillMonth_Reg(TCid);

	}

	@Test(priority = 1, groups = { "sanity", "SNAP" })
	public void validateEducation() throws IOException, InterruptedException {

		// Adding Member Details for HHM1
		log.info("Adding Member details (Individual Information) for HHM1");
		MD_IndInfo_EducationPO epo = new MD_IndInfo_EducationPO(driver);
		epo.Click_MI_HHM1();
		Thread.sleep(10500);
		// Scrollpagedown();
		Scrolldown();
		log.info("Adding Highest Level Of Education details for HHM1");
		epo.Click_HLOE_Start();
		Thread.sleep(3000);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select3G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(3000);
		log.info("Highest Level Of Education details have been added");
		log.info("Adding Current Education details for HHM1");
		// Scrollpagedown();
		Scrolldown();
		epo.Click_CE_Start();
		Thread.sleep(3500);
		epo.Click_CE_IT();
		Thread.sleep(1000);
		epo.Click_CE_IT_AE();
		Thread.sleep(1000);
		epo.Click_CE_GL();
		Thread.sleep(1000);
		epo.Click_CE_GL_2G();
		Thread.sleep(1000);
		epo.Enter_CE_EGD();
		Thread.sleep(1000);
		epo.Click_CE_School();
		Thread.sleep(1000);
		epo.Click_CE_SchoolGCC();
		Thread.sleep(1000);
		epo.Click_CE_FT();
		Thread.sleep(1000);
		epo.Click_CE_WSP_N();
		Thread.sleep(1000);
		epo.Click_CE_TAA_N();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(3000);
		Scrollpagedown();
		epo.ClickNext();
		Thread.sleep(4000);
		log.info("Current Education details have been added");
		Assert.assertEquals(driver.getTitle(), "Member Individual Info");
	}

	@Test(priority = 2, groups = { "sanity" })
	public void validateAIAN() throws IOException, InterruptedException {

		MD_IndInfo_AIANPO aian = new MD_IndInfo_AIANPO(driver);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Member Health Info");
		log.info("Member details (Individual Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Health Information) for HHM1");

		MD_HealthInfo_BlindPO bl = new MD_HealthInfo_BlindPO(driver);
		Thread.sleep(2000);
		bl.Click_ESRD_N();
		Thread.sleep(1000);
		bl.ClickNext();
		Thread.sleep(8000);

		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Health Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Other Information) for HHM1");
	}

	@Test(priority = 2, groups = "SNAP")
	public void validateAIANforSNAP() throws IOException, InterruptedException {

		MD_IndInfo_AIANPO aian = new MD_IndInfo_AIANPO(driver);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Individual Information) for HHM1 have been added successfully");
	}

	@Test(priority = 3, groups = { "sanity", "SNAP" })
	public void validateLA() throws IOException, InterruptedException {

		MD_OtherInfo_LAPO la = new MD_OtherInfo_LAPO(driver);
		la.Select_CLA_LIYH();
		la.ClickNext();
		Thread.sleep(4000);
		MD_OtherInfo_MSFWPO msfw = new MD_OtherInfo_MSFWPO(driver);
		msfw.Click_Job30days_N();
		la.ClickNext();
		Thread.sleep(12000);
		Assert.assertEquals(driver.getTitle(), "Member Asset Info");
		log.info("Member details (Other Information) for HHM1 have been added successfully");

	}

	@Test(priority = 4, groups = "sanity")
	public void validateAssetIncomeExpenses() throws IOException, InterruptedException {
		log.info("Adding Member details (Asset Information) for HHM1");

		MD_AssetInfoPO ai = new MD_AssetInfoPO(driver);
		ai.Click_AcceptAssetPopup();
		Thread.sleep(1500);

		ai.Click_Start("Trust");
		Thread.sleep(3000);
		ai.Select_TypeOfTrust("Pooled Disability");
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

		ai.Click_Start("Account");
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

		log.info("Adding Member details (Income and subsidies Information) for HHM1");
		MD_IncSubInfoPO is = new MD_IncSubInfoPO(driver);
		is.Click_AcceptIncomePopup();
		Thread.sleep(2000);
		is.Click_IncSub_Start("Job");
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

		log.info("Adding Member details (Expense Information) for HHM1");
		MD_ExpenseInfo_MedicalExpPO me = new MD_ExpenseInfo_MedicalExpPO(driver);
		me.Click_AcceptExpensePopup();
		Scrolldown();
		me.AddShelterExpense();
		Scrollpagedown();
		me.ClickNext();
		Thread.sleep(1000);
		me.Select_MedicalBillMonth();
		Thread.sleep(1000);
		me.ClickNext();
		//Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Expense Information) for HHM1 have been added successfully");

	}

	@Test(priority = 4, groups = "SNAP")
	public void validateAssetIncomeExpensesforSNAP() throws IOException, InterruptedException {
		MD_AssetInfoPO ai = new MD_AssetInfoPO(driver);
		ai.Click_AcceptAssetPopup();
		Thread.sleep(1500);
		ai.AddAccount();
		ai.ClickNext();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Member Income Info");
		log.info("Member details (Asset Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Income and subsidies Information) for HHM1");
		MD_IncSubInfoPO is = new MD_IncSubInfoPO(driver);
		is.Click_AcceptIncomePopup();
		Thread.sleep(2000);
		Scrolldown();
		is.AddAnyIncome();
		is.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Member Expense Info");
		log.info("Member details (Income and subsidies Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Expense Information) for HHM1");
		MD_ExpenseInfo_MedicalExpPO me = new MD_ExpenseInfo_MedicalExpPO(driver);
		me.Click_AcceptExpensePopup();
		Scrolldown();
		me.AddShelterExpense();
		// Scrolldown();
		Scrollpagedown();
		me.ClickNext();
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Expense Information) for HHM1 have been added successfully");

	}

	@Test(priority = 5, groups = { "sanity", "SNAP" })
	public void addDependentDetails() throws IOException, InterruptedException {
		MD_OtherInfo_LAPO la = new MD_OtherInfo_LAPO(driver);
		MD_IndInfo_EducationPO epo = new MD_IndInfo_EducationPO(driver);
		// Adding Member Details for HHM2
		log.info("Adding Member details (Individual Information) for HHM2");
		epo.Click_MI_HHM2();
		Thread.sleep(5000);
		log.info("Adding Highest Level Of Education details for HHM2");
		epo.Click_HLOE_Start();
		Thread.sleep(3000);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select2G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(2000);
		log.info("Highest Level Of Education details have been added");
		epo.ClickNext();
		MD_IndInfo_AIANPO aian = new MD_IndInfo_AIANPO(driver);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Individual Information) for HHM2 have been added successfully");
		log.info("Adding Member details (Other Information) for HHM2");
		la.Select_CLA_HS();
		Thread.sleep(1000);
		la.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Other Information) for HHM2 have been added successfully");

		// Adding Member Details for HHM3
		log.info("Adding Member details (Individual Information) for HHM3");
		epo.Click_MI_HHM3();
		Thread.sleep(5000);
		log.info("Adding Highest Level Of Education details for HHM3");
		epo.Click_HLOE_Start();
		Thread.sleep(300);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select4G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(2000);
		log.info("Highest Level Of Education details have been added");
		epo.ClickNext();
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		aian.ClickNext();
		// Absent Parent
		boolean flag = epo.checkOutofHousehold();
		if (flag) {

			Thread.sleep(2000);
			/*
			 * Scrollpagedown(); Thread.sleep(2000);
			 */
			epo.startOutOfHousehold();
			Thread.sleep(2000);
			epo.selectDontHaveInformation();
			Thread.sleep(2000);
			epo.clickSaveOutOfHousehold();
			Thread.sleep(3000);
			epo.ClickNext();
		} else {
			log.info("Out of Household Parent screen did not queued");
		}
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Individual Information) for HHM3 have been added successfully");
		log.info("Adding Member details (Other Information) for HHM3");
		la.Select_CLA_HS();
		Thread.sleep(1000);
		la.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Other Information) for HHM3 have been added successfully");

	}

	@Test(groups = { "TANF" })

	public void validateHHinfoExpenseTanf() throws IOException, InterruptedException {

		// Adding Member Details for HHM1
		log.info("Adding Member details (Individual Information) for HHM1");
		MD_IndInfo_EducationPO epo = new MD_IndInfo_EducationPO(driver);
		epo.Click_MI_HHM1();
		Thread.sleep(10500);
		Scrollpagedown();
		log.info("Adding Highest Level Of Education details for HHM1");
		epo.Click_HLOE_Start();
		Thread.sleep(3000);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select3G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(8000);
		log.info("Highest Level Of Education details have been added");
		epo.ClickNext();
		Thread.sleep(4000);
		// log.info("Current Education details have been added");
		Assert.assertEquals(driver.getTitle(), "Member Individual Info");
		MD_IndInfo_AIANPO aian = new MD_IndInfo_AIANPO(driver);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		// log.info("Member details (Health Information) for HHM1 have been added
		// successfully");
		log.info("Adding Member details (Other Information) for HHM1");

		MD_OtherInfo_LAPO la = new MD_OtherInfo_LAPO(driver);
		la.Select_CLA_LIYH();
		la.ClickNext();
		Thread.sleep(4000);
		log.info("Member details (Other Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Asset Information) for HHM1");

		MD_AssetInfoPO ai = new MD_AssetInfoPO(driver);
		ai.Click_AcceptAssetPopup();
		Thread.sleep(1500);
		ai.Click_CA_Start();
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
		// Assert.assertEquals(driver.getTitle(), "Member Income Info");
		log.info("Member details (Asset Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Income and subsidies Information) for HHM1");
		MD_IncSubInfoPO is = new MD_IncSubInfoPO(driver);
		is.Click_AcceptIncomePopup();
		Thread.sleep(2000);
		is.Click_IncSub_Start("Job");
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
		// Assert.assertEquals(driver.getTitle(), "Member Expense Info");
		log.info("Member details (Income and subsidies Information) for HHM1 have been added successfully");
		log.info("Adding Member details (Expense Information) for HHM1");
		MD_ExpenseInfo_MedicalExpPO me = new MD_ExpenseInfo_MedicalExpPO(driver);
		// Adding Shelter Expense
		me.acceptPopup();
		Thread.sleep(2000);
		Scrolldown();
		Thread.sleep(1000);
		me.startShelter();
		Thread.sleep(5000);
		// Scrollpagedown();
		me.selectTypeofShelter("Property Tax");
		Thread.sleep(3000);
		me.selectExpenseFrequency("Monthly");
		Thread.sleep(3000);
		me.expenseAmount("20");
		Thread.sleep(2000);
		me.selectFMHAToggle();
		Thread.sleep(3000);
		Scrollpagedown();
		me.ClickSave();
		Thread.sleep(3000);
		me.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Expense Information) for HHM1 have been added successfully");

		// Adding Member Details for HHM2
		log.info("Adding Member details (Individual Information) for HHM2");
		epo.Click_MI_HHM2();
		Thread.sleep(5000);
		log.info("Adding Highest Level Of Education details for HHM2");
		epo.Click_HLOE_Start();
		Thread.sleep(3000);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select2G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(2000);
		log.info("Highest Level Of Education details have been added");
		epo.ClickNext();
		Thread.sleep(7000);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Individual Information) for HHM2 have been added successfully");
		log.info("Adding Member details (Other Information) for HHM2");
		la.Select_CLA_HS();
		Thread.sleep(1000);
		la.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Other Information) for HHM2 have been added successfully");

		// Adding Member Details for HHM3
		log.info("Adding Member details (Individual Information) for HHM3");
		epo.Click_MI_HHM3();
		Thread.sleep(5000);
		log.info("Adding Highest Level Of Education details for HHM3");
		epo.Click_HLOE_Start();
		Thread.sleep(300);
		epo.Click_HLOE_SelectGrade();
		Thread.sleep(1000);
		epo.Click_HLOE_Select4G();
		Thread.sleep(1000);
		epo.ClickSave();
		Thread.sleep(2000);
		log.info("Highest Level Of Education details have been added");
		epo.ClickNext();
		Thread.sleep(7000);
		aian.Click_IsInd_MemOfTribe_Y();
		Thread.sleep(1000);
		aian.Click_TypeOfTribe();
		Thread.sleep(1000);
		aian.Click_EverRecServ();
		Thread.sleep(1000);
		aian.Click_EligRecSer();
		Thread.sleep(1000);
		aian.ClickNext();
		Thread.sleep(7000);
		// Out of Household Parent
		boolean flag = epo.checkOutofHousehold();
		if (flag) {

			Thread.sleep(2000);
			epo.startOutOfHousehold();
			Thread.sleep(2000);
			epo.selectDontHaveInformation();
			Thread.sleep(2000);
			epo.clickSaveOutOfHousehold();
			Thread.sleep(3000);
			epo.ClickNext();
		} else {
			log.info("Out of Household Parent screen did not queued");
		}
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Member Other Information");
		log.info("Member details (Individual Information) for HHM3 have been added successfully");
		log.info("Adding Member details (Other Information) for HHM3");
		la.Select_CLA_HS();
		Thread.sleep(1000);
		la.ClickNext();
		Thread.sleep(7000);
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Other Information) for HHM3 have been added successfully");

	}

	@DataProvider(name = "Datapro")
	public Object[][] testpro() throws Exception {
		// 
		return new Object[][] {{ "TC1" },{ "TC2" },{ "TC3" },{ "TC4" },{ "TC5" }, { "TC6" }, { "TC7" } };
	}
}
