package NAL_JavaQuestions;

public class _61_leaderElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={92,7,12,9,8,3};
		findLeaderEle(a);
		System.out.println();
		int[] a1={92,7,12,9,8,14};
		findLeaderEle(a1);
		}
	
	public static void findLeaderEle(int[] a) {
		int max= a[a.length-1];
		System.out.print(max);
		
		for(int i=a.length-2;i>=0;i--) {
			if (a[i]>max) {
				System.out.print(" ,"+a[i]);
				max=a[i];
			}
		}
	}

}
