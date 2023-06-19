package InterviewPractice;
import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);
	        System.out.println("Enter the number to check if prime: ");
	        int a = sc.nextInt();
	        boolean flag = false;
	        for(int i=2;i<a/2;i++){
	            if(a%i==0){
	                flag = true;
	                break;
	            }
	        }
	        
	        if(flag){
	            System.out.println("It is not a prime number");
	        }
	        else{
	            System.out.println("It is a prime number");
	        }
	}

}
