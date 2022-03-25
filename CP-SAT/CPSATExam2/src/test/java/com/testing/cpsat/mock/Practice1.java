package com.testing.cpsat.mock;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;
import com.testing.base.TestBase;

public class Practice1 extends TestBase {
	
	// a. Open the website https://www.rediff.com/ (1/2 mark)
	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() throws InterruptedException {

		
		// b. Click on the menu for News (1/2 mark)
		
		findEClick("//li[@class='news']/a[contains(text(),'NEWS')]");
		
		// c. Take a screenshot (showing that the News is clicked) (1/2 mark)
		takeTheScreenShot("Practice1");
		// d. Get the Href’s of all the submenu items (e.g headlines, defence etc) (2
		// marks)
		int a=1;
		List<WebElement> lst_submenu =d.findElements(By.xpath("//div[@class='subnavbar news']/ul[@class='navbarul']/li/a"));
		for(WebElement e: lst_submenu ) {
			
			System.out.println("The href of sub menu "+a+" is: " +e.getAttribute("href"));
			a++;
			
		}
		// e. Assert that the tool tip of the adjacent menu item Business is “Business
		// Headlines” (1.5 marks)
		WebElement title= d.findElement(By.xpath("//li[@class='news']/following::a[contains(text(),'BUSINESS')]"));
		Assert.assertEquals(title.getAttribute("title"), "Business headlines");
		System.out.println("The tool tip of the adjacent menu item Business is: "+title.getAttribute("title"));
		// f. Hover the mouse on the adjacent menu item (Business) showing the tool tip
		// “Business Headlines”. Take a screenshot showing the tooltip (4 marks)
		
		mouseHover(title);
		wait(1);
		takeScreenShotTip("Practice1","title");
		// g. Assert that the background colour of the submenu items for News is having
		// the following RGB (188, 62, 49) value. ( 2 Marks)
		String Ele=d.findElement(By.xpath("//li[@class='news']")).getCssValue("background-color");
		String Colorvalue=  Color.fromString(Ele).asRgb();
		Assert.assertEquals(Colorvalue,"rgb(188, 62, 49)");
		
		// h. Assert that the value of RGB in above step maps to the following colour
		// name (Grenadier) – Hint use the following website to get the colour name from
		// RGB values https://www.color-blindness.com/color-name-hue/ (4 Marks)
		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		WebElement frame=d.findElement(By.xpath("//iframe"));
		d.switchTo().frame(frame);
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("document.getElementById('cp1_Red').value=188;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Green').value=62;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Blue').value=49;");
		wait(1);
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys(Keys.ENTER);
		wait(1);
		String Colorname=d.findElement(By.id("cp1_ColorNameText")).getText();
		Assert.assertEquals(Colorname, "Grenadier");
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
