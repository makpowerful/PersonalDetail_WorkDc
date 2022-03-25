package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample15 {
	
	

	public static void main (String[] args) {
		
		
		String UN= "stateofmainecitizenjacksmith@deloitte.com";
		String pass="dELOITTE.2*";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver, 5);
		driver.get("https://sit-maine.cs32.force.com/benefits/s/signin?language=en_US");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div/div/lightning-input/div/input")));
		driver.findElement(By.xpath("//div[3]/div/div/lightning-input/div/input")).sendKeys(UN);
		driver.findElement(By.xpath("//div[4]/div/div/lightning-input/div/input")).sendKeys(pass);
		Actions ac= new Actions(driver);
		Set<String> s=driver.getWindowHandles();
		Iterator<String> i = s.iterator();
		String Pageone = i.next();
		String Pagetwo = i.next();
		driver.switchTo().window(Pageone);
		/*for(String winHandle:driver.getWindowHandles()) {
			driver.switchTo().window(Pagetwo);*/
		
		/*JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("")*/
		
		
	}
}
