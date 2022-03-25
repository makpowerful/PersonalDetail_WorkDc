package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import com.testing.base.CPSAT_Question5;
import com.testing.util.Constants;

public class CPSAT_Question2 extends CPSAT_Question5 {

	int counter=0;
	// Refer the images below for the question steps
	// For each row in the excel sheet
	// a) Open the website https://mayexam.cpsatexam.org/
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String val) throws InterruptedException {
		init(val, "https://exammay2020.agiletestingalliance.org/");
		wait(2);
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
	}

	// Do the following steps in a data driven test format. Use @Dataprovider or
	// similar way to execute the following steps for the given excel sheet below.
	
	@DataProvider(name="dprovider")
	public Object[][] datapro() throws Exception{
		Object[][] dp=readData(Constants.ExcelTest_XLS,"Sheet1");
		return dp;
	}
	
	@Test(priority=0)
	public void testInitial() {
		// b) Mouse over to Forms-Form1 (see image 1) - 1
		WebElement form = d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Forms')]"));
		WebElement form1 = d.findElement(By.xpath("//ul[@class='sub-menu']/li/a[contains(text(),'Form 1')]"));
		Actions action = new Actions(d);
		action.moveToElement(form).build().perform();
		// action.moveToElement(form1).build().perform();
		wait(2);
		// c) Take a screenshot - 1
		takeTheScreenShot("CPSATQ2");
		jsClick(form1);
		wait(2);
	}

	@Test(priority=1,dataProvider="dprovider")
	public void test(String fn, String email, String pn, String Remark) throws Exception {
		// d) Try to enter the data from the row in Get in Touch form. Capture all the
		// error messages for each field and display on the console field wise error
		// message. If there is 1 or more error in the data row, mark the test as
		// failure. If there is no error in the fields, mark the test as pass (8 marks)
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Full Name']")).clear();
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Email']")).clear();
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Mobile Number']")).clear();
		d.findElement(By.xpath("//*[@id='wpforms-129-field_4']")).clear();
		wait(2);
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Full Name']")).sendKeys(fn);
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Email']")).sendKeys(email);;
		d.findElement(By.xpath("//div[@class='wpforms-field-container']/div/input[@placeholder='Mobile Number']")).sendKeys(pn);;
		d.findElement(By.xpath("//*[@id='wpforms-129-field_4']")).sendKeys(Remark);
		d.findElement(By.xpath("//button[@type='submit']")).click();
		counter++;

		List<WebElement> errors=d.findElements(By.xpath("//label[contains(@id,'error')]"));
		setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,0,fn);
		setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,1,email);
		setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,2,pn);
		setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,3,Remark);
		// e) Write the test results row wise (with row data and test status as pass or
		// fail) in any text, csv or Excel file. (5 marks)
		if(errors.size()>0) {
			setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,4,"Fail");
		}
		else {
			setData(Constants.ExcelTestWrite_XLS,"Sheet1",counter,4,"Pass");
		}
		
		
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
