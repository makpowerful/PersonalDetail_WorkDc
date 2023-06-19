package NAL_JavaQuestions;

public class _10_staticBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(A.x);
	}
	

}
class A {
	public static final int x = 100;//  Because we are declaring x as final static block will not be executed
	
	static {
		System.out.println("Test print");
	}
}
