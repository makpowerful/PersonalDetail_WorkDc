package NAL_JavaQuestions;

public class _19_starPatterns3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//      *
	    //     * *
	    //    * * *
	    //   * * * *
	    //  * * * * *
		
		int count = 5;
		
		for(int i=0;i<count;i++) {
			for(int k=count;k>=i;k--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		
		System.out.println("------------------------");
		
		
		
	}
	
	
	
}
