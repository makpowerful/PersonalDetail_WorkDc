package NAL_JavaQuestions;
import java.util.stream.*;
import java.util.*;

public class _30_findLengthwithoutmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "kalam";
		
		//Using toCharArray
		System.out.println(s.toCharArray().length); //-> here length is not a method
		
		//Using Split
		System.out.println(s.split("").length); //-> here length is not a method
		
		//Using for loop
		char ch[] = s.toCharArray();
		int count=0;
		for(char c : ch) {
			count++;
		}
		System.out.println(count);
		
		//Using Streams
		long a = s.chars().count();
		System.out.println(a);
	}

}
