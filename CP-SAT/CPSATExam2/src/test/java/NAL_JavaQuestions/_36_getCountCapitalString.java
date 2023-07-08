package NAL_JavaQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _36_getCountCapitalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "KaLaM";
		
		//1.Using range method
		
		int count =0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)>='A' && a.charAt(i)<='Z') {
				count++;
			}
		}
		System.out.println(count);
		
		//2.Using Ascii
		int count1 =0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)>=65 && a.charAt(i)<=96) {
				count1++;
			}
		}
		System.out.println(count1);
		
		//3.Using Character
		
		int count2=0;
		for(int i=0;i<a.length();i++) {
			if(Character.isUpperCase(a.charAt(i))) {
				count2++;
			}
		}
		System.out.println(count2);
		
		
		//4.streams
		
		long l = a.chars().filter(e -> e>=65 && e<=96).count();
		System.out.println(l);
		
		//5.streams 2
		
		long l1 = a.chars().filter(e -> Character.isUpperCase(e)).count();
		System.out.println(l1);
		
		//6. Reg Expression
		String reg = "[A-Z]+";
		
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(a);
		
		int count5=0;
		while(matcher.find()) {
			count5++;
		}
		System.out.println(count5);
		
		
	}
}
