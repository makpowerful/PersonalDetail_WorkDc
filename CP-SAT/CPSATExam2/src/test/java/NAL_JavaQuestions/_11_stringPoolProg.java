package NAL_JavaQuestions;

public class _11_stringPoolProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "Hello World";//Creates 1 object in String constant pool
		String s2 = "Hello World";// Points to s1 object itself
		String s3 = s1; //points to s1 object itself
		
		String n1 = new String("Hello World"); // Creates 2 object, 1 in Heap memory and other in Stack memory
		String n2 = new String("Hello World"); 
		
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		
		System.out.println(n1==n2);
		System.out.println(n2==s1);
		
	}

}
