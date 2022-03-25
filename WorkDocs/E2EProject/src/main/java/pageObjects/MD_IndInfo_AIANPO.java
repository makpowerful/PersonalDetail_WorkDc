package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_IndInfo_AIANPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_MemOfTribe_Y_xpath = By.xpath("//span/label");
	By chkbx_Tribe_HM_xpath = By.xpath("//fieldset/div[1]/span[1]/label/span[1]");
	By tglbtn_RecServ_xpath = By.xpath(
			"//div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	By tglbtn_ERecServ_xpath = By.xpath(
			"//div[2]/div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");

	public MD_IndInfo_AIANPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_IsInd_MemOfTribe_Y() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_MemOfTribe_Y_xpath).click();
	}

	public void Click_TypeOfTribe() {

		driver.findElement(chkbx_Tribe_HM_xpath).click();

	}

	public void Click_EverRecServ() {

		if (isDisplayed(tglbtn_RecServ_xpath)) {
			driver.findElement(tglbtn_RecServ_xpath).click();
		} else {
			log.info("Button is not displayed");
		}

	}

	public void Click_EligRecSer() {

		if (isDisplayed(tglbtn_ERecServ_xpath)) {
			driver.findElement(tglbtn_ERecServ_xpath).click();
		} else {
			log.info("Button is not displayed");
		}

	}

	public void ClickNext() {

		WebElement element = driver.findElement(btn_Next_xpath);
		clickButton(element);
		wait(4);
	}

	// ***************************************************************************************************

	public void PickLAIAN() throws Exception {
		List<WebElement> lst_PNo = driver
				.findElements(By.xpath("//label[text()='Tribe']/following::span[@class='slds-form-element__label']"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "American Indian Alaskan Native", i + 1, 1,
					Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "American Indian Alaskan Native", i + 2, 1,
						lst_PNo.size());
			}
		}
	}

	public void EnterAmerIndorAlsNatv(String TCid) throws Exception {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String[] AIAN = al.get(13).trim().split(";");
		for (int i = 0; i < AIAN.length; i++) {

			String val = AIAN[i];
			if (val.contains("American Indian or Alaskan Native")) {
				Thread.sleep(700);
				al = excelData.getData(TCid, "Reg-MD-AIorAN", "Sno");
				ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
				cppo.ClearAmericanIndianAlaskanNative();
				Assert.assertTrue(driver.findElement(By.xpath("//p[text()='American Indian or Alaskan Native']"))
						.getText().contains("American Indian or Alaskan Native"));
				Thread.sleep(700);
				driver.findElement(By.xpath(
						"//label[contains(text(),'member of a tribe?')]/following::span[text()='" + al.get(2) + "']"))
						.click();
				wait(1);
				if (al.get(2).contains("Yes")) {
					PickLAIAN();
					String[] tribe = al.get(3).trim().split(";");
					for (int j = 0; j < tribe.length; j++) {

						driver.findElement(By
								.xpath("//label[contains(text(),'Tribe')]/following::span[text()='" + tribe[j] + "']"))
								.click();
						Thread.sleep(700);

					}
				}
				driver.findElement(By.xpath(
						"//div[contains(text(),'received service from any of the following')]/following::span[text()='"
								+ al.get(4) + "']"))
						.click();
				Thread.sleep(700);
				if (al.get(4).contains("No")) {
					driver.findElement(By.xpath(
							"//div[contains(text(),'receive services or a referral from any of the following')]/following::span[text()='"
									+ al.get(5) + "']"))
							.click();
					Thread.sleep(700);
					ClickNext();
				} else {
					ClickNext();
				}

			}

		}
	}
}
