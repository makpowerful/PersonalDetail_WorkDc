package NAL_JavaQuestions;

import java.util.Arrays;

public class _38_passwordStorageLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Password should not be stored as String as it will be immutable and will be
		// present in SCP can be accessed through memory dump

		String pass = "kalam";
		System.out.println("The password is: " + pass);

		char c[] = { 'k', 'a', 'l', 'a', 'm' };
		System.out.println("The password is: " + c);

		Arrays.fill(c, '*');

		for (char e : c) {
			System.out.print(e);
		}

	}

}
