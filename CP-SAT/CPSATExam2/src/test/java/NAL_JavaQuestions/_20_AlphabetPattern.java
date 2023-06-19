package NAL_JavaQuestions;

public class _20_AlphabetPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//A
	    //A B
	    //A B C
	    //A B C D
	    //A B C D E
		
		int count = 5;
		int c = 65;
		for(int i=0;i<count;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)(c+j)+" ");
			}
			System.out.println();
		}
		
		System.out.println("------------------------");
		
		
		
	}
	
	
	
}
