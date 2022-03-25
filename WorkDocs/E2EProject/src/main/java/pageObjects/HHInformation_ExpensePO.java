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

public class HHInformation_ExpensePO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	private By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_3Mnths_Y_xpath = By.xpath(
			"//label[contains(text(),'three months')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_3Mnths_N_xpath = By.xpath(
			"//label[contains(text(),'three months')]/following::span[contains(text(),'No')][1]");
	By chkbx_3Mnths_HHM1_xpath = By
			.xpath("//div[1]/p[2]/c-ssp-base-component-input-checkbox[1]/div/div/lightning-input/div/span/label/span");
	By tglbtn_SE_Y_xpath = By.xpath(
			"//label[contains(text(),'shelter expenses')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_SE_N_xpath = By.xpath(
			"//label[contains(text(),'shelter expenses')]/following::span[contains(text(),'No')][1]");
	By tglbtn_UE_Y_xpath = By.xpath(
			"//label[contains(text(),'utility expenses')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_UE_N_xpath = By.xpath(
			"//label[contains(text(),'utility expenses')]/following::span[contains(text(),'No')][1]");
	By tglbtn_TDE_Y_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_TDE_N_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Almny_Y_xpath = By.xpath(
			"//label[contains(text(),'alimony')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_Almny_N_xpath = By.xpath(
			"//label[contains(text(),'alimony')]/following::span[contains(text(),'No')][1]");
	By tglbtn_ME_abv60_Y_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_ME_abv60_N_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_CS_Y_xpath = By.xpath(
			"//label[contains(text(),'child support')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_CS_N_xpath = By.xpath(
			"//label[contains(text(),'child support')]/following::span[contains(text(),'No')][1]");
	By tglbtn_DC_Y_xpath = By.xpath(
			"//label[contains(text(),'dependent care')]/following::span[contains(text(),'Yes')][1]");
	By tglbtn_DC_N_xpath = By.xpath(
			"//label[contains(text(),'dependent care')]/following::span[contains(text(),'No')][1]");
	By selectMemberShelter = By.xpath("//*[contains(text(),'shelter')]/following::p[contains(text(),'Select')]/following-sibling::p[1]//label/span[1] ");

	public HHInformation_ExpensePO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	// Does anyone in your household need help paying medical bills from the last
	// three months?

	public void Click_Mbin3Mnths_Y() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if (isDisplayed(tglbtn_3Mnths_Y_xpath)) {
			driver.findElement(tglbtn_3Mnths_Y_xpath).click();
		} else {
			System.out.println(
					"Does anyone in your household need help paying medical bills from the last three months? - is not visible");
		}

	}

	public void Click_Mbin3Mnths_N() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if (isDisplayed(tglbtn_3Mnths_N_xpath)) {
			driver.findElement(tglbtn_3Mnths_N_xpath).click();
		} else {
			System.out.println(
					"Does anyone in your household need help paying medical bills from the last three months? - is not visible");
		}

	}

	public void Click_Mbin3Mnths_HHM1() {

		if (isDisplayed(chkbx_3Mnths_HHM1_xpath)) {
			driver.findElement(chkbx_3Mnths_HHM1_xpath).click();
		} else {
			System.out.println(
					"Does anyone in your household need help paying medical bills from the last three months? - is not visible");
		}

	}

	// Does anyone in this household have shelter expenses?

	public void Click_ShelterE_Y() {
		if (isDisplayed(tglbtn_SE_Y_xpath)) {
			driver.findElement(tglbtn_SE_Y_xpath).click();
		} else {
			System.out.println("Does anyone in this household have shelter expenses? - is not visible");
		}

	}

	public void Click_ShelterE_N() {

		if (isDisplayed(tglbtn_SE_N_xpath)) {
			driver.findElement(tglbtn_SE_N_xpath).click();
		} else {
			System.out.println("Does anyone in this household have shelter expenses? - is not visible");

		}
	}
	
	public void Click_checkmemberShelter_HHM1() {

		if (isDisplayed(selectMemberShelter)) {
			driver.findElement(selectMemberShelter).click();
		} else {
			System.out.println(
					"Select member for Does anyone in this household have shelter expenses? - is not visible");
		}

	}

	// Does anyone in this household have utility expenses?

	public void Click_UtilityE_Y() {

		if (isDisplayed(tglbtn_UE_Y_xpath)) {
			driver.findElement(tglbtn_UE_Y_xpath).click();
		} else {
			System.out.println("Does anyone in this household have utility expenses? - is not visible");

		}

	}

	public void Click_UtilityE_N() {
		if (isDisplayed(tglbtn_UE_N_xpath)) {
			driver.findElement(tglbtn_UE_N_xpath).click();
		} else {
			System.out.println("Does anyone in this household have utility expenses? - is not visible");

		}

	}

	// Does anyone in this household have tax deductible expenses?

	public void Click_TaxDE_Y() {

		if (isDisplayed(tglbtn_TDE_Y_xpath)) {
			driver.findElement(tglbtn_TDE_Y_xpath).click();
		} else {
			System.out.println("Does anyone in this household have tax deductible expenses? - is not visible");

		}

	}

	public void Click_TaxDE_N() {

		if (isDisplayed(tglbtn_TDE_N_xpath)) {
			driver.findElement(tglbtn_TDE_N_xpath).click();
		} else {
			System.out.println("Does anyone in this household have tax deductible expenses? - is not visible");

		}

	}

	// Does anyone in this household pay alimony?

	public void Click_Alimony_Y() {

		if (isDisplayed(tglbtn_Almny_Y_xpath)) {
			driver.findElement(tglbtn_Almny_Y_xpath).click();
		} else {
			System.out.println("Does anyone in this household pay alimony? - is not visible");

		}

	}

	public void Click_Alimony_N() {

		if (isDisplayed(tglbtn_Almny_N_xpath)) {
			driver.findElement(tglbtn_Almny_N_xpath).click();
		} else {
			System.out.println("Does anyone in this household pay alimony? - is not visible");

		}

	}

	// Does anyone in this household have medical expenses for someone who is age 60
	// or older, blind, or has a disability?

	public void Click_MedicalE_60above_Y() {

		if (isDisplayed(tglbtn_ME_abv60_Y_xpath)) {
			driver.findElement(tglbtn_ME_abv60_Y_xpath).click();
		} else {
			System.out.println(
					"Does anyone in this household have medical expenses for someone who is age 60 or older, blind, or has a disability? - is not visible");

		}

	}

	public void Click_MedicalE_60above_N() {

		if (isDisplayed(tglbtn_ME_abv60_N_xpath)) {
			driver.findElement(tglbtn_ME_abv60_N_xpath).click();
		} else {
			System.out.println(
					"Does anyone in this household have medical expenses for someone who is age 60 or older, blind, or has a disability? - is not visible");

		}

	}

	// Does anyone in this household pay child support?

	public void Click_ChildSupp_Y() {

		if (isDisplayed(tglbtn_CS_Y_xpath)) {
			driver.findElement(tglbtn_CS_Y_xpath).click();
		} else {
			System.out.println("Does anyone in this household pay child support?- is not visible");

		}

	}

	public void Click_ChildSupp_N() {

		if (isDisplayed(tglbtn_CS_N_xpath)) {
			driver.findElement(tglbtn_CS_N_xpath).click();
		} else {
			System.out.println("Does anyone in this household pay child support?- is not visible");

		}

	}

	// Does anyone in this household pay for child care or other dependent care?

	public void Click_ChildC_Y() {

		if (isDisplayed(tglbtn_DC_Y_xpath)) {
			driver.findElement(tglbtn_DC_Y_xpath).click();
		} else {
			System.out.println(
					"Does anyone in this household pay for child care or other dependent care?- is not visible");

		}

	}

	public void Click_ChildC_N() {

		if (isDisplayed(tglbtn_DC_N_xpath)) {
			driver.findElement(tglbtn_DC_N_xpath).click();
		} else {
			System.out.println(
					"Does anyone in this household pay for child care or other dependent care?- is not visible");

		}

	}



	public void ClickNext() {

		WebElement element= driver.findElement(btn_Next_xpath);
		clickButton(element);
		wait(4);
	}
	
	//Does anyone in your household need help paying medical bills from the last three months?
	public void ClickHHLast3monthwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'last three months')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'last three months')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household have shelter expenses?
	public void ClickHHSEwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'have shelter expenses')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq2=al.get(4).trim().split(";");
    		for(int i=0;i<Hq2.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'have shelter expenses')]/following::span[contains(text(),'"+Hq2[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household have utility expenses?
	public void ClickHHUTwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'utility expenses')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq3=al.get(6).trim().split(";");
    		for(int i=0;i<Hq3.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'utility expenses')]/following::span[contains(text(),'"+Hq3[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household have tax deductible expenses?
	public void ClickHHtaxDecwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'have tax deductible expenses')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'have tax deductible expenses')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household pay alimony?
	public void ClickHHPayAwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'household pay alimony')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq5=al.get(10).trim().split(";");
    		for(int i=0;i<Hq5.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'household pay alimony')]/following::span[contains(text(),'"+Hq5[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household have medical expenses for someone who is age 60 or older, blind, or has a disability?
	public void ClickHHAge60withMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'age 60 or older')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq6=al.get(12).trim().split(";");
    		for(int i=0;i<Hq6.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'age 60 or older')]/following::span[contains(text(),'"+Hq6[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household pay child support?
	public void ClickHHChildSwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'pay child support')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq7=al.get(14).trim().split(";");
    		for(int i=0;i<Hq7.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'pay child support')]/following::span[contains(text(),'"+Hq7[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	//Does anyone in this household pay for child care or other dependent care?
	public void ClickHHCCODCwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Expenses", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'child care or other dependent care')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq8=al.get(16).trim().split(";");
    		for(int i=0;i<Hq8.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'child care or other dependent care')]/following::span[contains(text(),'"+Hq8[i]+"')]")).click();
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
