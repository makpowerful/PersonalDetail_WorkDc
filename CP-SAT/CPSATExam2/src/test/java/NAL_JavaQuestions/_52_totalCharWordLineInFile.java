package NAL_JavaQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class _52_totalCharWordLineInFile {

	static String path = System.getProperty("user.dir")+"\\Resource\\TextFile";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hmchar = new HashMap<>();
		HashMap<String, Integer> hmstring = new HashMap<>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String currentLine = reader.readLine();
		int count=0;
		while(currentLine!= null) {
			//System.out.println("In loop");
			String words[] = currentLine.toLowerCase().split(" ");
			char[] c = currentLine.toCharArray();
			if(!currentLine.isBlank()) {
			for(String word:words) {
				if(!hmstring.containsKey(word)) {
					hmstring.put(word, 1);
				}
				else {
					hmstring.put(word, hmstring.get(word)+1);
				}
			}
			for(char ch:c) {
				if(!hmchar.containsKey(ch)) {
					hmchar.put(ch, 1);
				}
				else {
					hmchar.put(ch, hmchar.get(ch)+1);
				}
			}
			}
			currentLine=reader.readLine();
			count++;
		}
		reader.close();
		hmstring.forEach((k,v) -> System.out.println(k+" : "+v));
		
		System.out.println("***************");
		
		for(char c : hmchar.keySet()) {
			System.out.print(c);
			System.out.print(hmchar.get(c));
		}
		System.out.println();
		System.out.println("***************");
		System.out.println(count);
		
		System.out.println("***************");
		
		int sum =0;
		for(String c : hmstring.keySet()) {
			sum = sum+ hmstring.get(c);
			//System.out.print();
		}
		System.out.println(sum);
		System.out.println("***************");
		
		int sum1 =0;
		for(char c : hmchar.keySet()) {
			sum1 = sum1+ hmchar.get(c);
			//System.out.print();
		}
		System.out.println(sum1);
	}

}
