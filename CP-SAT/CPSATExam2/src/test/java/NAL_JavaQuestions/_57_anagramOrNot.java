package NAL_JavaQuestions;

import java.util.Arrays;

public class _57_anagramOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(checkAnagram("listen","silent"));
	System.out.println(checkAnagram("listen","SILENT"));
	System.out.println(checkAnagram("listen","silent "));
	System.out.println(checkAnagram("listen","silentt"));
	
	}
	
	public static boolean checkAnagram(String s1,String s2) {
		String word1= s1.replaceAll("\\s+", "");
		String word2= s2.replaceAll("\\s+", "");
		if(word1.length()!=word2.length()) {
			return false;
		}
		else {
			char[] c1 = word1.toLowerCase().toCharArray();
			char[] c2 = word2.toLowerCase().toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			return Arrays.equals(c1, c2);
		}
	}

}
