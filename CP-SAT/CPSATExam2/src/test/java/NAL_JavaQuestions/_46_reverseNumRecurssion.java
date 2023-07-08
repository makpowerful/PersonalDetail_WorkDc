package NAL_JavaQuestions;

public class _46_reverseNumRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		revNum(123);
	}
	
	public static void revNum(int a) {
		if(a<10) {
			System.out.print(a);
		}
		else {
			int c = a%10;
			System.out.print(c);
			revNum(a/10);
		}
	}

}
