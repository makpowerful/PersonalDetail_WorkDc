package NAL_JavaQuestions;

public class _23_AlphabetPattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A
		// B B
		// C C C
		// D D D D
		// E E E E E

		int count = 5;
		char c = 65;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (c) + " ");
			}
			c++;
			System.out.println();

		}
	}
}
