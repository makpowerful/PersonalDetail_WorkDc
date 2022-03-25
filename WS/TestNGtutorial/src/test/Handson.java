package test;

import java.util.Scanner;

public class Handson {
	
	public static void main(String[] args){
	
	Scanner s =new Scanner(System.in);
	System.out.println("Enter the rows of pyramid: ");
	int a=s.nextInt();
		
	for(int i=a;i>=1;--i) 
	{
		for(int j=1;j<=i;++j) {
			System.out.println(j+"* ");
		}
	}
	System.out.println();
	}
	

}
