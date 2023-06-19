package NAL_JavaQuestions;

public class _12_nullParameterProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Identify which method would be called in case of overloading
		test(null); //Even though Object is a super class of String the JVM is smart enough to understand
					//String is the type that makes more sense
	}
	
	public static void test(Object o) {
		System.out.println("Object Type");
	}

	public static void test(String s) {
		System.out.println("String Type");
	}
}
