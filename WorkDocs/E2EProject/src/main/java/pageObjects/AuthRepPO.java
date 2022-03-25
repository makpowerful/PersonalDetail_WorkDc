package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class AuthRepPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	private By btn_AuthRep_xpath = By.xpath("//button[@title='Start Authorized Representatives']");
	private By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	private By btn_Add_AuthRep_xpath = By.xpath("//button[text()='Add an Authorized Representative']");
	private By txt_FN_xpath = By.xpath("//lightning-input/label[contains(text(),'First Name')]/following::input");
	private By txt_MN_xpath = By.xpath("//lightning-input/label[contains(text(),'Middle name')]/following::input");
	private By txt_LN_xpath = By.xpath("//lightning-input/label[contains(text(),'Last Name')]/following::input");
	private By drp_Suffix_xpath = By.xpath("//select");
	private By txt_Email_xpath = By.xpath("//lightning-input/label[contains(text(),'Email')]/following::input");
	private By txt_PhoneN_xpath = By.xpath("//lightning-input/label[contains(text(),'Phone number')]/following::input");
	private By txt_Ext_xpath = By.xpath("//lightning-input/label[contains(text(),'Ext.')]/following::input");
	private By txt_OrgName_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Organization Name')]/following::input");
	private By txt_OrgId_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Organization ID')]/following::input");
	private By Asrt_Header_xpath = By.xpath("//h1");
	private By drp_P_Reltn_xpath = By.xpath("//select");
	private By txt_Addr_xpath = By.xpath("//label[text()='Address']/following::div/input");
	private By txt_Addrval_xpath = By.xpath("//span/span");
	private By txt_AddrL2_xpath = By.xpath("//label[text()='Address Line 2']/following::div/input");
	private By txt_Other_PD_xpath = By.xpath("//label[text()='Please describe']/following::div/input");
	private By Asrt_Header_Authconsent_xpath = By.xpath("//h1[text()='Authorized Representative Consent']");
	private By txt_Consent_FN_xpath = By
			.xpath("//lightning-input/label[contains(text(),'First Name')]/following::input");
	private By txt_Consent_MN_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Middle Name')]/following::input");
	private By txt_Consent_LN_xpath = By
			.xpath("//h2[text()='Primary Applicant Consent']/following::label[contains(text(),'Last Name')]/following::input");
	private By drp_Consent_Suffix_xpath = By.xpath("//h2[text()='Primary Applicant Consent']/following::select");
	private By txt_Consent_AR_FN_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Authorized Representative First Name')]/following::input");
	private By txt_Consent_AR_MN_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Authorized Representative Middle Name')]/following::input");
	private By txt_Consent_AR_LN_xpath = By
			.xpath("//lightning-input/label[contains(text(),'Authorized Representative Last Name')]/following::input");
	private By drp_Consent_AR_Suffix_xpath = By
			.xpath("//h2[text()='Authorized Representative Consent']/following::select");
	private By btn_Submit_AR_xpath= By.xpath("//button[text()='Submit Authorized Representative']");

	public AuthRepPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickAuthRepTile() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,550);");
		Thread.sleep(2000);
		driver.findElement(btn_AuthRep_xpath).click();
	}

	// To click on Add an Authorized Representative button
	public void ClickAddAuthRep() {

		driver.findElement(btn_Add_AuthRep_xpath).click();
	}

	// To Enter First Name for Authorized Representative
	public void AuthRep_EnterFN(String fn) throws InterruptedException {
		WebElement Wb_fn = driver.findElement(txt_FN_xpath);
		// clickButton(Wb_fn);
		Wb_fn.sendKeys(fn);
		Thread.sleep(700);
	}

	// To Enter Middle Name for Authorized Representative
	public void AuthRep_EnterMN(String mn) throws InterruptedException {

		driver.findElement(txt_MN_xpath).sendKeys(mn);
		Thread.sleep(700);
	}

	// To Enter Last Name for Authorized Representative
	public void AuthRep_EnterLN(String ln) throws InterruptedException {

		driver.findElement(txt_LN_xpath).sendKeys(ln);
		Thread.sleep(700);
	}

	// To Select Suffix for Authorized Representative
	public void SelectSuffix(String suffix) throws InterruptedException {
		WebElement ele= driver.findElement(drp_Suffix_xpath);
		try {
		Select s = new Select(ele);
		s.selectByVisibleText(suffix);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	// To Enter Email for Authorized Representative
	public void AuthRep_EnterEmail(String email) throws InterruptedException {

		driver.findElement(txt_Email_xpath).sendKeys(email);
		Thread.sleep(700);
	}

	// To Enter Phone Number for Authorized Representative
	public void AuthRep_EnterPhoneN(String pn) throws InterruptedException {

		driver.findElement(txt_PhoneN_xpath).sendKeys(pn);
		Thread.sleep(700);
	}

	// To Enter Phone Number for Authorized Representative
	public void AuthRep_EnterPhoneNext(String ext) throws InterruptedException {

		driver.findElement(txt_Ext_xpath).sendKeys(ext);
		Thread.sleep(700);
	}

	// Does this authorized representative work for an organization that provides
	// you assistance?
	public void Select_Togle_provides_you_assistance(String val) {

		driver.findElement(
				By.xpath("//label[contains(text(),'provides you assistance?')]//following::span[text()='" + val + "']"))
				.click();
	}

	// To Enter Organization Name for Authorized Representative
	public void AuthRep_EnterOrgName(String orgn) throws InterruptedException {

		driver.findElement(txt_OrgName_xpath).sendKeys(orgn);
		Thread.sleep(700);
	}

	// To Enter Organization Id for Authorized Representative
	public void AuthRep_EnterOrgId(String orgid) throws InterruptedException {

		driver.findElement(txt_OrgId_xpath).sendKeys(orgid);
		Thread.sleep(700);
	}

	// To Assert screen navigation to Authorized Representative permission screen
	public String AuthRep_H_Permsn() throws InterruptedException {

		String Assert_AuthRep_H_Permsn = driver.findElement(Asrt_Header_xpath).getText();
		Thread.sleep(700);
		return Assert_AuthRep_H_Permsn;
	}

	public void PickLRelated() throws Exception {
		List<WebElement> lst_Related = driver.findElements(By.xpath("//select/option"));
		for (int i = 0; i < lst_Related.size(); i++) {
			String Relaval = lst_Related.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i + 1, 1, Relaval);
			if (i == (lst_Related.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i + 2, 1,
						lst_Related.size());
			}
		}
	}
	
	public void PickLPermissions() throws Exception {
		List<WebElement> lst_Permis = driver.findElements(By.xpath("//p[contains(text(),'indicate the access to be granted')]/following::p[@class='ssp-color_monoBody ssp-labelLine1']"));
		for (int i = 0; i < lst_Permis.size(); i++) {
			String Permival = lst_Permis.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i + 1, 3, Permival);
			if (i == (lst_Permis.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i + 2, 3,
						lst_Permis.size());
			}
		}
	}
	// To Select Relation for Authorized Representative with person
	public void SelectPer_Relatn(String relation) throws Exception {
		WebElement ele= driver.findElement(drp_P_Reltn_xpath);
		try {
		Select s = new Select(driver.findElement(drp_P_Reltn_xpath));
		s.selectByVisibleText(relation);
		Thread.sleep(700);
		PickLRelated();	
		PickLPermissions();
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	// To Enter Address for Authorized Representative
	public void EnterAddr(String Addr) throws IOException, InterruptedException {

		driver.findElement(txt_Addr_xpath).sendKeys(Addr);
		Thread.sleep(700);
		//driver.findElement(txt_Addrval_xpath).click();
		SelectAddress();
		Thread.sleep(700);
	}

	// To Enter Address Line 2 for Authorized Representative
	public void EnterAddrL2(String AddrL2) throws InterruptedException {

		driver.findElement(txt_AddrL2_xpath).sendKeys(AddrL2);
		Thread.sleep(700);
	}

	// To Add Permission for Authorized Representative
	public void AuthRep_Permsns() throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-AuthRep", "Sno");
		String[] pvalue = al.get(14).trim().split(";");
		for (int i = 0; i < pvalue.length; i++) {
			// scrollIntoView(driver.findElement(By.xpath("//p[text()='"+pvalue[i]+"']")));
			// System.out.println(pvalue[i]);
			// ClickOn(By.xpath("//p[text()='"+pvalue[i]+"']"));
			driver.findElement(By.xpath("//p[text()='" + pvalue[i] + "']/following::input")).click();
			Thread.sleep(700);
			if (pvalue[i].equalsIgnoreCase("Other")) {

				driver.findElement(txt_Other_PD_xpath).sendKeys(al.get(15).toString());
			}
		}

	}

	// To Assert screen navigation to Authorized Representative permission screen
	public String AuthRepConsent_H_Permsn() throws InterruptedException {

		String Assert_AuthRepC_H_Permsn = driver.findElement(Asrt_Header_Authconsent_xpath).getText();
		Thread.sleep(700);
		return Assert_AuthRepC_H_Permsn;
	}

	// To Enter First Name for Consent Authorized Representative Primary
	public void AuthRepConsent_Pri_EnterFN(String fn) throws InterruptedException {
		WebElement Wb_fn = driver.findElement(txt_Consent_FN_xpath);
		// clickButton(Wb_fn);
		Wb_fn.sendKeys(fn);
		Thread.sleep(700);
	}

	// To Enter Middle Name for Consent Authorized Representative Primary
	public void AuthRepConsent_Pri_EnterMN(String mn) throws InterruptedException {

		driver.findElement(txt_Consent_MN_xpath).sendKeys(mn);
		Thread.sleep(700);
	}

	// To Enter Last Name for Consent Authorized Representative Primary
	public void AuthRepConsent_Pri_EnterLN(String ln) throws InterruptedException {

		driver.findElement(txt_Consent_LN_xpath).sendKeys(ln);
		Thread.sleep(700);
	}

	// To Select Suffix for Consent Authorized Representative Primary
	public void SelectSuffix_Pri(String suffix) throws InterruptedException {
		WebElement ele= driver.findElement(drp_Consent_Suffix_xpath);
		try {
		Select s = new Select(driver.findElement(drp_Consent_Suffix_xpath));
		s.selectByVisibleText(suffix);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	// To Enter First Name for Authorized Representative Consent
	public void AuthRepConsent_EnterFN(String fn) throws InterruptedException {
		WebElement Wb_fn = driver.findElement(txt_Consent_AR_FN_xpath);
		// clickButton(Wb_fn);
		Wb_fn.sendKeys(fn);
		Thread.sleep(700);
	}

	// To Enter Middle Name for Authorized Representative Consent
	public void AuthRepConsent_EnterMN(String mn) throws InterruptedException {

		driver.findElement(txt_Consent_AR_MN_xpath).sendKeys(mn);
		Thread.sleep(700);
	}

	// To Enter Last Name for Authorized Representative Consent
	public void AuthRepConsent_EnterLN(String ln) throws InterruptedException {

		driver.findElement(txt_Consent_AR_LN_xpath).sendKeys(ln);
		Thread.sleep(700);
	}

	// To Select Suffix for Authorized Representative Consent
	public void SelectSuffixConsent(String suffix) throws InterruptedException {
		WebElement ele= driver.findElement(drp_Consent_AR_Suffix_xpath);
		try {
		Select s = new Select(driver.findElement(drp_Consent_AR_Suffix_xpath));
		s.selectByVisibleText(suffix);
		Thread.sleep(700);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}
	
	// To Click on Submit Authorized Representative Button
	public void ClickSubmitAR() {

		driver.findElement(btn_Submit_AR_xpath).click();
		wait(5);
	}

	// To Click on Next Button
	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(3);
	}
	
	// To Click on Next Button
	public void ClickNext2() throws InterruptedException {
        checkPageReady();
		driver.findElement(btn_Next_xpath).click();
		wait(3);
	}
	
	
}
