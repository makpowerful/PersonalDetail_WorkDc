package test;

import java.util.Scanner;

public class Sample3 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number:");
		int a=s.nextInt();
		if(a<=10)
		{
			System.out.println("The entered value is less than 10");
		}
		else if(a<=20){
			System.out.println("The entered value is greater than 10 but less than 20");
			
		}
		else if(a<=30) {
			System.out.println("The entered value is greater than 20 but less than 30");
		}
		
		
	}
}
