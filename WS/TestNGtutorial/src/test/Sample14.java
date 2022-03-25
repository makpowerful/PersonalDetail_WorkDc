package test;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample14 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		/*
		 * File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(scr,new File("C://Work//Test.png"));
		 */
		
		/*
		 * System.out.println(driver.findElement(By.xpath(
		 * "//input[@id='checkBoxOption1']")).isSelected());
		 * driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		 * System.out.println(driver.findElement(By.xpath(
		 * "//input[@id='checkBoxOption1']")).isSelected());
		 * System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']"))
		 * .size());
		 */
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,2500)");
		WebElement area= driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		System.out.println(area.findElements(By.cssSelector("a")).size());
		for(int i=0;i<area.findElements(By.cssSelector("a")).size();i++) {
			
			Actions a= new Actions(driver);
			String p=Keys.chord(Keys.CONTROL,Keys.ENTER);
			area.findElements(By.cssSelector("a")).get(i).sendKeys(p);
		}
			Set<String> ttab = driver.getWindowHandles();
			Iterator<String> it= ttab.iterator();
		
			Thread.sleep(10);
			while(it.hasNext()){
			
				
				driver.switchTo().window(it.next());
				if(driver.getTitle().contains("404"))
				{
					System.out.println(driver.getTitle());
					File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scr,new File( "C://Work//Test.png"));
					
				}
				
				System.out.println(driver.findElement(By.tagName("title")).getText());
			}
				
			
			
		
		
	}
}
