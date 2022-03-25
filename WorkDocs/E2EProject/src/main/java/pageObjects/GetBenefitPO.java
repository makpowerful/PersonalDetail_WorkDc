package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class GetBenefitPO extends base{
	
	public WebDriver driver;

	By btn_SBA_xpath= By.xpath("//button[contains(text(),'Start Benefits Application')]");
	By Lbl_Welcome_xpath = By.xpath("//p[contains(text(),'Welcome')]");
	By btn_IAgree_xpath= By.xpath("//button[contains(text(),'I Agree')]");
	
	
	
	public GetBenefitPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	
    public void ClickSBA() {
		
		driver.findElement(btn_SBA_xpath).click();
	}

	public void ClicklblWelcome() {

		driver.findElement(Lbl_Welcome_xpath).click();
	}

	public void ClickIAgree() {

		driver.findElement(btn_IAgree_xpath).click();
	}
    
    
}
