package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class HHInformation_OAssetPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_TrstF_Y_xpath= By.xpath("//div[1]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_TrstF_N_xpath= By.xpath("//div[1]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Anuity_Y_xpath= By.xpath("//div[2]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Anuity_N_xpath= By.xpath("//div[2]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_LifeE_Y_xpath= By.xpath("//div[3]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_LifeE_N_xpath= By.xpath("//div[3]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_PNorLC_Y_xpath= By.xpath("//div[4]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_PNorLC_N_xpath= By.xpath("//div[4]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_BurialF_Y_xpath= By.xpath("//div[5]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_BurialF_N_xpath= By.xpath("//div[5]/div/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By chkbx_TrstF_HHM1_xpath= By.xpath("//div[1]/div/div/c-ssp-base-component-input-checkbox[1]/div/div/lightning-input/div/span/label/span");
	private By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	
	public HHInformation_OAssetPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	//Does anyone in this household have a trust fund?
	
	public void Click_TrustFund_Y() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_TrstF_Y_xpath).click();
	}

	public void Click_TrustFund_N() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_TrstF_N_xpath).click();
	}

	public void Click_TrustFund_HHM1() {
		
		driver.findElement(chkbx_TrstF_HHM1_xpath).click();
	}
	
	//Does anyone in this household have an annuity?
	
	public void Click_Annuity_Y() {
		
		driver.findElement(tglbtn_Anuity_Y_xpath).click();
	}

	public void Click_Annuity_N() {
		
		driver.findElement(tglbtn_Anuity_N_xpath).click();
	}
	
	//Does anyone in this household have a life estate?
	
	public void Click_LifeEstate_Y() {
		
		driver.findElement(tglbtn_LifeE_Y_xpath).click();
	}

	public void Click_LifeEstate_N() {
		
		driver.findElement(tglbtn_LifeE_N_xpath).click();
	}
	//Does anyone in this household have a promissory note or land contract?
	
	public void Click_PromiNote_LandContrct_Y() {
		
		driver.findElement(tglbtn_PNorLC_Y_xpath).click();
	}

	public void Click_PromiNote_LandContrct_N() {
		
		driver.findElement(tglbtn_PNorLC_N_xpath).click();
	}
	
	//Does anyone in this household have a burial fund, plot, or contract?
	
	public void Click_BurialF_Y() {
		
		driver.findElement(tglbtn_BurialF_Y_xpath).click();
	}

	public void Click_BurialF_N() {
		
		driver.findElement(tglbtn_BurialF_N_xpath).click();
	}
	
    public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}
    
    //Does anyone in this household have a trust fund?
    public void ClickHHTrustFwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-OAssets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'trust fund')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'trust fund')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //Does anyone in this household have an annuity?
    public void ClickHHAnnuitywithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-OAssets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'have an annuity')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq2=al.get(4).trim().split(";");
    		for(int i=0;i<Hq2.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'have an annuity')]/following::span[contains(text(),'"+Hq2[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //Does anyone in this household have a life estate?
    public void ClickHHLifeEswithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-OAssets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'life estate')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq3=al.get(6).trim().split(";");
    		for(int i=0;i<Hq3.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'life estate')]/following::span[contains(text(),'"+Hq3[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //Does anyone in this household have a promissory note or land contract?
    public void ClickHHPnotewithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-OAssets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'promissory note or land contract')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'promissory note or land contract')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //Does anyone in this household have a burial fund, plot, or contract?
    public void ClickHHfundplotwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-OAssets", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'fund, plot, or contract')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq5=al.get(10).trim().split(";");
    		for(int i=0;i<Hq5.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'fund, plot, or contract')]/following::span[contains(text(),'"+Hq5[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
    
    //To Assert the page load
    public String AssertM() throws InterruptedException {
    	Thread.sleep(700);
    	return driver.findElement(lbl_Header_xpath).getText();
    	
    }
}
