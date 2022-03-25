package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenCartTDPO {

	private String lnk_TopDeal_xpath ="//a[contains(text(),'Top Deals')]";
	private String txt_Search_xpath  =  "//input[@type='search']";
	private String lbl_ProdName_xpath = "//tbody/tr/td[1]";
	
	
	
	public WebDriver driver;
	
	public GreenCartTDPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void TDEnterSearchVal(String val) {
		driver.findElement(By.xpath(txt_Search_xpath)).sendKeys(val);
	}
	
	public String TDCaptureVal() {
		String List = driver.findElement(By.xpath(lbl_ProdName_xpath)).getText();		
		return List;
		
	}
}
