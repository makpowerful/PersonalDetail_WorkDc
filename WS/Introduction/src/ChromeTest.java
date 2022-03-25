import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeTest {
	
	public static void main(String[] args) {
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();*/
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		
	}

}
