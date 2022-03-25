package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreScreenPO {

	public WebDriver driver;

	By btn_PreSc_css = By.xpath("//button[@title='Prescreening Tool']");
	By chkbx_VerCapt_id = By.id("recaptcha-anchor-label");

	public PreScreenPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void ClickPreScreen() {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(btn_PreSc_css).click();

	}

	public void CheckVerifyCaptcha() {
		int size = driver.findElements(By.tagName("iframe")).size();

		for (int i = 0; i <= size; i++) {
			int total = driver.findElements(By.xpath("//iframe[@role = 'presentation']")).size();
			System.out.println(total);
			driver.switchTo().frame(total);
			// driver.switchTo().defaultContent();
			driver.findElement(chkbx_VerCapt_id).click();
		}
	}

}