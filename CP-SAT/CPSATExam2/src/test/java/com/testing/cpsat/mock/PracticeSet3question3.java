package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class PracticeSet3question3 extends TestBase{
	
	public static final String url= "https://exammay2020.agiletestingalliance.org/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		PracticeSet3question3POM pom= new PracticeSet3question3POM(d);
		pom.moveToAboutSpeaker();
		pom.GetPageTitle();
		String[] values= {"Khimanand Upreti","Masa K Maeda","Brijesh Deb"};
		for(int i=0;i<values.length;i++) {
			pom.GetSpeakerDetails(values[i]);
		}
		
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
