package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class MD_AssetTransferInfomationPO extends base {

	By giveAwayAssetToggleNo = By.xpath(
			"//*[contains(text(),'their spouse disposed of, sold, or given away any assets within the last 60 months?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By giveAwayAssetToggleYes = By.xpath(
			"//*[contains(text(),'their spouse disposed of, sold, or given away any assets within the last 60 months?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	By assetTypePicklist = By.xpath("//select[@title='Click here to see asset types']");
	By valueInput = By.xpath("//*[contains(text(),'Value')]//following-sibling::div/input");
	By addAnothetAssetBtn = By.xpath("//button[@title='Add another transferred asset']");
	By subtypeOfAssetPicklist = By.xpath("//select[@title='Click here to see other liquid asset types']");
	By typeOfAccountPicklist = By.xpath("//select[@title='Click here to see account types']");
	By closeAccountInput = By
			.xpath("//*[contains(text(),'Why did you close this account?')]//following-sibling::div/input");
	By closeAccountToggleNo = By.xpath(
			"//*[contains(text(),' their spouse closed any savings, checking, or any other financial accounts within the last 60 months?')]//following-sibling::div/div/span/label/span[contains(text(),'No')]");
	By closeAccountToggleYes = By.xpath(
			"//*[contains(text(),' their spouse closed any savings, checking, or any other financial accounts within the last 60 months?')]//following-sibling::div/div/span/label/span[contains(text(),'Yes')]");
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	public MD_AssetTransferInfomationPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void setGiveAwayToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(giveAwayAssetToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(giveAwayAssetToggleNo).click();
		} else {
			log.info("Value is not present");
		}
	}

	public void setTypeOfAsset(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value not present");
		} else {
			Select sel = new Select(driver.findElement(assetTypePicklist));
			sel.selectByVisibleText(value);
		}
	}

	public WebElement getSubtypeAsset(String asset) {
		
		return driver.findElement(By.xpath("//select[@title='Click here to see " + asset.toLowerCase() + " types']"));
	}

	public void setSubtypeOfAsset(String value, String typeOfAsset) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value not present");
		} else {
			Select sel = new Select(getSubtypeAsset(typeOfAsset));
			sel.selectByVisibleText(value);
		}
	}

	public void setvalueInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(valueInput).sendKeys(value);
		}
	}

	public void setClosedAccountToggle(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			driver.findElement(closeAccountToggleYes).click();
		} else if (value.equalsIgnoreCase("No")) {
			driver.findElement(closeAccountToggleNo).click();
		} else {
			log.info("Value is not present");
		}
	}

	public void setTypeOfAccount(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value not present");
		} else {
			Select sel = new Select(driver.findElement(typeOfAccountPicklist));
			sel.selectByVisibleText(value);
		}
	}

	public void closedAccountInput(String value) {
		if (value.equalsIgnoreCase("null")) {
			log.info("value is not present");
		} else {
			driver.findElement(closeAccountInput).sendKeys(value);
		}
	}

	public void setGiveAwayAccountDetails(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-AssetTransInfo", "Sno");
		setGiveAwayToggle(al.get(2).toString());
		setTypeOfAsset(al.get(3).toString());
		setSubtypeOfAsset(al.get(4).toString(), al.get(3).toString());
		setvalueInput(al.get(5).toString());
	}

	public void setClosedAccountDetails(String TCid) throws Exception {
		al = excelData.getData(TCid, "Reg-MD-AssetTransInfo", "Sno");
		setClosedAccountToggle(al.get(6).toString());
		setTypeOfAccount(al.get(7).toString());
		closedAccountInput(al.get(8).toString());

	}

	public void setAssetInformationDetails(String TCid) throws Exception {
		MD_AssetTransferInfomationPO asset = new MD_AssetTransferInfomationPO(driver);
		asset.setGiveAwayAccountDetails(TCid);
		asset.setClosedAccountDetails(TCid);
		ClickOn(btn_Next_xpath);
	}

}
