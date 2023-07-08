package NAL_JavaQuestions;

import java.net.MalformedURLException;
import java.net.URL;

public class _28_URLwithIPProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get IP address from Websites
		
		try {
			System.out.println(new URL("https://app.hubspot.com"));
			System.out.println(new URL("https://app.hubspot.com")
					.equals(new URL("https://104.19.155.83")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
