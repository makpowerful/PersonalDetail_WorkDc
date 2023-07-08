package NAL_JavaQuestions;

import java.io.IOException;

public class _49_RunApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		Process p1= runtime.exec("notepad.exe");
		Thread.sleep(2000);
		p1.destroy();
	}

}
