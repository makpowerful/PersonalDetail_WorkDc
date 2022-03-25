package com.testing.cpsat.mock;

import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.util.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class Sep25P1 extends TestBase{

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String val) throws InterruptedException {
		init(val, "https://mockexam1cpsat.agiletestingalliance.org/");
		wait(2);
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
	}

	@Test
	public void test() throws AWTException, InterruptedException {
		String Mainwin= d.getWindowHandle();
		d.findElement(By.xpath("//ul[@class=' menu sf-menu']/li/a")).click();
		System.out.println("The menu item list is below:");
		List<WebElement> lst_menu=d.findElements(By.xpath("//ul[@class=' slideout-menu']/li/a"));
		for(WebElement e: lst_menu) {
			
			System.out.println(e.getText());
		}
		System.out.println("The social media item list is below:");
		List<WebElement> lst_social=d.findElements(By.xpath("//ul[@class='lsi-social-icons icon-set-lsi_widget-1']/li/a"));
		for(WebElement f: lst_social) {
			
			System.out.println(f.getAttribute("href"));
		}
		for(int g=0;g<3;g++) {
			
			Actions action=new Actions(d);
			action.contextClick(lst_social.get(g)).build().perform();
			OpenNewWindow();
			switchWindow();
			System.out.println(d.getTitle());
			wait(1);
			d.close();
			d.switchTo().window(Mainwin);
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
