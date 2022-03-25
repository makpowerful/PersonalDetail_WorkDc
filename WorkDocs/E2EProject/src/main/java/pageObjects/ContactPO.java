package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class ContactPO extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ContactPO.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al1 = new ArrayList<String>();

	By btn_StartHHM1_xpath = By.xpath("//div/div[2]/span");
	By rdbtn_Email_xpath = By.xpath(
			"//div[@class='ssp-radioWidth']/lightning-radio-group/fieldset/div/span/label/span[2][contains(text(),'Electronic - Email')]");// "//span[2]");
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_SameAdd_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span/label/span[contains(text(),'Yes')]");// "//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span/label");
	By btn_StartHHM2_xpath = By.xpath("//li[2]/div/div[2]/span");
	By chk_SameAddasPri_xpath = By.xpath("//label/span");
		//	"//*[contains(text(),'household have the same address information?')]/following::span[contains(text(),'Yes')]");
	// "//label/span");
	By chk_SameAddasPriNo = By.xpath(
			"//*[contains(text(),'household have the same address information?')]/following::span[contains(text(),'No')]");
	By pck_PrefLangHHM2_xpath = By.xpath("//div[6]/div/c-ssp-base-component-input-picklist/div/select");
	By primaryPhoneType_picklist = By.xpath("//select[@title='Click here to see primary phone types']");
	By primaryPhoneNumber_input = By.xpath("//*[contains(text(),'Primary Phone Number')]/following::input[1]");
	By secondaryPhoneTypepicklist = By.xpath("//select[@title='Click here to see secondary phone types']");
	By secondaryPhoneNumber_input = By.xpath("//*[contains(text(),'Secondary Phone Number')]/following::input[1]");
	By preferredContactToggleYes = By.xpath(
			"//*[contains(text(),'Can we send text messages to this cell phone? (Standard data rates may apply)')]/following::span/label/span[contains(text(),'Yes')]");
	By preferredContactToggleNo = By.xpath(
			"//*[contains(text(),'Can we send text messages to this cell phone? (Standard data rates may apply)')]/following::span/label/span[contains(text(),'No')]");
	By contactMethodRadio = By.xpath("");
	By preferredLanguagePicklist = By.xpath("//select[@title='Click here to see available languages']");
	By txt_Add_xpath = By.xpath(
			"//c-ssp-base-component-input-text[@data-id='PhysicalAddressLine1__c']/div/div/lightning-input/div/input");// "//c-ssp-address-auto-complete[@class='ssp-address1']/div/div[1]

	By drp_Add_xpath = By.xpath("//span/span");
	By physicalAddressYesToggle = By
			.xpath("//*[contains(text(),'have a physical address?')]/following::span[contains(text(),'Yes')][1]");
	By physicalAddressNoToggle = By
			.xpath("//*[contains(text(),'have a physical address?')]/following::span[contains(text(),'No')][1]");

	By mailingAddressYesToggle = By.xpath(
			"//*[contains(text(),' have a different mailing address?')]/following::span[contains(text(),'Yes')][1]");
	By mailingAddressNoToggle = By.xpath(
			"//*[contains(text(),' have a different mailing address?')]/following::span[contains(text(),'No')][1]");
	By mailingAddressInput = By.xpath("//*[contains(text(),'Mailing Address')]/following::div/input");
	By contactSection = By.xpath("//div[@class='slds-m-vertical_medium ssp-summary-sections'][3] //ul");
	By sameContactInfoCheck = By
			.xpath("//input[@type='checkbox']/following::span[contains(text(),'the same contact information as')]");
	By cityTownPicklist = By
			.xpath("//div[@class='slds-col slds-size_1-of-1 slds-large-size_6-of-12 ssp-PAdd-citytown'] //ul/li/div");
	By cityTownInput = By.xpath("//label[contains(text(),'city/town')]//following::input[1]");
	By addressDropdown = By.xpath(
			"//div[@class='slds-grid slds-wrap slds-dropdown_length-with-icon-7 slds-dropdown_fluid ssp-address-dropdown'] //ul/li/div/span");
	By sameAddressInfo = By
			.xpath("//input[@type='checkbox']/following::span[contains(text(),'has the same address information')]");
	By rdbtn_preferredContact_xpath = By
			.xpath("//div[@class='ssp-radioWidth']/lightning-radio-group/fieldset/div/span/label/span");// "//span[2]");

	By addressInformationLabel = By.xpath("//p[contains(text(),'Address Information')]");
	public By contactInformationLabel = By.xpath("//p[contains(text(),'Contact Information')]");

