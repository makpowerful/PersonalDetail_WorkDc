package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_OtherInfo_LAPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	By pcklst_LA_xpath= By.xpath("//select");
	By lbl_LA_xpath =By.xpath("//p[text()='Living Arrangements']");
	static int counterx =1;
	public MD_OtherInfo_LAPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void Select_CLA_LIYH() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		Select cla = new Select(driver.findElement(pcklst_LA_xpath));
		cla.selectByVisibleText("Living in your home");
	}
	
	public void Select_CLA_HS() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		Select cla = new Select(driver.findElement(pcklst_LA_xpath));
		cla.selectByVisibleText("Homeless Shelter");
	}
	
    public void ClickNext() {
    	
		WebElement element=driver.findElement(btn_Next_xpath);
		clickButton(element);
		wait(4);
	}
    
    //***********************************************************************************
	public void PickLLivingArrangment() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//select/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Living Arrangement", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Living Arrangement", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
    public void EnterLivingArr(String TCid) throws Exception {
    	
    	al = excelData.getData(TCid, "Reg-MD-LivingA", "Sno");
    	if(isDisplayed(lbl_LA_xpath)) {
    		if(counterx==1) {
    		
    			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
    			cppo.ClearPLLivingArrangement();
    			PickLLivingArrangment();
    			counterx++;
    			
    		}
    		Select s1=new Select(driver.findElement(By.xpath("//select")));
    		s1.selectByVisibleText(al.get(2));
    		Thread.sleep(700);
    		if(al.get(2).contains("Jail or Prison")||al.get(2).contains("Youth Center (e.g. Long Creek Youth Development Center)")) {
    			driver.findElement(By.xpath("//label[contains(text(),'Imprisonment Start Date')]/following::input")).sendKeys(al.get(3));
    			Thread.sleep(700);
    			driver.findElement(By.xpath("//label[contains(text(),'Planned Release Date')]/following::input")).sendKeys(al.get(4),Keys.ENTER);
    			Thread.sleep(700);
    			Select s2=new Select(driver.findElement(By.xpath("//label[contains(text(),'be after your release date?')]/following::select")));
    			s2.selectByVisibleText(al.get(5));
    			Thread.sleep(700);
    			ClickNext();
    		}
    		
    		else if(al.get(2).contains("Drug/Alcohol Treatment Center")||al.get(2).contains("Hospital")) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Planned Release Date')]/following::input")).sendKeys(al.get(4),Keys.ENTER);
    			Thread.sleep(700);
    			ClickNext();
    		}
    		
    		else if(al.get(2).contains("Other")) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Other Living Arrangement')]/following::input")).sendKeys(al.get(6));
    			Thread.sleep(700);
    			ClickNext();
    		}
    		else {
    			ClickNext();
    		}
    		
    	}
    	
    	
    }

}
