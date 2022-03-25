package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.ExcelData;
import resources.base;

public class LoginScreenPO extends base{

	public WebDriver driver;

	By lkn_Login_xpath = By.xpath("//a[contains(text(),'Sign In')]");
	// a[contains(text(),'Sign In')] (//a[contains(@href,
	// 'javascript:void(0);')])[3]
	By txt_Usrnm_xpath = By.xpath("//div[3]/div/div/lightning-input/div/input");
	By txt_Passwd_xpath = By.xpath("//div[4]/div/div/lightning-input/div/input");
	By btn_login_xpath = By.xpath("//button[contains(text(),'Sign In')]");
	By btn_Yes_xpath = By.xpath("//button[contains(text(),'Yes')]");
	By btn_AccpetTerms_xpath = By.xpath("//button[@value='Accept']");
	
	ExcelData excelData= new ExcelData();
	ArrayList<String> al= new ArrayList<String>();

	public LoginScreenPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickLoginlink() throws InterruptedException {
		driver.findElement(lkn_Login_xpath).click();
		Thread.sleep(6000);
	}

	public void EnterUsername(String username) throws IOException {

		driver.findElement(txt_Usrnm_xpath).sendKeys(username);

	}
	
	public void EnterUN() {

		driver.findElement(txt_Usrnm_xpath).sendKeys("regression_27sep@mailinator.com");

	}

	public void EnterUN2() {

		driver.findElement(txt_Usrnm_xpath).sendKeys("autoreg@mailinator.com");

	}
	
	public void EnterPass() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,800);");
		driver.findElement(txt_Passwd_xpath).sendKeys("Deloitte@1");

	} 
	
	public void EnterPass2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,800);");
		driver.findElement(txt_Passwd_xpath).sendKeys("Deloitte@4");

	} 

	public void Enterpassword(String password) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,800);");
		driver.findElement(txt_Passwd_xpath).sendKeys(password);
	}
	
	public void ClickLogin() {
		
		driver.findElement(btn_login_xpath).click();
	}
	
	public void ClickYes_UseofWbste() {
		driver.findElement(btn_Yes_xpath).click();
	}
	
	public void ClickAccept() {
		
		driver.findElement(btn_AccpetTerms_xpath).click();
	}

}
