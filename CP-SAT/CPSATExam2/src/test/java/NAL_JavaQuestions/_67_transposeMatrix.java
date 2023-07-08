package NAL_JavaQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class _67_transposeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows = sc.nextInt();
		
		System.out.println("Enter the number of cols:");
		int cols = sc.nextInt();
		
		int[][] matrix = new int[rows][cols];
		int[][] transpose = new int[cols][rows];
		
		System.out.println("Enter data for the matrix:");
		//Adding data to matrix
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("The matrix data is:");
		
		for(int[] r: matrix) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println("*********************");
		
		//Transpose data from matrix
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				transpose[j][i]=matrix[i][j];
			}
		}
		
		System.out.println("The transpose data is:");
		
		for(int[] r: transpose) {
			System.out.println(Arrays.toString(r));
		}
		
	}

}