//public WebElement element2= driver.findElement(contactInformationLabel);
	public ContactPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public String getContactInfo() {
		String element2 = "";
		if (isDisplayed(contactInformationLabel)) {
			WebElement element = driver.findElement(contactInformationLabel);
			System.out.println(element.getText());
			element2 = element.getText();
			return element2;
		} else {
			return element2;
		}
	}

	public void ClickStartHHM1() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		ClickOn(btn_StartHHM1_xpath);
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearContactDetails();
	}

	public void ClickEmailRdbtn() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,850);");
		Thread.sleep(1000);
		driver.findElement(rdbtn_Email_xpath).click();
	}

	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
	}

	public void ClickSameAddYes() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,850);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_SameAdd_xpath).click();
	}

	public void ClickStartHHM2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,450);");
		Thread.sleep(1000);
		/*
		 * Thread.sleep(1000); driver.findElement(btn_StartHHM2_xpath).click()
		 */
		ClickOn(btn_StartHHM2_xpath);

	}

	public void ClickSameAsPriChk(String checkSameAddress) throws InterruptedException {
		if (checkSameAddress.equalsIgnoreCase("Yes")) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,850);");
			Thread.sleep(1000);
			driver.findElement(chk_SameAddasPri_xpath).click();
			Thread.sleep(500);
		}
	}

	public void SelectPrefLangHHM2() {

		Select pf = new Select(driver.findElement(pck_PrefLangHHM2_xpath));
		pf.selectByVisibleText("English");
	}

	/*
	 * **************************Regression Suite methods
	 *******************************/
	public WebElement getPrimaryPhoneType_picklist() {
		WebElement element = driver.findElement(primaryPhoneType_picklist);
		return element;
	}

	public void setPrimaryPhoneType_picklist(String phoneType) throws Exception {

		WebElement element = driver.findElement(primaryPhoneType_picklist);
		if (element.isEnabled()) {
			Select selPhone = new Select(element);
			selPhone.selectByVisibleText(phoneType);
			Thread.sleep(1000);
		} else {
			log.info("Element is disabled");
		}

	}

	public WebElement getPrimaryPhoneNumber_input() {

		return driver.findElement(primaryPhoneNumber_input);
	}

	public void setPrimaryPhoneNumber_input(String primaryPhoneNumber_input) throws Exception {
		if (getPrimaryPhoneNumber_input().isEnabled()) {
			getPrimaryPhoneNumber_input().sendKeys(primaryPhoneNumber_input);
			Thread.sleep(1000);
		} else {
			log.info("Primary Phone Number is disabled");
		}

	}

	public WebElement getSecondaryPhoneType_picklist() {
		return driver.findElement(secondaryPhoneTypepicklist);
	}

	public void setSecondaryPhoneType_picklist(String secondaryPhoneType_picklist, String TCid) throws Exception {

		al = excelData.getData(TCid, "R_ContactInformation", "Sno");
		String getValue = al.get(6).toString();
		if (getValue.equalsIgnoreCase("null")) {
			log.info("SecondaryPhoneType is not displayed");
		} else {
			Select secPhoneType = new Select(getSecondaryPhoneType_picklist());
			secPhoneType.selectByVisibleText(secondaryPhoneType_picklist);
		}
	}

	public WebElement getSecondaryPhoneNumber_input() {
		return driver.findElement(secondaryPhoneNumber_input);
	}

	public void setSecondaryPhoneNumber_input(String secondaryPhoneNumberinput, String TCid) throws Exception {

		al = excelData.getData(TCid, "R_ContactInformation", "Sno");
		String getValue = al.get(7).toString();
		if (getValue.equalsIgnoreCase("null")) {
			log.info("Secondary phone number not displayed");
		} else {
			getSecondaryPhoneNumber_input().sendKeys(secondaryPhoneNumberinput);
		}
	}

	public void setPreferredContactToggle(String toggleValue) throws Exception {

		if (toggleValue.equalsIgnoreCase("Yes")) {
			driver.findElement(preferredContactToggleYes).click();
		} else if (toggleValue.equalsIgnoreCase("No")) {
			driver.findElement(preferredContactToggleNo).click();

		} else {
			log.info("Can we send text messages to this cell phone? - Toggle question is not displayed");
		}

	}

	public WebElement getPreferredLanguagePicklist() {
		return driver.findElement(preferredLanguagePicklist);
	}

	public void setPreferredLanguagePicklist(String preferredLanguage) throws Exception {

		Select select = new Select(getPreferredLanguagePicklist());
		select.selectByVisibleText(preferredLanguage);
		Thread.sleep(1000);
	}

	public void setPhysicalAddressToggle(String toggleValue) throws Exception {
		if (toggleValue.equalsIgnoreCase("Yes")) {
			driver.findElement(physicalAddressYesToggle).click();
			log.info("Does Individual has Physical Address - Yes");

		} else if (toggleValue.equalsIgnoreCase("No")) {
			driver.findElement(physicalAddressNoToggle).click();
			log.info("Does Individual has Physical Address - No");

		}

	}

	public void setPhysicalAddressPrimaryIndv(String address) throws Exception {
		if (isDisplayed(txt_Add_xpath)) {
			driver.findElement(txt_Add_xpath).clear();
			driver.findElement(txt_Add_xpath).sendKeys(address);
			Thread.sleep(1000);
			driver.findElement(drp_Add_xpath).click();
			// selectAddressfromDropdown(address);
			Thread.sleep(1000);
		} else {
			log.info(" Field is not displayed/enabled");
		}
	}

	public void setMailingAddressToggle(String toggleValue) throws Exception {

		if (isDisplayed(mailingAddressYesToggle) && driver.findElement(mailingAddressYesToggle).isEnabled()) {
			if (toggleValue.equalsIgnoreCase("Yes")) {
				// driver.findElement(mailingAddressYesToggle).click();
				ClickOn(mailingAddressYesToggle);
				log.info("Mailing Address - Yes");
			} else {
				driver.findElement(mailingAddressNoToggle).click();
				log.info("Mailing Address - No");
			}
		} else {
			log.info("Mailing Address toggle did not display");
		}

	}

	public void setMailingAdressLine(String address) throws Exception {
		if (isDisplayed(mailingAddressInput)) {
			driver.findElement(mailingAddressInput).clear();
			driver.findElement(mailingAddressInput).sendKeys(address);
			Thread.sleep(1000);
			// selectAddressfromDropdown(address);
			driver.findElement(drp_Add_xpath).click();
		} else {
			log.info("Mailing Address fields are not visible");
		}
	}

	public void setCityTownPicklist(String city) throws Exception {
		if (isDisplayed(cityTownInput)) {
			driver.findElement(cityTownInput).sendKeys(city);
			Thread.sleep(1000);
			List<WebElement> li = driver.findElements(cityTownPicklist);
			for (WebElement element : li) {
				if (element.getText().equalsIgnoreCase(city)) {

					element.click();
					log.info("City is selected as city/town ");
				} else {
					log.info(city + " is not present in the list");
				}

			}
		} else {
			log.info("City/town option did not display");
		}
	}

	public void setPreferredContactMethod(String method) {
		String isDisabled = driver.findElement(By.xpath("//input[@type='radio']")).getAttribute("disabled");
		System.out.println(isDisabled);
		if (isDisabled == null) {
			List<WebElement> li = driver.findElements(rdbtn_preferredContact_xpath);
			for (WebElement element : li) {
				if (element.getText().equalsIgnoreCase(method)) {
					element.click();
					System.out.println("Radio button displayed---");
					break;
				}
				System.out.println("Radio button is not disabled");
			}
		} else {
			System.out.println("Radio button is disabled");
		}
	}
	
	public void PickLPriPhone() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[text()='Primary Phone Type']/following::select[@title='Click here to see primary phone types']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLPrefLang() throws Exception {
		List<WebElement> lst_PefLang = driver.findElements(By.xpath("//label[text()='Preferred Language']/following::select/option"));
		setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details", 1, 3, lst_PefLang.size());
		Thread.sleep(700);
	}	

	public void setContactDetailsPrimaryIndv() throws Exception {
		al = excelData.getData("TC1", "R_ContactInformation", "Sno");
		System.out.println(al.toString());

		setPrimaryPhoneType_picklist(al.get(3).toString());
		PickLPriPhone();
		PickLPrefLang();
		setPrimaryPhoneNumber_input(al.get(4).toString());
		setSecondaryPhoneType_picklist(al.get(6).toString(), "TC1");
		setSecondaryPhoneNumber_input(al.get(7).toString(), "TC1");
		setPreferredContactToggle(al.get(9).toString());
		setPreferredContactMethod(al.get(10).toString());
		setPreferredLanguagePicklist(al.get(11).toString());

/*		setPrimaryPhoneType_picklist(al.get(2).toString());
		
		setPrimaryPhoneNumber_input(al.get(3).toString());
		setSecondaryPhoneType_picklist(al.get(5).toString(), "Primary");
		setSecondaryPhoneNumber_input(al.get(6).toString(), "Primary");
		setPreferredContactToggle(al.get(8).toString());
		setPreferredContactMethod(al.get(9).toString());
		setPreferredLanguagePicklist(al.get(10).toString());
>>>>>>> kalam*/
		ClickNext();
	}

	public void clickStartButton() throws Exception {
		List<WebElement> li = driver.findElements(contactSection);
		for (WebElement element : li) {
			WebElement ele = element.findElement(By.xpath("//li/div/div[2]/span[contains(text(),'Start')]"));
			if (ele.getText().contains("Start")) {
				ele.click();
				log.info("Clicked on Start button");
			} else {
				log.info("Not able to click");
			}
		}

	}
	
	public void SelectAddressMA() throws IOException, InterruptedException {
		
		List<WebElement> Madd=driver.findElements(By.xpath("//*[text()='+ Manually enter address']"));
		if(Madd.size()==1) {
			al1 = excelData.getData("TC1", "Reg-ManualAdd", "Sno");
			driver.findElement(By.xpath("//*[text()='+ Manually enter address']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Mailing Address']/following::input")).sendKeys(al1.get(1));
			Thread.sleep(700);			
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Mailing Address Line 2']/following::input")).sendKeys(al1.get(2));
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='City']/following::input")).sendKeys(al1.get(3));
			Thread.sleep(700);
			driver.findElement(By.xpath("//ul/li/div[text()='"+al1.get(3)+"']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='State']/following::input")).sendKeys(al1.get(4));
			Thread.sleep(700);
			driver.findElement(By.xpath("//ul/li/div[text()='"+al1.get(4)+"']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Zip Code']/following::input")).sendKeys(al1.get(5));
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Country']/following::input")).sendKeys(al1.get(6));
			Thread.sleep(700);
			driver.findElement(By.xpath("//ul/li/div[text()='"+al1.get(6)+"']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::button[text()='Save']")).click();
			wait(2);
		}
		else {
			driver.findElement(By.xpath("//span/span")).click();
		}

	}

	public void setSameAddressToggle(String sameAddress) {
		if (isDisplayed(chk_SameAddasPri_xpath)) {
			if (sameAddress.equalsIgnoreCase("Yes")) {
				driver.findElement(chk_SameAddasPri_xpath).click();
				log.info("household have the same address information - Yes");
			} else {
				driver.findElement(chk_SameAddasPriNo).click();
				log.info("household have the same address information - No");
			}
		} else {
			log.info("Did not display");
		}
	}

	public void setSameContactInfoCheckBox(String checkSameContact) {
		// if (isDisplayed(sameContactInfoCheck)) {
		if (checkSameContact.equalsIgnoreCase("checked")) {
			System.out.println("Checkbox displayed-------");
			driver.findElement(sameContactInfoCheck).click();

		} else {
			log.info("User has same contact information checkbox did not select");
		}
	}

	public void setSameAddressInfo(String sameAddress) throws Exception {
		if (isDisplayed(sameAddressInfo)) {
			if (sameAddress.equalsIgnoreCase("Yes")) {
				driver.findElement(sameAddressInfo).click();
				Thread.sleep(1000);
			} else {
				log.info("Not same address");
			}
		} else {
			log.info("not displayed");
		}
	}

	public void setAddressInformationPrimaryIndv() throws Exception {
		ArrayList<String> al = excelData.getData("TC1", "R_AddressInformation", "Sno");
		System.out.println(al.toString());
		setPhysicalAddressToggle(al.get(2).toString());
		setPhysicalAddressPrimaryIndv(al.get(4).toString());
		setMailingAddressToggle(al.get(6).toString());
		setMailingAdressLine(al.get(7).toString());
		setSameAddressToggle(al.get(9).toString());
		ClickNext();
	}

	public String checkContactInformation() {
		String contactLabel = "";
		// boolean flag=false;

		if (isDisplayed(contactInformationLabel)) {
			contactLabel = driver.findElement(contactInformationLabel).getText();
			System.out.println(contactLabel);
			return contactLabel;
		} else {

			return contactLabel;
		}
	}
	
	public void setPhysicalAddress_Reg(String TCid) throws Exception {
        al = excelData.getData(TCid, "R_AddressInformation", "Sno");
        if (al.get(2).toString().equalsIgnoreCase("Yes")) {       
               driver.findElement(physicalAddressYesToggle).click();  // Select Physical Address Toggle as Yes
               log.info("Does Individual has Physical Address - Yes");
               driver.findElement(txt_Add_xpath).clear();
        driver.findElement(txt_Add_xpath).sendKeys(al.get(4).toString()); // Enter Physical Address Line 1
               Thread.sleep(700);
               SelectAddress();
               //ClickOn(drp_Add_xpath);
               //driver.findElement(drp_Add_xpath).click();
               Thread.sleep(1000);
               if (al.get(6).toString().equalsIgnoreCase("Yes")) {
                     ClickOn(mailingAddressYesToggle);                    // Select Mailing Address Toggle as Yes
                      driver.findElement(mailingAddressInput).clear();
               driver.findElement(mailingAddressInput).sendKeys(al.get(7).toString()); // Enter Mailing Address Line 1
                     log.info("Mailing Address - Yes");
                     Thread.sleep(700);
                     SelectAddressMA(); 
                   //  driver.findElement(drp_Add_xpath).click();
               } else {
                      driver.findElement(mailingAddressNoToggle).click(); // Select Mailing Address Toggle as No
                     log.info("Mailing Address - No");
               }

        } else if (al.get(2).toString().equalsIgnoreCase("No")) { 
               driver.findElement(physicalAddressNoToggle).click();     // Else Select Physical Address Toggle as No
               log.info("Does Individual has Physical Address - No");
         driver.findElement(cityTownInput).sendKeys(al.get(3).toString()); // Else Enter City
               Thread.sleep(1000);
               List<WebElement> li = driver.findElements(cityTownPicklist);
               for (WebElement element : li) {
                     if (element.getText().equalsIgnoreCase(al.get(3).toString())) {
                            element.click();
                            log.info("City is selected as city/town ");
                     } else {
                            log.info(al.get(3) + " is not present in the list");
                     }
               }

               driver.findElement(mailingAddressInput).clear();
          driver.findElement(mailingAddressInput).sendKeys(al.get(7)); // Enter Mailing Address Line 1
               Thread.sleep(1000);
               driver.findElement(drp_Add_xpath).click();
               Thread.sleep(1000);
        }
  }


}
