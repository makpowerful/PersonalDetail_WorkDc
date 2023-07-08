package NAL_JavaQuestions;

public class _68_maxnMinForPosiveNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findMaxNumber(10,20,30);
		findMinNumber(10,20,30);

	}
	
	public static void findMaxNumber(int a,int b,int c) {
		int max =0;
		while(a>0 ||b>0 ||c>0) {
			a--;
			b--;
			c--;
			max++;
		}
		System.out.println(max);
	}
	
	public static void findMinNumber(int a,int b,int c) {
		int min =0;
		while(a>0 &&b>0 &&c>0) {
			a--;
			b--;
			c--;
			min++;
		}
		System.out.println(min);
	}

}
