package pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_IndInfo_EducationPO extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(MD_IndInfo_EducationPO.class.getName());
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By btn_Save_xpath = By.xpath("//button[contains(text(),'Save')]");
	By btn_HHM1_xpath = By.xpath("//div[8]/c-ssp-member-section-card/div/div[2]/div/ul/li/div/div[2]/span");
	By btn_HHM2_xpath = By.xpath("//div[8]/c-ssp-member-section-card/div/div[2]/div/ul/li[2]/div/div[2]/span");
	By btn_HHM3_xpath = By.xpath("//div[8]/c-ssp-member-section-card/div/div[2]/div/ul/li[3]/div/div[2]/span");
	By btn_HLOE_xpath = By.xpath("//button");
	By thpl_HLOE_xpath = By.xpath("//input");
	By thpl_HLOE_2G_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li[2]/div");
	By thpl_HLOE_3G_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li[3]/div");
	By thpl_HLOE_4G_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li[4]/div");
	By btn_CE_xpath = By.xpath("//c-ssp-selection-card-without-remove-icon/div/div/div/div[2]/lightning-button/button");
	By thpl_CE_IT_xpath = By.xpath("//div[1]/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By thpl_CE_IT_AE_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li/div");
	By thpl_CE_GL_xpath = By.xpath("//div[2]/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By thpl_CE_GL_2G_xpath = By.xpath("//li[2]/div");
	By date_CE_EGD_xpath = By.xpath("//div/div/input");
	By thpl_CE_NOS_xpath = By.xpath("//div[3]/div/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By thpl_CE_NOS_GCC_xpath = By.xpath("//li[2]/div");
	By rdbtn_CE_ES_FT_xpath = By.xpath("//span[2]");
	By tglbtn_CE_WSP_N_xpath = By.xpath(
			"//div[1]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	By tglbtn_CE_TAA_N_xpath = By.xpath(
			"//div[2]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label");
	By OutOfHouseholdLabel = By.xpath("//p[contains(text(),'Out of Household')]");
	By startOutOfHousehold = By.xpath("//button[contains(text(),'Start')]");
	By dontHaveInfoCheckbox = By.xpath(
			"//lightning-input[@title=\"Select if you don't have the parent information at this time.\"]/div/span");
	By saveOutOfHousehold = By.xpath("//button[contains(text(),'Save')]");
	By lbl_CurrEdu_xpath = By.xpath("//p[text()='Current Education']");
	static int counterx = 1;
	static int counterv = 1;

	public MD_IndInfo_EducationPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_MI_HHM1() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,900);");
		Thread.sleep(2000);
		driver.findElement(btn_HHM1_xpath).click();
	}

	public void Click_MI_HHM2() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1050);");
		Thread.sleep(1000);
		driver.findElement(btn_HHM2_xpath).click();
	}

	public void Click_MI_HHM3() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1150);");
		Thread.sleep(1000);
		driver.findElement(btn_HHM3_xpath).click();
	}

	public void Click_HLOE_Start() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(btn_HLOE_xpath).click();
	}

	public void Click_HLOE_SelectGrade() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(500);
		driver.findElement(thpl_HLOE_xpath).click();
	}

	public void Click_HLOE_Select2G() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(thpl_HLOE_2G_xpath).click();
	}

	public void Click_HLOE_Select3G() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(thpl_HLOE_3G_xpath).click();
	}

	public void Click_HLOE_Select4G() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(thpl_HLOE_4G_xpath).click();
	}

	// Out of Household Parent
	public boolean checkOutofHousehold() {
		boolean flag = isDisplayed(OutOfHouseholdLabel);
		if (flag) {
			log.info("Out Of Household Parent screen queued of Individual");
			flag = true;
			return flag;
		} else {
			log.info("Out Of Household Parent screen is not queued for Individual");
			return flag;
		}

	}

	public void startOutOfHousehold() {
		WebElement element = driver.findElement(startOutOfHousehold);
		clickButton(element);
	}

	public void selectDontHaveInformation() {
		driver.findElement(dontHaveInfoCheckbox).click();
	}

	public void clickSaveOutOfHousehold() {

		WebElement element = driver.findElement(saveOutOfHousehold);
		clickButton(element);
	}

	public void Click_CE_Start() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(btn_CE_xpath).click();
	}

	public void Click_CE_IT() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(thpl_CE_IT_xpath).click();
	}

	public void Click_CE_IT_AE() throws InterruptedException {

		driver.findElement(thpl_CE_IT_AE_xpath).click();
	}

	public void Click_CE_GL() throws InterruptedException {

		driver.findElement(thpl_CE_GL_xpath).click();
	}

	public void Click_CE_GL_2G() throws InterruptedException {

		driver.findElement(thpl_CE_GL_2G_xpath).click();
	}

	public void Enter_CE_EGD() {

		driver.findElement(date_CE_EGD_xpath).sendKeys("01/01/2022");
	}

	public void Click_CE_School() throws InterruptedException {

		driver.findElement(thpl_CE_NOS_xpath).click();
	}

	public void Click_CE_SchoolGCC() throws InterruptedException {

		driver.findElement(thpl_CE_NOS_GCC_xpath).click();
	}

	public void Click_CE_FT() throws InterruptedException {

		driver.findElement(rdbtn_CE_ES_FT_xpath).click();
	}

	public void Click_CE_WSP_N() throws InterruptedException {

		driver.findElement(tglbtn_CE_WSP_N_xpath).click();
	}

	public void Click_CE_TAA_N() throws InterruptedException {

		driver.findElement(tglbtn_CE_TAA_N_xpath).click();
	}

	public void ClickNext() throws InterruptedException {

		WebElement ele = driver.findElement(btn_Next_xpath);
		clickButton(ele);
		wait(4);
	}

	public void ClickSave() {

		driver.findElement(btn_Save_xpath).click();
		wait(4);
	}

	// **********************************************************************************************************

	//
	//

	public void PickLInstitueType() throws Exception {

		List<WebElement> lst_Relatn = driver.findElements(By.xpath(
				"//label[text()='Institute Type']/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist][1]/li[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]"));
		for (int i = 0; i < lst_Relatn.size(); i++) {
			String Realtnval = lst_Relatn.get(i).getAttribute("data-label");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i + 1, 1, Realtnval);
			if (i == (lst_Relatn.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i + 2, 1,
						lst_Relatn.size());
			}
		}
	}

	public void PickLGradeLevel() throws Exception {

		List<WebElement> lst_Relatn = driver.findElements(By.xpath(
				"//label[text()='Institute Type']/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist][2]/li[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]"));
		for (int i = 0; i < lst_Relatn.size(); i++) {
			String Realtnval = lst_Relatn.get(i).getAttribute("data-label");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i + 1, 3, Realtnval);
			if (i == (lst_Relatn.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i + 2, 3,
						lst_Relatn.size());
			}
		}
	}

	public void PickLNameofSchool() throws Exception {

		List<WebElement> lst_Relatn = driver.findElements(By.xpath(
				"//label[text()='Institute Type']/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist][3]/li[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]"));
		setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", 1, 5, lst_Relatn.size());

	}

	public void EnterEduandCurrentEduD(String TCid) throws Exception {

		if (driver.getTitle().contains("Application Summary")) {
			al = excelData.getData(TCid, "Reg-MD-Education", "Sno");
			Thread.sleep(700);
			driver.findElement(By.xpath("//p[text()='Member Details']/following::span[contains(text(),'" + al.get(1)
					+ "')]/following::span[text()='Start']")).click();// Starting the Member details addition
			log.info("Adding the member details for " + al.get(1));

			log.info("Adding the Education details for " + al.get(1));
			wait(4);
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Education']")).getText().contains("Education"));
			Thread.sleep(700);
			driver.findElement(By.xpath("//p[text()='Highest Level of Education']/following::button[text()='Start']"))
					.click();
			wait(2);

			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			if (counterx == 1) {

				cppo.ClearHighestLevelOfEducation();
				driver.findElement(By.xpath("//label[contains(text(),'highest level of education?')]/following::input"))
						.click();
				Thread.sleep(800);
				List<WebElement> lst_Edu = driver.findElements(By.xpath(
						"//label[contains(text(),'highest level of education?')]/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]/li"));
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Highest Level of Education", 1, 1,
						lst_Edu.size());
				Thread.sleep(700);
				counterx++;
			}
			WebElement ele = driver
					.findElement(By.xpath("//label[contains(text(),'highest level of education?')]/following::input"));
			try {

				ele.sendKeys(al.get(2));
				Thread.sleep(700);
				driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
				Thread.sleep(700);
			} catch (Throwable t) {
				THPLvalidate(ele);
			}
			ClickSave();

			al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
			String FN = al.get(1);
			int Age = Integer.parseInt(al.get(19));

			System.out.println(FN);
			al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
			if (al.get(12).contains("Yes")) {
				String[] BASmem = al.get(13).trim().split(";");
				for (int i = 0; i < BASmem.length; i++) {

					String val = BASmem[i];
					System.out.println(val);

					if (val.contains(FN)) {

						al = excelData.getData(TCid, "Reg-MD-CurrEdu", "Sno");
						Thread.sleep(700);
						log.info("Adding the Current Education details for " + al.get(1));
						driver.findElement(
								By.xpath("//p[text()='Current Education']/following::button[text()='Start']")).click();
						cppo.ClearCurrentEducation();
						wait(3);
						if (counterv == 1) {
							driver.findElement(By.xpath("//label[contains(text(),'Institute Type')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLInstitueType();
						}
						WebElement ele1 = driver
								.findElement(By.xpath("//label[contains(text(),'Institute Type')]/following::input"));
						try {
							ele1.sendKeys(al.get(2));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele1);
						}
						if (counterv == 1) {
							driver.findElement(By.xpath("//label[contains(text(),'Grade Level')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLGradeLevel();
						}
						WebElement ele2 = driver
								.findElement(By.xpath("//label[contains(text(),'Grade Level')]/following::input"));
						try {
							ele2.sendKeys(al.get(3));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(3) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele2);
						}
						if (Age > 18) {
							WebElement ele3 = driver.findElement(
									By.xpath("//label[contains(text(),'Expected Graduation Date')]/following::input"));
							ele3.sendKeys(al.get(4));

						}
						if (counterv == 1) {
							driver.findElement(By.xpath("//label[contains(text(),'Name of School')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLNameofSchool();
							counterv++;
						}
						WebElement ele4 = driver
								.findElement(By.xpath("//label[contains(text(),'Name of School')]/following::input"));
						try {
							ele4.sendKeys(al.get(5));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(5) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele4);
						}
						driver.findElement(
								By.xpath("//label[contains(text(),'enrollment status?')]/following::span[text()='"
										+ al.get(6) + "']"))
								.click();
						Thread.sleep(700);
						driver.findElement(
								By.xpath("//label[contains(text(),'work-study program?')]/following::span[text()='"
										+ al.get(7) + "']"))
								.click();
						Thread.sleep(700);
						driver.findElement(By.xpath(
								"//label[contains(text(),'Opportunity Act (WIOA) and Trade Adjustment Act (TAA)?')]/following::span[text()='"
										+ al.get(8) + "']"))
								.click();
						Thread.sleep(700);
						ClickSave();
						ClickNext();
						log.info("Current Education details successfully added for " + al.get(1));
					} else {
						System.out.println("No Current Education details present.");
						ClickNext();
						log.info("Education details successfully added for " + al.get(1));
					}

				}
			}
		} else if (driver.getTitle().contains("Member Individual Info")) {
			al = excelData.getData(TCid, "Reg-MD-Education", "Sno");
			Thread.sleep(700);
			log.info("Adding the Education details for " + al.get(1));
			wait(4);
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Education']")).getText().contains("Education"));
			Thread.sleep(700);
			driver.findElement(By.xpath("//p[text()='Highest Level of Education']/following::button[text()='Start']"))
					.click();
			wait(3);

			ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
			if (counterx == 1) {

				cppo.ClearHighestLevelOfEducation();
				driver.findElement(By.xpath("//label[contains(text(),'highest level of education?')]/following::input"))
						.click();
				Thread.sleep(800);
				List<WebElement> lst_Edu = driver.findElements(By.xpath(
						"//label[contains(text(),'highest level of education?')]/following::ul[@c-ssptypeaheadpicklist_ssptypeaheadpicklist]/li"));
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Highest Level of Education", 1, 1,
						lst_Edu.size());
				Thread.sleep(700);
				counterx++;
			}

			WebElement ele5 = driver
					.findElement(By.xpath("//label[contains(text(),'highest level of education?')]/following::input"));
			try {
				ele5.sendKeys(al.get(2));
				Thread.sleep(700);
				driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
				Thread.sleep(700);
			} catch (Throwable t) {
				THPLvalidate(ele5);
			}
			ClickSave();

			al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
			String FN2 = al.get(1);
			int Age = Integer.parseInt(al.get(19));
			System.out.println(FN2);
			al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
			if (al.get(12).contains("Yes")) {
				String[] BASmem1 = al.get(13).trim().split(";");
				for (int i = 0; i < BASmem1.length; i++) {

					String val = BASmem1[i];
					System.out.println(val);

					if (val.contains(FN2)) {
						al = excelData.getData(TCid, "Reg-MD-CurrEdu", "Sno");
						Thread.sleep(700);
						log.info("Adding the Current Education details for " + al.get(1));
						driver.findElement(
								By.xpath("//p[text()='Current Education']/following::button[text()='Start']")).click();

						wait(2);

						if (counterv == 1) {
							cppo.ClearCurrentEducation();
							driver.findElement(By.xpath("//label[contains(text(),'Institute Type')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLInstitueType();
						}
						WebElement ele6 = driver
								.findElement(By.xpath("//label[contains(text(),'Institute Type')]/following::input"));
						try {

							ele6.sendKeys(al.get(2));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(2) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele6);
						}
						if (counterv == 1) {
							driver.findElement(By.xpath("//label[contains(text(),'Grade Level')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLGradeLevel();
						}
						WebElement ele7 = driver
								.findElement(By.xpath("//label[contains(text(),'Grade Level')]/following::input"));
						try {
							ele7.sendKeys(al.get(3));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(3) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele7);
						}
						if (Age > 18) {
							WebElement ele8 = driver.findElement(
									By.xpath("//label[contains(text(),'Expected Graduation Date')]/following::input"));

							ele8.sendKeys(al.get(4));
							Thread.sleep(700);

						}
						if (counterv == 1) {
							driver.findElement(By.xpath("//label[contains(text(),'Name of School')]/following::input"))
									.click();
							Thread.sleep(700);
							PickLNameofSchool();
							counterv++;
						}
						WebElement ele9 = driver
								.findElement(By.xpath("//label[contains(text(),'Name of School')]/following::input"));
						try {
							ele9.sendKeys(al.get(5));
							Thread.sleep(700);
							driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(5) + "']")).click();
							Thread.sleep(700);
						} catch (Throwable t) {
							THPLvalidate(ele9);
						}
						driver.findElement(
								By.xpath("//label[contains(text(),'enrollment status?')]/following::span[text()='"
										+ al.get(6) + "']"))
								.click();
						Thread.sleep(700);
						driver.findElement(
								By.xpath("//label[contains(text(),'work-study program?')]/following::span[text()='"
										+ al.get(7) + "']"))
								.click();
						Thread.sleep(700);
						driver.findElement(By.xpath(
								"//label[contains(text(),'Opportunity Act (WIOA) and Trade Adjustment Act (TAA)?')]/following::span[text()='"
										+ al.get(8) + "']"))
								.click();
						Thread.sleep(700);
						ClickSave();
						ClickNext();
						log.info("Current Education details successfully added for " + al.get(1));
					} else {
						System.out.println("No Current Education details present.");
						ClickNext();
						log.info("Education details successfully added for " + al.get(1));
					}

				}

			}
		}
	}
}
