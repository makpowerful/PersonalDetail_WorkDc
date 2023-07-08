package NAL_JavaQuestions;

import java.util.Arrays;

public class _40_shiftZeroProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,4,0,8,4,9,0,1,0,5,6};
		
		//brute force
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i]>=a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		
		//Through diff Logic
		System.out.println(Arrays.toString(moveElement(a)));

	}
	
	public static int[] moveElement(int a[]) {
		if(a.length == 1) {
			return a ;
		}
		
		int count =0;
		int k[]= new int[a.length];
		for(int n : a) {
			if(n!=0) {
				k[count++]=n;
			}
		}
		
		return k;
	}
	

}
