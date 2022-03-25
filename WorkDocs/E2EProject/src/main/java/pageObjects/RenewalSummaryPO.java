package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.ExcelData;
import resources.base;

public class RenewalSummaryPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();
	By btn_StartHM = By.xpath("//button[@title='Start Household Members']");
	public WebElement MaineCareProgram;
	public WebElement SNAPProgram;
	public WebElement TANFProgram;
	public WebElement subProgramMCCC;
	public WebElement subProgramFPS;
	public WebElement subProgramMSP;
	static int counter=0;

	public RenewalSummaryPO(WebDriver driver) {

		this.driver = driver;
	}

	public void ClickStartHM() throws Exception {

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_StartHM));
		driver.findElement(btn_StartHM).click();
		Thread.sleep(3000);
	}

}
