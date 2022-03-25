package test;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a number:");
		int i=sc.nextInt();
		System.out.println("Enter one more number:");
		int o=sc.nextInt();
		int m= i+o;
		System.out.println("The sum is:" +m);
	}

}
