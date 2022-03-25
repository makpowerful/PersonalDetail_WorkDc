package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_HealthInfo_MediCovPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By tglbtn_ESRD_N_xpath = By.xpath("//span[2]/label/span");


	public MD_HealthInfo_MediCovPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_ESRD_N() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_ESRD_N_xpath).click();
	}

	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}

	public void ClickSave() {

		driver.findElement(btn_Save_xpath).click();
		wait(4);
	}
	// *****************************************************************

	public void EnterMediCov(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
    	String FN=al.get(1);
    	System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
		if (al.get(5).contains("Yes")) {
			String[] LTCmem = al.get(6).trim().split(";");
			for (int i = 0; i < LTCmem.length; i++) {

				String val = LTCmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-MediCov", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Medicare Coverage']")).getText().contains("Medicare Coverage"));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//p[text()='Medicare Coverage']/following::button[text()='Start']")).click();
	    			wait(3);
	    			log.info("On Medicare Coverage Details screen");
	    			driver.findElement(By.xpath("//label[text()='Medicare Type']/following::span[text()='"+al.get(2)+"']")).click();
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[text()='Start Date']/following::input")).sendKeys(al.get(3));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[text()='End Date']/following::input")).sendKeys(al.get(4));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[text()='Medicare Number']/following::input")).sendKeys(al.get(5));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[text()='Medicare Claim Number (first 9 digits)']/following::input")).sendKeys(al.get(6));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[text()='Beneficiary Identity Code (BIC)']/following::input")).sendKeys(al.get(7));
	    			Thread.sleep(700);
					ClickSave();
					Thread.sleep(700);
					ClickNext();
					}

				}
			}

		}
	

}
