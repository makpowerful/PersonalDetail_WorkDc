package NAL_JavaQuestions;

public class _8_longSuffixLProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long withOutSuffix = 1000*60*60*24*365;
		long withSuffix = 1000*60*60*24*365l;
		
		System.out.println(withOutSuffix); //1471228928 --> int has max limit of 32 bits i.e(2147483647)
		
		System.out.println(withSuffix); //31536000000 --> 36 bits
		
		
	}

}
