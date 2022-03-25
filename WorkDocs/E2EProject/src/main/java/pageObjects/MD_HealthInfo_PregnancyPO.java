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

public class MD_HealthInfo_PregnancyPO extends base {

	public WebDriver driver;
	ExcelData excelData = new ExcelData();
	ArrayList<String> al = new ArrayList<String>();
	By btn_Next_xpath = By.xpath("//button[contains(text(),'Next')]");

	public MD_HealthInfo_PregnancyPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickNext() {

		driver.findElement(btn_Next_xpath).click();
		wait(5);
	}

	// ****************************************************************************************************8

	public void PickPregnancy() throws Exception {
		List<WebElement> lst_PNo = driver
				.findElements(By.xpath("//select/option"));
		for (int i = 0; i < lst_PNo.size(); i++) {
			String Pnoval = lst_PNo.get(i).getText();
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Pregnancy", i + 1, 1,
					Pnoval);
			if (i == (lst_PNo.size() - 1)) {
				setData2("src\\main\\java\\testData\\PickListResult.xlsx", "Pregnancy", i + 2, 1,
						lst_PNo.size());
			}
		}
	}
	public void EnterPregnancy(String TCid) throws Exception {

		al = excelData.getData(TCid, "HHMemDetailsRegression", "Sno");
		String Gender = al.get(5);
		System.out.println(al.get(5));
		String FN = al.get(1);
		System.out.println(FN);
		if (Gender.contains("Female") || Gender.contains("Non-Binary")) {
			al = excelData.getData("TC1", "Reg-HI-Health", "Sno");
			String[] Pmem = al.get(8).trim().split(";");
			for (int i = 0; i < Pmem.length; i++) {

				String val = Pmem[i];
				System.out.println(val);

				if (val.contains(FN)) {
					
					al = excelData.getData(TCid, "Reg-MD-Pregnancy", "Sno");
					ClearPickListDataPO cppo = new ClearPickListDataPO(driver);
					cppo.ClearPregnancy();
					Assert.assertTrue(
							driver.findElement(By.xpath("//p[text()='Pregnancy']")).getText().contains("Pregnancy"));
					Thread.sleep(700);
					PickPregnancy();
					driver.findElement(
							By.xpath("//label[contains(text(),'currently pregnant?')]/following::span[text()='"
									+ al.get(2) + "']"))
							.click();
					Thread.sleep(700);
					WebElement ele=driver.findElement(By.xpath("//select"));
					try {
					Select s1 = new Select(ele);
					s1.selectByVisibleText(al.get(3));
					Thread.sleep(700);
					}
					catch(Throwable t) {
					PLvalidate(ele);	
					}
					driver.findElement(By.xpath("//label[contains(text(),'Expected Due Date')]/following::input"))
							.sendKeys(al.get(4));
					Thread.sleep(700);
					ClickNext();
				}

			}
		}

	}

}
