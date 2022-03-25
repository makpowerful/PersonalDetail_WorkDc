package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ResetPasswordPO extends base {

	public WebDriver driver;
	
	By txt_Password_xpath = By.xpath("//tr[2]/td/input");
	By txt_ConfPassword_xpath = By.xpath("//tr[5]/td/input");
	
	By btn_Exit_xpath = By.xpath("//input[@value='Exit']");
	By btn_ChangePassword_xpath = By.xpath("//input[@value='Change Password']");

	public ResetPasswordPO(WebDriver driver) {

		this.driver = driver;
	}

	public void Enter_Password(String password) throws IOException {

		driver.findElement(txt_Password_xpath).sendKeys(password);
	}
	
	public void Enter_ConfirmPassword(String password) throws IOException {

		driver.findElement(txt_ConfPassword_xpath).sendKeys(password);
	}
	
	public void Click_ChangePassword() throws IOException, InterruptedException {

		driver.findElement(btn_ChangePassword_xpath).click();
		Thread.sleep(3000);
	}
	
	public void Click_Exit() throws IOException, InterruptedException {

		driver.findElement(btn_Exit_xpath).click();
		Thread.sleep(1200);
	}

}
