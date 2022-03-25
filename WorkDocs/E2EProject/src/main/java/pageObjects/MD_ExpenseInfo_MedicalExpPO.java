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

public class MD_ExpenseInfo_MedicalExpPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Accept_Popup_xpath = By.xpath("//button[@title='Go to Expenses Summary']");
	By btn_Start_xpath = By.xpath("//button[contains(text(),'Start')]");
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By btn_Month_xpath = By.xpath("//label/span");
	By pcklst_shelterType_xpath = By.xpath("//select[@title='Click here to see shelter expense types']");
	By pcklst_utilityType_xpath = By.xpath("//select[@title='Click here to see utility expense types']");
	By pcklst_tax_xpath = By
			.xpath("//label[contains(text(),'Type of tax deduction')]/following-sibling::div/input[@type='text']");

	By pcklst_medicalType_xpath = By
			.xpath("//label[contains(text(),'Type of medical expense')]/following-sibling::div/input");
	By pcklst_ExpFreq_xpath = By.xpath("//select[@title='Click here to see expense frequency options']");
	By txt_Amount_xpath = By.xpath("//label[contains(text(),'Amount')]/following-sibling::div/input[@type='text']");
	By btn_HousingAssitance_N_xpath = By.xpath("//label/span[contains(text(),'No')]");
	By btn_HousingAssitance_Y_xpath = By.xpath("//label/span[contains(text(),'Yes')]");
	By btn_accept_popup = By.xpath("//span[@slot='Footer']/lightning-button/button[contains(text(),'Next')]");
	By btn_start = By.xpath("//button[contains(text(),'Start')]");
	By txt_payment_xpath = By
			.xpath("//label[contains(text(),'Who is this payment made to?')]/following-sibling::div/input");
	By txt_MedicalExPaidTo_xpath = By
			.xpath("//label[contains(text(),'Who is this medical expense paid to?')]/following-sibling::div/input");
	By txt_nameOfChild_xpath = By
			.xpath("//label[contains(text(),'Name of Child')]/following-sibling::div/input[@type='text']");
	By txt_careProvider_xpath = By
			.xpath("//label[contains(text(),'Care provider name')]/following-sibling::div/input[@type='text']");
	By rdo_dependent_xpath = By.xpath(
			"//legend[contains(text(),'Who is the dependent care for?')]/following-sibling::div/span/label/span[1]");
	By lbl_MedicalExp3Months_xpath = By.xpath("//p[contains(text(),'Medical Expenses (Last 3 Months)')]");

	By lbl_IncHeader_xpath = By.xpath("//p");
	static int counterx=1;
	
	public MD_ExpenseInfo_MedicalExpPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void acceptPopup() {
		WebElement element = driver.findElement(btn_accept_popup);
		clickButton(element);
	}

	public void startShelter() {
		WebElement element = driver.findElement(btn_start);
		clickButton(element);
	}

	public void selectTypeofShelter(String shelterExpense) {
		WebElement ele = driver.findElement(pcklst_shelterType_xpath);
		try {
		Select sel = new Select(ele);
		sel.selectByVisibleText(shelterExpense);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	public void selectExpenseFrequency(String frequency) {
		WebElement ele = driver.findElement(pcklst_ExpFreq_xpath);
		try {
		Select sel = new Select(driver.findElement(pcklst_ExpFreq_xpath));
		sel.selectByVisibleText(frequency);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	public void expenseAmount(String amt) {
		driver.findElement(txt_Amount_xpath).sendKeys(amt);
	}

	public void selectFMHAToggle() {
		driver.findElement(btn_HousingAssitance_Y_xpath).click();
	}

	public void Click_AcceptExpensePopup() throws InterruptedException {
		try {
		WebElement lblHpopup_xpath= driver.findElement(By.xpath("//span[text()='Adding Expenses']"));
		if(lblHpopup_xpath.toString().contains("Adding Expenses"))
		wait(3);
		ClickOn(btn_Next_xpath);
		}
		catch(Throwable t) {
			System.out.println("There are no Expenses added for this member");
		}
	}

	public void ClickStart(String type) throws InterruptedException {
		driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]//following::button[1]")).click();
		Thread.sleep(1500);
	}

	public void Select_MedicalBillMonth() {

		driver.findElement(btn_Month_xpath).click();
	}

	public void Select_MedicalBillMonth_Reg(String TCid) throws IOException, InterruptedException {

		al = excelData.getData(TCid, "Reg-MD-MedExp3mnths", "Sno");	
		if(al.get(2).equalsIgnoreCase("Yes")) {
		driver.findElement(By.xpath("//fieldset//label/span[1]")).click();

		Thread.sleep(1000);
		ClickNext();
		}
		else  System.out.println("Medical Expenses (Last 3 Months) is not displayed");
	}

	public void ClickNext() throws InterruptedException {
		try {
		ClickOn(btn_Next_xpath);
		Thread.sleep(1000);
		}
		catch(Throwable t){
			System.out.println("No Next button.");
		}

	}

	public void ClickSave() throws InterruptedException {

		WebElement element = driver.findElement(btn_Save_xpath);
		clickButton(element);
		Thread.sleep(1000);
	}

	public void Select_TypeOfShelterExpense(String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		WebElement ele=driver.findElement(pcklst_shelterType_xpath);
		try {
		Select tos = new Select(ele);
		tos.selectByVisibleText(value);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	public void Select_TypeOfUtilityExpense(String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		WebElement ele=driver.findElement(pcklst_utilityType_xpath);
		try {
		Select tos = new Select(ele);
		tos.selectByVisibleText(value);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	public void Select_TypeOfMedicalExpense(String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(pcklst_medicalType_xpath).click();
		driver.findElement(By.xpath("//ul/li/div[contains(text(),'" + value + "')]")).click();
		Thread.sleep(1000);
	}

	public void Select_ExpenseFrequency(String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		Select tos = new Select(driver.findElement(pcklst_ExpFreq_xpath));
		tos.selectByVisibleText("Monthly");
		Thread.sleep(1000);
	}

	public void Enter_Amount(String value) {

		driver.findElement(txt_Amount_xpath).sendKeys("100");
	}

	public void Click_HousingAssistance_N() throws InterruptedException {

		driver.findElement(btn_HousingAssitance_N_xpath).click();
		Thread.sleep(1000);
	}

	public void Click_HousingAssistance_Y() throws InterruptedException {

		driver.findElement(btn_HousingAssitance_Y_xpath).click();
		Thread.sleep(1000);
	}

	public void Click_HousingAssistance(String value) throws InterruptedException {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(btn_HousingAssitance_Y_xpath).click();
			Thread.sleep(1000);
		} else {
			driver.findElement(btn_HousingAssitance_N_xpath).click();
			Thread.sleep(1000);
		}
	}

	public void AddShelterExpense() throws InterruptedException {
		ClickStart("Shelter");
		Select_TypeOfShelterExpense("Rent");
		Select_ExpenseFrequency("10");
		Enter_Amount("10");
		Click_HousingAssistance_N();
		ClickSave();

	}

	public void Enter_CareProviderName(String value) throws InterruptedException {

		driver.findElement(txt_careProvider_xpath).sendKeys(value);
		Thread.sleep(1000);
	}

	public void Click_DependentCare(String value) throws InterruptedException {

		driver.findElement(rdo_dependent_xpath).click();
		Thread.sleep(1000);
	}

	public void Enter_NameOfChild(String value) throws InterruptedException {

		driver.findElement(txt_nameOfChild_xpath).sendKeys(value);
		Thread.sleep(1000);
	}

	public void Enter_PaymentMadeTo(String value) throws InterruptedException {

		driver.findElement(txt_payment_xpath).sendKeys(value);
		Thread.sleep(1000);
	}

	public void Enter_MedicalExpensesPaidTo(String value) throws InterruptedException {

		driver.findElement(txt_MedicalExPaidTo_xpath).sendKeys(value);
		Thread.sleep(1000);
	}

	public void Select_TaxDeductionType(String value) throws InterruptedException {

		driver.findElement(pcklst_tax_xpath).click();
		driver.findElement(By.xpath("//ul/li/div[contains(text(),'" + value + "')]")).click();
		Thread.sleep(1000);
	}
	
	
	//*************************************Shelter Expense Regression*******************************************
	public void ClearAllExpenses() throws Exception {
		
		if(counterx==1) {
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLAllTypeofExpenses();
		cppo.ClearPLExpenseFrequency();
		}
		counterx++;
		PickLTTypeofExpenses();
		PickLTTypeofExpenseFreq();
	}
	
	public void PickLTTypeofExpenses() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see expense types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLTTypeofExpenseFreq() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see expense frequency options']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i + 1, 3, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i + 2, 3,
						lst_PNo.size());
			}
		}
	}
	
	//Shelter Expense
	
	public void PickLTShelterExpense() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see shelter expense types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Shelter Expense", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Shelter Expense", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void Add_Shelter_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLTypeofshelterexpense();
		PickLTShelterExpense();
		Select_TypeOfShelterExpense(al.get(2));
		Select_ExpenseFrequency(al.get(3));
		Enter_Amount(al.get(4));
		Click_HousingAssistance(al.get(5));
		Thread.sleep(1000);

	}

	//Utility Expense
	public void PickLTUtilityExpense() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see utility expense types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Utility Expense", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Utility Expense", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void Add_Utility_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLTypeofutilityexpense();
		PickLTUtilityExpense();
		Select_TypeOfUtilityExpense(al.get(14));
		Select_ExpenseFrequency(al.get(15));
		Enter_Amount(al.get(16));
		Thread.sleep(1000);

	}

	
	//Tax Deduction Expense
	public void PickLTTaxDeductionExpense() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[text()='Type of tax deduction']/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]/li"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Tax Deduction", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Tax Deduction", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	
	public void Add_TaxDeduction_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLTypeoftaxdeduction();
		driver.findElement(By.xpath("//label[contains(text(),'Type of tax deduction')]/following-sibling::div/input[@type='text']")).click();
		Thread.sleep(700);
		PickLTTaxDeductionExpense();
		Select_TaxDeductionType(al.get(20));
		//PickLTTaxDeductionExpense();
		Select_ExpenseFrequency(al.get(21));
		Enter_Amount(al.get(22));
		Thread.sleep(1000);

	}

	
	//Alimony
	
	
	public void Add_Alimony_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		Select_ExpenseFrequency(al.get(17));
		Enter_Amount(al.get(18));
		Enter_PaymentMadeTo(al.get(19));
		Thread.sleep(1000);
	}

	//Child Support
	
	public void Add_ChildSupport_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		Select_ExpenseFrequency(al.get(23));
		Enter_Amount(al.get(24));
		Enter_NameOfChild(al.get(25));
		Enter_PaymentMadeTo(al.get(26));
		Thread.sleep(1000);

	}

	
	
	//Dependent Care
	public void Add_DependentCare_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		Select_ExpenseFrequency(al.get(10));
		Enter_Amount(al.get(11));
		Enter_CareProviderName(al.get(12));
		Click_DependentCare(al.get(13));
		Thread.sleep(1000);
	}

	//Medical Expense
	public void PickLTMedicalExpense() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[text()='Type of medical expense']/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]/li"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Medical Expense", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Medical Expense", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void Add_Medical_Expense_Reg(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-Expenses", "Sno");
		ClearAllExpenses();
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLTypeofmedicalexpense();
		driver.findElement(By.xpath("//label[contains(text(),'Type of medical expense')]/following-sibling::div/input")).click();
		Thread.sleep(700);
		PickLTMedicalExpense();
		Select_TypeOfMedicalExpense(al.get(6));
		Select_ExpenseFrequency(al.get(7));
		Enter_Amount(al.get(8));
		Enter_MedicalExpensesPaidTo(al.get(9));
		Thread.sleep(1000);
	}

	public void Enter_Expense_Reg(String TCid, String type) throws Exception {
		String lblH = driver.findElement(lbl_IncHeader_xpath).getText();
		if (lblH.contains("Expenses Summary")) {
		ClickStart(type);
		if (type.contains("Shelter Expense")) {
			Add_Shelter_Expense_Reg(TCid);
		}

		else if (type.contains("Utility Expense")) {
			Add_Utility_Expense_Reg(TCid);
		}

		else if (type.contains("Tax Deduction Expense")) {
			Add_TaxDeduction_Expense_Reg(TCid);
		}

		else if (type.contains("Alimony")) {
			Add_Alimony_Expense_Reg(TCid);
		}

		else if (type.contains("Child Support")) {
			Add_ChildSupport_Expense_Reg(TCid);
		}

		else if (type.contains("Dependent Care")) {
			Add_DependentCare_Expense_Reg(TCid);
		}

		else if (type.contains("Medical Expense")) {
			Add_Medical_Expense_Reg(TCid);
		}

		ClickSave();
		}
	}
}
