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

public class MD_HealthInfo_LTCPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_ESRD_N_xpath = By.xpath("//span[2]/label/span");
	By lbl_DandB_xpath = By.xpath("//p[text()='Disability & Blindness']");

	public MD_HealthInfo_LTCPO(WebDriver driver) {
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

	public void EnterLTC(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
    	String FN=al.get(1);
    	System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
		if (al.get(3).contains("Yes")) {
			String[] LTCmem = al.get(4).trim().split(";");
			for (int i = 0; i < LTCmem.length; i++) {

				String val = LTCmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-LTC", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Long-Term Care Services']")).getText().contains("Long-Term Care Services"));
	    			Thread.sleep(700);
					String[] LTCType = al.get(2).trim().split(";");
					for (int j = 0; j < LTCType.length; j++) {

						driver.findElement(By.xpath("//div[contains(text(),'need help paying for ?')]/following::span[text()='"+LTCType[j]+"']")).click();
						Thread.sleep(700);
						if(LTCType[j].contains("Nursing Facility Care")) {
							
							driver.findElement(By.xpath("//span[text()='Nursing Facility Care']/following::label[text()='Facility Address']/following::input")).sendKeys(al.get(3));
							wait(2);
							SelectAddress();
							//driver.findElement(By.xpath("//span/span")).click();
							Thread.sleep(700);
							driver.findElement(By.xpath("//span[text()='Nursing Facility Care']/following::label[text()='Facility Address Line 2']/following::input")).sendKeys(al.get(4));
							Thread.sleep(700);
							driver.findElement(By.xpath("//span[text()='Nursing Facility Care']/following::label[text()='Date Admitted']/following::input")).sendKeys(al.get(5));
							Thread.sleep(700);
						}
						
						else if(LTCType[j].contains("Residential Care Facility")){
							driver.findElement(By.xpath("//span[text()='Residential Care Facility']/following::label[text()='Facility Address']/following::input")).sendKeys(al.get(6));
							wait(2);
							SelectAddress();
							//driver.findElement(By.xpath("//span/span")).click();
							Thread.sleep(700);
							driver.findElement(By.xpath("//span[text()='Residential Care Facility']/following::label[text()='Facility Address Line 2']/following::input")).sendKeys(al.get(7));
							Thread.sleep(700);
							driver.findElement(By.xpath("//span[text()='Residential Care Facility']/following::label[text()='Date Admitted']/following::input")).sendKeys(al.get(8));
							Thread.sleep(700);
							
						}
							
						
					}
					ClickNext();
				}
			}

		}
	}

}
