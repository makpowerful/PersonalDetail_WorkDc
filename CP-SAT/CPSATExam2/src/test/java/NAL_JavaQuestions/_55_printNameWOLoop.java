package NAL_JavaQuestions;

public class _55_printNameWOLoop {
	
	  private static int counter = 1;
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//print name 1000 times w/o loop
		String nameString = "kalam";
		String i = "i";
		i =i.replaceAll("i", "iiiiiiiiii");
		i =i.replaceAll("i", "iiiiiiiiii");
		i =i.replaceAll("i", nameString +"\n");
			System.out.println(i);
			System.out.println("******");
			Recur_Approach(nameString);
		
	}
	
	public static void Recur_Approach(String s) {
		 if (counter <= 100)
	        {
	              System.out.println(s);
	              counter++;
	              main(null);
	         }
	}
	
	

}
