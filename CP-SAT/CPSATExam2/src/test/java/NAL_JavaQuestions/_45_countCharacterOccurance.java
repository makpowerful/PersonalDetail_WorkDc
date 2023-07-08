package NAL_JavaQuestions;

import java.util.*;


public class _45_countCharacterOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "anncsdhfbsancalbfdoads";
		//Using for loop
		System.out.println(usingForLoop(a,'a'));
		//Using HashMap
		System.out.println(usingHashMap(a,'a'));
		//Using Streams
		long l=a.chars()
				.mapToObj(e -> String.valueOf((char)e))
		.filter(e -> e.equals("a"))
		.count();
		System.out.println(l);

	}
	
	public static int usingForLoop(String a, char d) {
		char c[] = a.toCharArray();
		int count =0;
		for(int i= 0; i<c.length;i++) {
			if(c[i]==d) {
				count++;
			}
		}
		return count;
	}
	
	public static int usingHashMap(String a, char d) {
		char c[] = a.toCharArray();
		HashMap<Character,Integer> hm = new HashMap<>();
		
		for(char ch : c) {
			if(!hm.containsKey(ch)) {
				hm.put(ch, 1);
			}
			else {
				int c1 = hm.get(ch);
				hm.put(ch, c1+1);
			}
		}
		int count =0;
		for(char e : hm.keySet()) {
			if(e==d) {
				count = hm.get(e);
			}
		}
		return count;
	}

}
