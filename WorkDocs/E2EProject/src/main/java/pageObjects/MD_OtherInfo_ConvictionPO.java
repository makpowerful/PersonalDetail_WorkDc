package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import resources.ExcelData;
import resources.base;

public class MD_OtherInfo_ConvictionPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");
	By tglbtn_Job30days_xpath = By.xpath("//span[2]/label");

	public MD_OtherInfo_ConvictionPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void Click_Job30days_N() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250);");
		Thread.sleep(1000);
		driver.findElement(tglbtn_Job30days_xpath).click();
	}

	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(4);
	}

	// *********************************************************************************

	public void PickLSNAP() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[contains(text(),'How many SNAP Intentional Program')]/following::select[1]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i + 1, 1, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	
	public void PickLTANF() throws Exception {
		List<WebElement> lst_PNo = driver.findElements(By.xpath("//label[contains(text(),'How many SNAP Intentional Program')]/following::select[2]/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i + 1, 3, Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i + 2, 3,
						lst_PNo.size());
			}
		}
	}
	
	public void EnterConviction(String TCid) throws Exception {
		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String FN = al.get(1);
		System.out.println(FN);
		al = excelData.getData("TC1", "Reg-HI-HHCircum", "Sno");
		String Q1=al.get(1);
		String Q1mem=al.get(2);
		String Q2=al.get(3);
		String Q2mem=al.get(4);
		String Q3=al.get(7);
		String Q3mem=al.get(8);
		if (Q1.contains("Yes")) {
			String[] Conmem1 = Q1mem.trim().split(";");
			for (int i = 0; i < Conmem1.length; i++) {

				String val = Conmem1[i];
				System.out.println(val);

				if (val.contains(FN)) {

					al = excelData.getData(TCid, "Reg-MD-Convictn", "Sno");
					Assert.assertTrue(
							driver.findElement(By.xpath("//p[text()='Conviction']")).getText().contains("Conviction"));
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'a fleeing felon?')]/following::span[text()='" + al.get(2) + "']"))
							.click();
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'currently violating probation or parole?')]/following::span[text()='"
									+ al.get(3) + "']"))
							.click();
					Thread.sleep(700);
					//System.out.println(Q2mem);
					//System.out.println(Q3mem);
					if(Q2mem.contains(val)||Q3mem.contains(val)) {
						System.out.println("Member is present for other questions");
					}
					else {
						ClickNext();
					}
				}
			}
		} 
		if (Q2.contains("Yes")) {
			String[] Conmem2 = Q2mem.trim().split(";");
			for (int j = 0; j < Conmem2.length; j++) {

				String val2 = Conmem2[j];
				System.out.println(val2);

				if (val2.contains(FN)) {

					al = excelData.getData(TCid, "Reg-MD-Convictn", "Sno");
					driver.findElement(By.xpath(
							"//label[contains(text(),'such an offense, after February 7, 2014?')]/following::span[text()='"
									+ al.get(4) + "']"))
							.click();
					Thread.sleep(700);
					if(Q3mem.contains(val2)) {
						System.out.println("Member is present for other questions");
					}
					else {
						ClickNext();
					}
				}
			}
		} if (Q3.contains("Yes")) {
			String[] Conmem3 = Q3mem.trim().split(";");
			for (int k = 0; k < Conmem3.length; k++) {

				String val3 = Conmem3[k];
				System.out.println(val3);

				if (val3.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-Convictn", "Sno");
					driver.findElement(By.xpath(
							"//label[contains(text(),'convicted of buying, selling or trading more than $500 in SNAP benefits?')]/following::span[text()='"
									+ al.get(5) + "']"))
							.click();
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'for firearms, ammunition, or explosives?')]/following::span[text()='"
									+ al.get(6) + "']"))
							.click();
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'convicted of trading SNAP benefits for drugs?')]/following::span[text()='"
									+ al.get(7) + "']"))
							.click();
					Thread.sleep(700);
					driver.findElement(By.xpath(
							"//label[contains(text(),'SNAP Intentional Program Violation (IPV)?')]/following::span[text()='"
									+ al.get(8) + "']"))
							.click();
					Thread.sleep(700);
					if(al.get(8).contains("Yes")) {
						ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
						cppo.ClearPLConviction1();
						PickLSNAP();
						Select s1=new Select(driver.findElement(By.xpath("//label[contains(text(),'How many SNAP Intentional Program Violations')]/following::select")));
						s1.selectByVisibleText(al.get(9));
						Thread.sleep(700);
					}
					driver.findElement(By.xpath(
							"//label[contains(text(),'TANF Intentional Program Violation (IPV)?')]/following::span[text()='"
									+ al.get(10) + "']"))
							.click();
					Thread.sleep(700);
					if(al.get(10).contains("Yes")) {
						ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
						cppo.ClearPLConviction2();
						PickLTANF();
						Select s2=new Select(driver.findElement(By.xpath("//label[contains(text(),'How many TANF Intentional Program Violations')]/following::select")));
						s2.selectByVisibleText(al.get(11));
						Thread.sleep(700);
						ClickNext();
					}

				}
			}
		}
		
	}
}
