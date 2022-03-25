package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import resources.ExcelData;
import resources.base;

public class RelationshipandTaxfillingPO extends base {
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	public WebDriver driver;

	By btn_StartHHM1_xpath = By.xpath("//div[6]/c-ssp-member-section-card/div/div[2]/div/ul/li[1]/div/div[2]/img");
	By btn_StartHHM2_xpath = By.xpath("//div[6]/c-ssp-member-section-card/div/div[2]/div/ul/li[2]/div/div[2]/img");
	By btn_StartHHM3_xpath = By.xpath("//div[6]/c-ssp-member-section-card/div/div[2]/div/ul/li[3]/div/div[2]/img");
	By btn_StartHHAll_xpath = By
			.xpath("//p[text()='Relationships & Tax Filing']/following::li/preceding::span[contains(text(),'Start')]");
	By thpl1_HHM1_xpath = By
			.xpath("//li[1]/div/div/div[3]/div/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By thpl1_HHM2_xpath = By
			.xpath("//li[2]/div/div/div[3]/div/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By thpl1_HHM3_xpath = By
			.xpath("//li[3]/div/div/div[3]/div/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By tglbtn1_HHM1_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn2_HHM1_xpath = By.xpath(
			"//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn3_HHM1_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[1]/label/span");
	By tglbtn1_HHM2_xpath = By.xpath(
			"//div[4]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn2_HHM2_xpath = By.xpath(
			"//div[5]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By tglbtn3_HHM2_xpath = By.xpath(
			"//div[6]/c-ssp-base-component-input-toggle/div/div/lightning-radio-group/fieldset/div/div/span[2]/label/span");
	By thpl2_HHM1_xpath = By
			.xpath("//li[2]/div/div/div[3]/div/c-ssp-type-ahead-picklist/div/lightning-input/div/input");
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By val_Parent_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li[3]/div");
	By val_Spouse_xpath = By.xpath("//c-ssp-type-ahead-picklist/div/ul/li/div");
	By rdbtn_HHM1tax_xpath = By.xpath("//span[2]");
	By tglbtn1_HHM1tax_xpath = By.xpath("//div/div/span/label");

	By chk_HHM1tax_xpath = By.xpath("//lightning-checkbox-group/fieldset/div/span/label/span[1]");
	By relationshipTypehead = By.xpath("//li[@class='ssp-typeahead-items']/div");
	static int counter = 0;
	static int counterx = 1;
	private By lbl_HHmeals_xpath = By.xpath("//p[text()='Household Meals']");
	private By lbl_HHTax_xpath = By.xpath("//p");

	public RelationshipandTaxfillingPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickStartHHM1() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,650);");
		Thread.sleep(1000);

		ClickOn(btn_StartHHM1_xpath);

	}

	public void ClickStartHHM2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("scroll(0,700);");

		Thread.sleep(1000);

