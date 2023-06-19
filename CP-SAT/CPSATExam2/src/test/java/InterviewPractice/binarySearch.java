package InterviewPractice;

import java.util.*;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[] = {33,7,99,0,31,77,54};
	        Arrays.sort(a);
	        System.out.println(Arrays.toString(a));
	        int b = binarySearch(a,54);
	        System.out.println("Index value is : "+b);
	}
	
	 public static int binarySearch(int a[],int key){
	        int l = 0;
	        int r = a.length-1;
	        while(l<=r){
	            int mid = (l+r)/2;
	            if(a[mid]==key){
	                return mid;
	            }
	            else if(a[l]<key){
	                l++;
	            }
	            else if(a[r]>key){
	                r--;
	            }
	        }
	        return -1;
	    }

}
