package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class PracticeSet3question4 extends TestBase{

	public static final String url = "https://exammay2020.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() {
		
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Registration')]")).click();
		wait(1);
		String b1= d.findElement(By.xpath("(//button[text()='Sold Out'])[1]")).getAttribute("class");
		String b2= d.findElement(By.xpath("(//button[text()='Sold Out'])[2]")).getAttribute("class");
		WebElement b3= d.findElement(By.xpath("(//button[text()='Register Now'])[1]"));
		if(b1.contains("disabled")&&b2.contains("disabled")) {
			
			jsClick(b3);
		}
		
		
		List<WebElement> lst_name = d.findElements(By.xpath("//div[@class='pill__item__content pill__item__content__first']"));
		List<WebElement> lst_amt = d.findElements(By.xpath("//div[@class='pill__item__content pill__item__content__first']"));
			
		
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		/*
		 * if(d != null) { terminate(); }
		 */
	}

}