		ClickOn(btn_StartHHM2_xpath);

	}

	public void ClickStartHHM3() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,750);");
		Thread.sleep(1000);
		/*
		 * driver.findElement(btn_StartHHM3_xpath).click();
		 */
		ClickOn(btn_StartHHM3_xpath);
	}

	public void ClickStartHHMAll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,750);");
		Thread.sleep(1000);
		/*
		 * driver.findElement(btn_StartHHM3_xpath).click();
		 */
		ClickOn(btn_StartHHAll_xpath);
	}

	public void SelectRelatnHHM1toHHM3() throws InterruptedException {

		driver.findElement(thpl1_HHM1_xpath).click();
		driver.findElement(thpl1_HHM1_xpath).clear();
		driver.findElement(thpl1_HHM1_xpath).sendKeys("Parent");
		Thread.sleep(800);
		driver.findElement(val_Parent_xpath).click();
		Thread.sleep(800);

	}

	public void SelectRelatnHHM2toHHM3() throws InterruptedException {

		driver.findElement(thpl1_HHM2_xpath).click();
		driver.findElement(thpl1_HHM2_xpath).clear();
		driver.findElement(thpl1_HHM2_xpath).sendKeys("Parent");
		Thread.sleep(800);
		driver.findElement(val_Parent_xpath).click();
		Thread.sleep(800);
	}

	public void SelectYLegalGaurdn() throws InterruptedException {

		if (isDisplayed(tglbtn1_HHM1_xpath)) {
			driver.findElement(tglbtn1_HHM1_xpath).click();
		} else {
			System.out.println("button not displayed");
		}
		Thread.sleep(800);

	}

	public void SelectYPriCartaker() throws InterruptedException {
		if (isDisplayed(tglbtn2_HHM1_xpath)) {
			driver.findElement(tglbtn2_HHM1_xpath).click();

			Thread.sleep(800);
		} else {
			System.out.println("tglbtn3_HHM1_xpath button does not appear");
		}

	}

	public void SelectYMaintnHome() throws InterruptedException {
		if (isDisplayed(tglbtn3_HHM1_xpath)) {
			driver.findElement(tglbtn3_HHM1_xpath).click();

			Thread.sleep(800);
		} else {
			System.out.println("tglbtn3_HHM1_xpath button does not appear");
		}

	}

	public void SelectNLegalGaurdn() throws InterruptedException {
		if (isDisplayed(tglbtn1_HHM2_xpath)) {
			driver.findElement(tglbtn1_HHM2_xpath).click();
			Thread.sleep(800);
		} else {
			System.out.println("tglbtn3_HHM1_xpath button does not appear");
		}

	}

	public void SelectNPriCartaker() throws InterruptedException {
		if (isDisplayed(tglbtn2_HHM2_xpath)) {
			driver.findElement(tglbtn2_HHM2_xpath).click();
			Thread.sleep(800);

		} else {
			System.out.println("tglbtn2_HHM2_xpath button does not appear");
		}

	}

	public void SelectNMaintnHome() throws InterruptedException {
		if (isDisplayed(tglbtn3_HHM2_xpath)) {
			driver.findElement(tglbtn3_HHM2_xpath).click();
			Thread.sleep(800);

		} else {
			System.out.println("tglbtn3_HHM2_xpath button does not appear");
		}

	}

	public void SelectRelatnHHM1toHHM2() throws InterruptedException {

		driver.findElement(thpl2_HHM1_xpath).click();
		driver.findElement(thpl2_HHM1_xpath).clear();
		driver.findElement(thpl2_HHM1_xpath).sendKeys("Spouse");
		Thread.sleep(800);
		driver.findElement(val_Spouse_xpath).click();
		Thread.sleep(800);

	}

	public void SelectMarriedFilngtaxHHM1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400);");
		Thread.sleep(1000);
		WebElement element = driver.findElement(rdbtn_HHM1tax_xpath);
		clickButton(element);
		Thread.sleep(800);

	}

	public void SelectPriCaretaxHHM1() throws InterruptedException {
		if (isDisplayed(tglbtn1_HHM1tax_xpath)) {
			driver.findElement(tglbtn1_HHM1tax_xpath).click();
			Thread.sleep(800);

		} else {
			System.out.println("tglbtn1_HHM1tax_xpath button does not appear");
		}

	}

	public void SelectDependOntaxHHM1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,800);");
		Thread.sleep(1000);
		driver.findElement(chk_HHM1tax_xpath).click();
		Thread.sleep(800);

	}

	public void PickLRelationship() throws Exception {
		System.out.println("Does Enter");
		List<WebElement> lst_Relatn = driver
				.findElements(By.xpath("//ul[@class='ssp-lookup-option-container ssp-Hide']/li"));
		for (int i = 0; i < lst_Relatn.size(); i++) {
			String Realtnval = lst_Relatn.get(i).getAttribute("data-label");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships", i + 1, 1, Realtnval);
			if (i == (lst_Relatn.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships", i + 2, 1,
						lst_Relatn.size());
			}
		}
	}

	public int HHMembercount() throws Exception {

		int k = getRowCount("src\\main\\java\\testData\\TestData.xlsx", "HHMemDetailsRegression") - 2;
		System.out.println(k);
		return k;

	}

	public void EnterHHMRelationship(String HHname) throws Exception {

		al = excelData.getData(HHname, "Reg-Relationship", "HH member with");
		String[] HHnamesplit = HHname.trim().split(" is ");
		System.out.println("The value of counter is initial: " + counter);
		if (al.get(2).contains("null") && al.get(3).contains("null") && al.get(4).contains("null")) {
			wait(1);
			WebElement rn = driver.findElement(By.xpath("//label[contains(text(),'" + HHname + "')]/following::input"));
			try {
				rn.clear();
				Thread.sleep(700);
				/*
				 * if (counterx == 1) { System.out.println("counterx loop 1 value: "+counterx);
				 * PickLRelationship(); counterx++; }
				 */
				rn.sendKeys(al.get(1).toString());
				Thread.sleep(700);
				driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(1).toString() + "']")).click();
				Thread.sleep(700);
			} catch (Throwable t) {
				THPLvalidate(rn);
			}
			counter++;
			System.out.println("The value of counter is loop1: " + counter);
			if (counter == HHMembercount()) {
				ClickNext();
				counter = 0;
				System.out.println("Adding Tax filing");
				driver.findElement(By.xpath("//span[text()='" + al.get(5) + "']")).click();
				Thread.sleep(700);

				if (al.get(6).contains("No") || al.get(6).contains("Yes")) {
					System.out.println("Inside Dependents loop1");
					driver.findElement(By.xpath(
							"//label[contains(text(),'household members as dependents')]/following::span[contains(text(),'"
									+ al.get(6) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(6).contains("Yes")) {
						String[] dependents = al.get(7).trim().split(";");
						for (int i = 0; i < dependents.length; i++) {
							driver.findElement(By.xpath("//span[text()='" + dependents[i] + "']")).click();
							Thread.sleep(700);
						}

					}
					ClickNext();
					System.out.println(driver.findElement(By.xpath("//p")).getText());
					if (driver.findElement(By.xpath("//p")).getText().contains("Household Meals")) {
						String[] HHmeals = al.get(8).trim().split(";");
						for (int j = 0; j < HHmeals.length; j++) {
							driver.findElement(By.xpath("//span[text()='" + HHmeals[j] + "']")).click();
						}
						ClickNext();
						driver.findElement(btn_StartHHAll_xpath).click();
						wait(4);
					} else {
						driver.findElement(btn_StartHHAll_xpath).click();
						wait(4);
					}
				}

				if (driver.findElement(lbl_HHTax_xpath).getText().contains("Tax Filing")) {
					System.out.println("Relationships Tax Filing loop1");
					ClickNext();

					// WebElement ele=driver.findElement(btn_StartHHAll_xpath);
					// scrollIntoView(ele);
					if (driver.getTitle().contains("Application Summary"))
						try {
							driver.findElement(btn_StartHHAll_xpath).click();
							wait(4);
						} catch (Throwable t) {
							System.out.println("All members are done.");
						}
				}
				/*
				 * else
				 * if(driver.findElement(lbl_HHmeals_xpath).getText().contains("Household Meals"
				 * )) { System.out.println("HH mealsloop1"); String[]
				 * HHmeals=al.get(8).trim().split(";"); for(int j=0;j<HHmeals.length;j++) {
				 * driver.findElement(By.xpath("//span[text()='"+HHmeals[j]+"']")).click(); }
				 * ClickNext(); driver.findElement(btn_StartHHAll_xpath).click(); wait(5); }
				 */

			}
		} else

		{

			WebElement rn = driver.findElement(By.xpath("//label[contains(text(),'" + HHname + "')]/following::input"));
			rn.clear();
			Thread.sleep(700);
		try {	
			if (counterx == 1) {
				ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
				cppo.ClearRelationships();
				wait(1);
				rn.click();
				wait(1);
				driver.findElement(By.xpath("//label[contains(text(),'" + HHname + "')]")).click();
				wait(1);
				System.out.println("counterx loop 2 value: " + counterx);
				List<WebElement> lst_Relatn = driver.findElements(By.xpath("//label[contains(text(),'" + HHname
						+ "')]/following::ul[@class='ssp-lookup-option-container ssp-Hide']/li"));
				for (int i = 0; i < lst_Relatn.size(); i++) {
					String Realtnval = lst_Relatn.get(i).getAttribute("data-label");
					System.out.println(Realtnval);
					setData("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships", i + 1, 1, Realtnval);
					if (i == (lst_Relatn.size() - 1)) {
						setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships", i + 2, 1,
								lst_Relatn.size());
					}
				}
			
				counterx++;
			}
		
			rn.sendKeys(al.get(1).toString());
			Thread.sleep(700);
			driver.findElement(By.xpath("//ul/li/div[text()='" + al.get(1).toString() + "']")).click();
			Thread.sleep(700);
		}
		catch(Throwable t) {
			THPLvalidate(rn);
		}
			driver.findElement(By.xpath("//div[@class='slds-grid slds-wrap']/div[text()='Relation to " + HHnamesplit[1]
					+ "']/following::label[contains(text(),'" + HHname
					+ "')]/following::label[contains(text(),'legal guardian or Indian Custodian')][contains(text(),'acting as "
					+ HHnamesplit[1] + "')]/following::span[contains(text(),'" + al.get(2).toString() + "')]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//div[@class='slds-grid slds-wrap']/div[text()='Relation to " + HHnamesplit[1]
					+ "']/following::label[contains(text(),'" + HHname
					+ "')]/following::label[contains(text(),'primary')][contains(text(),'acting as " + HHnamesplit[1]
					+ "')]/following::span[contains(text(),'" + al.get(3).toString() + "')]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//div[@class='slds-grid slds-wrap']/div[text()='Relation to " + HHnamesplit[1]
					+ "']/following::label[contains(text(),'" + HHname
					+ "')]/following::label[contains(text(),'maintain')]/following::span[contains(text(),'"
					+ al.get(4).toString() + "')]")).click();
			counter++;
			System.out.println("The value of counter is loop2: " + counter);
			Thread.sleep(700);
			if (counter == HHMembercount()) {
				ClickNext();
				counter = 0;
				System.out.println("Adding Tax filing loop 2");
				driver.findElement(By.xpath("//span[text()='" + al.get(5) + "']")).click();
				Thread.sleep(700);
				if (al.get(6).contains("No") || al.get(6).contains("Yes")) {
					System.out.println("Adding Tax filing question loop 2");
					driver.findElement(By.xpath(
							"//label[contains(text(),'household members as dependents')]/following::span[contains(text(),'"
									+ al.get(6) + "')]"))
							.click();
					Thread.sleep(700);
					if (al.get(6).contains("Yes")) {
						String[] dependents = al.get(7).trim().split(";");
						for (int i = 0; i < dependents.length; i++) {
							driver.findElement(By.xpath("//span[text()='" + dependents[i] + "']")).click();
							Thread.sleep(700);

						}

					}
					ClickNext();
					System.out.println(driver.findElement(By.xpath("//p")).getText());
					if (driver.findElement(By.xpath("//p")).getText().contains("Household Meals")) {
						String[] HHmeals = al.get(8).trim().split(";");
						for (int j = 0; j < HHmeals.length; j++) {
							driver.findElement(By.xpath("//span[text()='" + HHmeals[j] + "']")).click();
						}
						ClickNext();
						driver.findElement(btn_StartHHAll_xpath).click();
						wait(4);
					} else {
						driver.findElement(btn_StartHHAll_xpath).click();
						wait(4);
					}
				}
			}
		}
	}

	public void ClickNext() throws InterruptedException {

		ClickOn(btn_Next_xpath);
		wait(5);

	}
}
