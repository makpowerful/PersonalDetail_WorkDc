package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import com.testing.base.CPSAT_Question5;


public class CPSAT_Question1 extends CPSAT_Question5 {
	// a) Open the website https://mayexam.cpsatexam.org/
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String val) throws InterruptedException {
		init(val, "https://exammay2020.agiletestingalliance.org/");
		wait(2);
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
	}

	@Test
	public void test() throws AWTException, InterruptedException {

		// b) Click on Menu Venue, it will open up the page as per image 1
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'Venue')]")).click();
		wait(2);
		// c) Extract the mail id from the element under Email Us
		String Mainwin=d.getWindowHandle();
		String email=d.findElement(By.xpath("//div[@class='elementor-icon-box-content']/p/a")).getText();
		// d) Print it on the system console (for steps b,c, d : 1 mark)
		System.out.println("The email is: "+email);
		//	e) Extract the phone number below Call us
		String phonenumber=d.findElement(By.xpath("//div[@class='elementor-icon-box-content']/p[1]/a[contains(text(),'91')]")).getText().replace("+91-","");
		// f) Convert the number after +91- to Integer
		Long pn=Long.parseLong(phonenumber);
		// g) Print it on the system console (for steps e,f,g : 1 mark)
		System.out.println("The phone number is: "+pn);
		// h) Scroll down to the bottom of the page – see image 2 (1 mark)
		scrollIntoView(d.findElement(By.xpath("//div[@class='social_icon']/a")));
		//i) Extract the phone number next the phone symbol and convert to the integer (1 mark)
		String infophonenumber = d.findElement(By.xpath("//div[@class='info_area']/i/following::p")).getText().replace("+91 ", "");
		Long ipn=Long.parseLong(infophonenumber);
		// j) Do an assertion on the phone number in step i) being same as in step f (1
		// mark)
		Assert.assertEquals(pn,ipn);
		// k) Extract the email id next to the email image and do an assertion if the
		// email is same as in step c (1 mark)
		String infoemail = d.findElement(By.xpath("//div[@class='info_area']/i/following::p[2]")).getText();
		Assert.assertEquals(email,infoemail);
		// l) Click on all the social media icons and print the title of the social
		// media page that has been opened up after clicking. This should be done for
		// all the 4 social media icons. (4 marks)
		
		List<WebElement> lst_social= d.findElements(By.xpath("//div[@class='social_icon']/a"));
		for(int i=0;i<lst_social.size();i++) {
			
			Actions action = new Actions(d);
			action.contextClick(lst_social.get(i)).build().perform();
			OpenNewWindow();
			switchWindow();
			wait(2);
			System.out.println("The title of the page is: "+ d.getTitle());
			d.close();
			d.switchTo().window(Mainwin);
			
		}

	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
