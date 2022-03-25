package test;

public class Sample17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "malam";
		System.out.println(name);
		/*
		 * for(int i=name.length();i==name.lastIndexOf(i);i--) {
		 * System.out.println(name.charAt(i)); }
		 */
		/*
		 * int i=name.length(); while(i==0) {
		 * 
		 * System.out.println(name.charAt(i)); i--;
		 */
		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(name);

		// reverse StringBuilder input1
		input1.reverse();

		// print reversed String
		System.out.println(input1);
		
		if(name==input1.toString()) {
			System.out.println("Input is a palindrome");
		}
		else {
			System.out.println("Input is not a palindrome");
		}
	}

}
