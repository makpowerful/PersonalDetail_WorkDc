package NAL_JavaQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class _52_totalCharWordLineInFile_Approach2 {

	static String path = System.getProperty("user.dir")+"\\Resource\\TextFile";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int lineCount =0;
		int wordCount = 0;
		int charCount =0;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String currentLine = reader.readLine();
		
		while(currentLine!=null) {
			lineCount++;
			
			//words:
			String[] words = currentLine.split(" ");
			wordCount = wordCount+ words.length;
			
			//char:
			for(String word: words) {
				charCount= charCount+word.length();
			}
			currentLine = reader.readLine();
		}
		
		System.out.println("Line count :"+lineCount);
		System.out.println("Word count :"+wordCount);
		System.out.println("Char count :"+charCount);
	}
}
