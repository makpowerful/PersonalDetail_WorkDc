package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class PrimaryAppDetailPO extends base {

	public WebDriver driver;

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By txt_FN_xpath = By.xpath("//input");
	By txt_MN_xpath = By.xpath("//div[2]/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_LN_xpath = By.xpath("//div[5]/div/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By chkbx_MN_xpath = By.xpath("//label/span");
	By tgl_PA_Add_xpath = By.xpath("//div/div/span/label");
	By txt_Add_xpath = By.xpath(
			"//c-ssp-address-auto-complete/div/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By drp_Add_xpath = By.xpath("//span/span");
	By txt_AddL2_xpath = By.xpath("//div[2]/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By tgl_PA_MAdd_xpath = By.xpath(
			"//div[8]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	By txt_AddM_xpath = By.xpath(
			"//div[9]/c-ssp-address-auto-complete/div/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_AddML2_xpath = By.xpath(
			"//div[9]/c-ssp-address-auto-complete/div/div[2]/c-ssp-base-component-input-text/div/div/lightning-input/div/input");

	public PrimaryAppDetailPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickNext() throws InterruptedException {
		ClickOn(btn_Next_xpath);

	}

	public void EnterFN(String fn) throws IOException {

		driver.findElement(txt_FN_xpath).clear();
		driver.findElement(txt_FN_xpath).sendKeys(fn);

	}

	public void EnterMN(String mn) throws InterruptedException {

		driver.findElement(chkbx_MN_xpath).click();
		Thread.sleep(1000);
		driver.findElement(txt_MN_xpath).sendKeys(mn);
	}

	public void EnterLN(String ln) throws InterruptedException {

		driver.findElement(txt_LN_xpath).clear();
		driver.findElement(txt_LN_xpath).sendKeys(ln);
	}

	public void Does_PA_Addr_Y() {

		driver.findElement(tgl_PA_Add_xpath).click();
	}

	public void EnterPA_Add(String addr) throws InterruptedException, IOException {

		driver.findElement(txt_Add_xpath).clear();
		driver.findElement(txt_Add_xpath).sendKeys(addr);
		Thread.sleep(1000);
		//driver.findElement(drp_Add_xpath).click();
		SelectAddress();
	}

	public void EnterPA_AddL2(String addrl2) throws InterruptedException {

		driver.findElement(txt_AddL2_xpath).clear();
		driver.findElement(txt_AddL2_xpath).sendKeys(addrl2);
	}

	public void Does_PA_MAddr_N() {

		driver.findElement(tgl_PA_MAdd_xpath).click();
	}
	
	public void PickListClearAll() throws Exception {
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.AllClear();
	}

	public void PickListCheck() throws Exception {
		ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
		cppo.ClearPrimaryApplicant();
		List<WebElement> lst_Suffix = driver.findElements(By.xpath("//select/option"));
		for (int i = 0; i < lst_Suffix.size(); i++) {
			String suffixval = lst_Suffix.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i + 1, 1, suffixval);
			if (i == (lst_Suffix.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i + 2, 1,
						lst_Suffix.size());
			}
		}
		driver.findElement(By.xpath("//label[contains(text(),'have a different mailing address?')]/following::span[text()='Yes']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Mailing Address')]/following::input")).sendKeys("MANUAL");
		List<WebElement> Madd=driver.findElements(By.xpath("//*[text()='+ Manually enter address']"));
		if(Madd.size()==1) {
			driver.findElement(By.xpath("//*[text()='+ Manually enter address']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='City']/following::input")).click();
			Thread.sleep(700);
			List<WebElement> lst_City = driver.findElements(By.xpath("//span[text()='Enter Address']/following::label[text()='City']/following::ul/li[@class='ssp-typeahead-items']"));
			setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", 1, 3, lst_City.size());
			driver.findElement(By.xpath("//ul/li/div[text()='Not A Maine Resident']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='State']/following::input")).click();
			Thread.sleep(700);
			List<WebElement> lst_State = driver.findElements(By.xpath("//span[text()='Enter Address']/following::label[text()='State']/following::ul/li[@class='ssp-typeahead-items']"));
			setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", 1, 5, lst_State.size());
			driver.findElement(By.xpath("//ul/li/div[text()='Alabama']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='State']")).click();
			Thread.sleep(700);
			Scrollpagedown();
			driver.findElement(By.xpath("//span[text()='Enter Address']/following::label[text()='Country']/following::input")).click();
			Thread.sleep(700);
			List<WebElement> lst_Country = driver.findElements(By.xpath("//span[text()='Enter Address']/following::label[text()='Country']/following::ul/li[@class='ssp-typeahead-items']"));
			setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", 1, 7, lst_Country.size());
			Thread.sleep(700);
			driver.findElement(By.xpath("//ul/li/div[text()='Afghanistan']")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//label[contains(text(),'have a different mailing address?')]/following::span[text()='No']")).click();
			Thread.sleep(700);
		}
		
	}
}
