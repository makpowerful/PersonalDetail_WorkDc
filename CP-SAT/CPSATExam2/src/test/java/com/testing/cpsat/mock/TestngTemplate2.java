package com.testing.cpsat.mock;

import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.util.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class TestngTemplate2 extends TestBase{

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
