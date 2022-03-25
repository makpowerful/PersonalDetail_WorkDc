package dockertesting.dockerValidtn;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest1 {
	
	@BeforeTest
	public void startDocker() throws IOException, InterruptedException {
		
		File  fi=new File("output.txt");
		fi.delete();
		DockerrunStart s=new DockerrunStart();
		s.Startfile();
	}
	
	@AfterTest
	public void stopDocker() throws IOException, InterruptedException {
		File  fi=new File("output1.txt");
		fi.delete();
		DockerrunStop s1=new DockerrunStop();
		s1.Stopfile();
	}

@Test
public void testChrome1() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		//cap.setCapability("marionette", true);
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver dr=new RemoteWebDriver(u,cap);
		dr.get("https://www.google.com/");
		System.out.print(dr.getTitle());
		

	}

}
