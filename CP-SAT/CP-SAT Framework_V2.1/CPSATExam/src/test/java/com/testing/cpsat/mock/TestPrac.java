package com.testing.cpsat.mock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestPrac {

	@Test
	
	public void test_Sample() {
	//System.setProperty("C:\\Users\\mkalamshabaz\\CP-SAT\\CP-SAT Framework_V2.1\\CPSATExam\\src\\test\\resources\\chromedriver.exe"),"webdriver.chrome.driver"));
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\mkalamshabaz\\eclipse-workspace2021\\E2EProject\\src\\main\\java\\resources\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.google.com");
	}
}
