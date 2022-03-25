package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_IndInfo_NotUSCitiznPO extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(MD_IndInfo_NotUSCitiznPO.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	

	public MD_IndInfo_NotUSCitiznPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	
	public void ClickNext() throws InterruptedException {

		WebElement ele = driver.findElement(btn_Next_xpath);
		clickButton(ele);
		wait(4);
	}

	// **********************************************************************************************************

	//
	//
	public void PickLTImmigrationStatus() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select[@title='']/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLTImmigrationDoc() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[text()='Immigration Document Type']/following::ul[1]/li"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getAttribute("data-label");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i + 1, 3, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i + 2, 3,
						lst_PNo.size());
			}
		}
	}
	public void EnterNotUSCitizen(String TCid) throws Exception {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		if(al.get(10).contains("No")) {
			if (driver.getTitle().contains("Application Summary")) {
				al = excelData.getData(TCid, "Reg-MD-NonUSCtzn", "Sno");
				Thread.sleep(700);
				driver.findElement(By.xpath("//p[text()='Member Details']/following::span[contains(text(),'" + al.get(1)
						+ "')]/following::span[text()='Start']")).click();// Starting the Member details addition
				log.info("Adding the member details for " + al.get(1));

				log.info("Adding the Not a US Citizen details for " + al.get(1));
				wait(4);
				Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Not a U.S. Citizen']")).getText().contains("Not a U.S. Citizen"));
				Thread.sleep(700);
				ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
				cppo.ClearPLNotUSCitizen();
				PickLTImmigrationStatus();
				driver.findElement(By.xpath("//label[contains(text(),'have an alien sponsor?')]/following::span[text()='"+al.get(2)+"']"))
						.click();
				Thread.sleep(700);
				WebElement ele=driver.findElement(By.xpath("//label[contains(text(),'immigration status?')]/following::select"));
				try {
				Select s1=new Select(ele);
				s1.selectByVisibleText(al.get(3));
				Thread.sleep(700);
				}
				catch(Throwable t) {
					PLvalidate(ele);
				}
				driver.findElement(By.xpath("//label[contains(text(),'come to the US to live?')]/following::input"))
						.sendKeys(al.get(4));
				Thread.sleep(700);
				driver.findElement(By.xpath("//label[contains(text(),'Immigration Document Type')]/following::input")).click();
				Thread.sleep(700);
				PickLTImmigrationDoc();
				WebElement ele1 = driver.findElement(By.xpath("//label[contains(text(),'Immigration Document Type')]/following::input"));
				try {
				ele1.sendKeys(al.get(5));
		        Thread.sleep(700);
				driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(5) + "']")).click();
				Thread.sleep(700);
				}
				catch(Throwable t) {
					THPLvalidate(ele1);
				}
				driver.findElement(By.xpath("//label[contains(text(),'Alien Number')]/following::input"))
				.sendKeys(al.get(6));
		        Thread.sleep(700);
				driver.findElement(By.xpath("//label[contains(text(),'Citizenship Number')]/following::input"))
				.sendKeys(al.get(7));
		        Thread.sleep(700);
		        if(al.get(8).contains("Yes")) {
		        driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		        Thread.sleep(700);
		        driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following::input"))
				.sendKeys(al.get(9));
		        Thread.sleep(700);
		        driver.findElement(By.xpath("//label[contains(text(),'Middle Name')]/following::input"))
				.sendKeys(al.get(10));
		        Thread.sleep(700);
		        driver.findElement(By.xpath("//label[contains(text(),'Last Name')]/following::input"))
				.sendKeys(al.get(11));
		        Thread.sleep(700);
		        WebElement ele3 = driver.findElement(By.xpath("//label[contains(text(),'Suffix')]/following::select"));
		        try {
		        Select s2=new Select(ele3);
				s2.selectByVisibleText(al.get(12));
				Thread.sleep(700);
		        }
		        catch(Throwable t) {
		        	PLvalidate(ele3);
		        }
		        driver.findElement(By.xpath("//label[contains(text(),'Date of Birth')]/following::input"))
				.sendKeys(al.get(13));
		        Thread.sleep(700);
		        ClickNext();
		        log.info("Not a US Citizen details have been added successfully " + al.get(1));
		        }
		        else {
		        	ClickNext();
		        	log.info("Not a US Citizen details have been added successfully " + al.get(1));
		        }
		 

		}
		
			
		}

	}
}
