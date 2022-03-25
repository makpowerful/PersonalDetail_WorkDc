package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class HHInformation_HHCircumPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	public static Logger log = LogManager.getLogger(HHInformation_HHCircumPO.class.getName());

	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	By tglbtn_Parole_Y_xpath = By
			.xpath("//legend[contains(text(),'parole')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Parole_N_xpath = By
			.xpath("//legend[contains(text(),'parole')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_SNAPorTANF_Bnfit_Y_xpath = By
			.xpath("//legend[contains(text(),'benefits')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_SNAPorTANF_Bnfit_N_xpath = By
			.xpath("//legend[contains(text(),'benefits')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_SNAPorTANF_Vltn_Y_xpath = By
			.xpath("//legend[contains(text(),'violation')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_SNAPorTANF_Vltn_N_xpath = By
			.xpath("//legend[contains(text(),'violation')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_FarmWorker_Y_xpath = By
			.xpath("//legend[contains(text(),'farm')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_FarmWorker_N_xpath = By
			.xpath("//legend[contains(text(),'farm')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_Lessthan25_Y_xpath = By
			.xpath("//legend[contains(text(),'less')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_Lessthan25_N_xpath = By
			.xpath("//legend[contains(text(),'less')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_EnrlSchl_Y_xpath = By
			.xpath("//legend[contains(text(),'enrolled')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_EnrlSchl_N_xpath = By
			.xpath("//legend[contains(text(),'enrolled')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_FC18_Y_xpath = By
			.xpath("//legend[contains(text(),'foster')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_FC18_N_xpath = By
			.xpath("//legend[contains(text(),'foster')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_SNAP_EandT_Y_xpath = By
			.xpath("//legend[contains(text(),'Training')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_SNAP_EandT_N_xpath = By
			.xpath("//legend[contains(text(),'Training')]/following-sibling::div//span[contains(text(),'No')]");
	By tglbtn_February7_Y_xpath = By
			.xpath("//legend[contains(text(),'February')]/following-sibling::div//span[contains(text(),'Yes')]");
	By tglbtn_February7_N_xpath = By
			.xpath("//legend[contains(text(),'February')]/following-sibling::div//span[contains(text(),'No')]");
	By chkbx_EnrlSchl_HHM1_xpath = By
			.xpath("//div[7]//c-ssp-base-component-input-checkbox[1]//lightning-input/div/span/label/span[1]");
	By chkbx_FarmWorker_HHM1_xpath = By
			.xpath("//div[5]//c-ssp-base-component-input-checkbox[1]//lightning-input/div/span/label/span[1]");

	// By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By checkbox_enrolledMM = By.xpath("//legend[contains(text(),'enrolled')]");
	private By lbl_Header_xpath=By.xpath("//div[@class='ssp-menuItemDropDownHeader']/p");
	public WebElement murderConv_Bnfit_Y;
	public WebElement murderConv_Bnfit_N;
	public WebElement btn_Parole_Y;
	public WebElement btn_Parole_N;
	public WebElement btn_murderConv_Bnfit_Y;
	public WebElement btn_murderConv_Bnfit_N;
	public WebElement btn_SNAPorTANF_Bnfit_Y;
	public WebElement btn_SNAPorTANF_Bnfit_N;
	public WebElement btn_SNAPorTANF_Vltn_Y;
	public WebElement btn_SNAPorTANF_Vltn_N;
	public WebElement btn_FarmWorker_Y;
	public WebElement btn_FarmWorker_N;
	public WebElement btn_Lessthan25_Y;
	public WebElement btn_Lessthan25_N;
	public WebElement btn_EnrlSchl_Y;
	public WebElement btn_EnrlSchl_N;
	public WebElement btn_FC18_Y;
	// public WebElement btn_FC18_N;
	public WebElement btn_SNAP_EandT_Y;

	private WebElement btn_FC18_N;

	private WebElement btn_SNAP_EandT_N;
	// public WebElement btn_SNAP_EandT_N;

	public HHInformation_HHCircumPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	// Is anyone in this household fleeing a felony conviction or violating
	// probation or parole?
	public void Click_Violating_Parole_Y() throws InterruptedException {
		checkbox_enrolledMM.findElement(btn_EnrlSchl_N);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		btn_Parole_Y = driver.findElement(tglbtn_Parole_Y_xpath);
		if (isDisplayed(tglbtn_Parole_Y_xpath)) {
			driver.findElement(tglbtn_Parole_Y_xpath).click();
			log.info("Is anyone in this household fleeing a felony conviction or violating probation or parole? - Yes");
		} else {
			log.info(
					"Is anyone in this household fleeing a felony conviction or violating probation or parole? toggle question does not display");
		}

	}

	public void Click_Violating_Parole_N() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);

		btn_Parole_N = driver.findElement(tglbtn_Parole_N_xpath);
		if (isDisplayed(tglbtn_Parole_N_xpath)) {
			btn_Parole_N.click();
			log.info("Is anyone in this household fleeing a felony conviction or violating probation or parole? - No");
		} else {
			log.info(
					"Is anyone in this household fleeing a felony conviction or violating probation or parole? toggle question does not display");
		}

	}
	// Has anyone in this household been convicted as an adult of aggravated sexual
	// abuse, murder, sexual exploitation and other abuse of children, a Federal or
	// State offense involving sexual assault, or an offense under State law
	// determined by the Attorney General to be substantially similar to such an
	// offense, after February 7, 2014?
	/*
	 * public void Click_murderConv_Bnfit_Y() {
	 * 
	 * btn_murderConv_Bnfit_Y=driver.findElement(tglbtn_murderConv_Bnfit_Y_xpath);
	 * if(btn_murderConv_Bnfit_Y.isDisplayed()) { btn_murderConv_Bnfit_Y.click();
	 * log.
	 * info("Has anyone in this household been convicted as an adult of aggravated sexual abuse, murder, sexual exploitation and other abuse of children, a Federal or State offense involving sexual assault, or an offense under State law determined by the Attorney General to be substantially similar to such an offense, after February 7, 2014? - No"
	 * ); } else { log.
	 * info("Has anyone in this household been convicted as an adult of aggravated sexual abuse, murder, sexual exploitation and other abuse of children, a Federal or State offense involving sexual assault, or an offense under State law determined by the Attorney General to be substantially similar to such an offense, after February 7, 2014? toggle question does not display"
	 * ); } }
	 */

	/*
	 * public void Click_murderConv_Bnfit_N() {
	 * btn_murderConv_Bnfit_N=driver.findElement(tglbtn_murderConv_Bnfit_N_xpath);
	 * if(btn_murderConv_Bnfit_N.isDisplayed()) { btn_murderConv_Bnfit_N.click();
	 * log.
	 * info("Has anyone in this household been convicted as an adult of aggravated sexual abuse, murder, sexual exploitation and other abuse of children, a Federal or State offense involving sexual assault, or an offense under State law determined by the Attorney General to be substantially similar to such an offense, after February 7, 2014? - No"
	 * ); } else { log.
	 * info("Has anyone in this household been convicted as an adult of aggravated sexual abuse, murder, sexual exploitation and other abuse of children, a Federal or State offense involving sexual assault, or an offense under State law determined by the Attorney General to be substantially similar to such an offense, after February 7, 2014? toggle question does not display"
	 * ); }
	 * 
	 * }
	 */
	// Has anyone in this household been convicted of giving wrong information about
	// who they are or where they live to get or try to get SNAP and/or TANF
	// benefits in more than one household at a time?

	/*
	 * public void Click_SNAPorTANF_Benefit_Y() {
	 * btn_SNAPorTANF_Bnfit_Y=driver.findElement(tglbtn_SNAPorTANF_Bnfit_Y_xpath);
	 * if(isDisplayed(tglbtn_SNAPorTANF_Bnfit_Y_xpath)) {
	 * btn_SNAPorTANF_Bnfit_Y.click(); log.
	 * info("Has anyone in this household been convicted of giving wrong information about who they are or where they live to get or try to get SNAP and/or TANF benefits in more than one household at a time? - Yes"
	 * ); } else { log.
	 * info("Has anyone in this household been convicted of giving wrong information about who they are or where they live to get or try to get SNAP and/or TANF benefits in more than one household at a time? toggle question does not display"
	 * ); }
	 * 
	 * }
	 */

	/*
	 * public void Click_SNAPorTANF_Benefit_N() { btn_SNAPorTANF_Bnfit_N =
	 * driver.findElement(tglbtn_SNAPorTANF_Bnfit_N_xpath);
	 * if(isDisplayed(tglbtn_SNAPorTANF_Bnfit_N_xpath)) {
	 * btn_SNAPorTANF_Bnfit_N.click(); log.
	 * info("Has anyone in this household been convicted of giving wrong information about who they are or where they live to get or try to get SNAP and/or TANF benefits in more than one household at a time? - No"
	 * ); } else { log.
	 * info("Has anyone in this household been convicted of giving wrong information about who they are or where they live to get or try to get SNAP and/or TANF benefits in more than one household at a time? toggle question does not display"
	 * ); }
	 * 
	 * }
	 */
	// Has anyone in this household been convicted of a SNAP and/or TANF program
	// violation?

	public void Click_SNAPorTANF_Violation_Y() {
		btn_SNAPorTANF_Vltn_Y = driver.findElement(tglbtn_SNAPorTANF_Vltn_Y_xpath);
		if (isDisplayed(tglbtn_SNAPorTANF_Vltn_Y_xpath)) {
			btn_SNAPorTANF_Vltn_Y.click();
			log.info("Has anyone in this household been convicted of a SNAP and/or TANF program violation? - Yes");
		} else {
			log.info(
					"Has anyone in this household been convicted of a SNAP and/or TANF program violation? toggle question does not display");
		}

	}

	public void Click_SNAPorTANF_Violation_N() {
		btn_SNAPorTANF_Vltn_N = driver.findElement(tglbtn_SNAPorTANF_Vltn_N_xpath);
		if (isDisplayed(tglbtn_SNAPorTANF_Vltn_N_xpath)) {
			btn_SNAPorTANF_Vltn_N.click();
			log.info("Has anyone in this household been convicted of a SNAP and/or TANF program violation? - No");
		} else {
			log.info(
					"Has anyone in this household been convicted of a SNAP and/or TANF program violation? toggle question does not display");
		}

	}

	// Is anyone in this household a migrant or seasonal farmworker?

	public void Click_Seasonal_FW_Y() {
		// btn_FarmWorker_Y = driver.findElement(tglbtn_FarmWorker_Y_xpath);
		if (isDisplayed(tglbtn_FarmWorker_Y_xpath)) {
			driver.findElement(tglbtn_FarmWorker_Y_xpath).click();
			log.info("Is anyone in this household a migrant or seasonal farmworker? - Yes");
		} else {
			log.info("Is anyone in this household a migrant or seasonal farmworker?- toggle question does not display");
		}

	}

	public void Click_Seasonal_FW_N() {
		btn_FarmWorker_N = driver.findElement(tglbtn_FarmWorker_N_xpath);
		if (isDisplayed(tglbtn_FarmWorker_N_xpath)) {
			btn_FarmWorker_N.click();
			log.info("Is anyone in this household a migrant or seasonal farmworker? - No");
		} else {
			log.info("Is anyone in this household a migrant or seasonal farmworker?- toggle question does not display");
		}

	}

	public void Click_Seasonal_FW_HHM1() {
		if (isDisplayed(chkbx_FarmWorker_HHM1_xpath)) {
			driver.findElement(chkbx_FarmWorker_HHM1_xpath).click();
			log.info("Is anyone in this household a migrant or seasonal farmworker? - No");
		} else {
			log.info("Is anyone in this household a migrant or seasonal farmworker?- toggle question does not display");
		}

	}

	// Will the household receive less than $25 in the next 10 days?

	public void Click_Rec_lessthan25_FW_Y() {
		btn_Lessthan25_Y = driver.findElement(tglbtn_Lessthan25_Y_xpath);
		if (isDisplayed(tglbtn_Lessthan25_Y_xpath)) {
			btn_Lessthan25_Y.click();
			log.info("Will the household receive less than $25 in the next 10 days? - Yes");
		} else {
			log.info(
					"Will the household receive less than $25 in the next 10 days? - toggle question does not display");
		}

	}

	public void Click_Rec_lessthan25_FW_N() {
		// btn_Lessthan25_N = driver.findElement(tglbtn_Lessthan25_N_xpath);
		if (isDisplayed(tglbtn_Lessthan25_N_xpath)) {
			driver.findElement(tglbtn_Lessthan25_N_xpath).click();
			log.info("Will the household receive less than $25 in the next 10 days? - No");
		} else {
			log.info(
					"Will the household receive less than $25 in the next 10 days? - toggle question does not display");
		}

	}

	// Is anyone in this household currently enrolled in school?

	public void Click_Enrollin_School_Y() throws Exception {
		//btn_EnrlSchl_Y = driver.findElement(tglbtn_EnrlSchl_Y_xpath);
		if (isDisplayed(tglbtn_EnrlSchl_Y_xpath)) {
			driver.findElement(tglbtn_EnrlSchl_Y_xpath).click();
			Thread.sleep(1000);
			log.info("Is anyone in this household currently enrolled in school? - Yes");
		} else {
			log.info("Is anyone in this household currently enrolled in school? - toggle question does not display");
		}

	
	}
	// Has anyone in this household been convicted of giving wrong information about
	// who they are or where they live to get or try to get SNAP and/or TANF
	// benefits in more than one household at a time?

	
	  public void Click_SNAPorTANF_Benefit_Y() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("scroll(0,250);"); Thread.sleep(1000); if
	  (isDisplayed(tglbtn_SNAPorTANF_Bnfit_Y_xpath)) {
	  driver.findElement(tglbtn_SNAPorTANF_Bnfit_Y_xpath).click();
	  Thread.sleep(1000); } else { System.out.println("Question 2 is not visible");
	  } }
	  
	  
	  
	  public void Click_SNAPorTANF_Benefit_N() throws InterruptedException {
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("scroll(0,250);"); Thread.sleep(1000); if
	  (isDisplayed(tglbtn_SNAPorTANF_Bnfit_N_xpath)) {
	  driver.findElement(tglbtn_SNAPorTANF_Bnfit_N_xpath).click();
	  Thread.sleep(1000); } else { System.out.println("Question 2 is not visible");
	  } }
	 

	// Has anyone in this household been convicted of a SNAP and/or TANF program
	// violation?
	/*
	 * public void Click_SNAPorTANF_Violation_Y() throws InterruptedException {
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("scroll(0,250);"); Thread.sleep(1000); if
	 * (isDisplayed(tglbtn_SNAPorTANF_Vltn_Y_xpath)) {
	 * driver.findElement(tglbtn_SNAPorTANF_Vltn_Y_xpath).click();
	 * Thread.sleep(1000); } else { System.out.println("Question 3 is not visible");
	 * } }
	 */

	/*
	 * public void Click_SNAPorTANF_Violation_N() throws InterruptedException {
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("scroll(0,250);"); Thread.sleep(1000); if
	 * (isDisplayed(tglbtn_SNAPorTANF_Vltn_N_xpath)) {
	 * driver.findElement(tglbtn_SNAPorTANF_Vltn_N_xpath).click();
	 * Thread.sleep(1000); } else { System.out.println("Question 3 is not visible");
	 * } }
	 */

	// Is anyone in this household a migrant or seasonal farmworker?

	/*
	 * public void Click_Seasonal_FW_Y() throws InterruptedException { if
	 * (isDisplayed(tglbtn_FarmWorker_Y_xpath)) {
	 * driver.findElement(tglbtn_FarmWorker_Y_xpath).click(); Thread.sleep(1000); }
	 * else { System.out.println("Question 4 is not visible"); } }
	 * 
	 * public void Click_Seasonal_FW_N() throws InterruptedException {
	 * 
	 * if (isDisplayed(tglbtn_FarmWorker_N_xpath)) {
	 * driver.findElement(tglbtn_FarmWorker_N_xpath).click(); Thread.sleep(1000); }
	 * else { System.out.println("Question 4 is not visible"); } }
	 */

	/*
	 * public void Click_Seasonal_FW_HHM1() throws InterruptedException {
	 * 
	 * if (isDisplayed(chkbx_FarmWorker_HHM1_xpath)) {
	 * driver.findElement(chkbx_FarmWorker_HHM1_xpath).click(); Thread.sleep(1000);
	 * } else { System.out.println("Question 6 is not visible"); } }
	 */
	// Will the household receive less than $25 in the next 10 days?

	/*
	 * public void Click_Rec_lessthan25_FW_Y() throws InterruptedException { if
	 * (isDisplayed(tglbtn_Lessthan25_Y_xpath)) {
	 * driver.findElement(tglbtn_Lessthan25_Y_xpath).click(); Thread.sleep(1000); }
	 * else { System.out.println("Question 5 is not visible"); } }
	 */

	/*
	 * public void Click_Rec_lessthan25_FW_N() throws InterruptedException {
	 * 
	 * if (isDisplayed(tglbtn_Lessthan25_N_xpath)) {
	 * driver.findElement(tglbtn_Lessthan25_N_xpath).click(); Thread.sleep(1000); }
	 * else { System.out.println("Question 5 is not visible"); } }
	 */

	// Is anyone in this household currently enrolled in school?

	/*
	 * public void Click_Enrollin_School_Y() throws InterruptedException { if
	 * (isDisplayed(tglbtn_EnrlSchl_Y_xpath)) {
	 * driver.findElement(tglbtn_EnrlSchl_Y_xpath).click(); Thread.sleep(1000); }
	 * else { System.out.println("Question 6 is not visible"); } }
	 */

	public void Click_Enrollin_School_N() throws InterruptedException {

		if (isDisplayed(tglbtn_EnrlSchl_N_xpath)) {
			driver.findElement(tglbtn_EnrlSchl_N_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 6 is not visible");
		}
	}

	public void Click_Enrollin_School_HHM1() throws InterruptedException {

		if (isDisplayed(chkbx_EnrlSchl_HHM1_xpath)) {
			driver.findElement(chkbx_EnrlSchl_HHM1_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 6 is not visible");
		}

		}
	// Was anyone in foster care when they turned 18?

	public void Click_FosterCare_Y() throws InterruptedException {

		if (isDisplayed(tglbtn_FC18_Y_xpath)) {
			driver.findElement(tglbtn_FC18_Y_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 7 is not visible");
		}
	}

	public void Click_FosterCare_N() throws InterruptedException {

		if (isDisplayed(tglbtn_FC18_N_xpath)) {
			driver.findElement(tglbtn_FC18_N_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 7 is not visible");
		}
	}


	public void Click_SNAP_EmployandTrain_Y() {
		btn_SNAP_EandT_Y = driver.findElement(tglbtn_SNAP_EandT_Y_xpath);
		if (isDisplayed(tglbtn_SNAP_EandT_Y_xpath)) {
			btn_SNAP_EandT_Y.click();
			log.info(
					"Is anyone in the household currently participating in the SNAP Employment & Training (E&T) program? - Yes");
		} else {
			log.info(
					"Is anyone in the household currently participating in the SNAP Employment & Training (E&T) program? - toggle question does not display");
		}
	}

	public void Click_SNAP_EmployandTrain_N() throws InterruptedException {

		if (isDisplayed(tglbtn_SNAP_EandT_N_xpath)) {
			driver.findElement(tglbtn_SNAP_EandT_N_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 8 is not visible");
		}
	}

	public void Click_February7_Y() throws InterruptedException {

		if (isDisplayed(tglbtn_February7_Y_xpath)) {
			driver.findElement(tglbtn_February7_Y_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 9 is not visible");
		}
		btn_SNAP_EandT_N = driver.findElement(tglbtn_SNAP_EandT_N_xpath);
		if (isDisplayed(tglbtn_SNAP_EandT_N_xpath)) {
			btn_SNAP_EandT_N.click();
			log.info(
					"Is anyone in the household currently participating in the SNAP Employment & Training (E&T) program? - No");
		} else {
			log.info(
					"Is anyone in the household currently participating in the SNAP Employment & Training (E&T) program? - toggle question does not display");
		}
	}

	 
	public void Click_February7_N() throws InterruptedException {

		if (isDisplayed(tglbtn_February7_N_xpath)) {
			driver.findElement(tglbtn_February7_N_xpath).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Question 9 is not visible");
		}
	}

	public void ClickNext() throws InterruptedException {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}
	
	
	//Is anyone in this household fleeing a felony conviction or violating probation or parole?
    public void ClickHHFelonywithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'fleeing a felony conviction')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq1=al.get(2).trim().split(";");
    		for(int i=0;i<Hq1.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'fleeing a felony conviction')]/following::span[contains(text(),'"+Hq1[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	
	//Has anyone in this household been convicted as an adult of aggravated sexual abuse, murder, sexual exploitation and other abuse of children, a Federal or State offense involving sexual assault, or an offense under State law determined by the Attorney General to be substantially similar to such an offense, after February 7, 2014?
    public void ClickHHFedralwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'Federal or State')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq2=al.get(4).trim().split(";");
    		for(int i=0;i<Hq2.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'Federal or State')]/following::span[contains(text(),'"+Hq2[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Has anyone in this household been convicted of giving wrong information about who they are or where they live to get or try to get SNAP and/or TANF benefits in more than one household at a time?
    public void ClickWrongSNAPTANFwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'giving wrong information')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq3=al.get(6).trim().split(";");
    		for(int i=0;i<Hq3.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'giving wrong information')]/following::span[contains(text(),'"+Hq3[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Has anyone in this household been convicted of a SNAP and/or TANF program violation?
    public void ClickPrgViolatnwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'convicted of a SNAP and/or TANF program violation')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq4=al.get(8).trim().split(";");
    		for(int i=0;i<Hq4.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'convicted of a SNAP and/or TANF program violation')]/following::span[contains(text(),'"+Hq4[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Is anyone in this household a migrant or seasonal farmworker?
	//Will the household receive less than $25 in the next 10 days?
    public void ClickMigorSFWwithMem(String val,String val2) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'migrant or seasonal farmworker')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq5=al.get(10).trim().split(";");
    		for(int i=0;i<Hq5.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'migrant or seasonal farmworker')]/following::span[contains(text(),'"+Hq5[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		driver.findElement(By.xpath("//label[contains(text(),'$25 in the next 10 days')]/following::span[contains(text(),'"+val2+"')]")).click();
    		Thread.sleep(700);
    	}
    }
	
	//HHCir-Is anyone in this household currently enrolled in school?
    public void ClickEnrollSchlwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'enrolled in school')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq6=al.get(13).trim().split(";");
    		for(int i=0;i<Hq6.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'enrolled in school')]/following::span[contains(text(),'"+Hq6[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Was anyone in foster care when they turned 18?
    public void ClickFC18withMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'they turned 18')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq8=al.get(15).trim().split(";");
    		for(int i=0;i<Hq8.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'they turned 18')]/following::span[contains(text(),'"+Hq8[i]+"')]")).click();
    			Thread.sleep(700);
    		}
    		
    	}
    }
	//Is anyone in the household currently participating in the SNAP Employment & Training (E&T) program?
	
    public void ClickSNAPEandTwithMem(String val) throws IOException, InterruptedException {
    	al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
    	driver.findElement(By.xpath("//label[contains(text(),'SNAP Employment & Training (E&T)')]/following::span[contains(text(),'"+val+"')]")).click();
    	Thread.sleep(700);
    	if(val.contains("Yes")) {
    		String[] Hq9=al.get(17).trim().split(";");
    		for(int i=0;i<Hq9.length;i++) {
    			
    			driver.findElement(By.xpath("//label[contains(text(),'SNAP Employment & Training (E&T)')]/following::span[contains(text(),'"+Hq9[i]+"')]")).click();
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
