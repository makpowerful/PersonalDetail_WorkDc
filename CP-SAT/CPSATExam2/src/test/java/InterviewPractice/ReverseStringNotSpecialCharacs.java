package InterviewPractice;

public class ReverseStringNotSpecialCharacs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       String a = "S#l@es%*a";
	        char[] c = a.toCharArray();
	        revString(c);
	        System.out.print(c);
	}
	
	 public static void revString(char[] c){
	        int l = 0;
	        int r = c.length-1;
	        while(l<r){
	            if(!Character.isAlphabetic(c[l])){
	                l++;
	            }
	            else if(!Character.isAlphabetic(c[r])){
	               r--; 
	            }
	            else{
	               char temp;
	               temp = c[l];
	               c[l] = c[r];
	               c[r] = temp;
	               l++;
	               r--;
	            }
	        }
	    }

}
