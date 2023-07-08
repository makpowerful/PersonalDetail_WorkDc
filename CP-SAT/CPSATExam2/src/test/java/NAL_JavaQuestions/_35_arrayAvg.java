package NAL_JavaQuestions;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class _35_arrayAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,3};
		
		//for loop
		int total = 0;
		for(int e : a) {
			total = total + e;
		}
		System.out.println(total/a.length);
		
		//Streams
		OptionalDouble d = IntStream.of(a).average();
		System.out.println(d);
		
	}

}
