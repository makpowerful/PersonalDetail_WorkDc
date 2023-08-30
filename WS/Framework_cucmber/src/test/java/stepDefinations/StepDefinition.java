package stepDefinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.GreenCartMainPO;
import pageObjects.GreenCartTDPO;
import utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;


public class StepDefinition {
	
	public WebDriver driver;
	String Mainwinval;
	String TDwinval;
	TestContextSetup testcontextsetup;
	
	public StepDefinition(TestContextSetup testcontextsetup) {
		
		this.testcontextsetup=testcontextsetup;
		
	}
	
    @Given("^User is on Greenkart Homepage and should search the product (.+)$")
    public void user_is_on_greenkart_homepage_and_should_search_the_product(String productmain) throws Throwable {
    	//System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
    	testcontextsetup.driver=new ChromeDriver();
    	testcontextsetup.driver.manage().window().maximize();
    	testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    	Thread.sleep(3000);
    	//Mainwin=driver.getWindowHandle();
    	GreenCartMainPO  gc= new GreenCartMainPO(testcontextsetup.driver);
    	gc.EnterSearchVal(productmain);
    	Thread.sleep(1000);
    	System.out.println(gc.CaptureVal());
    	Mainwinval=gc.CaptureVal();
    	gc.ClicklinkTopdeal();
    	Thread.sleep(1000);
  	
    	
    	
    	
    }

    @When("^GreenKart Homepage Value is compared with Top deal  search Page$")
    public void greenkart_homepage_value_is_compared_with_top_deal_search_page() throws Throwable {
       
    }

    @Then("^They values should match$")
    public void they_values_should_match() throws Throwable {
    	
    	Assert.assertEquals(Mainwinval, TDwinval);
    	System.out.println("Value  matches"+Mainwinval+TDwinval);
        
    }

    @And("^User is on Greenkart top search page and should search the product (.+)$")
    public void user_is_on_greenkart_top_search_page_and_should_search_the_product(String producttable) throws Throwable {
    	
        GreenCartTDPO td=new GreenCartTDPO(testcontextsetup.driver);
     	
		Set<String> winid = testcontextsetup.driver.getWindowHandles();
        Iterator<String> iter = winid.iterator();
        iter.next();
        String tab = iter.next();
        Thread.sleep(3000);
        testcontextsetup.driver.switchTo().window(tab);
    	td.TDEnterSearchVal(producttable);
    	TDwinval=td.TDCaptureVal();
    	
    	
    }


}