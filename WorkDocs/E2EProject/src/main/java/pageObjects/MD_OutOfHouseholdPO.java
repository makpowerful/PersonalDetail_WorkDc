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

public class MD_OutOfHouseholdPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By lbl_ooh_xpath = By.xpath("//p");
	By btn_Start_xpath = By.xpath("//button[contains(text(),'Start')]");
	By txt_FN_xpath = By.xpath("//label[contains(text(),'First Name')]/following-sibling::div/input");
	By chkbx_MN_xpath = By.xpath("//label[contains(text(),'Middle Name')]/following-sibling::div/input");
	By txt_LN_xpath = By.xpath("//label[contains(text(),'Last Name')]/following-sibling::div/input");
	By pck_Suffix_xpath = By.xpath("//select[@title='Click here to see suffix options.']");
	By pck_Gender_xpath = By.xpath("//select[@title='Click here to see gender options.']");
	By dt_DOB_xpath = By.xpath("//label[contains(text(),'Date of Birth')]/following-sibling::div/input");
	By txt_SSN_xpath = By.xpath("//label[starts-with(text(),'Social Security Number')]//following-sibling::div/input");

	By btn_DSER_Yes_xpath = By.xpath("//span[contains(text(),'Yes')]");
	By btn_DSER_No_xpath = By.xpath("//span[contains(text(),'No')]");
	By btn_Deceased_Yes_xpath = By.xpath(
			"//*[contains(text(),'parent deceased?')]//following-sibling::div//label/span[contains(text(),'Yes')]");
	By btn_Deceased_No_xpath = By.xpath(
			"//*[contains(text(),'parent deceased?')]//following-sibling::div//label/span[contains(text(),'No')]");
	By dt_DOD_xpath = By.xpath("//label[contains(text(),'Date of Death')]/following-sibling::div/input");
	By pck_State_xpath = By.xpath("//label[contains(text(),'born?')]/following-sibling::div/input");
	By btn_Conceived_Yes_xpath = By.xpath(
			"//*[contains(text(),'conceived in Maine?')]//following-sibling::div//label/span[contains(text(),'Yes')]");
	By btn_Conceived_No_xpath = By.xpath(
			"//*[contains(text(),'conceived in Maine?')]//following-sibling::div//label/span[contains(text(),'No')]");
	By btn_ChildSupport_Yes_xpath = By.xpath(
			"//*[contains(text(),'child support?')]//following-sibling::div//label/span[contains(text(),'Yes')]");
	By btn_ChildSupport_No_xpath = By
			.xpath("//*[contains(text(),'child support?')]//following-sibling::div//label/span[contains(text(),'No')]");
	By btn_CourtOrder_Yes_xpath = By.xpath(
			"//*[contains(text(),'support order?')]//following-sibling::div//label/span[contains(text(),'Yes')]");
	By btn_CourtOrder_No_xpath = By
			.xpath("//*[contains(text(),'support order?')]//following-sibling::div//label/span[contains(text(),'No')]");
	By btn_JointCustody_Yes_xpath = By.xpath(
			"//*[contains(text(),'joint custody?')]//following-sibling::div//label/span[contains(text(),'Yes')]");
	By btn_JointCustody_No_xpath = By
			.xpath("//*[contains(text(),'joint custody?')]//following-sibling::div//label/span[contains(text(),'No')]");
	By chk_ParentInfo_xpath = By.xpath("//lightning-input/div/span/label/span[1]");
	By btn_Save_xpath = By.xpath("//button[text()='Save']");
	By btn_Cancel_xpath = By.xpath("//button[text()='Cancel']");
	By btn_Next_xpath = By.xpath("//button[text()='Next']");

	public MD_OutOfHouseholdPO(WebDriver driver) {

		this.driver = driver;
	}

	public void Click_Start() throws InterruptedException {

		driver.findElement(btn_Start_xpath).click();
		Thread.sleep(1000);
	}

	public void EnterFN(String fn) throws InterruptedException {
		driver.findElement(txt_FN_xpath).clear();
		driver.findElement(txt_FN_xpath).sendKeys(fn);
		Thread.sleep(1000);
	}

	public void EnterMN(String mn) throws InterruptedException {

		driver.findElement(chkbx_MN_xpath).clear();
		driver.findElement(chkbx_MN_xpath).sendKeys(mn);
		Thread.sleep(1000);
	}

	public void EnterLN(String ln) throws InterruptedException {
		driver.findElement(txt_LN_xpath).clear();
		driver.findElement(txt_LN_xpath).sendKeys(ln);
		Thread.sleep(1000);
	}

	public void Select_Suffix(String sfx) throws InterruptedException {

		if (sfx.contains("null")) {
			log.info(" Individual does not have Suffix");
		} else {
			Select suffix = new Select(driver.findElement(pck_Suffix_xpath));
			suffix.selectByVisibleText(sfx);
		}
	}

	public void Select_Gender(String gender) {

		Select Gen = new Select(driver.findElement(pck_Gender_xpath));
		Gen.selectByVisibleText(gender);
	}

	public void EnterDob(String dob) {

		WebElement ele = driver.findElement(dt_DOB_xpath);
		if (ele.isEnabled()) {
			ele.sendKeys(dob);
		} else {
			log.info("DOB field is not enabled");
		}
	}

	public void Enter_SSN(String ssn) {

		if (ssn.contains("null")) {
			log.info(" Individual does not have Suffix");
		} else {
			driver.findElement(txt_SSN_xpath).sendKeys(ssn); // Enter SSN
		}
	}

	public void Click_DSER(String value) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(btn_DSER_Yes_xpath).click();

		} else {
			driver.findElement(btn_DSER_No_xpath).click();
		}
		Thread.sleep(1000);
	}

	public void Click_ParentInfo() throws InterruptedException {

		driver.findElement(chk_ParentInfo_xpath).click();
		Thread.sleep(1000);
	}

	public void Click_ParentDeceased(String value, String dod) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(btn_Deceased_Yes_xpath).click();
			EnterDoD(dod);

		} else {
			driver.findElement(btn_Deceased_No_xpath).click();
		}
		Thread.sleep(1000);
	}

	public void EnterDoD(String dob) throws InterruptedException {

		driver.findElement(dt_DOD_xpath).sendKeys(dob);
		Thread.sleep(1000);

	}

	public void Enter_State(String value) throws InterruptedException {

		driver.findElement(pck_State_xpath).sendKeys(value);
		driver.findElement(By.xpath("//ul/li/div[contains(text(),'" + value + "')]")).click();
		Thread.sleep(1000);

	}

	public void Click_Conceived(String value) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes"))
			driver.findElement(btn_Conceived_Yes_xpath).click();
		else
			driver.findElement(btn_Conceived_No_xpath).click();
	}

	public void Click_ChildSupport(String value) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes"))
			driver.findElement(btn_ChildSupport_Yes_xpath).click();
		else
			driver.findElement(btn_ChildSupport_No_xpath).click();
	}

	public void Click_CourtOrder(String value) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes"))
			driver.findElement(btn_CourtOrder_Yes_xpath).click();
		else
			driver.findElement(btn_CourtOrder_No_xpath).click();
	}

	public void Click_JointCustody(String value) throws InterruptedException {

		if (value.equalsIgnoreCase("Yes"))
			driver.findElement(btn_JointCustody_Yes_xpath).click();
		else
			driver.findElement(btn_JointCustody_No_xpath).click();

	}

	public void Click_Save() throws InterruptedException {

		driver.findElement(btn_Save_xpath).click();
		Thread.sleep(4000);
	}

	public void Click_Cancel() throws InterruptedException {

		driver.findElement(btn_Cancel_xpath).click();
		Thread.sleep(1000);
	}

	public void Click_Next() throws InterruptedException {

		driver.findElement(btn_Next_xpath).click();
		Thread.sleep(1000);
	}

	public void Enter_OOHdetails_Reg(String TCid) throws InterruptedException, IOException {
		String LblH = driver.findElement(lbl_ooh_xpath).getText();
		if (LblH.contains("Out of Household Parent")) {
			al = excelData.getData(TCid, "Reg-MD-OutofHHParnt", "Sno");
			Click_Start();
			if (al.get(17).equalsIgnoreCase("Yes"))
				Click_ParentInfo();
			else {
				EnterFN(al.get(2));
				EnterMN(al.get(3));
				EnterLN(al.get(4));
				Select_Suffix(al.get(5));
				Select_Gender(al.get(6));
				EnterDob(al.get(7));
				Enter_SSN(al.get(8));
				Click_DSER(al.get(9));
				if (al.get(9).equalsIgnoreCase("Yes")) {
					Click_Save();
				} else {
					Click_ParentDeceased(al.get(10), al.get(16));
					Enter_State(al.get(11));
					Click_Conceived(al.get(12));
					Click_ChildSupport(al.get(13));
					Click_CourtOrder(al.get(14));
					Click_JointCustody(al.get(15));

				}
			}
			Click_Save();

			if (al.get(18).equalsIgnoreCase("Yes")) {
				Click_Start();
				Click_ParentInfo();
				Click_Save();
			} else {
				System.out.println("Only on record is displayed");
			}
			Click_Next();
		} else {
			System.out.println("Out of Household Information not available");
		}
	}
}
