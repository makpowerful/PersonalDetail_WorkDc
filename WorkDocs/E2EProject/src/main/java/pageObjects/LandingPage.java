package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	
	  By title=By.xpath("/html/head/title");
	
		
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	
}
