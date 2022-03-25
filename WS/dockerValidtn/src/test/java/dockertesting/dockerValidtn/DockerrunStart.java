package dockertesting.dockerValidtn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DockerrunStart{
	
	@Test
	public void Startfile() throws IOException, InterruptedException {
		
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("cmd /c start DockerStart.bat");
		String f="output.txt";
		boolean flag=false;
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopnow=cal.getTimeInMillis();
		Thread.sleep(3000);
		
		while(System.currentTimeMillis()<stopnow) {
			
			if(flag) {
				break;
			}
			
			BufferedReader reader=new BufferedReader(new FileReader(f));
			String currline=reader.readLine();
		while(currline!=null && !flag) {
			
			if(currline.contains("registered to hub and ready to use")) {
				
				System.out.println("Found the text");
				flag=true;
				break;
				
			}
			currline=reader.readLine();
			
		}
		reader.close();
		}
		//Assert.assertTrue(flag);
		Thread.sleep(15000);
		runtime.exec("cmd /c start scale.bat");	
	}
	

}
