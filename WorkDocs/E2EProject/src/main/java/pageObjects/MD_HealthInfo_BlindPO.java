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

public class MD_HealthInfo_BlindPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_ESRD_N_xpath = By.xpath("//span[2]/label/span");
	By lbl_DandB_xpath = By.xpath("//p[text()='Disability & Blindness']");

	public MD_HealthInfo_BlindPO(WebDriver driver) {
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

	// *****************************************************************

	public void EnterDisandBlind(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
    	String FN=al.get(1);
    	System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
		if (al.get(1).contains("Yes")) {
			String[] DBmem = al.get(2).trim().split(";");
			for (int i = 0; i < DBmem.length; i++) {

				String val = DBmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-Disab|blind", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Disability & Blindness']")).getText().contains("Disability & Blindness"));
	    			Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'have end-stage renal disease (ESRD)?')]//following::span[contains(text(),'"+al.get(2)+"')]")).click();
					Thread.sleep(700);
					ClickNext();

				}
			}

		}
	}

}
