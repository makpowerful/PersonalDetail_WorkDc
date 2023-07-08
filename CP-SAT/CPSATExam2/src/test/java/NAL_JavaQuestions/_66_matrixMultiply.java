package NAL_JavaQuestions;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.Arrays;
import java.util.Scanner;

public class _66_matrixMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows fro 1st matrix:");
		int rowsfor1stmatrix = sc.nextInt();

		System.out.println("Enter the number of columns for 1st matrix and rows for 2nd matrix:");
		int colsfor1stmatriand2ndmatrixrow = sc.nextInt();

		System.out.println("Enter the number of columns for 2nd matrix:");
		int colsfor2ndmatrix = sc.nextInt();

		int[][] matrix1 = new int[rowsfor1stmatrix][colsfor1stmatriand2ndmatrixrow];
		int[][] matrix2 = new int[colsfor1stmatriand2ndmatrixrow][colsfor2ndmatrix];
		int[][] Multiply = new int[rowsfor1stmatrix][colsfor2ndmatrix];

		System.out.println("Enter the data in matrix1:");
		for (int i = 0; i < rowsfor1stmatrix; i++) {
			for (int j = 0; j < colsfor1stmatriand2ndmatrixrow; j++) {
				matrix1[i][j] = sc.nextInt();
			}
		}

		System.out.println("Enter the data in matrix2:");
		for (int i = 0; i < colsfor1stmatriand2ndmatrixrow; i++) {
			for (int j = 0; j < colsfor2ndmatrix; j++) {
				matrix2[i][j] = sc.nextInt();
			}
		}

		// printing the matrix using for Arrays built in
		System.out.println("Matrix1 data:");
		for (int r[] : matrix1) {
			System.out.println(Arrays.toString(r));
		}

		System.out.println("*************************");

		System.out.println("Matrix2 data:");
		for (int r[] : matrix2) {
			System.out.println(Arrays.toString(r));
		}

		System.out.println("*************************");
		System.out.println("Product of numbers is:");
		for (int i = 0; i < rowsfor1stmatrix; i++) {
			for (int j = 0; j < colsfor2ndmatrix; j++) {
				for (int k = 0; k < colsfor1stmatriand2ndmatrixrow; k++) {
					Multiply[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		
		for(int[] r: Multiply) {
			System.out.println(Arrays.toString(r));
		}
	}

}
