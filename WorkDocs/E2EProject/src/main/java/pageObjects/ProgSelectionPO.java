package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.ExcelData;
import resources.base;

public class ProgSelectionPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By chk_MainCare_xpath = By.xpath("//span[text()='MaineCare and Cub Care (Health Assistance)']/following::input");
	By chk_SNAP_xpath = By.xpath("(//input[@name=''])[2]");
	By chk_TANF_xpath = By.xpath("(//input[@name=''])[3]");
	By btn_next = By.xpath("//button[@title='Save and go to next screen']");

	public ProgSelectionPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickMainCare() {

		driver.findElement(chk_MainCare_xpath).click();
	}

	public void ClickSNAP() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400);");
		Thread.sleep(500);
		driver.findElement(chk_SNAP_xpath).click();
	}

	public void ClickTANF() {

		driver.findElement(chk_TANF_xpath).click();
	}

	public void ClickNext() throws InterruptedException {

		WebElement nextElement = driver.findElement(btn_Next_xpath);
		clickButton(nextElement);

	}

	public void ClickNextTanf() throws InterruptedException {

		WebElement nextElement = driver.findElement(btn_next);
		clickButton(nextElement);
	}
	
	public void PrgmSelecMC() throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-PrgSelection", "Sno");
		driver.findElement(chk_MainCare_xpath).click();
		Thread.sleep(700);
	}

	public void PrgmSelecSNAP() throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-PrgSelection", "Sno");
		driver.findElement(chk_SNAP_xpath).click();
		Thread.sleep(700);
	}
	
	public void PrgmSelecTANF() throws IOException, InterruptedException {
		al = excelData.getData("TC1", "Reg-PrgSelection", "Sno");
		driver.findElement(chk_TANF_xpath).click();
		Thread.sleep(700);
	}
}
