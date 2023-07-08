package NAL_JavaQuestions;

import com.google.common.base.CharMatcher;

public class _33_countVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is to check vowels count";
		
		//Java for loop
		int count =0;
		for(int i=0;i<s.length();i++) {
			if(isVowel(s.charAt(i))) {
				count++;
			}
		}
		System.out.println(count);
		
		//Streams
		long l =s.chars()
		.filter(e -> (char)e == 'a' || (char)e == 'e' || (char)e == 'i' || (char)e == 'o' || (char)e == 'u')
		.count();
		
		System.out.println(l);
		
		//Google guava
		int t=CharMatcher.anyOf("aeiouAEIUO").countIn(s);
		System.out.println(t);

	}
	
	public static boolean isVowel(char c) {
	
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
				c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}

}
