package NAL_JavaQuestions;
import java.util.*;
import java.util.stream.*;

public class _22_CountOccuranceOfChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "kalam";
		charApproach(a,'a');
		charAtApproach(a,'a');
		streamsApproach(a,"a");
	}
	
	public static void charApproach(String a,char c) {
		char ch[] = a.toCharArray();
		int count =0;
		for(int i=0;i<a.length();i++) {
			if(ch[i]==c) {
				count++;
			}
		}
		
		System.out.println(c+ " : "+count);
	}

	public static void charAtApproach(String s,char c) {
		int count =0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c) {
				count++;
			}
		}
		
		System.out.println(c+ " : "+count);
	}
	
	
	public static void streamsApproach(String s, String d) {
		//char ch[] = s.toCharArray();
		long l=s.chars()
				.mapToObj(e -> String.valueOf((char)e))
		.filter(e -> e.equals(d))
		.count();
		
		System.out.println(d+ " : "+l);
	}
}
