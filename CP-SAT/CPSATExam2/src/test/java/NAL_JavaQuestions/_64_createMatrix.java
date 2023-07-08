package NAL_JavaQuestions;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.Arrays;
import java.util.Scanner;

public class _64_createMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of rows:");
		int rows = sc.nextInt();
		
		System.out.println("Enter the number of columns:");
		int cols = sc.nextInt();
		
		System.out.println("Enter the data in matrix:");
		int[][] data = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i][j] = sc.nextInt();
			}
		}
		
		//printing the matrix using for loop
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(data[i][j]+" ");		
			}
			System.out.println();
		}
		System.out.println("*************************");
		
		//printing the matrix using foreach loop
		for(int r[] : data) {
			for(int k : r) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		System.out.println("*************************");
		
		//printing the matrix using for Arrays built in
		for(int r[] : data) {
		System.out.println(Arrays.toString(r));
		}
		
		System.out.println("*************************");
		
		System.out.println(Arrays.deepToString(data));
		
		System.out.println("*************************");
		
		//printing the matrix using Streams
		Arrays.stream(data).forEach( e -> {
			Arrays.stream(e).forEach(j -> System.out.print(j+" "));
			System.out.println();
		});
	}

}
