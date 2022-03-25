package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class HHInformation_AssetPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_IDA_Y_xpath = By.xpath(
			"//div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_IDA_N_xpath = By.xpath(
			"//div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_StckorBond_Y_xpath = By.xpath(
			"//div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_StckorBond_N_xpath = By.xpath(
			"//div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Liquid_Y_xpath = By.xpath(
			"//div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Liquid_N_xpath = By.xpath(
			"//div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Vehicle_Y_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Vehicle_N_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_RealEstate_Y_xpath = By.xpath(
			"//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_RealEstate_N_xpath = By.xpath(
			"//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_LfeIns_Y_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_LfeIns_N_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By chkbx_IDA_HHM1_xpath = By.xpath(
			"//div[1]/div/div/c-ssp-base-component-input-checkbox[1]/div/div/lightning-input/div/span/label/span");
	private By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	public WebElement btn_IDA_Y;
	public WebElement btn_IDA_N;
	public WebElement btn_StckorBond_Y;
	public WebElement btn_StckorBond_N;
	public WebElement btn_Liquid_Y;
	public WebElement btn_Liquid_N;
	public WebElement btn_Vehicle_Y;
	public WebElement btn_Vehicle_N;
	public WebElement btn_RealEstate_Y;
	public WebElement btn_RealEstate_N;
	public WebElement btn_LfeIns_Y;
	public WebElement btn_LfeIns_N;


	public HHInformation_AssetPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_CA_SA_IDA_Y() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if(isDisplayed(tglbtn_IDA_Y_xpath))
		{
		driver.findElement(tglbtn_IDA_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a checking account, savings account, certificate of deposit, individual development account (IDA), or nursing facility resident account?Question not appear");
		}
	}

	public void Click_CA_SA_IDA_N() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if(isDisplayed(tglbtn_IDA_N_xpath))
		{
			driver.findElement(tglbtn_IDA_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a checking account, savings account, certificate of deposit, individual development account (IDA), or nursing facility resident account?Question not appear");
		}
		
	}

	public void Click_CA_SA_IDA_HHM1() {

		driver.findElement(chkbx_IDA_HHM1_xpath).click();
	}

	// Does anyone in this household have investments such as stocks or bonds?

	public void Click_StocksOrBonds_Y() {
		if(isDisplayed(tglbtn_StckorBond_Y_xpath))
		{
			driver.findElement(tglbtn_StckorBond_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have investments such as stocks or bonds? - Question not appear");
		}
		
	}

	public void Click_StocksOrBonds_N() {
		if(isDisplayed(tglbtn_StckorBond_N_xpath))
		{
			driver.findElement(tglbtn_StckorBond_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have investments such as stocks or bonds? - Question not appear");
		}
		
	}
	// Does anyone in this household have other liquid/spendable assets such as
	// cash?

	public void Click_Liquid_Y() {
		if(isDisplayed(tglbtn_Liquid_Y_xpath))
		{
			driver.findElement(tglbtn_Liquid_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have other liquid/spendable assets such as cash? - Question not appear");
		}
		
	}

	public void Click_Liquid_N() {
		if(isDisplayed(tglbtn_Liquid_N_xpath))
		{
			driver.findElement(tglbtn_Liquid_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have other liquid/spendable assets such as cash? - Question not appear");
		}
		
	}
	// Does anyone in this household have a vehicle?

	public void Click_Vehicle_Y() {
		if(isDisplayed(tglbtn_Vehicle_Y_xpath))
		{
			driver.findElement(tglbtn_Vehicle_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a vehicle? - Question not appear");
		}
		
	}

	public void Click_Vehicle_N() {
		if(isDisplayed(tglbtn_Vehicle_N_xpath))
		{
			driver.findElement(tglbtn_Vehicle_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a vehicle? - Question not appear");
		}
		
		
	}

	// Does anyone in this household have a real estate property?

	public void Click_RealEstate_Y() {
		if(isDisplayed(tglbtn_RealEstate_Y_xpath))
		{
			driver.findElement(tglbtn_RealEstate_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a real estate property? - Question not appear");
		}
		
	}

	public void Click_RealEstate_N() {
		if(isDisplayed(tglbtn_RealEstate_N_xpath))
		{
			driver.findElement(tglbtn_RealEstate_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a real estate property? - Question not appear");
		}
		
	}
	// Does anyone in this household have life insurance?

	public void Click_LifeInsurance_Y() {
		if(isDisplayed(tglbtn_LfeIns_Y_xpath))
		{
			driver.findElement(tglbtn_LfeIns_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have life insurance? - Question not appear");
		}
		
	}

	public void Click_LifeInsurance_N() {
		if(isDisplayed(tglbtn_LfeIns_N_xpath))
		{
			driver.findElement(tglbtn_LfeIns_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have life insurance? - Question not appear");
		}
		
	}

	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}
	
	//Does anyone in this household have a checking account, savings account, certificate of deposit, individual development account (IDA), or nursing facility resident account?
	
	public void ClickHHCA_SAwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'checking account, savings account')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'checking account, savings account')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Does anyone in this household have investments such as stocks or bonds?
	
	public void ClickHHStckorBndwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'stocks or bonds')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq2=al.get(4).trim().split(";");
    		for(int i=0;i<Hq2.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'stocks or bonds')]/following::span[contains(text(),'"+Hq2[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Does anyone in this household have other liquid/spendable assets such as cash?
	public void ClickHHLiqwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'liquid/spendable')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq3=al.get(6).trim().split(";");
    		for(int i=0;i<Hq3.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'liquid/spendable')]/following::span[contains(text(),'"+Hq3[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Does anyone in this household have a vehicle?
	public void ClickHHVehiclewithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'vehicle')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'vehicle')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Does anyone in this household have a real estate property?
	public void ClickReakEstatwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'real estate property')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq5=al.get(10).trim().split(";");
    		for(int i=0;i<Hq5.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'real estate property')]/following::span[contains(text(),'"+Hq5[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Does anyone in this household have life insurance?
	public void ClickLifeInswithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Assets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'life insurance')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq6=al.get(12).trim().split(";");
    		for(int i=0;i<Hq6.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'life insurance')]/following::span[contains(text(),'"+Hq6[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    //To Assert the page load
    public String AssertM() {
    	wait(1);
    	return driver.findElement(lbl_Header_xpath).getText();
    	
    }
}
