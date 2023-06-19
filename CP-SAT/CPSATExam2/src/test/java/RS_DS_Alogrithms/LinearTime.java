package RS_DS_Alogrithms;

public class LinearTime {

    static int arr[] = {10, 324, 45, 90, 9808};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			largest();
		
	}
	
	 static int largest()
     {
         int i;
           
         // Initialize maximum element
         int max = arr[0];
        
         // Traverse array elements from second and
         // compare every element with current max  
         for (i = 1; i < arr.length; i++)  //O(n)
             if (arr[i] > max)
                 max = arr[i];
        
         return max;

}
	 
	 static  void printAll()  
	 {
		 
		 for(int i =0;i<arr.length;i++)
		 {
			 System.out.println(arr[i]);
		 }
	
	 }
	 
	 
	 
}
