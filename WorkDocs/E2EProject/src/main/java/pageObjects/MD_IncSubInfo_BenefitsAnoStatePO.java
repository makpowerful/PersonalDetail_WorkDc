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

public class MD_IncSubInfo_BenefitsAnoStatePO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By tglbtn_ESRD_N_xpath = By.xpath("//span[2]/label/span");


	public MD_IncSubInfo_BenefitsAnoStatePO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
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

	public void EnterBnftAnoState(String TCid) throws IOException {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
    	String FN=al.get(1);
    	System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
		if (al.get(21).contains("Yes")) {
			String[] BASmem = al.get(22).trim().split(";");
			for (int i = 0; i < BASmem.length; i++) {

				String val = BASmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-BednfitAntState", "Sno");
					Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Benefits from Another State']")).getText().contains("Benefits from Another State"));
	    			wait(1);
	    			driver.findElement(By.xpath("//p[text()='Benefits from Another State']/following::button[text()='Start']")).click();
	    			wait(3);
	    			log.info("On Benefits from Another State Details screen");
	    			driver.findElement(By.xpath("//label[text()='State']/following::input")).sendKeys(al.get(2));
	    			wait(1);
	    			driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
					wait(1);
	    			String[] Benftprg=al.get(3).trim().split(";");
				    for(int j=0;j<Benftprg.length;j++) {
				    	
				    	driver.findElement(By.xpath("//p[text()='Type of benefit program(s)']/following::span[text()='"+Benftprg[j]+"']")).click();
				    	wait(1);
				    	if(Benftprg[j].contains("Medicaid")) {
				    		driver.findElement(By.xpath("//span[text()='Medicaid']/following::label[text()='Benefit start date']/following::input")).sendKeys(al.get(4));
				    		wait(1);
				    		driver.findElement(By.xpath("//span[text()='Medicaid']/following::label[text()='Benefit end date']/following::input")).sendKeys(al.get(5));
				    		wait(1);
				    	}
				    	if(Benftprg[j].contains("SNAP")) {
				    		driver.findElement(By.xpath("//span[text()='SNAP']/following::label[text()='Benefit start date']/following::input")).sendKeys(al.get(6));
				    		wait(1);
				    		driver.findElement(By.xpath("//span[text()='SNAP']/following::label[text()='Benefit end date']/following::input")).sendKeys(al.get(7));
				    		wait(1);
				    	}
				    	if(Benftprg[j].contains("TANF")) {
				    		driver.findElement(By.xpath("//span[text()='TANF']/following::label[text()='Benefit start date']/following::input")).sendKeys(al.get(8));
				    		wait(1);
				    		driver.findElement(By.xpath("//span[text()='TANF']/following::label[text()='Benefit end date']/following::input")).sendKeys(al.get(9));
				    		wait(1);
				    	}
				    }
					
					ClickSave();
					wait(1);
					ClickNext();
					}

				}
			}

		}
	

}
