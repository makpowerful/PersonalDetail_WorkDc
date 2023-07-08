package NAL_JavaQuestions;

public class _47_phoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//To check for credit card num just replace 10 with 16
		validNum("123a");
	System.out.println(validPN("1234567890"));	
	System.out.println(validPN("345678a78"));
	System.out.println("***********************");
	System.out.println(reg_validPN("1234567890"));	
	System.out.println(reg_validPN("345678a78"));
	System.out.println("***********************");
	System.out.println(reg2_validPN("1234567890"));	
	System.out.println(reg2_validPN("345678a78"));
	}

	public static boolean validNum(String a) {
		try {
		Long.parseLong(a);
		System.out.println("Is a valid number");
		}
		catch(NumberFormatException e) {
			System.out.println("Is not a valid number");
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean validPN(String a) {
		if(a.length()==10 && validNum(a)) {
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public static boolean reg_validPN(String a) {
		return a.matches("[0-9]{10}");
	}
	public static boolean reg2_validPN(String a) {
		return a.matches("\\d{10}");
	}
}
