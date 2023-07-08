package NAL_JavaQuestions;

import java.text.DecimalFormat;

public class _63_calPercentage {

	//Calculate percantage of Upper characters, lower characters,digits and special characters
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calPer("This is a test 123 !@#");

	}
	
	public static void calPer(String s) {
		int upperCase =0;
		int lowerCase =0;
		int specialChar=0;
		int digit =0;
		char c[] = s.toCharArray();
		int length = 0;
		for(char ch : c) {
			if(ch!=' ') {
				length++;
			}
		}
		System.out.println(length);
		for(int i=0;i<c.length;i++) {
			if(Character.isDigit(c[i])) {
				digit++;
			}
			else if(Character.isUpperCase(c[i])) {
				upperCase++;
			}
			else if(Character.isLowerCase(c[i])) {
				lowerCase++;
			}
			else if(!Character.isAlphabetic(c[i])) {
				specialChar++;
			}
		}
		
		DecimalFormat dFormat = new DecimalFormat("##.##");
		double digitd= (digit*100.0)/length;
		double upperCased=(upperCase*100.0)/length;
		double lowerCased=(lowerCase*100.0)/length;
		double specialChard=(specialChar*100.0)/length;
		
		System.out.println("% of Digits : "+dFormat.format(digitd));
		System.out.println("% of UpperCase : "+dFormat.format(upperCased));
		System.out.println("% of LowerCase : "+dFormat.format(lowerCased));
		System.out.println("% of Speical Characters : "+dFormat.format(specialChard));
	}

}
