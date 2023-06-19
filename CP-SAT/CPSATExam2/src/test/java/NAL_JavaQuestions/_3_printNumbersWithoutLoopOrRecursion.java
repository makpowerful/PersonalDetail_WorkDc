package NAL_JavaQuestions;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.*;

public class _3_printNumbersWithoutLoopOrRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Print from 1 to 100 without loop or recursion
		
		//1. Arrays.fill
		Object[] b = new Object[100];
		Arrays.fill(b, new Object() {
			int count = 0;

			@Override
			public String toString() {
				return Integer.toString(++count);
			}
		});
		System.out.println(Arrays.toString(b));
		
		System.out.println();
		
		//bitset Approach
		String s = new BitSet() {{set(1,101);}}.toString();
		System.out.append(s, 1, s.length());
	}

}
