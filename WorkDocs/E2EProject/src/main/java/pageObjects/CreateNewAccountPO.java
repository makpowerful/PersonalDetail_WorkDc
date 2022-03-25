package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class CreateNewAccountPO extends base {

	public WebDriver driver;

	By txt_FirstName_xpath = By.xpath("//*[contains(text(),'First Name')]/following-sibling::div/input");
	By txt_MiddleName_xpath = By.xpath("//*[contains(text(),'Middle Name')]/following-sibling::div/input");
	By txt_LastName_xpath = By.xpath("//*[contains(text(),'Last Name')]/following-sibling::div/input");
	By Drp_Suffix_xpath = By.xpath("//div/select");
	By Drp_Dob_xpath = By.xpath("//*[contains(text(),'Date of Birth')]/following-sibling::div/input");

	// Connecting to Your Benefits
	By Btn_Yes_xpath = By.xpath("//input[@name = 'input-2']/following-sibling::label/span[contains(text(),'Yes')]");
	By Btn_No_xpath = By.xpath("//input[@name = 'input-2']/following-sibling::label/span[contains(text(),'No')]");
	By txt_SSN_xpath = By.xpath("//label[text()='Social Security Number']/following-sibling::div/input");
	By txt_CfmSSN_xpath = By.xpath("//label[text()='Confirm Social Security Number']/following-sibling::div/input");
	By txt_ClientIdNo_xpath = By.xpath("//*[contains(text(),'Client')]/following-sibling::div/input");
	By txt_Email_xpath = By.xpath("//label[text()='Email']/following-sibling::div/input");
	By txt_CfmEmail_xpath = By.xpath("//label[text()='Confirm Email']/following-sibling::div/input");

	// Would you like to receive electronic notifications instead of via standard
	// paper mail?
	By Btn_Yes2_xpath = By.xpath("//input[@name = 'input-3']/following-sibling::label/span[contains(text(),'Yes')]");
	By Btn_No2_xpath = By.xpath("//input[@name = 'input-3']/following-sibling::label/span[contains(text(),'No')]");

	// Please choose the method by which you would like to receive notifications of
	// communications.
	By Rdo_EmailOnly_xpath = By.xpath("//*[contains(text(),'Email only')]//preceding-sibling::span");
	By Rdo_EmailAndText_xpath = By.xpath("//*[contains(text(),'Email and Text')]//preceding-sibling::span");

	// Terms Of Agreement
	By Rdo_TermsOfAgree_xpath = By.xpath("//*[contains(text(),'Read and agree to Terms of Agreement')]");

	By Rdo_TermsAndCond_xpath = By.xpath("//*[contains(text(),'Read and agree to Paperless Terms')]");

	By Btn_IAgreeTOA_xpath = By.xpath("//*[contains(text(),'I agree')]");
	By Btn_IAgreeTAC_xpath = By.xpath("//button[contains(text(),'I agree')]");

	By Btn_Exit_xpath = By.xpath("//*[contains(text(),'Exit')]");
	By Btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	// No Match Modal
	By Btn_Review_xpath = By.xpath("//*[contains(text(),'Review Information')]");
	By Btn_Continue_xpath = By.xpath("//*[contains(text(),'Continue Without Review')]");

	public CreateNewAccountPO(WebDriver driver) {

		this.driver = driver;
	}

	public void EnterFirstName(String firstName) throws IOException {

		driver.findElement(txt_FirstName_xpath).sendKeys(firstName);
	}

	public void EnterMiddleName(String middleName) throws IOException {

		driver.findElement(txt_MiddleName_xpath).sendKeys(middleName);
	}

	public void EnterLastName(String lastName) throws IOException, InterruptedException {

		driver.findElement(txt_LastName_xpath).sendKeys(lastName);
		Thread.sleep(1200);
	}

	public void SelectSuffix(String suffix) throws IOException {

		Select select = new Select(driver.findElement(Drp_Suffix_xpath));
		select.selectByValue(suffix);
	}

	public void EnterDOB(String dob) throws IOException, InterruptedException {

		driver.findElement(Drp_Dob_xpath).sendKeys(dob);
		Thread.sleep(1200);
	}

	public void Click_Toggle1(String yesNo) throws InterruptedException {

		if (yesNo.equals("Yes"))
			driver.findElement(Btn_Yes_xpath).click();
		else if (yesNo.equals("No"))
			driver.findElement(Btn_No_xpath).click();
		Thread.sleep(1200);
	}

	public void EnterSSN(String ssn) throws IOException {

		driver.findElement(txt_SSN_xpath).sendKeys(ssn);
	}

	public void EnterCfmSSN(String ssn) throws IOException {

		driver.findElement(txt_CfmSSN_xpath).sendKeys(ssn);
	}

	public void EnterClientIdno(String clientId) throws IOException, InterruptedException {

		driver.findElement(txt_ClientIdNo_xpath).sendKeys(clientId);
		Thread.sleep(1200);
	}

	public void EnterEmail(String email) throws IOException {

		driver.findElement(txt_Email_xpath).sendKeys(email);
	}

	public void EnterCfmEmail(String email) throws IOException, InterruptedException {

		driver.findElement(txt_CfmEmail_xpath).sendKeys(email);
		Thread.sleep(1200);
	}

	public void Click_Toggle2(String yesNo) throws InterruptedException {

		if (yesNo.equals("Yes"))
			driver.findElement(Btn_Yes2_xpath).click();
		else if (yesNo.equals("No"))
			driver.findElement(Btn_No2_xpath).click();
		Thread.sleep(1200);
	}

	public void Click_PreferredMethod(String method) throws InterruptedException {

		if (method.equals("Email only"))
			driver.findElement(Rdo_EmailOnly_xpath).click();
		else if (method.equals("Email and Text Message"))
			driver.findElement(Rdo_EmailAndText_xpath).click();
		Thread.sleep(1200);
	}

	public void Click_TermsOfAgreement() throws InterruptedException {

		driver.findElement(Rdo_TermsOfAgree_xpath).click();
		Scrollpopup("//span/br[6]");
		Thread.sleep(1000);
		Click_TOA_IAgree();
		Thread.sleep(1200);
	}

	public void Click_TOA_IAgree() throws InterruptedException {

		driver.findElement(Btn_IAgreeTOA_xpath).click();
	}

	public void Click_TermsANDCondition() throws InterruptedException {

		driver.findElement(Rdo_TermsAndCond_xpath).click();
		Scrollpopup("//slot/div/br[20]");
		Thread.sleep(1000);
		Click_TAC_IAgree();
		Thread.sleep(1200);
	}

	public void Click_TAC_IAgree() throws InterruptedException {

		driver.findElement(Btn_IAgreeTAC_xpath).click();
	}

	public void Click_Next() throws InterruptedException {

		driver.findElement(Btn_Next_xpath).click();
		Thread.sleep(2000);
	}

	public void Click_Exit() throws InterruptedException {

		driver.findElement(Btn_Exit_xpath).click();
		Thread.sleep(1200);
	}

	public void Click_ContinueWithoutReview() throws InterruptedException {

		driver.findElement(Btn_Continue_xpath).click();
		Thread.sleep(1200);
	}

	public void Click_ReviewInformation() throws InterruptedException {

		driver.findElement(Btn_Review_xpath).click();
		Thread.sleep(1200);
	}
}
