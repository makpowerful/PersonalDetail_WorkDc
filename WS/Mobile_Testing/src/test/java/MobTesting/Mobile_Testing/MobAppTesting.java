package MobTesting.Mobile_Testing;

import java.net.MalformedURLException;

import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobAppTesting extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='6. Advanced preferences']").click();
		TouchActions t=new  TouchActions(driver);
		//t.singleTap(null);

	}

}
