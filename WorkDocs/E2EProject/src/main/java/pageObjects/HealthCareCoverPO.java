package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class HealthCareCoverPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	private By btn_HealthC_Start_xpath = By.xpath("(//button[@type='button'])[5]");
	private By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	private By btn_Save_xpath= By.xpath("//button[contains(text(),'Save')]");
	private By tglbtn_Enrol_HC_N_xpath = By.xpath("//c-ssp-health-coverage-selection/div/div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	private By tglbtn_NotEnrol_HC_N_xpath = By.xpath("//c-ssp-health-coverage-selection/div/div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	private By btn_HCInd_Start_xpath = By.xpath("//button[@title='Start entering details for Healthcare Coverage']");
	private By txt_CompName_xpath = By.xpath("//label[contains(text(),'Healthcare coverage company name')]/following::input");
	private By txt_Addr_xpath = By.xpath("//label[text()='Address']/following::div/input");
	private By txt_Addrval_xpath = By.xpath("//span/span");
	private By txt_AddrL2_xpath = By.xpath("//label[text()='Address Line 2']/following::div/input");
	private By txt_PID_xpath = By.xpath("//label[text()='Policy ID']/following::div/input");
	private By txt_GID_xpath = By.xpath("//label[text()='Group ID']/following::div/input");
	private By pck_HM_Enrdplan_xpath = By.xpath("//select[@title='Click here to see enrollment options']");
	private By txt_FN_xpath=By.xpath("//label[text()='First Name']/following::input");
	private By txt_MN_xpath=By.xpath("//label[text()='Middle Name']/following::input");
	private By txt_LN_xpath=By.xpath("//label[text()='Last Name']/following::input");
	private By pck_Suffix_xpath= By.xpath("//label[text()='Suffix']/following::select");
	private By txt_NOE_xpath=By.xpath("//label[text()='Name of employer']/following::input");
	private By txt_AddrPH_xpath = By.xpath("//label[text()='Address']/following::div/input");
	private By txt_AddrvalPH_xpath = By.xpath("//span/span");
	private By txt_AddrL2PH_xpath = By.xpath("//label[text()='Address Line 2']/following::div/input");
	static int counterx=1;
	
	public HealthCareCoverPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void ClickHealthCTile_Start() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1150);");
		Thread.sleep(1000);
		driver.findElement(btn_HealthC_Start_xpath).click();
		wait(5);
	}
	
	public void Click_IsEnrolled_HC_N() {
		
		driver.findElement(tglbtn_Enrol_HC_N_xpath).click();

	}
	
	public void Click_IsNotEnrolled_HC_N() {
		
		driver.findElement(tglbtn_NotEnrol_HC_N_xpath).click();

	}
	
	//Is anyone in your household enrolled in healthcare coverage?
	public void Click_EnrollinHC(String val) throws InterruptedException {
		
		driver.findElement(By.xpath("//label[contains(text(),'enrolled in healthcare coverage')]/following::span[contains(text(),'"+val+"')]")).click();
		Thread.sleep(700);
	}
    
	//Does anyone in your household have an employer that offers healthcare coverage, but has not yet enrolled?
	public void Click_HC_NotEnrolled(String val) throws InterruptedException {
		
		driver.findElement(By.xpath("//label[contains(text(),'healthcare coverage, but has not yet enrolled')]/following::span[contains(text(),'"+val+"')]")).click();
		Thread.sleep(700);
	}
	
	//To Click the Healthcoverage Start button
	public void Click_HC_Start() {
		driver.findElement(btn_HCInd_Start_xpath).click();
		wait(3);
	}
	
	public void PickLTHHMEnrolled() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLTReasonforRemoval() throws Exception {
		if (counterx == 1) {
			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			cppo.ClearPLReasonforRemoval();
			List<WebElement> lst_PNo = driver.findElements(By.xpath("//select/option"));
			for (int i = 0; i < lst_PNo.size(); i++) {
				String Pnoval = lst_PNo.get(i).getText();
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i + 1, 3, Pnoval);
				if (i == (lst_PNo.size() - 1)) {
					setData2("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i + 2, 3,
							lst_PNo.size());
					counterx++;
				}
			}
		}

	}
	
	
	//Is this an employer offered health care plan?
	public void Click_EmpOffer_HC(String val) throws Exception {
		
		driver.findElement(By.xpath("//label[contains(text(),'employer offered health care plan')]/following::span[contains(text(),'"+val+"')]")).click();
		Thread.sleep(700);
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPLMemEnroll();
		PickLTHHMEnrolled();
	}
	
	//To Enter the company name
	public void Enter_CompName(String Cname) throws InterruptedException {
		driver.findElement(txt_CompName_xpath).sendKeys(Cname);
		Thread.sleep(700);
	}
	
	// To Enter Address for company 
	public void EnterAddr(String Addr) throws IOException, InterruptedException {

		driver.findElement(txt_Addr_xpath).sendKeys(Addr);
		Thread.sleep(700);
		SelectAddress();
		//driver.findElement(txt_Addrval_xpath).click();
		Thread.sleep(700);
	}

	// To Enter Address Line 2 for company
	public void EnterAddrL2(String AddrL2) throws InterruptedException {

		driver.findElement(txt_AddrL2_xpath).sendKeys(AddrL2);
		Thread.sleep(700);
	}
	
	// To Enter Policy ID for company
	public void EnterPID(String pid) throws InterruptedException {

		driver.findElement(txt_PID_xpath).sendKeys(pid);
		Thread.sleep(700);
	}
	
	// To Enter Group ID for company
	public void EnterGID(String gid) throws InterruptedException {

		driver.findElement(txt_GID_xpath).sendKeys(gid);
		Thread.sleep(700);
	}
	
	// How is the household member enrolled in this plan?
	public void SelectHM_EnrldP(String val) throws InterruptedException {
		WebElement ele= driver.findElement(pck_HM_Enrdplan_xpath);
		try {
		Select s=new Select(ele);
		s.selectByVisibleText(val);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}
	
	//Who is the policy holder?
		public void SelectPH(String ph) throws IOException, InterruptedException {
			al = excelData.getData("TC1", "Reg-HealthCareCov", "Sno");
			driver.findElement(By.xpath("//div[text()='Who is the policy holder?']/following::span[contains(text(),'"+ph+"')]")).click();
			Thread.sleep(700);
			if(ph.contains("Someone outside my household")) {
				EnterFN(al.get(11));
				EnterMN(al.get(12));
				EnterLN(al.get(13));
				SelectSuffix(al.get(14));
			}
		}
		
		
		//Enter First name for Someone outside my household policy holder
		public void EnterFN(String fn) throws InterruptedException {
			driver.findElement(txt_FN_xpath).sendKeys(fn);
			Thread.sleep(700);
		}
		
		//Enter Middle name for Someone outside my household policy holder
		public void EnterMN(String mn) throws InterruptedException {
			driver.findElement(txt_MN_xpath).sendKeys(mn);
			Thread.sleep(700);
		}
		
		//Enter Last name for Someone outside my household policy holder
		public void EnterLN(String ln) throws InterruptedException {
			driver.findElement(txt_LN_xpath).sendKeys(ln);
			Thread.sleep(700);
		}
		
		//Enter suffix for Someone outside my household policy holder
		
		public void SelectSuffix(String suffix) throws InterruptedException {
			WebElement ele= driver.findElement(pck_Suffix_xpath);
			try {
			Select s = new Select(ele);
			s.selectByVisibleText(suffix);
			Thread.sleep(700);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
		}
		
	//Who is enrolled in this plan?
	public void SelectHMEnrolled() throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-HealthCareCov", "Sno");
		String[] val = al.get(15).trim().split(";");
		for (int i = 0; i < val.length; i++) {
		driver.findElement(By.xpath("//div[text()='Who is enrolled in this plan?']/following::span[text()='"+val[i]+"']")).click();
		Thread.sleep(700);
		}
	}
	
	//Clicking on Start for details for Policy Holder
	public void ClickStart_PH() throws IOException {
		driver.findElement(By.xpath("//p[text()='Policy Holder']/following::button[contains(text(),'Start')]")).click();
	wait(3);
	
	}
	
	//To Enter Name of employer for policy holder
	public void EnterNOE(String name) throws InterruptedException {

		driver.findElement(txt_NOE_xpath).sendKeys(name);
		Thread.sleep(700);
	}
	
	// To Enter Address for company 
	public void EnterAddrPH(String Addr) throws IOException, InterruptedException {

		driver.findElement(txt_AddrPH_xpath).sendKeys(Addr);
		Thread.sleep(700);
		SelectAddress();
		//driver.findElement(txt_AddrvalPH_xpath).click();
		Thread.sleep(700);
	}

	// To Enter Address Line 2 for company
	public void EnterAddrL2PH(String AddrL2) throws InterruptedException {

		driver.findElement(txt_AddrL2PH_xpath).sendKeys(AddrL2);
		Thread.sleep(700);
	}
	
	//To Enter Covered Individual details
	public void EnterCoveredInd(String Indvid) throws Exception {
		al = excelData.getData(Indvid, "Reg-HealthCareCov", "Sno");
		String[] name=al.get(1).trim().split(" ");
		String[] HC=al.get(2).trim().split(";");
		driver.findElement(By.xpath("//p[contains(text(),'"+name[0]+"')]/following::p[text()='Covered Individual']/following::button[contains(text(),'Start')]")).click();
		wait(3);
		for(int i=0;i<HC.length;i++) {
			driver.findElement(By.xpath("//span[text()='"+HC[i]+"']")).click();
			Thread.sleep(700);
		}
		
			driver.findElement(By.xpath("//span[text()='"+HC[0]+"']/following::label[text()='Coverage start date']/following::input")).sendKeys(al.get(3));
			Thread.sleep(700);
			scrollIntoView(driver.findElement(By.xpath("//span[text()='"+HC[1]+"']/following::label[text()='Coverage start date']/following::lightning-button-icon")));
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='"+HC[1]+"']/following::label[text()='Coverage start date']/following::input")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//button[@name='today']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='"+HC[1]+"']/following::label[text()='Coverage end date']/following::input")).sendKeys(al.get(4),Keys.ENTER);
			Thread.sleep(700);
			PickLTReasonforRemoval();
			WebElement ele= driver.findElement(By.xpath("//span[text()='"+HC[1]+"']/following::label[text()='Reason for removal']/following::select"));
			try {
			Select s=new Select(ele);
			s.selectByVisibleText(al.get(5));
			Thread.sleep(700);
			}
			catch(Throwable t) {
				PLvalidate(ele);
			}
			ClickSave();

	}
	
	
	//To click on Next button
    public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(5);
	}
    
	//To click on Save button
    public void ClickSave() {

		driver.findElement(btn_Save_xpath).click();
		wait(5);
	}
}
