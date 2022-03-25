package dockertesting.dockerValidtn;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest2 {

@Test
public void testChrome1() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		//cap.setCapability("marionette", true);
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver dr=new RemoteWebDriver(u,cap);
		dr.get("https://www.gmail.com/");
		System.out.print(dr.getTitle());
		

	}

}
