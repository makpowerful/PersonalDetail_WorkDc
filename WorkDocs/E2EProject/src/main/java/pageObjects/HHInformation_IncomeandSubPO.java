package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class HHInformation_IncomeandSubPO extends base{
	
	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath= By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_3Mnths_Y_xpath= By.xpath("//div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_3Mnths_N_xpath= By.xpath("//div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By chkbx_3Mnths_HHM1_xpath= By.xpath("//div[1]/div/p[2]/c-ssp-base-component-input-checkbox[1]/div/div/lightning-input/div/span/label/span");
	By tglbtn_Strike_Y_xpath= By.xpath("//div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Strike_N_xpath= By.xpath("//div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_60days_Y_xpath= By.xpath("//div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_60days_N_xpath= By.xpath("//div[3]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_SelfE_Y_xpath= By.xpath("//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_SelfE_N_xpath= By.xpath("//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_SSI_Y_xpath= By.xpath("//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_SSI_N_xpath= By.xpath("//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Retirmnt_Y_xpath= By.xpath("//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Retirmnt_N_xpath= By.xpath("//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_DIR_Y_xpath= By.xpath("//div[7]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_DIR_N_xpath= By.xpath("//div[7]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_MaintI_Y_xpath= By.xpath("//div[8]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_MaintI_N_xpath= By.xpath("//div[8]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_Insrnce_Y_xpath= By.xpath("//div[9]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_Insrnce_N_xpath= By.xpath("//div[9]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_GSP_Y_xpath= By.xpath("//div[10]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_GSP_N_xpath= By.xpath("//div[10]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_HA_FA_CA_Y_xpath= By.xpath("//div[11]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_HA_FA_CA_N_xpath= By.xpath("//div[11]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn_HEAP_Y_xpath= By.xpath("//div[12]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn_HEAP_N_xpath= By.xpath("//div[12]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	private By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	
	public HHInformation_IncomeandSubPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	//Does anyone in this household have job income from an employer or had a job in the last 3 months?
	
	public void Click_Jobin3Mnths_Y() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if(isDisplayed(tglbtn_3Mnths_Y_xpath))
		{
		driver.findElement(tglbtn_3Mnths_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have job income from an employer or had a job in the last 3 months?- is not visible");
		}
	}

	public void Click_Jobin3Mnths_N() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		if(isDisplayed(tglbtn_3Mnths_N_xpath))
		{
			driver.findElement(tglbtn_3Mnths_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have job income from an employer or had a job in the last 3 months?- is not visible");
		}
		
	}
	
	public void Click_Jobin3Mnths_HHM1() {
		
		if(isDisplayed(chkbx_3Mnths_HHM1_xpath))
		{
			driver.findElement(chkbx_3Mnths_HHM1_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have job income from an employer or had a job in the last 3 months?- is not visible");
		}
		
	}	
	
	//Does anyone in this household have a job but is on strike?
	
	public void Click_JobonStrike_Y() {
		if(isDisplayed(chkbx_3Mnths_HHM1_xpath))
		{
			driver.findElement(tglbtn_Strike_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a job but is on strike?- is not visible");
		}
		
	}

	public void Click_JobonStrike_N() {
		if(isDisplayed(tglbtn_Strike_N_xpath))
		{
			driver.findElement(tglbtn_Strike_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have a job but is on strike?- is not visible");
		}
		
	}
	
	//Has anyone in the household quit a job or voluntarily reduced their work hours in the last 60 days?
	
	public void Click_WH60days_Y() {
		if(isDisplayed(tglbtn_60days_Y_xpath))
		{
			driver.findElement(tglbtn_60days_Y_xpath).click();
		}
		else
		{
			System.out.println("Has anyone in the household quit a job or voluntarily reduced their work hours in the last 60 days?- is not visible");
		}
		
	}

	public void Click_WH60days_N() {
		
		if(isDisplayed(tglbtn_60days_N_xpath))
		{
			driver.findElement(tglbtn_60days_N_xpath).click();
		}
		else
		{
			System.out.println("Has anyone in the household quit a job or voluntarily reduced their work hours in the last 60 days?- is not visible");
		}
		
	}
	
	//Does anyone in this household have self-employment income?
	
	public void Click_SelfEInc_Y() {
		
		if(isDisplayed(tglbtn_SelfE_Y_xpath))
		{
			driver.findElement(tglbtn_SelfE_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have self-employment income?- is not visible");
		}
		
	}

	public void Click_SelfEInc_N() {
		
		if(isDisplayed(tglbtn_SelfE_N_xpath))
		{
			driver.findElement(tglbtn_SelfE_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household have self-employment income?- is not visible");
		}
		
		
	}
	
	//Does anyone in this household receive income from Social Security/SSI, Veterans Administration or railroad benefits?
	
	public void Click_SSI_VA_Y() {
		
		if(isDisplayed(tglbtn_SSI_Y_xpath))
		{
			driver.findElement(tglbtn_SSI_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from Social Security/SSI, Veterans Administration or railroad benefits?- is not visible");
		}
		
	}

	public void Click_SSI_VA_N() {
		
		if(isDisplayed(tglbtn_SSI_N_xpath))
		{
			driver.findElement(tglbtn_SSI_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from Social Security/SSI, Veterans Administration or railroad benefits?- is not visible");
		}
		
	}
	
	//Does anyone in this household receive income from retirement, pension or an investment such as an annuity or trust?
	
	public void Click_Retire_Pension_Y() {
		
		if(isDisplayed(tglbtn_Retirmnt_Y_xpath))
		{
			driver.findElement(tglbtn_Retirmnt_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from retirement, pension or an investment such as an annuity or trust?- is not visible");
		}
		
		
	}

	public void Click_Retire_Pension_N() {
		
		if(isDisplayed(tglbtn_Retirmnt_N_xpath))
		{
			driver.findElement(tglbtn_Retirmnt_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from retirement, pension or an investment such as an annuity or trust?- is not visible");
		}
		
		
	}
	
	//Does anyone in this household receive income from dividends, interest, or royalties?
	
	public void Click_Divid_Interest_Y() {
		if(isDisplayed(tglbtn_DIR_Y_xpath))
		{
			driver.findElement(tglbtn_DIR_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from dividends, interest, or royalties?- is not visible");
		}
		
	}

	public void Click_Divid_Interest_N() {
		if(isDisplayed(tglbtn_DIR_Y_xpath))
		{
			driver.findElement(tglbtn_DIR_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from dividends, interest, or royalties?- is not visible");
		}
		
	}
	
	//Does anyone in this household receive support or maintenance income, such as alimony, child support, adoption subsidy payments, or foster care income?
	
	public void Click_MaintIncome_Alimny_Y() {
		if(isDisplayed(tglbtn_MaintI_Y_xpath))
		{
			driver.findElement(tglbtn_MaintI_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive support or maintenance income, such as alimony, child support, adoption subsidy payments, or foster care income?- is not visible");
		}
		
	}

	public void Click_MaintIncome_Alimny_N() {
		if(isDisplayed(tglbtn_MaintI_N_xpath))
		{
			driver.findElement(tglbtn_MaintI_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive support or maintenance income, such as alimony, child support, adoption subsidy payments, or foster care income?- is not visible");
		}
		
	}
	
	//Does anyone in this household receive income from an insurance or benefit such as unemployment or workers compensation?
	
	public void Click_WorkerCompen_Y() {
		if(isDisplayed(tglbtn_Insrnce_Y_xpath))
		{
			driver.findElement(tglbtn_Insrnce_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from an insurance or benefit such as unemployment or workers compensation?- is not visible");
		}
		
	}

	public void Click_WorkerCompen_N() {
		if(isDisplayed(tglbtn_Insrnce_N_xpath))
		{
			driver.findElement(tglbtn_Insrnce_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive income from an insurance or benefit such as unemployment or workers compensation?- is not visible");
		}
		
	}
	
	//Does anyone in this household receive any other type of goods, services, or payments?
	
	public void Click_Goods_Service_Y() {
		if(isDisplayed(tglbtn_GSP_Y_xpath))
		{
			driver.findElement(tglbtn_GSP_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive any other type of goods, services, or payments?- is not visible");
		}
	
	}

	public void Click_Goods_Service_N() {
		if(isDisplayed(tglbtn_GSP_N_xpath))
		{
			driver.findElement(tglbtn_GSP_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive any other type of goods, services, or payments?- is not visible");
		}
		
	}
	
	//Does anyone in this household receive health assistance (Medicaid), food assistance (SNAP), cash assistance (TANF) benefits in another state in the month of May or expect to receive benefits in the month of June?
	
	public void Click_HA_FA_CA_Y() {
		if(isDisplayed(tglbtn_HA_FA_CA_Y_xpath))
		{
			driver.findElement(tglbtn_HA_FA_CA_Y_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive health assistance (Medicaid), food assistance (SNAP), cash assistance (TANF) benefits in another state in the month of May or expect to receive benefits in the month of June?- is not visible");
		}
		
	}

	public void Click_HA_FA_CA_N() {
		if(isDisplayed(tglbtn_HA_FA_CA_N_xpath))
		{
			driver.findElement(tglbtn_HA_FA_CA_N_xpath).click();
		}
		else
		{
			System.out.println("Does anyone in this household receive health assistance (Medicaid), food assistance (SNAP), cash assistance (TANF) benefits in another state in the month of May or expect to receive benefits in the month of June?- is not visible");
		}
		
	}
	
	//Did the household get more than $20 in verified HEAP (fuel assistance) benefit in this month or in the previous 12 months?
	
	public void Click_HEAP_Y() {
		if(isDisplayed(tglbtn_HEAP_Y_xpath))
		{
			driver.findElement(tglbtn_HEAP_Y_xpath).click();
		}
		else
		{
			System.out.println("Did the household get more than $20 in verified HEAP (fuel assistance) benefit in this month or in the previous 12 months?- is not visible");
		}
		
	}

	public void Click_HEAP_N() {
		if(isDisplayed(tglbtn_HEAP_N_xpath))
		{
			driver.findElement(tglbtn_HEAP_N_xpath).click();
		}
		else
		{
			System.out.println("Did the household get more than $20 in verified HEAP (fuel assistance) benefit in this month or in the previous 12 months?- is not visible");
		}
		
	}
	
    public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}
    
    
    //Does anyone in this household have job income from an employer or had a job in the last 3 months?
    //Does anyone in this household have a job but is on strike?
    //Has anyone in the household quit a job or voluntarily reduced their work hours in the last 60 days?
    public void ClickHH3MontswithMem(String val,String val2,String val3) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'job in the last 3 months')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'job in the last 3 months')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		driver.findElement(By.xpath("//label[contains(text(),'job but is on strike')]/following::span[contains(text(),'"+val2+"')]")).click();
			Thread.sleep(700);
			if(val2.contains("Yes")) {
	    		String[] Hq2=al.get(4).trim().split(";");
	    		for(int j=0;j<Hq2.length;j++) {
	    			
	    			driver.findElement(By.xpath("//label[contains(text(),'job but is on strike')]/following::span[contains(text(),'"+Hq2[j]+"')]")).click();
	    			Thread.sleep(700);
	    		}
	    		driver.findElement(By.xpath("//label[contains(text(),'last 60 days')]/following::span[contains(text(),'"+val2+"')]")).click();
				Thread.sleep(700);
				if(val3.contains("Yes")) {
		    		String[] Hq3=al.get(6).trim().split(";");
		    		for(int k=0;k<Hq3.length;k++) {
		    			
		    			driver.findElement(By.xpath("//label[contains(text(),'last 60 days')]/following::span[contains(text(),'"+Hq3[k]+"')]")).click();
		    			Thread.sleep(700);
		    		}
				}
			}
    	}
    }

    
    //Does anyone in this household have self-employment income?
	public void ClickHHSelfIncwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'self-employment income')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'self-employment income')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
    
    //Does anyone in this household receive income from Social Security/SSI, Veterans Administration or railroad benefits?
	public void ClickHHSSIwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'Social Security/SSI')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq5=al.get(10).trim().split(";");
    		for(int i=0;i<Hq5.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Social Security/SSI')]/following::span[contains(text(),'"+Hq5[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
    //Does anyone in this household receive income from retirement, pension or an investment such as an annuity or trust?
	public void ClickHHAnnuorTrustwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'retirement, pension or an investment')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq6=al.get(12).trim().split(";");
    		for(int i=0;i<Hq6.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'retirement, pension or an investment')]/following::span[contains(text(),'"+Hq6[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
    //Does anyone in this household receive income from dividends, interest, or royalties?
	public void ClickHHRoyalwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'interest, or royalties')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq7=al.get(14).trim().split(";");
    		for(int i=0;i<Hq7.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'interest, or royalties')]/following::span[contains(text(),'"+Hq7[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
    //Does anyone in this household receive support or maintenance income, such as alimony, child support, adoption subsidy payments, or foster care income?
	public void ClickHHMaintIncwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'alimony, child support, adoption')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq8=al.get(16).trim().split(";");
    		for(int i=0;i<Hq8.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'alimony, child support, adoption')]/following::span[contains(text(),'"+Hq8[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
	
    //Does anyone in this household receive income from an insurance or benefit such as unemployment or workers compensation?
	public void ClickHHWorkerCwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'insurance or benefit such as')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq9=al.get(18).trim().split(";");
    		for(int i=0;i<Hq9.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'insurance or benefit such as')]/following::span[contains(text(),'"+Hq9[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	
    //Does anyone in this household receive any other type of goods, services, or payments?
	public void ClickHHGSPwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'goods, services, or payments')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq10=al.get(20).trim().split(";");
    		for(int i=0;i<Hq10.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'goods, services, or payments')]/following::span[contains(text(),'"+Hq10[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	} 
    //Does anyone in this household receive health assistance (Medicaid), food assistance (SNAP), cash assistance (TANF) benefits in another state in the month of October or expect to receive benefits in the month of November?
	public void ClickHHMSTwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'(Medicaid), food assistance (SNAP), cash assistance (TANF)')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq11=al.get(22).trim().split(";");
    		for(int i=0;i<Hq11.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'(Medicaid), food assistance (SNAP), cash assistance (TANF)')]/following::span[contains(text(),'"+Hq11[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    	}
	}
	

    //Did the household get more than $20 in verified HEAP (fuel assistance) benefit in this month or in the previous 12 months?
	public void ClickHH12monthswithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-Incme&sub", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'previous 12 months')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
	} 


	//To Assert the page load
	public String AssertM() throws InterruptedException {
		Thread.sleep(700);
		return driver.findElement(lbl_Header_xpath).getText();
		
	}
}

