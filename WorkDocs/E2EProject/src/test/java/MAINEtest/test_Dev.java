package MAINEtest;
import java.io.IOException;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class test_Dev extends TestBase {
	public static final String URL = "https://dev-maine.cs32.force.com/benefits/s/";

	@BeforeTest
	public void setUp() {
		init("Chrome",URL);
	}
	@Test
	public void Test() throws IOException, InterruptedException {

		
		wait(3);
		d.findElement(By.xpath("//li/div/a[contains(text(),'Sign In')]")).click();
		d.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input[@type='text']")).sendKeys("nuptestaccount@mailinator.com");
		d.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input[@type='password']")).sendKeys("Deloitte@1234");
		d.findElement(By.xpath("//button[@value='Accept']")).click();
		d.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		wait(3);
		d.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		wait(2);
		d.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		wait(2);
		d.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
		wait(15);
		Scrollend();
		WebElement element=d.findElement(By.xpath("//button[contains(text(),'Next')]"));
		WebDriverWait wait= new WebDriverWait(d, 10000);
		
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
		wait(2); 
		for(int i=0;i<=10;i++)
		{
		d.findElement(By.xpath("//input[@type='text']")).clear();
		wait(1);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("4089, IRON WORKS PARKWAY,", Keys.BACK_SPACE);
		wait(2);
		WebElement w=d.findElement(By.xpath("//div/input"));
		if(w.isDisplayed()) {
			w.click();
			wait(1);
		}
		}
		
	}

	@AfterTest
	public void teardown() {
		//driver.close();
	}
}
