package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.Color;

import com.testing.base.CPSAT_Question5;


public class CPSAT_Question3 extends CPSAT_Question5{
	
	public static final String url= "https://exammay2020.agiletestingalliance.org/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		CPSAT_Question3POM pom= new CPSAT_Question3POM(d);
		System.out.println("The title of the page is: "+ pom.GetPageTitle());
		pom.getSpeakerDetails("Masa K Maeda");
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
