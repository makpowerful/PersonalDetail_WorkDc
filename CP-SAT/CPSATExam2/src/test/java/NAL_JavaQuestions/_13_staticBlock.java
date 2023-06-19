package NAL_JavaQuestions;

public class _13_staticBlock {

	static {
		System.out.println("Hello World");
	}
	public static final int x =20;
	public static void test() {
		System.out.println("static Method");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Explain static block in java --> They are executed even before the main method
		 * 2. How can we run a java program w/o making any object? --> static method can be used
		 * 3. Similarity and difference b/w static block and static method --> executes w/o main method and static method needs to be called in main method
		 * 4. How can we create objects if we make the constructor private --> make the method as static
		 * 5. Is it possible to compile and run java program w/o writing main method --> Yes using static block
		 * 6. Can we initialize member variables within static block --> Yes we can initialize by create object for them
		 */
		
		test();
		System.out.println(x);
	}

}
