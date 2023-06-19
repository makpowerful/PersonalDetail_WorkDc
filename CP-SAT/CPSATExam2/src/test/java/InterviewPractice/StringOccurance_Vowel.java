package InterviewPractice;
import java.util.*;

public class StringOccurance_Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String a="akjsdksdaeiuoaeiuo";
	        char ch[]= a.toCharArray();
	        HashMap<Character,Integer> hm = new HashMap<>();
	        
	        for(char c : ch){
	            if(!hm.containsKey(c)){
	                hm.put(c,1);
	            }
	            else{
	                int count = hm.get(c);
	                hm.put(c,count+1);
	            }
	        }
	        
	        for(char ch1:hm.keySet()){
	            if(ch1 == 'a'|| ch1 == 'e'|| ch1 == 'i' ||ch1 == 'o' ||ch1 == 'u'||ch1 == ' '){
	            System.out.print(ch1);
	            System.out.print(hm.get(ch1));
	            }
	        }
	}

}
