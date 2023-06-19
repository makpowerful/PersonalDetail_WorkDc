package RS_DS_Alogrithms;

public class Recursion_1 {
	
	static int[] arr = {12,2,30,13,5};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//
		
		int value =SumofDigits(arr.length-1);
		System.out.println(value);
		int fact_value = Fact(4);
		System.out.println(fact_value);
		int fib_value =Fib(7);
		System.out.println(fib_value);
		
	}

	private static int Fib(int n) {
		// TODO Auto-generated method stub
		if(n == 0 || n ==1)
		return n;
		
		return Fib(n-1) + Fib(n-2);
		
	}

	private static int Fact(int n) {
		// TODO Auto-generated method stub
		if (n ==1)
		{
			return 1;
		}
		 return n * Fact(n-1);
	}

	private static int SumofDigits(int n) {
		// TODO Auto-generated method stub
		
		if(n==0)
			return arr[n];
		
		return arr[n] + SumofDigits(n-1);
		
	}
		
		
		
		
		
	}

