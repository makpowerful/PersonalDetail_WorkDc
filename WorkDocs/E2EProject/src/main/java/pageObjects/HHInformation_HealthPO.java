package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class HHInformation_HealthPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	
	By btn_StartHHI_xpath = By.xpath("(//button[@type='button'])[4]");
	By tglbtn_Blind_xpath_Y = By.xpath("//legend[contains(text(),'blind or disabled?')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Blind_xpath_N = By.xpath("//legend[contains(text(),'blind or disabled?')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_LTC_xpath_Y = By.xpath("//legend[contains(text(),'Long-Term Care')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_LTC_xpath_N = By.xpath("//legend[contains(text(),'Long-Term Care')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_MediBenft_xpath_Y = By.xpath("//legend[contains(text(),'Medicare benefits')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_MediBenft_xpath_N = By.xpath("//legend[contains(text(),'Medicare benefits')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_Preg_xpath_Y = By.xpath("//legend[contains(text(),'pregnant')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Preg_xpath_N = By.xpath("//legend[contains(text(),'pregnant')]/following-sibling::div//span[contains(text(),'No')]");
	By chkbx_Blind_HHM1_xpath = By.xpath("//lightning-input/div/span/label/span");
	By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	public WebElement blind_xpath_Y;
	public WebElement btn_LTC_xpath_Y;
	public WebElement btn_MediBenft_xpath_Y;
	public WebElement btn_Preg_xpath_Y;
	public WebElement sel_Blind_HHM1;
	By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	
	public HHInformation_HealthPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void ClickStart_HHInfo() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,700);");
		Thread.sleep(1000);
		driver.findElement(btn_StartHHI_xpath).click();
		wait(4);
	}
	//Is anyone in the household blind or disabled?
	
	public void Click_Blind_Y() throws InterruptedException{
		
		/*
		 * blind_xpath_Y=driver.findElement(tglbtn_Blind_xpath_Y);
		 * if(blind_xpath_Y.isDisplayed()) { JavascriptExecutor js =
		 * (JavascriptExecutor) driver; js.executeScript("scroll(0,250);");
		 * Thread.sleep(1000); blind_xpath_Y.click(); } else {
		 * System.out.println("Disabled toggle question did not display"); }
		 */
		
		List<WebElement> blind_xpath_YList=driver.findElements(tglbtn_Blind_xpath_Y);
		if(!blind_xpath_YList.isEmpty())
		{
			if(blind_xpath_YList.get(0).isDisplayed())
			{
				JavascriptExecutor js =(JavascriptExecutor) driver; 
				js.executeScript("scroll(0,250);");
				blind_xpath_YList.get(0).click();
			}
		}
		else
		{
			System.out.println("Disabled toggle question did not display");
		}
		
	}
    public void Click_Blind_N() throws InterruptedException{
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if(isDisplayed(tglbtn_Blind_xpath_N))
		{
			driver.findElement(tglbtn_Blind_xpath_N).click();
		}
		else
		{
			System.out.println("Disabled toggle question did not display");
		}
    	
	}
    
    public void Click_Blind_HHM1() throws InterruptedException {
    	
    	sel_Blind_HHM1=driver.findElement(chkbx_Blind_HHM1_xpath);
    	if(isDisplayed(chkbx_Blind_HHM1_xpath))
    	{
    		sel_Blind_HHM1.click();
    		Scrollpagedown();
    	}
    	else
    	{
    		System.out.println("Select Member is not visible");
    	}
    	
    }
    
    public void ClickBorDwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'blind or disabled')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'blind or disabled')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
	//Does anyone in the household need assistance paying for the cost of Long-Term Care services?
    
	public void Click_LTC_Y(){
		
		btn_LTC_xpath_Y=driver.findElement(tglbtn_LTC_xpath_Y);
		if(isDisplayed(tglbtn_LTC_xpath_Y))
		{
			btn_LTC_xpath_Y.click();
		}
		else
		{
			System.out.println("LTC question is not visible");
		}
		
	}
    public void Click_LTC_N(){
    	
    	if(isDisplayed(tglbtn_LTC_xpath_N))
    	{
    	driver.findElement(tglbtn_LTC_xpath_N).click();
    	}
    	else
    	{
    		System.out.println("LTC question is not visible");
    	}
    	
	}
    
    public void ClickLTCwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'Long-Term Care services')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq2=al.get(4).trim().split(";");
    		for(int i=0;i<Hq2.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Long-Term Care services')]/following::span[contains(text(),'"+Hq2[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Does anyone in this household currently or previously have Medicare benefits, is conditionally enrolled in Medicare Part A, or will be entitled to Medicare in the next few months?
	 
	public void Click_MediCare_Benfit_Y(){
		
		btn_MediBenft_xpath_Y=	driver.findElement(tglbtn_MediBenft_xpath_Y);
		if(isDisplayed(tglbtn_MediBenft_xpath_Y))
		{
		btn_MediBenft_xpath_Y.click();
		}
		else
		{
			System.out.println("Medicare Benefit question is not visible");
		}
		
	}
    public void Click_MediCare_Benfit_N(){
    	
    	
    	if(isDisplayed(tglbtn_MediBenft_xpath_N))
		{
    		driver.findElement(tglbtn_MediBenft_xpath_N).click();
		}
		else
		{
			System.out.println("Medicare Benefit question is not visible");
		}
	}
    
    public void ClickMedAwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'Medicare Part A')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq3=al.get(6).trim().split(";");
    		for(int i=0;i<Hq3.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Medicare Part A')]/following::span[contains(text(),'"+Hq3[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    //Is anyone in this household pregnant or was pregnant in the last three months?
	public void Click_Pregnancy_Y(){
		
		if(isDisplayed(tglbtn_Preg_xpath_Y))
		{
		driver.findElement(tglbtn_Preg_xpath_Y).click();
		}
		else
    	{
    		System.out.println("Pregnancy Question is not visible");
    	}
		
		
	}
    public void Click_Pregnancy_N(){
    	
    	//btn_Preg_xpath_Y = driver.findElement(tglbtn_Preg_xpath_N);
    	if(isDisplayed(tglbtn_Preg_xpath_N))
		{
		driver.findElement(tglbtn_Preg_xpath_N).click();
		}
		else
    	{
    		System.out.println("Pregnancy Question is not visible");
    	}
	}
    
    public void ClickPregwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'household pregnant')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'household pregnant')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //To Assert the page load
    public String AssertM() {
    	wait(1);
    	return driver.findElement(lbl_Header_xpath).getText();
    	
    }
    public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}
}
