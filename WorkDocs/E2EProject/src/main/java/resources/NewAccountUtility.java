package resources;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewAccountUtility extends base {

	public WebDriver driver; 

	By txt_email_xpath = By.xpath("//div/input");
	By btn_go_xpath = By.xpath("//div/button[@id = 'go-to-public']");
	By latestmail_xpath = By.xpath("//*[contains(text(),'Sandbox: Welcome to My Maine Connection')]");
	By hyperlink_xpath = By.xpath("//html/body/a");
	By btn_iaccept_xpath = By.xpath("//*[contains(text(),'Yes, I Accept')]");

	public NewAccountUtility(WebDriver driver) {

		this.driver = driver;
	}

	public void navigateMailinator() throws IOException, InterruptedException {

		driver.get("https://www.mailinator.com/");
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(1200);
		
	}

	public void accessMail(String email) throws IOException, InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(txt_email_xpath).sendKeys(email);
		driver.findElement(btn_go_xpath).click();
		Thread.sleep(1200);

	}

	public void openLatestMail() throws IOException, InterruptedException {
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(latestmail_xpath)).perform();
		Thread.sleep(1200);
		driver.switchTo().frame("texthtml_msg_body");
		Scrolldown();
		driver.findElement(hyperlink_xpath).click();
		Thread.sleep(9000);
	}

	public void clickIAccept() throws IOException, InterruptedException {

		driver.findElement(btn_iaccept_xpath).click();
		Thread.sleep(2000);
	}
	
	

	
}
