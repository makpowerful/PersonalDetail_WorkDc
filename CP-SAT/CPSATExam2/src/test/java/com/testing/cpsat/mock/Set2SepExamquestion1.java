package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2SepExamquestion1 extends TestBase {
	// i. Go to ‘URL’
	public static final String url = "https://exammay2020.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() throws Exception {

		// ii. Mouse hover over DHOPPA2020 on the menu bar, take screenshot at this
		// instance, click about
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		WebElement menu_dhoppa = d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Doppa2020')]"));
		Actions action = new Actions(d);
		action.moveToElement(menu_dhoppa).build().perform();
		wait(1);
		takeTheScreenShot("Set2SepEQ1");
		wait(1);
		WebElement menu_dhoppa_about =d.findElement(By.xpath("//ul[@class='sub-menu']/li/a[contains(@href,'about')]"));
		
		
		//WebDriverWait w=new WebDriverWait(d,10);
		//w.until(ExpectedConditions.elementToBeClickable(menu_dhoppa_about));
		//action.moveToElement(menu_dhoppa_about).build().perform();
		//action.click(menu_dhoppa_about).build().perform();
		jsClick(menu_dhoppa_about);
		wait(2);
		// iii. Find out the name of all jury members and volunteers who have “Test” in
		// their titles (if the titles have anything extra, it should not be
		// considered.)This should be done using xpath or CSS locators and in java code
		// please use findelements.
		String MainWin;
		MainWin=d.getWindowHandle();

		scrollIntoView(d.findElement(By.xpath("//p[@class='elementor-image-box-description']")));
		
		List<WebElement> lst_valuetest=d.findElements(By.xpath("//p[@class='elementor-image-box-description']"));
		List<WebElement> lst_nametest=d.findElements(By.xpath("//div[@class='elementor-image-box-content']/h4"));
		int j=1;
		for(int i=0;i<lst_valuetest.size();i++) {
			
			if(lst_valuetest.get(i).getText().contains("Test")) {
				//System.out.println("The names containing word Test is: "+lst_nametest.get(i).getText());
				System.out.println("The name "+j+" containing word Test is: "+lst_nametest.get(i).getText());
				j++;
			}
			
		}
		
		
		
		// iv. Please do the following
		// a. Scroll down to the place where the social media icons are there and take a
		// screenshot
		// b. Using single xpath or CSS locator, find the href of all social media icons
		// i. Print them on system console
		// ii. Click on these social media icons – it will open a new window
		// iii. Print the title of the new window opened
		// iv. Take a screen shot
		// c. Find out how many times #dhoppa2020 is there on the web page. Print the
		// number on the system console
		
		scrollIntoView(d.findElement(By.xpath("//div[@class='social_icon']/a")));
		takeTheScreenShot("Set2SepEQ1");
		List <WebElement> lst_social=d.findElements(By.xpath("//div[@class='social_icon']/a"));
		for(WebElement e: lst_social) {
			
			System.out.println(e.getAttribute("href"));
		}
		
		for(int k=0;k<lst_social.size();k++) {
			
			action.contextClick(lst_social.get(k)).build().perform();
			OpenNewWindow();
			wait(2);
			switchWindow();
			System.out.println("The title of the page is :"+d.getTitle());
			takeScreenShotTip("Set2SepEQ1","title"+k);
			wait(2);
			d.close();
			d.switchTo().window(MainWin);
			
		}
		
		List <WebElement> lst_doppa=d.findElements(By.xpath("//*[contains(text(),'#doppa2020')]"));
		System.out.println("The total number of elements on web page are: "+lst_doppa.size());

	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
