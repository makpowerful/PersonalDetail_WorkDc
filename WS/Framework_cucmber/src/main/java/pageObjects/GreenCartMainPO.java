package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenCartMainPO {

	private String lnk_TopDeal_xpath ="//a[contains(text(),'Top Deals')]";
	private String txt_Search_xpath  =  "//input[@type='search']";
	private String lbl_ProdName_xpath = "//div[@class='product']/h4";
	
	
	
	WebDriver driver;
	
	public GreenCartMainPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClicklinkTopdeal() {
		driver.findElement(By.xpath(lnk_TopDeal_xpath)).click();
	}
	
	public void EnterSearchVal(String val) {
		driver.findElement(By.xpath(txt_Search_xpath)).sendKeys(val);
	}
	
	public String CaptureVal() {
		List<WebElement> List = driver.findElements(By.xpath(lbl_ProdName_xpath));
		/*
		 * for(int i=0;i<List.size();i++) {
		 * 
		 * System.out.println("Value on Main Greencart page is:"+List.get(i).getText());
		 * }
		 */
		
		String[] val1=List.get(0).getText().trim().split("-");
		return val1[0].trim();
		
	}
}
