package NAL_JavaQuestions;
import java.util.*;

public class _29_MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//formula n(n+1)/2 then subtract from sum of given array
		int a[] = {1,2,3,5};
		int val = MissingNo(a,5);
		System.out.println(val);
	}
	
	public static int MissingNo(int a[],int totalCount) {
		int num = (totalCount)*(totalCount+1)/2;
		int actualsum =0;
		for(int e : a) {
			actualsum+=e;
		}
		return num-actualsum;
	}

}
