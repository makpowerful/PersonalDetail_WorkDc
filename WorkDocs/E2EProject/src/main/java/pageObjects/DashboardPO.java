package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class DashboardPO extends base{
	
	public WebDriver driver;

	By continuBtn= By.xpath("//button[contains(text(),'Continue Application')]");
	By btn_AFB_xpath= By.xpath("//button[contains(text(),'Apply for Benefits')]");
	By renewBtn = By.xpath("//button[@title='Renew Benefits']");
	
	public DashboardPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void clickContinuebtn()
	{
		driver.findElement(continuBtn);
	}
	
    public void ClickAFB() {
		
		driver.findElement(btn_AFB_xpath).click();
	}
    
    public void clickRB() {
    	driver.findElement(renewBtn).click();
    	
    }
    
    public void checkDashboardButton()
    {
    	if(isDisplayed(continuBtn))
    	{
    		System.out.println("Application is already created --");
    		driver.findElement(continuBtn).click();
    	}
    	else if(isDisplayed(btn_AFB_xpath))
    	{
    		driver.findElement(btn_AFB_xpath).click();
    	}
    }
}
