package InterviewPractice;

public class NumberCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("The Identified combinations are: ");
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[i]+a[j]==10){
                    System.out.println(a[i]+" & "+a[j]);
                }
            }
        }
	}

}
