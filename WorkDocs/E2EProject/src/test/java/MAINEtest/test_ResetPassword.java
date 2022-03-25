package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ResetPasswordPO;
import resources.base;

public class test_ResetPassword extends base {

	public static Logger log = LogManager.getLogger(test_AddingHHMembers.class.getName());

	@Test(groups="SNAP")
	public void resetPassword() throws InterruptedException, IOException {

		//String password = ConfigFileReader("password");
	//	System.out.println(password);
		Thread.sleep(1500);
		Scrolldown();
		ResetPasswordPO reset = new ResetPasswordPO(driver);
		reset.Enter_Password("Deloitte");
		reset.Enter_ConfirmPassword("Deloitte");
		reset.Click_ChangePassword();

	}
}
