package MAINEtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.MD_ExpenseInfo_MedicalExpPO;
import resources.base;

public class test_ExpenseSummaryScreen extends base {

	// public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_MemDetailsScreen.class.getName());

	@Test(priority = 1, groups = { "sanity", "SNAP" })
	public void validateExpenseSummary() throws IOException, InterruptedException {

		log.info("Adding Member details (Expense Information) for HHM1");
		MD_ExpenseInfo_MedicalExpPO me = new MD_ExpenseInfo_MedicalExpPO(driver);
		me.Select_MedicalBillMonth();
		Thread.sleep(1000);
		me.ClickNext();
		Assert.assertEquals(driver.getTitle(), "Application Summary");
		log.info("Member details (Expense Information) for HHM1 have been added successfully");

	}

	@Test(priority = 1, groups = { "Regression" }, dataProvider = "TestCaseID")
	public void testClass(String TCid) throws Exception {

		MD_ExpenseInfo_MedicalExpPO ex = new MD_ExpenseInfo_MedicalExpPO(driver);
		ex.Click_AcceptExpensePopup();
		List<WebElement> elements = driver.findElements(By.xpath("//span/p[1]")); // get all the record elements on
																					// screen
		List<String> types = new ArrayList<String>();
		for (WebElement e : elements) {
			types.add(e.getText());
		}
		Scrolldown();
		if ((types != null) && !types.isEmpty()) {
			for (String type : types) {
				ex.Enter_Expense_Reg(TCid, type);
			}
			Scrollend();
			ex.ClickNext();
		} else {
			Scrollend();
			ex.ClickNext();
			log.info("Expense record is not displayed");
			System.out.println("Expense record is not displayed");
		}
			Assert.assertEquals(driver.getTitle(), "Application Summary");
		}
	

	@DataProvider(name = "TestCaseID")
	public Object[][] dpMethod() {
		return new Object[][] { { "TC1" }, { "TC2" }, { "TC3" }, { "TC4" }, { "TC5" }, { "TC6" }, { "TC7" } };
	}

}
