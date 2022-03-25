package com.testing.cpsat.mock;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class HashMapSample extends TestBase{

	public static final String url = "https://gitlab.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() {
		
		HashMapSamplePOM pom= new HashMapSamplePOM(d);
		
		//pom.MenuLocator("Company");
	
		for(Map.Entry<String, String> me  : pom.MenuLocator("Company").entrySet()) {
			
			//System.out.println(pom.clickLink(me.getKey()).equalsIgnoreCase(me.getValue()));
			Assert.assertTrue(pom.clickLink(me.getKey()).equalsIgnoreCase(me.getValue()));
			
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
