package InterviewPractice;

import java.util.*;

public class Fibanocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);
	        System.out.println("Enter the number to generate fibanocci series: ");
	        int count = sc.nextInt();
	        int a =0;
	        int b= 1;
	        int sum = 0;
	        for(int i=0;i<count;i++){
	            sum = a+b;
	            a = b;
	            b = sum;
	            System.out.print(sum);
	}
	}
}
