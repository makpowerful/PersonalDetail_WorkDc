package com.testing.cpsat.mock;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class HashMapSamplePOM extends TestBase {
	
	private String MenuHeader_xpath="//div[@class='footer-links-container']/div/h3";
	HashMap<String,String> menulink=new HashMap<String,String>();
	String url;

	public  HashMapSamplePOM (WebDriver d) {
		
	this.d=d;
	
	}
	
	public HashMap<String, String> MenuLocator(String menu) {
		
		scrollIntoView(d.findElement(By.xpath("//div[@class='footer-links-container']/div/h3")));
		wait(1);
		
		List<WebElement> lst_menu=d.findElements(By.xpath("//div[@class='footer-links-container']/div/h3[contains(text(),'"+menu+"')]/following::ul/li/a"));
		int a=1;
		for(WebElement e: lst_menu ) {
			
			//System.out.println("The href for menu item "+a+" is: "+e.getAttribute("href"));
		a++;	
		menulink.put(e.getText(), e.getAttribute("href"));
		System.out.println(menulink);
		
		}
		
		return menulink;
	}
	
	public String clickLink(String Key) {
		
		d.findElement(By.xpath("//a[text()='"+Key+"']")).click();
		wait(3);
		url= d.getCurrentUrl();
		d.navigate().back();
		wait(3);
		return url;
	}
}
