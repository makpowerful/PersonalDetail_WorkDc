package NAL_JavaQuestions;

public class _9_MIN_VALUE_Prog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Double.MIN_VALUE); //is a +ve Number
		System.out.println(Integer.MIN_VALUE);//is a -ve Number
		System.out.println(Float.MIN_VALUE); //is a +ve Number
		System.out.println(Long.MIN_VALUE); //is a -ve Number
		
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Double.MIN_VALUE, Double.NEGATIVE_INFINITY));
	}

}
