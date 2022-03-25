package test;

import org.testng.annotations.Test;

public class Day1 {
   
	
	@Test
	public void demo2() {
		String name= "Kalam";
		for(int i=name.length();i<=0;i--) {
			System.out.println(name.charAt(i));
		}
				
	}

}
