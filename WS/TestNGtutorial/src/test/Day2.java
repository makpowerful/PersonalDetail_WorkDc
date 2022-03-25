package test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import static org.openqa.selenium.support.locators.RelativeLocator.withTagname;

import com.google.common.collect.Streams;

public class Day2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//System.out.println(Stream.of("Kalam","Shabaz").filter(s->s.startsWith("K")).count());
		
		/*
		 * List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
		 * 
		 * values.stream().distinct().sorted().forEach(s->System.out.println(s));
		 */
		System.setProperty("webdriver.chrome.driver", "C://Work//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys("w");
		/*
		 * WebElement c= driver.findElement(By.cssSelector("input[type='search']"));
		 * driver.findElement(withTagname("label").above(c)).click();
		 */
		Thread.sleep(2);
		List<WebElement> lst=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> lst2=lst.stream().filter(s->s.getText().contains("w")).collect(Collectors.toList());
		System.out.println(lst.size());
		System.out.println(lst2.size());
		File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,new File( "C://Work//Test1.png"));
		
		
	}
}
