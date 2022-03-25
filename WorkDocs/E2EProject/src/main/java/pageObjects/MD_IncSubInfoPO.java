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

public class MD_IncSubInfoPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By btn_Accept_Popup_xpath = By.xpath("//button[@title='Go to Income Summary']");
	By pcklst_TOJI_xpath = By.xpath("//div[2]/c-ssp-base-component-input-picklist/div/select");
	By txt_Emp_Name_xpath = By.xpath("//input");
	By txt_EmpAddr_xpath = By.xpath(
			"//c-ssp-address-auto-complete/div/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By popup_EmpAddr_xpath = By.xpath("//span/span");
	By txt_EmpAddrL2_xpath = By.xpath("//div[2]/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_PriPN_xpath = By.xpath("//c-ssp-base-component-input-phone/div/lightning-input/div/input");
	By date_IncSour_xpath = By.xpath("//div/div/input");
	By pcklst_IncFreq_xpath = By.xpath("//div[7]/c-ssp-base-component-input-picklist/div/select");
	By txt_TaxAvg_xpath = By.xpath("//c-ssp-base-component-input-text-icon/div/div/lightning-input/div/input");
	By txt_HrsWorked_xpath = By.xpath("//c-ssp-base-component-input-number/div/lightning-input/div/input");
	By tglbtn_IncSource_xpath = By.xpath("//span/label");
	By lbl_JIFE_xpath = By.xpath("//p[contains(text(),'Job Income from Employer')]");
	By lbl_SMI_xpath = By.xpath("//p[contains(text(),'Support & Maintenance Income')]");
	By lbl_SEI_xpath = By.xpath("//p[contains(text(),'Self-Employment Income')]");
	By lbl_SSRRVA_xpath = By.xpath("//p[contains(text(),'Social Security, Railroad Retirement')]");
	By lbl_RPI_xpath = By.xpath("//p[contains(text(),'Retirement, Pension, & Investment Income')]");
	By lbl_DIR_xpath = By.xpath("//p[contains(text(),'Dividends, Interest, & Royalties')]");
	By lbl_IPBI_xpath = By.xpath("//p[contains(text(),'Insurance Payments & Benefits Income')]");
	By lbl_OGPS_xpath = By.xpath("//p[contains(text(),'Other Goods, Payments, & Services')]");
	By lbl_IncHeader_xpath = By.xpath("//p");
	static int counterx=1;

	public MD_IncSubInfoPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_AcceptIncomePopup() throws InterruptedException {

		/* driver.findElement(btn_Accept_Popup_xpath).click(); */
		ClickOn(btn_Accept_Popup_xpath);
	}

	public void Click_IncSub_Start(String type) {

		driver.findElement(By.xpath("//p[contains(text(),'" + type + "')]//following::button[1]")).click();
	}

	public void Select_TypeofJob() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		Select tot = new Select(driver.findElement(pcklst_TOJI_xpath));
		tot.selectByVisibleText("AmeriCorps/VISTA - Living Allowance");
	}

	public void Enter_Empl_Name() {

		driver.findElement(txt_Emp_Name_xpath).sendKeys("LANTERN");
	}

	public void Enter_EmpAddr() throws InterruptedException {

		driver.findElement(txt_EmpAddr_xpath).sendKeys("1237, HARDING PLACE");
		Thread.sleep(2000);
		driver.findElement(popup_EmpAddr_xpath).click();

	}

	public void Enter_EmpAddrL2() {

		driver.findElement(txt_EmpAddrL2_xpath).sendKeys("2ND CROSS");
	}

	public void Enter_PriPN() {

		driver.findElement(txt_PriPN_xpath).sendKeys("5558239849");
	}

	public void Enter_IncomeSourceDate() {

		driver.findElement(date_IncSour_xpath).sendKeys("01/01/2020");
	}

	public void Select_IncFreq() throws InterruptedException {

		Select inf = new Select(driver.findElement(pcklst_IncFreq_xpath));
		inf.selectByVisibleText("Annually");
	}

	public void Enter_GrossTaxAverage() {

		driver.findElement(txt_TaxAvg_xpath).sendKeys("100");
	}

	public void Enter_HrsWorked() {

		driver.findElement(txt_HrsWorked_xpath).sendKeys("45");
	}

	public void Click_IncSource_Y() {

		driver.findElement(tglbtn_IncSource_xpath).click();
	}

	public void ClickNext() throws InterruptedException {

		ClickOn(btn_Next_xpath);
		wait(4);
	}

	public void ClickSave() {

		driver.findElement(btn_Save_xpath).click();
		wait(4);
	}

	public void AddAnyIncome() throws InterruptedException {
		Click_IncSub_Start("Job");
		Thread.sleep(3000);
		Select_TypeofJob();
		Thread.sleep(1000);
		Enter_Empl_Name();
		Thread.sleep(1000);
		Enter_EmpAddr();
		Thread.sleep(1000);
		Enter_EmpAddrL2();
		Thread.sleep(1000);
		Enter_PriPN();
		Thread.sleep(1000);
		Enter_IncomeSourceDate();
		Thread.sleep(1000);
		Select_IncFreq();
		Thread.sleep(1000);
		Enter_GrossTaxAverage();
		Thread.sleep(1000);
		Enter_HrsWorked();
		Thread.sleep(1000);
		Click_IncSource_Y();
		Thread.sleep(1000);
		ClickSave();
		Thread.sleep(3000);
	}
	
	public void SelectAddressInc() throws IOException, InterruptedException {
		
		//List<WebElement> Madd=driver.findElements(By.xpath("//*[text()='+ Manually enter address']"));
		List<WebElement> Madd=driver.findElements(By.xpath("//*[text()='+ Manually enter address']"));
		if(Madd.size()==1) {
		al2 = excelData.getData("TC1", "Reg-ManualAdd", "Sno");
		driver.findElement(By.xpath("//*[text()='+ Manually enter address']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Employer address']/following::input")).sendKeys(al2.get(1));
		Thread.sleep(700);			
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Address Line 2']/following::input")).sendKeys(al2.get(2));
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='City']/following::input")).sendKeys(al2.get(3));
		Thread.sleep(700);
		driver.findElement(By.xpath("//ul/li/div[text()='"+al2.get(3)+"']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='State']/following::input")).sendKeys(al2.get(4));
		Thread.sleep(700);
		driver.findElement(By.xpath("//ul/li/div[text()='"+al2.get(4)+"']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Zip Code']/following::input")).sendKeys(al2.get(5));
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Country']/following::input")).sendKeys(al2.get(6));
		Thread.sleep(700);
		driver.findElement(By.xpath("//ul/li/div[text()='"+al2.get(6)+"']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Enter Address']/following::button[text()='Save']")).click();
		wait(2);
	}
		else {
		driver.findElement(By.xpath("//span/span")).click();
	}
	}

	// ********************************************************************************************************************

	public void ClearAllIncomeandSub() throws Exception {
		
		if(counterx==1) {
		System.out.println("Entered the counterx loop" +counterx);
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLAllTypeofIncome();
		cppo.ClearPLIncomefrequency();
		counterx++;
		PickLTTypeofIncomeandSub();
		PickLTTypeofIncomeFreq();
		}
	}
	
	public void PickLTTypeofIncomeandSub() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see types of income']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLTTypeofIncomeFreq() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see income frequency options.']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies", i + 1, 3, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies", i + 2, 3,
						lst_PNo.size());
			}
		}
	}
	
	// Method to add details for Job Income from Employer information
	
	public void PickLTJobIncome() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see types of job income from employer']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncJobIncomefromEmployerinformation(String TCid) throws Exception {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(1).contains("Yes")) {
			String[] Mem = al.get(2).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Job Income from Employer')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLTypeofjobincome();
					PickLTJobIncome();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele= driver.findElement(By
							.xpath("//label[contains(text(),'Type of job income from employer')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(2));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath("//label[contains(text(),'Employer name')]/following::input"))
							.sendKeys(al.get(3));
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'Employer address')]/following::input"))
							.sendKeys(al.get(4));
					Thread.sleep(700);
					SelectAddressInc();
					//driver.findElement(By.xpath("//span/span")).click();
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'Address Line 2')]/following::input"))
							.sendKeys(al.get(5));
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'Primary Phone Number')]/following::input"))
							.sendKeys(al.get(6));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'start getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(7));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(8));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(9));
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'Hours worked per week')]/following::input"))
							.sendKeys(al.get(10));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(11) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(11).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(12));
						Thread.sleep(700);
						driver.findElement(By.xpath(
								"//label[contains(text(),'What was the last day of employment?')]/following::input"))
								.sendKeys(al.get(13));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Support & Maintenance Income
	
	public void PickLTSupportMaint() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see support & maintenance income types')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Maintance Income", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Maintance Income", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void EnterIncSupportMaintenanceIncome(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(15).contains("Yes")) {
			String[] Mem = al.get(16).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Support & Maintenance Income')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLmaintenanceincome();
					PickLTSupportMaint();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele=driver.findElement(By.xpath(
							"//label[contains(text(),'Type of support or maintenance income')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(14));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'start getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(15));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(16));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(17));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(18) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(18).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(19));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Self-Employment Income
	
	public void PickLTSelfEmp() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='Click here to see self-employment types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Self-Employ", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Self-Employ", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncSelfEmploymentIncome(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(7).contains("Yes")) {
			String[] Mem = al.get(8).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Self-Employment Income')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLSelfEmployment();
					PickLTSelfEmp();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele=driver.findElement(
							By.xpath("//label[contains(text(),'Self-Employment Type')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(20));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath("//label[contains(text(),'Type of Business')]/following::textarea"))
							.sendKeys(al.get(21));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'Is this business a corporation or partnership?')]/following::span[contains(text(),'"
									+ al.get(22) + "')]"));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(23));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(24));
					Thread.sleep(1000);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(25));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'Biweekly expenses related to this self-employment income')]/following::input"))
							.sendKeys(al.get(26));
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'Hours worked per week')]/following::input"))
							.sendKeys(al.get(27));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(28) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(28).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(29));
						Thread.sleep(700);
						driver.findElement(By.xpath(
								"//label[contains(text(),'What was the last day of employment?')]/following::input"))
								.sendKeys(al.get(30));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Social Security, Railroad Retirement, & Veteran's
	// Administration Benefits
	
	public void PickLTSocialSecurityRailroad() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see social security, railroad retirement, & Veteran')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Social Security", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Social Security", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncSocialSecurity(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(9).contains("Yes")) {
			String[] Mem = al.get(10).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Social Security, Railroad Retirement')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLsocialsecurityrailroad();
					PickLTSocialSecurityRailroad();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele = driver.findElement(By.xpath(
							"//label[contains(text(),'Type of social security, railroad retirement')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(43));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(44));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(45));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(46));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(47) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(47).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(48));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Retirement, Pension, & Investment Income
	
	public void PickLTRetirementpension() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see retirement, pension, & investment income types')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Retire pension", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Retire pension", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncPensionII(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(11).contains("Yes")) {
			String[] Mem = al.get(12).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Retirement, Pension, & Investment Income')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLretirementpension();
					PickLTRetirementpension();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele= driver.findElement(By.xpath(
							"//label[contains(text(),'Type of retirement, pension, or investment income')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(49));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(50));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(51));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(52));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(53) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(53).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(54));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}

			}
		}
	}

	// Method to add details for Dividends, Interest, & Royalties

	public void PickLTDividends() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see dividends, interest, & royalties types')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Dividends", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Dividends", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncDivInterRoyal(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(13).contains("Yes")) {
			String[] Mem = al.get(14).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Dividends, Interest, & Royalties')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLdividendsinterests();
					PickLTDividends();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele= driver.findElement(By.xpath(
							"//label[contains(text(),'Type of dividends, interest, or royalties')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(55));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(56));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(57));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(58));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(59) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(59).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(60));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Insurance Payments & Benefits Income
	
	public void PickLTInsurancePay() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see insurance payment & benefits income types')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Insurance", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Insurance", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncInsurancePay(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(17).contains("Yes")) {
			String[] Mem = al.get(18).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Insurance Payments & Benefits Income')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLTypeofinsurancepayment();
					PickLTInsurancePay();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement  ele= driver.findElement(By.xpath(
							"//label[contains(text(),'Type of insurance payment or benefits income')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(37));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(38));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(39));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(40));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(41) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(41).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(42));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Method to add details for Other Goods, Payments, & Services

	public void PickLTOtherGoods() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[contains(@title,'Click here to see other unearned income types')]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Other goods", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Other goods", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterIncOtherGoods(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(19).contains("Yes")) {
			String[] Mem = al.get(20).trim().split(";");
			for (int i = 0; i < Mem.length; i++) {

				String val = Mem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					driver.findElement(By.xpath(
							"//p[contains(text(),'Other Goods, Payments, & Services')]/following::button[contains(text(),'Start')]"))
							.click();
					//wait(2);
					ClearAllIncomeandSub();
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPLTypeofothergoods();
					PickLTOtherGoods();
					al = excelData.getData(TCid, "Reg-MD-IncmSumry", "Sno");
					WebElement ele = driver.findElement(By.xpath(
							"//label[contains(text(),'Type of other goods, payments, or services')]/following::select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(31));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'getting payments from this income source?')]/following::input"))
							.sendKeys(al.get(32));
					Thread.sleep(700);
					WebElement ele1 = driver
							.findElement(By.xpath("//label[contains(text(),'Income frequency')]/following::select"));
					try {
					Select s2 = new Select(ele1);
					s2.selectByVisibleText(al.get(33));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'If the amount varies, provide an average.')]/following::input"))
							.sendKeys(al.get(34));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'still have this source of income?')]/following::span[contains(text(),'"
									+ al.get(35) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(35).equalsIgnoreCase("No")) {
						driver.findElement(By.xpath("//label[contains(text(),'End Date')]/following::input"))
								.sendKeys(al.get(36));
						Thread.sleep(700);
					}
					ClickSave();
					List<WebElement> start = driver.findElements(By.xpath("//*[text()='Start']"));
					if (start.size() < 1) {
						ClickNext();
						log.info("All the income summary details have been entered successfully");
					}
				}
			}
		}
	}

	// Call all the methods of Income summary
	public void AllIncomeSummary_Reg(String TCid) throws Exception {
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		Thread.sleep(800);
		String lblH = driver.findElement(lbl_IncHeader_xpath).getText();
		System.out.println(lblH);
		if (lblH.contains("Income Summary")) {
			if (al.get(1).contains("Yes") || al.get(7).contains("Yes") || al.get(9).contains("Yes")
					|| al.get(11).contains("Yes") || al.get(13).contains("Yes") || al.get(15).contains("Yes")
					|| al.get(17).contains("Yes") || al.get(19).contains("Yes")) {
				ClickNext();// To close the pop up
				Assert.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Income Summary"));
				EnterIncJobIncomefromEmployerinformation(TCid);
				EnterIncSelfEmploymentIncome(TCid);
				EnterIncSocialSecurity(TCid);
				EnterIncPensionII(TCid);
				EnterIncDivInterRoyal(TCid);
				EnterIncSupportMaintenanceIncome(TCid);
				EnterIncInsurancePay(TCid);
				EnterIncOtherGoods(TCid);
			}
		}
		if (al.get(21).contains("Yes")) {

			MD_IncSubInfo_BenefitsAnoStatePO mdBAS = new MD_IncSubInfo_BenefitsAnoStatePO(driver);
			mdBAS.EnterBnftAnoState(TCid);
		}

	}

}
