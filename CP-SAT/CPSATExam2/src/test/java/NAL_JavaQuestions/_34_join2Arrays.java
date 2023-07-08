package NAL_JavaQuestions;

import java.util.Arrays;
import java.util.stream.Stream;

import com.google.common.collect.ObjectArrays;

public class _34_join2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = {"Rohit","Virat","Hardik"};
		String b[] = {"Sharma","Kohli","Pandya"};
		
		//for loop
		String c[] = new String[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length) {
			c[k++]=a[i++];
		}
		while(j<b.length) {
			c[k++]=b[j++];
		}
		System.out.println(Arrays.toString(c));
		
		System.out.println("*********************");
		
		//Streams
		Stream<String> sa= Arrays.stream(a);
		Stream<String> sb= Arrays.stream(b);
		
		String full[] = Stream.concat(sa, sb).toArray(size -> new String[size]);
		System.out.println(Arrays.toString(full));
		
		System.out.println("*********************");
		
		//Guava
		
		String full2[] = ObjectArrays.concat(a, b,String.class);
		System.out.println(Arrays.toString(full2));
	}

}
