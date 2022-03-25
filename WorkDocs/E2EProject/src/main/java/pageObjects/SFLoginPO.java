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

public class SFLoginPO {

	public WebDriver driver;

	By txt_Search_xpath = By.xpath("//div/input");
	By btn_Search_xpath = By.xpath("//*[@id=\"searchButtonContainer\"]");
	By lnk_Contct_xpath = By.xpath("//a[contains(text(),'Jack SMITH')]");
	By txt_Usrnm_xpath = By.xpath("//*[@id=\"username\"]");
	By txt_Passwd_xpath = By.xpath("//*[@id=\"password\"]");
	By btn_login_xpath = By.xpath("//*[@id=\"Login\"]");
	By lnk_DelSSPM_xpath = By.xpath("//div[6]/div/div/div[2]/table/tbody/tr[2]/td/a[2]");
	


	public SFLoginPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void EnterUsername(String username) throws IOException {

		driver.findElement(txt_Usrnm_xpath).sendKeys(username);

	}
	
	public void Enterpassword(String password) {
		
		driver.findElement(txt_Passwd_xpath).sendKeys(password);
	}
	
	public void ClickLogin() {
		
		driver.findElement(btn_login_xpath).click();
	}
	
	public void EnterSearch() throws InterruptedException {

		driver.findElement(txt_Search_xpath).sendKeys("mkalamshabaz");
		Thread.sleep(1000);
		driver.findElement(btn_Search_xpath).click();
		
	}
	
	public void ClickUser() {
		
		driver.findElement(lnk_Contct_xpath).click();
	}	
	
	public void Click_DelSSPM() {
		
		driver.findElement(lnk_DelSSPM_xpath).click();
	}
	
	

}
