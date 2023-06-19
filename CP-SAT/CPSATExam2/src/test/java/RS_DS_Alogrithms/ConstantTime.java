package RS_DS_Alogrithms;

public class ConstantTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		evenOrOdd(1200);
		
		checkItemNull(2);
		
	}
	
	private static boolean checkItemNull(int i) {
		// TODO Auto-generated method stub
		Object[] arr = {1,2,3,4,5,6};
		if (arr[i] == null)
		return true;
		return false;
		
	}

	public static void evenOrOdd(int num) //O(1)
	  {
	   

	    /* If number is divisible by 2 then it's an even number
	     * else odd number*/
	    if ( num % 2 == 0 )
	        System.out.println("Entered number is even");
	     else
	        System.out.println("Entered number is odd");
	  }

	
	
}
