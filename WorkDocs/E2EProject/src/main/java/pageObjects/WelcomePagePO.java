package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class WelcomePagePO  extends base{
	
	public WebDriver driver;
	
	By btn_SingUp_xpath = By.xpath("//*[contains(text(),'Sign Up')]");
	By btn_Accept_xpath = By.xpath("//button[@value= 'Accept']");

	public WelcomePagePO(WebDriver driver) {

		this.driver = driver;
	}
	
public void Click_SignUp() throws InterruptedException {
		
		driver.findElement(btn_SingUp_xpath).click();
		
}	

public void Click_Accept() throws InterruptedException {
	
	driver.findElement(btn_Accept_xpath).click();
	
}	
}
