package NAL_JavaQuestions;

import java.util.HashMap;

public class _54_numberFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumFreq(121);
		System.out.println("************");
		NumFreq(5);
		System.out.println("************");
		NumFreq(9874892360293L);
	}
	
	public static void NumFreq(long num) {
		
		if(String.valueOf(num).length()==1) {
			System.out.println(num+" : "+1);
			return;
		}
		
		HashMap<Long, Integer> hm = new HashMap<>();
		while(num!=0) {
			long lastnum = num%10;
			if(!hm.containsKey(lastnum)) {
				hm.put(lastnum, 1);
			}
			else {
				hm.put(lastnum, hm.get(lastnum)+1);
			}
			num=num/10;
		}
		
		hm.forEach((k,v) -> System.out.println(k+" : "+v));
		
	}

}
