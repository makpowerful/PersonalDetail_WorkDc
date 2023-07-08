package NAL_JavaQuestions;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _51_maxWordCountInFile {
	
	static String path = System.getProperty("user.dir")+"\\Resource\\TextFile";
			//"C:\\Users\\Tnluser.5CG144BY5B\\OneDrive\\Desktop\\PersonalDetail_WorkDc\\CP-SAT\\CPSATExam2\\Resource\\TextFile";
			
			//
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 HashMap<String,Integer> hm = new HashMap<>();
		BufferedReader reader = null;
				
			reader=	new BufferedReader(new FileReader(path));
			String s = reader.readLine();
			while(s!=null) {
				String words[]=s.toLowerCase().split(" ");
				for(String word: words ) {
					if(!word.isBlank()) {
					if(!hm.containsKey(word)) {
						hm.put(word, 1);
					}
					else {
						hm.put(word, hm.get(word)+1);
					}
				}
					
				}
				s = reader.readLine();
				
				
			}
			hm.forEach((k,v) -> System.out.println(k+" : "+v));
			
			HashMap<String,Integer> maxmap = new HashMap<>();
			
			hm.entrySet().stream().filter(e -> e.getValue() == Collections.max(hm.values()))
			.forEach(e -> System.out.println(e));
	}

}
