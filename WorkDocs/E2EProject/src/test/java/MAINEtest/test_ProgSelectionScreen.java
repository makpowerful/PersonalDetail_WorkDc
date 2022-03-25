package MAINEtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ProgSelectionPO;
import resources.base;

public class test_ProgSelectionScreen extends base{

	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(test_ProgSelectionScreen.class.getName());
	ProgSelectionPO ps;
	
	@Test(groups={"sanity"})
	public void validateProgSelec() throws IOException, InterruptedException {
		ps = new ProgSelectionPO(driver);
		ps.ClickMainCare();
		Thread.sleep(1000);
		ps.ClickSNAP();
		Thread.sleep(1000);
		ps.ClickTANF();
		Thread.sleep(1000);
		ps.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(),"Application Summary");
		log.info("User has landed on Application Summary after making program selection screen");
		

	}
	
	@Test(groups="TANF")
	public void tanfProgramSelection() throws InterruptedException
	{
		ps = new ProgSelectionPO(driver);
		Thread.sleep(1000);
		ps.ClickTANF();
		Thread.sleep(3000);
		Scrollpagedown();
		ps.ClickNextTanf();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(),"Application Summary");
		log.info("User has landed on Application Summary after making TANF program selection screen");
	}
	
	@Test(groups="SNAP")
	public void snapProgramSelection() throws InterruptedException
	{
		ps = new ProgSelectionPO(driver);
		ps.ClickSNAP();
		Thread.sleep(1000);
		ps.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(),"Application Summary");
		log.info("User has landed on Application Summary after making SNAP program selection screen");
	}
	
	@Test(groups="Regression")
	public void validateProgramSelection() throws InterruptedException, IOException
	{
		ps = new ProgSelectionPO(driver);
		ps.PrgmSelecMC();
		ps.PrgmSelecSNAP();
		ps.PrgmSelecTANF();
		ps.ClickNext();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getTitle(),"Application Summary");
		log.info("User has landed on Application Summary after selectingall 3 programs");
	}
	
}
