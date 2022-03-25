package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.ExcelData;
import resources.base;

public class HHMemberPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();
	By btn_StartHHM_xpath = By.xpath("//button[contains(text(),'Start')]");
	By btn_StartHHM1_xpath = By.xpath("//button[contains(text(),'Start')]");
	By txt_HHM_FN_xpath = By.xpath("//div[1]/c-ssp-base-component-input-text/div/div/lightning-input/div[1]/input");
	By chkbx_HHM_MN_xpath = By.xpath("//label/span");
	By txt_HHM_MN_xpath = By.xpath("//div[2]/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_HHM_LN_xpath = By.xpath("//div[3]/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By pck_Suffix_xpath = By.xpath("//select[@title='Click here to see suffix options']");
	By pck_Gender_xpath = By.xpath("//select[@title='Click here to see gender options']");
	By tglbtn_Does_SSN_Y_xpath = By.xpath("//div/div/span/label");
	By tglbtn_Does_SSN_N_xpath = By.xpath("//div/div/span[2]/label");
	By txt_SSN_xpath = By.xpath("//label[starts-with(text(),'Social Security Number')]//following-sibling::div/input");
	By txt_CN_SSN_xpath = By
			.xpath("//label[starts-with(text(),'Confirm Social Security Number')]//following-sibling::div/input");
	By tglbtn_USCtzn_Y_xpath = By
			.xpath("//legend[contains(text(),'Citizen?')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_USCtzn_N_xpath = By
			.xpath("//legend[contains(text(),'Citizen?')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_USMiltry_Y_xpath = By
			.xpath("//legend[contains(text(),'military?')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_USMiltry_N_xpath = By
			.xpath("//legend[contains(text(),'military?')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_Resi_Maine_Y_xpath = By
			.xpath("//legend[contains(text(),'resident')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Resi_Maine_N_xpath = By
			.xpath("//legend[contains(text(),'resident')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_Hisplati_Y_xpath = By
			.xpath("//legend[contains(text(),'Latino')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Hisplati_N_xpath = By
			.xpath("//legend[contains(text(),'Latino')]/following-sibling::div//span[contains(text(),'No')]");
	By pck_MarrStats_xpath = By.xpath("//select[@title='Click here to see marital status options.']");
	By Tile_Prg_MC_xpath = By.xpath("//span[contains(text(),'MaineCare and Cub Care (Health Assistance)')]");
	public By chkbx_Prg_MCandCC_xpath = By
			.xpath("//c-ssp-base-component-multiline-input-checkbox[1]/div/div/div/label/input");
	By chkbx_Prg_TANF_xpath = By
			.xpath("//c-ssp-base-component-multiline-input-checkbox[@data-value='TANF (Cash Assistance)']/div/div/div");
	By chkbx_SubPrg_MCandCC_xpath = By
			.xpath("//c-ssp-base-component-multiline-input-checkbox[@data-value='MCCC']/div/div/div");
	By chkbx_SubPrg_FPS_xpath = By
			.xpath("//c-ssp-base-component-multiline-input-checkbox[@data-value='FPSO']/div/div/div");
	By chkbx_SubPrg_MSP_xpath = By
			.xpath("//c-ssp-base-component-multiline-input-checkbox[@data-value='MSPO']/div/div/div");
	By lbl_PrgSel_xpath = By.xpath("//c-ssp-add-house-hold-member/div/div[2]");
	By lbl_belowHis_xpath = By.xpath("//div[4]/div/div/p");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By btn_AddHHMem_xpath = By.xpath("//button[contains(text(),'Add Member')]");
	By dt_DOB_xpath = By.xpath("//div/div/input");
	By chkbx_Death_xpath = By.xpath("//span[contains(text(),'passed away')]/preceding-sibling::span");
	By dt_DOD_xpath = By.xpath("//label[contains(text(),'Date of Death')]/following-sibling::div/input");

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_ContAny_xpath = By.xpath("//button[contains(text(),'Continue Anyway')]");
	By btn_Cancel_xpath = By.xpath("//button[contains(text(),'Cancel')]");
	public WebElement MaineCareProgram;
	public WebElement SNAPProgram;
	public WebElement TANFProgram;
	public WebElement subProgramMCCC;
	public WebElement subProgramFPS;
	public WebElement subProgramMSP;
	static int counter=0;

	public HHMemberPO(WebDriver driver) {

		this.driver = driver;
	}

	public void ClickStartHHM() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(btn_StartHHM_xpath).click();
		Thread.sleep(3000);
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearHouseholdMemberDetails();
	}
	
	public void PickLGender() throws Exception {
		List<WebElement> lst_Gender = driver.findElements(By.xpath("//label[text()='Gender']/following::select[@title='Click here to see gender options']/option"));
		for (int i = 0; i < lst_Gender.size(); i++) {
			String Genderxval = lst_Gender.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 1, 1, Genderxval);
			if (i == (lst_Gender.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 2, 1,
						lst_Gender.size());
			}
		}
	}
	
	public void PickLRace() throws Exception {
		List<WebElement> lst_Race = driver.findElements(By.xpath("//label[contains(text(),'race(s)')]/following::span[@class='slds-form-element__label']"));
		for (int i = 0; i < lst_Race.size(); i++) {
			String Raceval = lst_Race.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 1, 5, Raceval);
			if (i == (lst_Race.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 2, 5,
						lst_Race.size());
			}
		}
	}
	
	public void PickLMaritalStatus() throws Exception {
		List<WebElement> lst_MS = driver.findElements(By.xpath("//label[contains(text(),'marital status?')]/following::select/option"));
		for (int i = 0; i < lst_MS.size(); i++) {
			String MSval = lst_MS.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 1, 7, MSval);
			if (i == (lst_MS.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 2, 7,
						lst_MS.size());
			}
		}
	}

	public void ClickStartHHM1() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		WebElement click = driver.findElement(btn_StartHHM1_xpath);
		clickButton(click);
		Thread.sleep(4000);
		PickLGender();
		PickLMaritalStatus();
		PickLRace();	
	}

	public void EnterFN(String fn) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		WebElement ele = driver.findElement(txt_HHM_FN_xpath);
		if (ele.isEnabled()) {
			driver.findElement(txt_HHM_FN_xpath).clear();
			driver.findElement(txt_HHM_FN_xpath).sendKeys(fn);
			Thread.sleep(1000);
		} else {
			log.info("First Name field is not enabled");
		}
		
	}

	public void EnterMN(String mn) throws InterruptedException {

		if (mn.contains("null")) {
			log.info(" Individual does not have middle name");
		} else {
			driver.findElement(chkbx_HHM_MN_xpath).click();
			Thread.sleep(1000);
			driver.findElement(txt_HHM_MN_xpath).clear();
			driver.findElement(txt_HHM_MN_xpath).sendKeys(mn);
		}
		Thread.sleep(1000);
	}

	public void EnterLN(String ln) throws InterruptedException {
		WebElement ele = driver.findElement(txt_HHM_LN_xpath);
		if (ele.isEnabled()) {
			driver.findElement(txt_HHM_LN_xpath).clear();
			driver.findElement(txt_HHM_LN_xpath).sendKeys(ln);
			Thread.sleep(1000);
		} else {
			log.info("Last Name field is not enabled");
		}
		
	}

	public void Suffix(String sfx) throws InterruptedException {

		if (sfx.contains("null")) {
			log.info(" Individual does not have Suffix");
		} else {
			WebElement ele=driver.findElement(pck_Suffix_xpath);
			try {
				
			Select suffix = new Select(driver.findElement(pck_Suffix_xpath));
			suffix.selectByVisibleText(sfx);
			}
			catch(Throwable t) {
				 PLvalidate(ele);
			}
		}
	}

	public void SelectGender(String gender) {
		WebElement ele=driver.findElement(pck_Gender_xpath);
		try {
		Select Gen = new Select(driver.findElement(pck_Gender_xpath));
		Gen.selectByVisibleText(gender);
		}
		catch(Throwable t) {
			PLvalidate(ele);
		}
	}

	public void EnterDob(String dob) {

		WebElement ele = driver.findElement(dt_DOB_xpath);
		if (ele.isEnabled()) {
			ele.sendKeys(dob);
		} else {
			log.info("DOB field is not enabled");
		}
	}

	public void Has_SSN(String value, String ssn, String reason) throws Exception {

		if (value.contains("Yes")) {
			driver.findElement(tglbtn_Does_SSN_Y_xpath).click(); // Select toggle as Yes
			driver.findElement(txt_SSN_xpath).sendKeys(ssn); // Enter SSN
			driver.findElement(txt_CN_SSN_xpath).sendKeys(ssn); // Enter confirm SSN
		} else {
			driver.findElement(tglbtn_Does_SSN_N_xpath).click(); // Select toggle as No
			counter++;
			driver.findElement(By.xpath("//span[contains(text(),'" + reason + "')]/preceding-sibling::span")).click(); // Reason// ssn
			if(counter==1) {
				List<WebElement> lst_NoSSN = driver.findElements(By.xpath("//label[contains(text(),'doesn’t this individual have a SSN?')]/following::label[@class='slds-radio__label']"));
				for (int i = 0; i < lst_NoSSN.size(); i++) {
					String SSNval = lst_NoSSN.get(i).getText();
					setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 1, 3, SSNval);
					if (i == (lst_NoSSN.size() - 1)) {
						setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i + 2, 3,
								lst_NoSSN.size());
					}
				}
			}
		}
	}

	public void Select_US_Citizen(String value) throws InterruptedException {

		if (value.contains("Yes")) {
			driver.findElement(tglbtn_USCtzn_Y_xpath).click();
			Thread.sleep(700);
		} else {
			driver.findElement(tglbtn_USCtzn_N_xpath).click();
			Thread.sleep(700);
		}
	}

	public void Select_US_Miltary(String value) throws InterruptedException {

		if (value.contains("Yes")) {
			driver.findElement(tglbtn_USMiltry_Y_xpath).click();
			Thread.sleep(700);
		} else {
			driver.findElement(tglbtn_USMiltry_N_xpath).click();
			Thread.sleep(700);
		}
	}

	public void Select_Resid_Maine(String value) throws InterruptedException {

		if (value.contains("Yes")) {
			driver.findElement(tglbtn_Resi_Maine_Y_xpath).click();
			Thread.sleep(700);
		} else {
			driver.findElement(tglbtn_Resi_Maine_N_xpath).click();
			Thread.sleep(700);
		}
	}

	public void Select_Race(String race) throws InterruptedException {

		String[] arrSplit = race.split("; ");
		for (int i = 0; i < arrSplit.length; i++) {
			System.out.println(arrSplit[i]);
			driver.findElement(By.xpath("//span[contains(text(),'" + arrSplit[i] + "')]/preceding-sibling::span"))
					.click();
			Thread.sleep(700);
		}
	}

	public void Select_HispLatino(String value) throws InterruptedException {

		if (value.contains("Yes")) {
			driver.findElement(tglbtn_Hisplati_Y_xpath).click();
		} else {
			driver.findElement(tglbtn_Hisplati_N_xpath).click();
		}
		Thread.sleep(700);
		driver.findElement(lbl_belowHis_xpath).click();
		Thread.sleep(700);
	}

	public void Select_MaritalStatus(String value) throws InterruptedException {
		WebElement ele=driver.findElement(pck_MarrStats_xpath);
		try {
		Select ms = new Select(driver.findElement(pck_MarrStats_xpath));
		ms.selectByVisibleText(value);
		driver.findElement(lbl_PrgSel_xpath).click();
		}
		catch(Throwable t) {
			PLvalidate(ele);
			driver.findElement(lbl_PrgSel_xpath).click();
		}
	}

	public void Select_PassedAway_chk(String value) {

		if (isDisplayed(chkbx_Death_xpath)) {
			if (value.contains("Yes")) {
				driver.findElement(chkbx_Death_xpath).click();
			} else {
				System.out.println("Individual is not dead");
			}
		}
	}

	public void Enter_DOD(String dod) throws InterruptedException {

		if (isDisplayed(dt_DOD_xpath)) {
			driver.findElement(dt_DOD_xpath).sendKeys(dod);
			Thread.sleep(700);
		}
	}

	public void Select_Prg_MainCareCubCare() throws Exception {

		if (isDisplayed(Tile_Prg_MC_xpath)) {
			driver.findElement(chkbx_Prg_MCandCC_xpath).click();
		} else {
			System.out.println("Element is not present-- isDisplayed");
		}
		Thread.sleep(700);
	}

	public void Select_Prg_TANF() throws InterruptedException {

		if (isDisplayed(chkbx_Prg_TANF_xpath)) {
			TANFProgram = driver.findElement(chkbx_Prg_TANF_xpath);
			TANFProgram.click();
		} else {
			System.out.println("TANF is not visible");
		}
		Thread.sleep(700);
	}

	public void Select_SubPrg(String value) {

		if (isDisplayed(Tile_Prg_MC_xpath)) {
			WebElement checkbox = driver.findElement(chkbx_Prg_MCandCC_xpath);
			if (checkbox.isSelected()) {

				String[] arrSplit = value.split("; ");
				for (int i = 0; i < arrSplit.length; i++) {
					System.out.println(arrSplit[i]);
					driver.findElement(By.xpath("//span[text()='" + arrSplit[i] + "']//ancestor::label/input")).click();
				}
			} else
				System.out.println("Subprogram is not visible");
		} else
			System.out.println("MaineCare is not selected");
	}

	public void ClickSave() throws InterruptedException {

		driver.findElement(btn_Save_xpath).click();
		Thread.sleep(4000);
	}

	public void ClickAddHHMem() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,350);");
		//Thread.sleep(700);
		ClickOn(btn_AddHHMem_xpath);
	}

	public void ClickContinueAny() throws InterruptedException {

		if (isDisplayed(btn_ContAny_xpath)) {
			driver.findElement(btn_ContAny_xpath).click();
			checkPageReady();
			Thread.sleep(3000);
		} else {
			System.out.println("Review Information popup did not appear");
		}
		
	
	}

	public void ClickNext() throws InterruptedException {

		driver.findElement(btn_Next_xpath).click();
		Thread.sleep(5000);
	}

	public void ClickCancel() throws InterruptedException {

		driver.findElement(btn_Cancel_xpath).click();
		Thread.sleep(3000);
	}
	
	public void ProgramSelectionReg(String TCid) throws IOException {
		al = excelData.getData("TC1", "Reg-PrgSelection", "Sno");
		String MC  = al.get(1);
		String SNAP = al.get(2);
		String TANF = al.get(3);
		
		al2 = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String DOD = al2.get(16);
		String[] subprgMC=al2.get(18).trim().split(";");
		if(MC.contains("Yes")&&DOD.contains("null")) {
			driver.findElement(chkbx_Prg_MCandCC_xpath).click();
			wait(2);
			for(int i=0;i<subprgMC.length;i++) {
				
				driver.findElement(By.xpath("//p[text()='What MaineCare services is this individual interested in?']/following::span[contains(text(),'"+subprgMC[i]+"')]/following::input")).click();
				wait(1);
				System.out.println("ClickMaincare");
			}
		}
		
		System.out.println("Before TANF" +TANF+ " "+DOD);
		if(TANF.contains("Yes")&&DOD.contains("null")) {
			System.out.println("Inside TANF");
			driver.findElement(chkbx_Prg_TANF_xpath).click();
			wait(1);
			System.out.println("ClickTANF");
		}
		
		
	}
	
	public void Select_PassedAway_chkReg(String value,String dod) throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-PrgSelection", "Sno");
		String MC  = al.get(1);
		
		if (MC.contains("Yes")&&value.contains("Yes")) {
			driver.findElement(chkbx_Death_xpath).click();
			wait(1);
			driver.findElement(dt_DOD_xpath).sendKeys(dod);
			Thread.sleep(1000);
		} else {
			System.out.println("Individual is not dead");
		}
	}
	
	public void Enter_DODReg(String dod) throws InterruptedException, IOException {
		al2 = excelData.getData("TC5", "HHMemDetailsRegression", "Sno");
		String Death_check = al2.get(16);
		System.out.print("Before loop " + al2.get(16));
		if (Death_check.contains("Yes")) {
			System.out.println("Enter loop");
			driver.findElement(dt_DOD_xpath).sendKeys(dod);
			Thread.sleep(1000);
		}
	}
}
