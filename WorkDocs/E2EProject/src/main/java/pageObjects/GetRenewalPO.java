package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class GetRenewalPO extends base{
	
	public WebDriver driver;

	By btn_SR_xpath= By.xpath("//button[@title='Click to Start Renewal']");
	
	
	
	
	public GetRenewalPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	
    public void ClickRB() {
		
		driver.findElement(btn_SR_xpath).click();
	}
}
