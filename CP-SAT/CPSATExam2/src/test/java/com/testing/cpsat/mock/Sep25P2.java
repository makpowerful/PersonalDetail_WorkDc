package com.testing.cpsat.mock;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.util.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Sep25P2 extends TestBase {

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String val) throws InterruptedException {
		init(val, "https://mockexam1cpsat.agiletestingalliance.org/");
		wait(2);
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
	}

	@DataProvider(name = "datapro")
	public Object[][] datapro() throws Exception {
		Object[][] dp = readData("src\\test\\resources\\TestData\\TestData.xlsx", "Mock1Q2");
		return dp;
	}

	@Test(priority = 1)
	public void initial() throws InterruptedException {
		d.findElement(By.xpath("//ul[@class=' menu sf-menu']/li/a")).click();
		wait(1);
		WebElement listpart = d.findElement(By.xpath("//ul[@class=' slideout-menu']/li/a[contains(text(),'List')]"));
		scrollIntoView(listpart);
		listpart.click();
		wait(2);

	}
	int i=0;
	@Test(priority = 2, dataProvider = "datapro")
	public void testpro(String tName, String name, String desig, String oName, String ExeR) throws Exception {
		WebElement input = d.findElement(By.xpath("//input[@type='text']"));
		scrollIntoView(input);

			d.findElement(By.xpath("//input[@type='text']")).clear();
			wait(2);
			d.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
			wait(2);
			List<WebElement> lst_table = d.findElements(By.xpath("//tr/td"));
			String Actualname = lst_table.get(1).getText();
			String Actualdesig = lst_table.get(2).getText();
			String ActualoName = lst_table.get(3).getText();

			if (name.equalsIgnoreCase(Actualname) && desig.equalsIgnoreCase(Actualdesig)
					&& oName.equalsIgnoreCase(ActualoName)) {

				setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 4, "Pass");

			} else {
				setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 4, "Fail");
			}

			setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 0, tName);
			setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 1, Actualname);
			setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 2, Actualdesig);
			setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", i, 3, ActualoName);
			i++;
			d.findElement(By.xpath("//button[@type='submit']")).click();
			wait(2);

			d.findElement(By.xpath("//input[@type='text']")).clear();
			wait(2);
		}


	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
