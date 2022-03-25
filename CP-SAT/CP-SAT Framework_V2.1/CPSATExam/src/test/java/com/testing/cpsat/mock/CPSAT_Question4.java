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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import com.testing.base.CPSAT_Question5;



public class CPSAT_Question4 extends CPSAT_Question5{

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String val) throws InterruptedException {
		init(val, "https://exammay2020.agiletestingalliance.org/");
		wait(2);
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
	}

	@Test
	public void test() {
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'News')]")).click();
		wait(2);
		
		List<WebElement> lst_blog=d.findElements(By.xpath("//div[@class='elementor-post__meta-data']/following::a[contains(text(),'Read')]"));
		List<WebElement> lst_pagenumbers=d.findElements(By.xpath("//nav[@class='elementor-pagination']/span/following::a[@class='page-numbers']"));
	
		for(int i=0;i<lst_pagenumbers.size();i++) {
			
			System.out.println(lst_blog.get(i).getAttribute("href"));
			
		}
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Registration')]")).click();
		wait(2);
		
	}
	
	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
