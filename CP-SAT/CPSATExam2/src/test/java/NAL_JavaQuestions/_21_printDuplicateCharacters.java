package NAL_JavaQuestions;
import java.util.*;

public class _21_printDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "dnkasndasdhijeirhshsw";
		
		//Using HashSet
		char c[]= a.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		for(char e : c) {
			if(hs.add(e) == false) {
				System.out.println(e);
			}
		}
		System.out.println("------------------------");
		
		printDuplicates("");
		printDuplicates(" ");
		printDuplicates("A");
		printDuplicates("java");
		printDuplicates("No Dup");
		printDuplicates(null);
		

	}
	
	public static void printDuplicates(String s) {
		if(s==null) {
			System.out.println("Null String");
			return;
		}
		if(s.length()==1) {
			System.out.println("Single Character");
		}
		if(s.isEmpty()) {
			System.out.println("Empty String");
		}
		if(s.length()>2) {
			char c[] = s.toCharArray();
			HashMap<Character,Integer> hm= new HashMap<>();
			
			for(char ch : c) {
				if(!hm.containsKey(ch)) {
					hm.put(ch, 1);
				}
				else {
					int count = hm.get(ch);
					hm.put(ch, count+1);
				}
			}
			
			for(char cr : hm.keySet()) {
				if(hm.get(cr)>1) {
					System.out.println(cr+" : "+hm.get(cr));
				}
			}
		}
	}

}
