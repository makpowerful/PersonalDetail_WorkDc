package NAL_JavaQuestions;

import java.util.regex.*;

public class _37_subStringPresent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(subString("There is no rain today","rain"));
		System.out.println(subString1("There is no rain today","rain"));
		System.out.println(subString2("There is no rain today","rain"));
		

	}
	
	public static boolean subString(String main , String sub) {
		
		return main.matches("(.*)" + sub +"(.*)");
	}
	
	public static boolean subString1(String main , String sub) {
		
		return main.contains(sub);
	}
	
	public static boolean subString2(String main , String sub) {
		
		return main.indexOf(sub)!=-1;
	}

}
