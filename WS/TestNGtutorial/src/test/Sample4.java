package test;

public class Sample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="malak";
		String d = "";
		for(int i=a.length()-1;i>=0;i--)
		{
			d= d+a.charAt(i);
			
		}
		System.out.println(d);
		System.out.println(a);
		
		if(d.equals(a)) 
		{
			System.out.println("Given string is a plaindrome");
		}
		else {
			System.out.println("Given string is not a plaindrome");
		}

	}

}
