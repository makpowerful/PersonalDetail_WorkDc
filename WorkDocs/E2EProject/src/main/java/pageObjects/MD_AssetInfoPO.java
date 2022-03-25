package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_AssetInfoPO extends base {

	public WebDriver driver;

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By btn_Accept_Popup_xpath = By.xpath("//button[@title = 'Go to Assets Summary']");
	By btn_Start_xpath = By.xpath("//p[contains(text(),'Investment')]//following::button[1]");
	By pcklst_TOT_xpath = By.xpath("//div[2]/c-ssp-base-component-input-picklist/div/select");
	By txt_Trst_NOB_xpath = By.xpath("//input");
	By txt_Trust_Value_xpath = By.xpath("//c-ssp-base-component-input-text-icon/div/div/lightning-input/div/input");
	By rdbtn_ET_xpath = By.xpath("//span[2]");
	By date_ED_xpath = By.xpath("//div/div/input");
	By tglbtn_RecPayTrsut_xpath = By.xpath("//div/div/span/label/span");
	By pcklst_TOA_xpath = By.xpath("//div[2]/c-ssp-base-component-input-picklist/div/select");
	By txt_CA_NOB_xpath = By.xpath("//input");
	By txt_CA_Value_xpath = By.xpath("//c-ssp-base-component-input-text-icon/div/div/lightning-input/div/input");
	By tglbtn_CA_Anthr_Own_xpath = By.xpath("//span[2]/label");
	By btn_A_Trust_Start_xpath = By.xpath("//div[2]/lightning-button/button");
	By btn_A_CA_Start_xpath = By.xpath("//button[contains(text(),'Start')]");

	// Life Insurance fields
	By insuranceCompanyNameInput = By
			.xpath("//*[contains(text(),'Insurance Company Name')]//following-sibling::div/input");
	By policyNumberInput = By.xpath("//*[contains(text(),'Policy number')]//following-sibling::div/input");
	By typeOfInsurancePicklist = By.xpath("//select[@title='Click here to see life insurance types']");
	By faceValueInput = By.xpath("//*[contains(text(),'Life Insurance Face Value ($)')]//following-sibling::div/input");
	By cashSurrenderValue = By
			.xpath("//*[contains(text(),'Life Insurance Cash Surrender Value ($)')]//following-sibling::div/input");
	By anotherOwnerYesToggle = By
			.xpath("//*[contains(text(),'Is there another owner?')]//following::label/span[contains(text(),'Yes')]");
	By anotherOwnerNoToggle = By
			.xpath("//*[contains(text(),'Is there another owner?')]//following::label/span[contains(text(),'No')]");

	// Real Estate Property fields
	By realEstateTypePicklist = By.xpath("//select[@title='Click here to see property types']");
	By realEstateDescTextarea = By.xpath("//textarea");
	By ownerlivePropertyToggleYes = By.xpath(
			"//*[contains(text(),'Does the real estate owner live on the property? Only answer yes if this is their primary residence.')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By ownerlivePropertyToggleNo = By.xpath(
			"//*[contains(text(),'Does the real estate owner live on the property? Only answer yes if this is their primary residence.')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By planToReturnToggleYes = By.xpath(
			"//*[contains(text(),'does the real estate owner plan to return?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By planToReturnToggleNo = By.xpath(
			"//*[contains(text(),'does the real estate owner plan to return?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By fairMarketValueInput = By
			.xpath("//*[contains(text(),'Property Fair Market Value')]//following-sibling::div/input");
	By realEstatePropertySaleToggleYes = By.xpath(
			"//*[contains(text(),'Is the real estate property for sale?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By realEstatePropertySaleToggleNo = By.xpath(
			"//*[contains(text(),'Is the real estate property for sale?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By loanAmountOwnedInput = By
			.xpath("//*[contains(text(),'Current Loan Amount Owed ($)')]//following-sibling::div/input");

	// Vehicle fields
	By typeOfVehiclePicklist = By.xpath("//select[@title='Click here to see vehicle type options']");
	By makeInput = By.xpath("//*[contains(text(),'Make')]//following-sibling::div/input");
	By modelInput = By.xpath("//*[contains(text(),'Model')]//following-sibling::div/input");
	By yearInput = By.xpath("//*[contains(text(),'Year')]//following-sibling::div/input");
	By mileageInput = By.xpath("//*[contains(text(),'Mileage')]//following-sibling::div/input");
	By commuteToggleYes = By.xpath(
			"//*[contains(text(),'Is this vehicle used to commute to school or work?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By commuteToggleNo = By.xpath(
			"//*[contains(text(),'Is this vehicle used to commute to school or work?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By vehicleRegisteredToggleYes = By.xpath(
			"//*[contains(text(),'Is this vehicle registered?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By vehicleRegisteredToggleNo = By.xpath(
			"//*[contains(text(),'Is this vehicle registered?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By vehicleLeasedToggleYes = By.xpath(
			"//*[contains(text(),'Is this vehicle leased?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By vehicleLeasedToggleNo = By.xpath(
			"//*[contains(text(),'Is this vehicle leased?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By currentValueOfVehicleInput = By
			.xpath("//*[contains(text(),'Current value of vehicle ($)')]//following-sibling::div/input");
	By currentAmountOwnedInput = By
			.xpath("//*[contains(text(),'Current amount owed for vehicle ($)')]//following-sibling::div/input");

	// Investment //Promissory Note or Land Contract
	By typeOfInvestmentPicklist = By.xpath("//select[@title='Click here to see investment types']");
	By nameOfCompanyInput = By.xpath("//*[contains(text(),'Name of company or bank')]//following-sibling::div/input");
	By valueInput = By.xpath("//*[contains(text(),'Value')]//following-sibling::div/input");

	// Burial Asset

	By typeOfBurialAsset = By.xpath("//select[@title='Click here to see burial asset types']");
	By funeralHomeInput = By
			.xpath("//*[contains(text(),'Name of funeral home, company, or bank')]//following-sibling::div/input");
	By burialRadio = By.xpath("//input[@type='radio']//following-sibling::label/span[2]");

	// Trust

	By establishedRadioButton = By.xpath(
			"//*[contains(text(),'Who established the trust?')]/following-sibling::div/span/input[@type='radio']//following-sibling::label/span[2]");
	By typeOfTrustPicklist = By.xpath("//select[@title='Click here to see trust types']");
	By dateEstablished = By.xpath("//*[contains(text(),'Date Established')]/following-sibling::div/input");
	By paymentToggleYes = By.xpath(
			"//*[contains(text(),'receive payments from the Trust?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By paymentToggleNo = By.xpath(
			"//*[contains(text(),'receive payments from the Trust?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");

	// Annuity
	By purchaseAnnuityToggleYes = By.xpath(
			"//*[contains(text(),'purchase the annuity?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By purchaseAnnuityToggleNo = By.xpath(
			"//*[contains(text(),'purchase the annuity?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By paymentFromAnnuityToggleYes = By.xpath(
			"//*[contains(text(),'receive payments from the Annuity?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By paymentFromAnnuityToggleNo = By.xpath(
			"//*[contains(text(),'receive payments from the Annuity?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");

	// Liquid Asset

	By typeOfLiquidAssetPicklist = By.xpath("//select[@title='Click here to see other liquid asset types']");

	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By checkAssetTransfer = By.xpath("//p[contains(text(),'Asset Transfer Information')]");
	By assetTypelabel = By.xpath("//span/p[1]");
	static int counterx =1;

	public MD_AssetInfoPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_A_Trust_Start() {

		driver.findElement(btn_A_Trust_Start_xpath).click();
	}

	public void Click_AcceptAssetPopup() throws InterruptedException {

		ClickOn(btn_Accept_Popup_xpath);

	}

	public void Select_TypeOfTrust(String type) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		Select tot = new Select(driver.findElement(pcklst_TOT_xpath));
		tot.selectByVisibleText(type);
	}

	public void Enter_Trust_NameofBank() {

		driver.findElement(txt_Trst_NOB_xpath).sendKeys("STAR");
	}

	public void Enter_Trust_Value() {

		driver.findElement(txt_Trust_Value_xpath).sendKeys("100");
	}

	public void Click_Estab_Trust() {

		driver.findElement(rdbtn_ET_xpath).click();
	}

	public void Enter_DateEstab() {

		driver.findElement(date_ED_xpath).sendKeys("01/01/2020");
	}

	public void Click_RecPay_Trust() {

		driver.findElement(tglbtn_RecPayTrsut_xpath).click();
	}

	public void Click_CA_Start() {

		WebElement element = driver.findElement(btn_A_CA_Start_xpath);
		clickButton(element);
	}

	public void Click_Start(String type) {

		// driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]
		// //following::button[contains(text(),'Edit')][1]"));
		String text = driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]//following::button[1]"))
				.getText();
		if (text.equalsIgnoreCase("Edit")) {
			log.info("Value is already provided");
		} else if (text.equalsIgnoreCase("Start")) {
			driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]//following::button[1]")).click();
		}
	}

	public WebElement startLabel(String type) {
		return driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]//following::button[1]"));
	}

	public void Select_TypeOfAccount() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1500);
		Select tot = new Select(driver.findElement(pcklst_TOA_xpath));
		tot.selectByVisibleText("Checking Accounts");
	}

	public void Enter_CA_NameofBank() {

		driver.findElement(txt_CA_NOB_xpath).sendKeys("STARLET");
	}

	public void Click_CA_AnotherOwner() {

		driver.findElement(tglbtn_CA_Anthr_Own_xpath).click();
	}

	public void Enter_CA_Value() {

		driver.findElement(txt_CA_Value_xpath).sendKeys("100");
	}

	public void ClickNext() throws InterruptedException {

		/*
		 * WebElement element = driver.findElement(btn_Next_xpath);
		 * clickButton(element);
		 */
		ClickOn(btn_Next_xpath);
		Thread.sleep(10000);

	}

	public void ClickSave() {

		WebElement element = driver.findElement(btn_Save_xpath);
		clickButton(element);
	}

	public void AddAccount() throws InterruptedException {
		Click_Start("Account");
		Thread.sleep(3000);
		Select_TypeOfAccount();
		Thread.sleep(1000);
		Enter_CA_NameofBank();
		Thread.sleep(1000);
		Enter_CA_Value();
		Thread.sleep(1000);
		Click_CA_AnotherOwner();
		Thread.sleep(1000);
		ClickSave();
		Thread.sleep(3000);
	}

	/*******************************
	 * Regression Suite methods
	 * 
	 * @throws Exception
	 ***************************************/
	
	public void ClearAllAssets() throws Exception {
		
		if(counterx==1) {
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLAllTypeofAsset();
		
		counterx++;
		PickLTTypeofAsset();
		}
	}
	
	public void PickLTTypeofAsset() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see asset types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Assets", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "All Assets", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void checkAnotherOwner(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(anotherOwnerYesToggle).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(anotherOwnerNoToggle).click();
		} else {
			log.info("Is another owner option is not selected");
		}

	}

	// Life Insurance

	public void PickLTLifeInsurance() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see life insurance types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Life Insurance", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Life Insurance", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void setTypeOfInsurance(String type) throws Exception {

		if (type.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLLifeInsurance();
			PickLTLifeInsurance();
			WebElement ele=driver.findElement(typeOfInsurancePicklist);
			try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(type);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}

	}

	public void setInsuranceCompanyInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			WebElement insuranceElement = driver.findElement(insuranceCompanyNameInput);
			insuranceElement.sendKeys(value);
		}
	}

	public void setPolicyNumberInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(policyNumberInput).sendKeys(value);
		}
	}

	public void setfaceValueInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(faceValueInput).sendKeys(value);
		}
	}

	public void setCashValueInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(cashSurrenderValue).sendKeys(value);
		}
	}

	public void setLifeInsuranceAsset(String TCid) throws Exception {
		/*
		 * if (isDisplayed(startLabel("Life Insurance"))) {
		 * Click_Start("Life Insurance");
		 */
		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		//// p[contains(text(),'Life Insurance')]
		System.out.println("List size---" + al.size() + "---" + al.toString());

		setInsuranceCompanyInput(al.get(10).toString());

		setPolicyNumberInput(al.get(11).toString());
		setTypeOfInsurance(al.get(12).toString());
		wait(1);
		setfaceValueInput(al.get(13).toString());
		wait(1);
		String typeOfInsurance = al.get(12).toString();
		if (typeOfInsurance.equalsIgnoreCase("Whole Life Insurance")) {
			setCashValueInput(al.get(14).toString());
		} else {
			log.info("Whole Life Insurance is not selected");
		}
		checkAnotherOwner(al.get(15).toString());
		ClickSave();
		wait(2);

	}

	// Real Estate methods
	
	public void PickLTRealEstate() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see property types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Real Estate", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Real Estate", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void setTypeOfestate(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLRealEstateProperty();
			PickLTRealEstate();
			WebElement ele= driver.findElement(realEstateTypePicklist);
			try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
			}
			catch(Throwable  t) {
				PLvalidate(ele);
			}
		}
	}

	public void setLiveOnProperty(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(ownerlivePropertyToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(ownerlivePropertyToggleNo).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setplanToReturn(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(planToReturnToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(planToReturnToggleYes).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setpropertyForSale(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(realEstatePropertySaleToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(realEstatePropertySaleToggleNo).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setfairMarketValueInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(fairMarketValueInput).sendKeys(value);
		}
	}

	public void setcurrentAmountOwnedInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(loanAmountOwnedInput).sendKeys(value);
		}
	}

	public void setRealEstateAsset(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setTypeOfestate(al.get(28).toString());
		driver.findElement(realEstateDescTextarea).sendKeys(al.get(29).toString());
		setLiveOnProperty(al.get(30).toString());
		if (al.get(30).toString().equalsIgnoreCase("No")) {
			setplanToReturn(al.get(31).toString());
		}
		setfairMarketValueInput(al.get(32).toString());
		setpropertyForSale(al.get(33).toString());
		setcurrentAmountOwnedInput(al.get(34).toString());
		checkAnotherOwner(al.get(35).toString());
		ClickSave();
		wait(2);
	}

	// Vehicle

	public void PickLTVehicle() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see vehicle type options']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Vehicle", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Vehicle", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	
	public void setTypeOfVehicle(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLVehicle();
			PickLTVehicle();
			WebElement ele=driver.findElement(typeOfVehiclePicklist);
					try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
		}
	}

	public void setMileage(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(mileageInput).sendKeys(value);

		}
	}

	public void setCommuteToSchoolToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(commuteToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(commuteToggleNo).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setVehicleRegisteredToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(vehicleRegisteredToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(vehicleRegisteredToggleNo).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setVehicleLeasedToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(vehicleLeasedToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(vehicleLeasedToggleNo).click();
		} else {
			log.info("Question did not display");
		}
	}

	public void setCurrentValue(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(currentValueOfVehicleInput).sendKeys(value);

		}
	}

	public void setAmountOwned(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(currentAmountOwnedInput).sendKeys(value);

		}
	}

	public void setVehicleAsset(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setTypeOfVehicle(al.get(48).toString());
		driver.findElement(makeInput).sendKeys(al.get(49).toString());
		driver.findElement(modelInput).sendKeys(al.get(50).toString());
		driver.findElement(yearInput).sendKeys(al.get(51).toString());
		setMileage(al.get(52).toString());
		setCommuteToSchoolToggle(al.get(53).toString());
		setVehicleRegisteredToggle(al.get(54).toString());
		setVehicleLeasedToggle(al.get(55).toString());
		setCurrentValue(al.get(56).toString());
		setAmountOwned(al.get(57).toString());
		checkAnotherOwner(al.get(58).toString());
		ClickSave();
		wait(2);

	}

	// Account Asset
	public void PickLTAccount() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see account types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Account", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Account", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void setTypeOfAccount(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLAccount();
			PickLTAccount();
			WebElement ele= driver.findElement(pcklst_TOA_xpath);
			try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
	}

	public void setnameOfCompanyInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(nameOfCompanyInput).sendKeys(value);
		}
	}

	public void setvalueInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(valueInput).sendKeys(value);
		}
	}

	public void setAccountAsset(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setTypeOfAccount(al.get(6).toString());
		setnameOfCompanyInput(al.get(7).toString());
		setvalueInput(al.get(8).toString());
		checkAnotherOwner(al.get(9).toString());
		ClickSave();
		wait(2);
	}

	// Investment
	
	public void PickLTInvestment() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see investment types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Investment", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Investment", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void setTypeOfInvestment(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLInvestment();
			PickLTInvestment();
			WebElement ele= driver.findElement(typeOfInvestmentPicklist);
			try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
	}

	public void setInvestmentAsset(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setTypeOfInvestment(al.get(24).toString());
		setnameOfCompanyInput(al.get(25).toString());
		setvalueInput(al.get(26).toString());
		checkAnotherOwner(al.get(27).toString());
		ClickSave();
		wait(2);
	}

	// Other Liquid Asset
	
	public void PickLTOtherLiquid() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see other liquid asset types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Other Liquid Asset", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Other Liquid Asset", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void setTypeOfOtherLiquidAsset(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			ClearAllAssets();
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLOtherLiquidAsset();
			PickLTOtherLiquid();
			WebElement ele =  driver.findElement(typeOfLiquidAssetPicklist);
			try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
	}

	public void setOtherLiquidAsset(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		System.out.println(al.toString() + "----------" + al.get(44).toString());
		setTypeOfOtherLiquidAsset(al.get(45).toString());
		setvalueInput(al.get(46).toString());
		checkAnotherOwner(al.get(47).toString());
		ClickSave();
		wait(2);

	}

	/**************** Other Asset methods 
	 * *****************************/

	// Burial Asset methods

	public void PickLTBurial() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see burial asset types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Burial", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Burial", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void setTypeOfBurialAsset(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			ClearAllAssets();
			
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLBurialAsset();
			PickLTBurial();
			WebElement ele = driver.findElement(typeOfBurialAsset);
			try {
			Select select = new Select(ele);
			select.selectByVisibleText(value);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
	}

	public void setfuneralInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(funeralHomeInput).sendKeys(value);

		}
	}

	public void setBurialTrustFor(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			List<WebElement> li = driver.findElements(burialRadio);
			for (WebElement element : li) {
				if (element.getText().equalsIgnoreCase(value)) {
					element.click();
					break;
				}
			}

		}
	}

	public void setBurialAssetDetails(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		System.out.println(al.get(36).toString() + "------" + al.toString());
		setTypeOfBurialAsset(al.get(36).toString());
		setfuneralInput(al.get(37).toString());
		setBurialTrustFor(al.get(38).toString());
		setvalueInput(al.get(39).toString());
		ClickSave();
		wait(2);
	}

	// Promissory Note or Land Contract

	public void setPromissoryNoteAssetDetails(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		ClearAllAssets();
		setnameOfCompanyInput(al.get(16).toString());
		setvalueInput(al.get(17).toString());
		ClickSave();
		wait(2);
	}

	// Trust

	public void PickLTTrust() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see trust types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Trust", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Trust", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void setTypeOfTrust(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			ClearAllAssets();
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLTrust();
			PickLTTrust();
			WebElement ele= driver.findElement(typeOfTrustPicklist);
			try {
			Select select = new Select(ele);
			select.selectByVisibleText(value);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
	}

	public void setEstablishedTrustRadio(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			List<WebElement> li = driver.findElements(establishedRadioButton);
			for (WebElement element : li) {
				if (element.getText().equalsIgnoreCase(value)) {
					element.click();
					break;
				}
			}

		}
	}

	public void setDateEstablished(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			driver.findElement(dateEstablished).sendKeys(value);
		}
	}

	public void setReceivePaymentToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(paymentToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(paymentToggleNo).click();
		} else {
			log.info("Value is not present");
		}
	}

	public void setTrustAssetDetails(String TCid) throws Exception {

		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setTypeOfTrust(al.get(18).toString());
		setnameOfCompanyInput(al.get(19).toString());
		setvalueInput(al.get(20).toString());
		setEstablishedTrustRadio(al.get(21).toString());
		setDateEstablished(al.get(22).toString());
		setReceivePaymentToggle(al.get(23).toString());
		ClickSave();
		wait(2);
	}

	// Life Estate

	public void setDescTextArea(String value) throws Exception {
		if (value.equalsIgnoreCase("null")) {
			log.info("Value is not present");
		} else {
			ClearAllAssets();
			driver.findElement(realEstateDescTextarea).sendKeys(value);
		}
	}

	public void setLifeEstateAssetDetails(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		setnameOfCompanyInput(al.get(2).toString());
		setDescTextArea(al.get(3).toString());
		setvalueInput(al.get(4).toString());
		setDateEstablished(al.get(5).toString());
		ClickSave();
		wait(2);
	}

	// Annuity

	public void setPurchaseAnnuityToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(purchaseAnnuityToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(purchaseAnnuityToggleNo).click();
		} else {
			log.info("Value is not present");
		}
	}

	public void setReceivePaymentAnnuityToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(paymentFromAnnuityToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(paymentFromAnnuityToggleNo).click();
		} else {
			log.info("Value is not present");
		}
	}

	public void setAnnuityAssetDetails(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-AssetSumry", "Sno");
		ClearAllAssets();
		System.out.println(al.get(44).toString() + "-------" + al.toString());
		setnameOfCompanyInput(al.get(40).toString());
		setvalueInput(al.get(41).toString());
		setPurchaseAnnuityToggle(al.get(42).toString());
		if (al.get(42).toString().equalsIgnoreCase("Yes")) {
			setDateEstablished(al.get(43).toString());
		}
		setReceivePaymentAnnuityToggle(al.get(44).toString());
		ClickSave();
		wait(2);
	}

	public By getAssetLabels() {
		return assetTypelabel;

	}

	public void setAssetDetails(String TCid, String assetType) throws Exception {

		MD_AssetInfoPO asset = new MD_AssetInfoPO(driver);
		// driver.getTitle().contains("Asset Info");
		if (driver.getTitle().contains("Asset Info")) // //p[contains(text(),'Assets Summary')]
		{
			Click_Start(assetType);
			if (assetType.equalsIgnoreCase("Life Insurance")) {
				asset.setLifeInsuranceAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Account")) {
				asset.setAccountAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Investment")) {
				asset.setInvestmentAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Other Liquid Asset")) {
				asset.setOtherLiquidAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Real Estate Property")) {
				asset.setRealEstateAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Vehicle")) {
				asset.setVehicleAsset(TCid);
			} else if (assetType.equalsIgnoreCase("Burial Asset")) {
				asset.setBurialAssetDetails(TCid);
			} else if (assetType.equalsIgnoreCase("Promissory Note or Land Contract")) {
				asset.setPromissoryNoteAssetDetails(TCid);
			} else if (assetType.equalsIgnoreCase("Trust")) {
				asset.setTrustAssetDetails(TCid);
			} else if (assetType.equalsIgnoreCase("Life Estate")) {
				asset.setLifeEstateAssetDetails(TCid);
			} else if (assetType.equalsIgnoreCase("Annuity")) {
				asset.setAnnuityAssetDetails(TCid);

			} else {
				log.info("No Asset found");
			}
		}

	}

	public void fillAssetDetails(String TCid) throws Exception {
		wait(2);
		if (driver.getTitle().contains("Member Asset Info") ||driver.getTitle().contains("Member Resource Info")) {
			wait(1);
			Click_AcceptAssetPopup();
			List<WebElement> list = driver.findElements(getAssetLabels());
			ArrayList<String> assetType = new ArrayList<String>();
			for (WebElement element : list) {
				assetType.add(element.getText());

			}
			if (!assetType.isEmpty()) {
				for (String assetT : assetType) {
					System.out.println(assetT);
					setAssetDetails(TCid, assetT);
				}
				Scrollend();
				ClickNext();
			} else {
				wait(2);
				ClickNext();
			}

			wait(2);

			if (checkAssetTransferInformation().length() != 0) {
				MD_AssetTransferInfomationPO assetTransfer = new MD_AssetTransferInfomationPO(driver);
				assetTransfer.setAssetInformationDetails(TCid);
			} else {
				log.info("Asset Summary is completed");
			}
		}
		else {
			System.out.println("Asset Information did not queue");
		}
	}

	public String checkAssetTransferInformation() {
		String label = "";
		if (isDisplayed(checkAssetTransfer)) {
			label = driver.findElement(checkAssetTransfer).getText();
			return label;
		} else {
			return label;
		}
	}
}