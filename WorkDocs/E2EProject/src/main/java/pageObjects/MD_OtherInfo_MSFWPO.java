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

public class MD_OtherInfo_MSFWPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_Job30days_xpath= By.xpath("//span[2]/label");
	
	public MD_OtherInfo_MSFWPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void Click_Job30days_N() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_Job30days_xpath).click();
	}
	
    public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}

    //*********************************************************************************
    
    public void EnterMigrSFW(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
    	String FN=al.get(1);
    	System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
		if (al.get(9).contains("Yes")) {
			String[] LTCmem = al.get(10).trim().split(";");
			for (int i = 0; i < LTCmem.length; i++) {

				String val = LTCmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					wait(2);
					al = excelData.getData("TC1", "Reg-MD-MigrSF", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Migrant or Seasonal Farmworker']")).getText().contains("Migrant or Seasonal Farmworker"));
	    			Thread.sleep(700);
	    			driver.findElement(By.xpath("//label[contains(text(),'end in the last thirty days?')]/following::span[text()='"+al.get(2)+"']")).click();
	    			Thread.sleep(700);
	    			ClickNext();
	    			
				}
			}
		}
    }
}
