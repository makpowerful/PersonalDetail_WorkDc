package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2SepExamquestion2 extends TestBase {

	// 1. For every row open the website ‘URL’
	public static final String url = "https://exammay2020.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}
	
	@DataProvider(name="dataprovider")
	public Object[][] Testdp() throws Exception{
		
		Object[][] dp= readData("src\\test\\resources\\TestData\\TestData.xlsx","SepExamQ2");
		return dp;
		
	}

	@Test(priority=0)
	public void Initial() {

		// 2. For every row use mouse hover over on menu data and click on data2
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		WebElement menu_Data = d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Data')]"));
		Actions action = new Actions(d);
		action.moveToElement(menu_Data).build().perform();
		wait(1);
		WebElement menu_Data_data2 = d.findElement(By.xpath("//ul[@class='sub-menu']/li/a[contains(@href,'Data 2')]"));

		jsClick(menu_Data_data2);
		wait(2);
	}

	@Test(priority=1)
	public void test() {

		// 3. From an excel sheet table fetch the rows and validate that the table on
		// the website from step 2 has similar row value fetched from the excel sheet,
		// ID, Employee Name, City and Hire Date. If the values match the test should
		// show as pass, if the value doesn’t match the test should fail.

		// 4. Create a separate file which will store the pass/fail for every row
		// Please note that every row has to run in a separate test. In other words ,
		// you should not validate all the rows of the excel sheet in the same test.

	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
