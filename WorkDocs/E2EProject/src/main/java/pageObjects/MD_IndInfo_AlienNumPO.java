package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_IndInfo_AlienNumPO extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(MD_IndInfo_AlienNumPO.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	public MD_IndInfo_AlienNumPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickNext() throws InterruptedException {

		WebElement ele = driver.findElement(btn_Next_xpath);
		clickButton(ele);
		wait(4);
	}

	// **********************************************************************************************************

	//
	//

	public void EnterAlienNum(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String USCitizenq= al.get(10);
		if (USCitizenq.contains("No")) {
			al = excelData.getData(TCid, "Reg-MD-AlienSpon", "Sno");
			Thread.sleep(700);
			log.info("Adding the Alien Number details for " + al.get(1));
			wait(4);
			Assert.assertTrue(
					driver.findElement(By.xpath("//p[text()='Alien Sponsor']")).getText().contains("Alien Sponsor"));
			Thread.sleep(700);
			driver.findElement(
					By.xpath("//label[contains(text(),'sponsored by an organization?')]/following::span[text()='"
							+ al.get(2) + "']"))
					.click();
			Thread.sleep(700);
			if (al.get(2).contains("No")) {
				driver.findElement(By.xpath(
						"//label[contains(text(),'alien sponsor a member of this household?')]/following::span[text()='"
								+ al.get(3) + "']"))
						.click();
				Thread.sleep(700);
				if (al.get(3).contains("No")) {
					Select s1 = new Select(driver.findElement(
							By.xpath("//label[contains(text(),'Who is the alien sponsor?')]/following::select")));
					s1.selectByVisibleText(al.get(5));
					Thread.sleep(700);
					if (al.get(5).contains("Someone Else")) {
						driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following::input"))
								.sendKeys(al.get(6));
						Thread.sleep(700);
						driver.findElement(By.xpath("//label[contains(text(),'Middle Name')]/following::input"))
								.sendKeys(al.get(7));
						Thread.sleep(700);
						driver.findElement(By.xpath("//label[contains(text(),'Last Name')]/following::input"))
								.sendKeys(al.get(8));
						Thread.sleep(700);
						WebElement  ele= driver.findElement(By.xpath("//label[contains(text(),'Suffix')]/following::select"));
						try {
						Select s2 = new Select(ele);
						s2.selectByVisibleText(al.get(9));
						Thread.sleep(700);
						}
						catch(Throwable t) {
							PLvalidate(ele);
						}
						driver.findElement(By.xpath("//label[contains(text(),'Address')]/following::input"))
								.sendKeys(al.get(10));
						wait(1);
						//driver.findElement(By.xpath("//span/span")).click();
						SelectAddress();
						Thread.sleep(700);
						driver.findElement(By.xpath("//label[contains(text(),'Address Line 2')]/following::input"))
								.sendKeys(al.get(11));
						Thread.sleep(700);
						ClickNext();
					}
				} else {
					WebElement ele1 = driver.findElement(By.xpath("//label[contains(text(),'Suffix')]/following::select"));
					try {
					Select s3 = new Select(ele1);
					s3.selectByVisibleText(al.get(4));
					Thread.sleep(700);
					}
					catch(Throwable t) {
						PLvalidate(ele1);
					}
					ClickNext();
				}

			}

			else {
				ClickNext();
			}

		}

	}

}
