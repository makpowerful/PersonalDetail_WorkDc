package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_IndInfo_FFCPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	public MD_IndInfo_FFCPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickNext() {

		WebElement element = driver.findElement(btn_Next_xpath);
		clickButton(element);
		wait(4);
	}

	// ***************************************************************************************************

	public void EnterFFC(String TCid) throws IOException, InterruptedException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
		if (al.get(14).contains("Yes")) {
			String[] BASmem = al.get(15).trim().split(";");
			for (int i = 0; i < BASmem.length; i++) {

				String val = BASmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					al = excelData.getData(TCid, "Reg-MD-FrmerFosterC", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Former Foster Care']")).getText().contains("Former Foster Care"));
	    			Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'in the foster care system?')]/following::input")).sendKeys(al.get(2));
					Thread.sleep(700);
					driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
					Thread.sleep(700);
					driver.findElement(By.xpath("//label[contains(text(),'through Medicaid when they left foster care?')]/following::span[text()='"+al.get(3)+"']")).click();
					Thread.sleep(700);
					ClickNext();
				}

			}
		}
	}
}
