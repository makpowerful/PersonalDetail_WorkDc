package InterviewPractice;
import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the word to check for palindrome check: ");
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        String res ="";
        for(int i=c.length-1;i>=0;i--){
           res+=c[i]; 
        }
        if(s.equalsIgnoreCase(res)){
            System.out.println("It is a plaindrome");
        }
        else{
            System.out.println("Not a plaindrome");
        }
        
        //Using StringBuffer
        //StringBuffer sb = new StringBuffer(s);
        //String t = sb.reverse().toString();
        //if(s.equalsIgnoreCase(t)){
        //    System.out.println("It is a plaindrome");
        //}
        //else{
        //    System.out.println("Not a plaindrome");
        //}
	}

}
