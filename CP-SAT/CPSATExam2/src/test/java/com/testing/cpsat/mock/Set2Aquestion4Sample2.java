package com.testing.cpsat.mock;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set2Aquestion4Sample2 extends TestBase{

	public static final String url = "https://www.woodlandworldwide.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	@DataProvider(name="datap")
	public Object[][] testdp() throws Exception{
		
		Object[][] dp=readData("src\\test\\resources\\TestData\\TestData.xlsx","Set2aQ4");
		return dp;
	}

	@Test(dataProvider="datap")
	public void test(String name) {
		
		wait(1);
		d.findElement(By.xpath("//input[@id='searchKey']")).sendKeys(name,Keys.ENTER);
		wait(3);
		int m=1;
		int n=1;
		String val="Value for "+name+" product ";
		List<WebElement> lst_BP=d.findElements(By.xpath("//div[@class='product-text']/a/p/span[1]"));
		HashMap<String,String> hm_BF=new HashMap<String,String>();
		for(int i=0; i<=8;i++) {
			//String[] a=lst_BP.get(i).getText().trim().split(" ");
			String b[]=lst_BP.get(i).getAttribute("innerHTML").split("</span>");
			//System.out.println(a[0]);
			//System.out.println(b[1].replace(" ", ""));
			
			hm_BF.put(Integer.toString(m), b[1].replace(" ", "").trim());
			
			m++;
		}
		System.out.println("Prices not in Ascening order for "+name+"  : "+hm_BF.values());
		
		WebElement sortb=d.findElement(By.xpath("//div[@class='sorting']/span"));
		Actions action=new Actions(d);
		action.moveToElement(sortb).build().perform();
		wait(2);
		d.findElement(By.xpath("//div[@class='dropdown-menu1']/a[4]")).click();
		wait(1);
		HashMap<String,String> hm_AF=new HashMap<String,String>();
		List<WebElement> lst_AP=d.findElements(By.xpath("//div[@class='product-text']/a/p/span[1]"));
		for(int j=0;j<=8;j++) 
		{
			
			
			String c[]=lst_AP.get(j).getAttribute("innerHTML").split("</span>");
			hm_AF.put(Integer.toString(n), c[1].replace(" ", "").trim());
			
			n++;
		}
		System.out.println("Prices in Ascening order for"+name+" : "+hm_AF.values());
		wait(1);
		
		//System.out.println(hm_BF.keySet().equals(hm_AF.values()));
		
		d.findElement(By.xpath("//input[@id='searchKey']")).clear();
		
		
		
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
