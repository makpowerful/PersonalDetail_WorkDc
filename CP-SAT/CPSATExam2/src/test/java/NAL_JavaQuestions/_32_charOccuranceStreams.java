package NAL_JavaQuestions;

public class _32_charOccuranceStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "kalam";
		
		System.out.println(count(s,'a'));
		
	}
	
	public static long count(String s, char c) {
		long l = s.chars()
				   .filter(e -> (char)e == c)
				    .count();
		return l;
	}

}
