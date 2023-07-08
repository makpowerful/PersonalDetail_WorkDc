package NAL_JavaQuestions;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.Arrays;
import java.util.Scanner;

public class _65_matrixSumSubtract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of rows:");
		int rows = sc.nextInt();
		
		System.out.println("Enter the number of columns:");
		int cols = sc.nextInt();
		
		
		int[][] matrix1 = new int[rows][cols];
		int[][] matrix2 = new int[rows][cols];
		int[][] sum = new int[rows][cols];
		
		System.out.println("Enter the data in matrix1:");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix1[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the data in matrix2:");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix2[i][j] = sc.nextInt();
			}
		}
		
		
		//printing the matrix using for Arrays built in
		System.out.println("Matrix1 data:");
		for(int r[] : matrix1) {
		System.out.println(Arrays.toString(r));
		}
		
		System.out.println("*************************");
		
		System.out.println("Matrix2 data:");
		for(int r[] : matrix2) {
		System.out.println(Arrays.toString(r));
		}
		
		System.out.println("*************************");
		System.out.println("Addition of numbers is:");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				sum[i][j] = matrix1[i][j]+matrix2[i][j];
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("*************************");
		System.out.println("Subtraction of numbers is:");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				sum[i][j] = matrix1[i][j]-matrix2[i][j];
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
	}

}
