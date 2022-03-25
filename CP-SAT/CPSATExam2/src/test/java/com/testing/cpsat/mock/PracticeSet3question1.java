package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class PracticeSet3question1 extends TestBase{
	//a.	Open the website ‘URL’
	public static final String url = "https://exammay2020.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws AWTException, InterruptedException {
		
		
		//b.	Click on menu venue. It will open up a page
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(@href,'venue')]")).click();
		wait(2);
		
		//c.	Extract the mail id from element under Email us
		//d.	Print it on the system console(for steps b,c,d 1 marks)
		String Mainwin=d.getWindowHandle();
		String email1= d.findElement(By.xpath("//p[@class='elementor-icon-box-description']/a")).getText();
		System.out.println("The mail id is: "+email1);
		
		//e.	Extract phone number below call us
		//f.	Convert the number after +91- to Integer
		//g.	Print it on the system console(for steps e,f,g 1 mark)
		String[] pnumber=d.findElement(By.xpath("//p[@class='elementor-icon-box-description']/following::a")).getText().trim().split("-");
		long pn= Long.parseLong(pnumber[1]);
		System.out.println("The number is: "+pn);
		//h.	Scroll down to the bottom of the page
		//i.	Extract the phone number next to the phone symbol and convert tot integer
		//j.	Do an assertion on phone number in step i) being the same in step f).
		scrollIntoView(d.findElement(By.xpath("//div[@class='info_area']/i/following::p")));
		wait(1);
		String[] anothernumber=d.findElement(By.xpath("//div[@class='info_area']/i/following::p")).getText().trim().split(" ");
		long an= Long.parseLong(anothernumber[1]);
		Assert.assertEquals(pn,an);
		
		//k.	Extract the email id next the email image and do an assertion if the email is same as step c)
		String email= d.findElement(By.xpath("//div[@class='info_area']/following::p/a")).getText();
		Assert.assertEquals(email,email1);
		wait(1);
		
		//l.	Click on all the social media icons and print the title of the social media page that has been opened up after clicking . This should be done for all the four social media icons 
		List<WebElement> lst_social= d.findElements(By.xpath("//div[@class='social_icon']/a"));
		for(int i=0; i<lst_social.size();i++) {
			
			Actions action= new Actions(d);
			action.contextClick(lst_social.get(i)).build().perform();
			OpenNewWindow();
			wait(1);
			switchWindow();
			System.out.println(d.getTitle());
			d.close();
			d.switchTo().window(Mainwin);
			
			
		}

	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
