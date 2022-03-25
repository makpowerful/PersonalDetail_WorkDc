package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.base;

public class SignSubmitPO extends base{
	
	public WebDriver driver;
	By btn_SignS_Start_xpath = By.xpath("//button[@title=\"Start Sign & Submit\"]"); ////button[@title='Start Sign & Submit']
	By btn_SBA_xpath= By.xpath("//button[contains(text(),'Submit Benefits Application')]");
	By btn_IAgree_xpath= By.xpath("//button[contains(text(),'I agree')]");
	By lnk_ASOU_xpath = By.xpath("//a[contains(text(),'Read and agree to Application Statement of Understanding')]");
	By lbl_ASOU_xpath = By.xpath("//span/div/div/ul/li");
	By lnk_SNAPRR_xpath = By.xpath("//a[contains(text(),'Read and agree to SNAP Rights & Responsibilities')]");
	By lbl_SNAPRR_xpath = By.xpath("//span/div[2]");
	By lnk_TANFFC_xpath = By.xpath("//a[contains(text(),'Read and agree to TANF Family Contract')]");
	By lbl_TANFFC_xpath = By.xpath("//span/div");
	By lnk_MA34_xpath = By.xpath("//a[contains(text(),'Read and agree to MA 34 - Declaration of Annuities')]");
	By lbl_MA34_xpath = By.xpath("//span[text()='MA 34 - Declaration of Annuities']/following::li[contains(text(),'Deficit Reduction Act (DRA)')]");
	By txt_FN_xpath = By.xpath("//div[1]/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_MN_xpath = By.xpath("//div[2]/div/c-ssp-base-component-input-text/div/div/lightning-input/div/input");
	By txt_LN_xpath = By.xpath("//c-ssp-base-component-input-text[@data-id=\"sLastName\"]/div/div/lightning-input/div/input");
	By btn_CloseIcon_xpath = By.xpath("//button/lightning-primitive-icon");
	By pcklst_Suffix_xpath= By.xpath("//select");
	
	public SignSubmitPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void ClickSignSubmitTile_Start() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1150);");
		Thread.sleep(1000);
		driver.findElement(btn_SignS_Start_xpath).click();
	}
	
	public void Click_RandA_ASOU() throws InterruptedException {
		
		driver.findElement(lnk_ASOU_xpath).click();
		Thread.sleep(800);
		driver.findElement(lbl_ASOU_xpath).click();
		Thread.sleep(800);
		Scrollend();
		driver.findElement(btn_IAgree_xpath).click();
	}
	
	public void Click_RandA_SNAPRR() throws InterruptedException {
		
		if (isDisplayed(lnk_SNAPRR_xpath)) {
			driver.findElement(lnk_SNAPRR_xpath).click();
			
			Thread.sleep(1000);
			driver.findElement(lbl_SNAPRR_xpath).click();
			Thread.sleep(800);
			Scrollend();
			driver.findElement(btn_IAgree_xpath).click();
		} else {
			System.out.println(
					"SNAP is not selected"); 
		}
	}
	
	public void Click_RandA_TANFFC() throws InterruptedException {
		
		if (isDisplayed(lnk_TANFFC_xpath)) {
			driver.findElement(lnk_TANFFC_xpath).click();
			Thread.sleep(800);
			driver.findElement(lbl_TANFFC_xpath).click();
			Thread.sleep(800);
			Scrollend();
			driver.findElement(btn_IAgree_xpath).click();
		} else {
			System.out.println(
					"TANF is not selected");
		}
	}
	
	public void Click_RandA_MA34() throws InterruptedException {
		
		if (isDisplayed(lnk_TANFFC_xpath)) {
			driver.findElement(lnk_MA34_xpath).click();
			Thread.sleep(800);
			driver.findElement(lbl_MA34_xpath).click();
			Thread.sleep(800);
			Scrollend();
			driver.findElement(By.xpath("//span[text()='MA 34 - Declaration of Annuities']/following::button[contains(text(),'Yes')]")).click();
		} else {
			System.out.println(
					"MA34 is not selected");
		}
	}
	
	public void EnterFN(String fn) {
		
		driver.findElement(txt_FN_xpath).sendKeys(fn);
	}

	public void EnterMN(String mn) {
		
		driver.findElement(txt_MN_xpath).sendKeys(mn);
	}
	
	public void EnterLN(String ln) {
		
		driver.findElement(txt_LN_xpath).sendKeys(ln);
	}
	
	public void EnterSuffix(String suffix) {
		
		Select suf= new Select(driver.findElement(pcklst_Suffix_xpath));
		suf.selectByVisibleText(suffix);
	}
	public void Select_Suffix_III(){
		
		Select suf= new Select(driver.findElement(pcklst_Suffix_xpath));
		suf.selectByVisibleText("III");
		
	}
public void Select_Suffix_II(){
		
		Select suf= new Select(driver.findElement(pcklst_Suffix_xpath));
		suf.selectByVisibleText("II");
		
	}
	
    public void Click_SBA() {

		driver.findElement(btn_SBA_xpath).click();
	}
}
