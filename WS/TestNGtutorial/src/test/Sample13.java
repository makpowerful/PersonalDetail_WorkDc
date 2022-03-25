package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample13 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	
}
