package com.testing.cpsat.mock;

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


public class TestngTemplate extends CPSAT_Question5{

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String val) throws InterruptedException {
		init(val, "");
		wait(2);
	}

	@Test
	public void test() {
	
	}
	
	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
