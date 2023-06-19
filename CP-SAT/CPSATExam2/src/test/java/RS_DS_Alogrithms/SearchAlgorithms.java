package RS_DS_Alogrithms;

public class SearchAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,4,6,9,12,13,14,15,17};
		//O(1)  O(n)   O(n)
		System.out.println(LinearSearch(arr,13));
		//Goal - pass the input //output the index
		System.out.println(binarySearch(arr,13));
		System.out.println(jumpSearch(arr,13));
		//O(logn)
		
		System.out.println(binarySearchRecursion(arr,13,0,arr.length-1));
		
				
	}
	
	public static int LinearSearch(int[] arr, int target)
	{
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i] == target)
				return i;
		}
		return -1;
		
	}
	

	public static int binarySearch(int[] arr , int target)
	{
		
		int left = 0, right = arr.length-1; int middle;
		while(left<=right)
		{
			middle = (left+ right)/2;
			if(arr[middle] == target)
				return middle;
			
			 if (arr[middle]> target)
				right = middle-1;
			else 
				left = middle + 1;
			}
		return -1;
	}
	
	public static int binarySearchRecursion(int[] arr ,int target,int left,int right)
	{
			if (right < left)	
			return -1;
			int middle = (left+ right)/2;
			
			if(arr[middle] == target)
				return middle;
			
			 if (arr[middle]> target)
			 {
				right = middle-1;
			 return binarySearchRecursion(arr,target,left,right);
			 }
			 	
			else 
			{
				left = middle + 1;
				return binarySearchRecursion(arr,target,left,right);
			}
			 
			
	
	}
	
	public static int jumpSearch(int[] arr,int target)
	{
		int blocksize = (int) Math.sqrt(arr.length);
		System.out.println(blocksize);
		int start = 0;
		int last = blocksize - 1;
		while(arr[last]<target && start <arr.length)
		{
			start = last + 1;
			last = last + blocksize;
			if(last>arr.length-1)
				last = arr.length-1;
		}
		for(int i =start;i<=last;i++)
		{
			if(arr[i] == target)
				return i;
		}
		return -1;
	}


	
	
}
