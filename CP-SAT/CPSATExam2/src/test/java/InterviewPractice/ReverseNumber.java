package InterviewPractice;
import java.util.*;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number to be reveresed: ");
        int a = sc.nextInt();
        int res = 0;
        while(a!=0){
            int b =a%10;
           res = res*10+b;
           a=a/10; 
        }
        System.out.print(res);
	}

}
