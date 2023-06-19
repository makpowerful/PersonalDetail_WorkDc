package NAL_JavaQuestions;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _16_FindDuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a[] = {"Amazon","google","microsoft","apple","Amazon","SF","apple"};
		
		//1.bruteforce
		
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					System.out.println(a[i]);
				}
			}
		}
		 
		
		System.out.println("**************************");
		
		//2.Hashset
		
		HashSet<String> hs = new HashSet<>();
		for(String e : a) {
			if(hs.add(e)== false) {
				System.out.println(e);
			}
		}
		
		System.out.println("**************************");
		//3.HashMap
		
		HashMap<String,Integer> hm = new HashMap<>();
		for(String e : a) {
			if(!hm.containsKey(e)) {
				hm.put(e,1);
			}
			else {
				int count = hm.get(e);
				hm.put(e, count+1);
			}
		}
		
		for(String e : hm.keySet()) {
			if(hm.get(e)>1) {
				System.out.println(e);
			}
		}
		System.out.println("**************************");
		
		//4.Streams
		
		//By Using Hashset and streams
		HashSet<String> hs1= new HashSet<>();
		
		Arrays.asList(a)
		.stream()
		.filter(e -> !hs1.add(e)).collect(Collectors.toSet())
		.forEach(e -> System.out.println(e));
		
		System.out.println("**************************");
		
		//By Using frequency and streams
		
		List<String> list = Arrays.asList(a);
		Set<String> eleList= list.stream()
		.filter(e -> Collections.frequency(list, e) > 1)
		.collect(Collectors.toSet());
		
		System.out.println(eleList);
	}

}
