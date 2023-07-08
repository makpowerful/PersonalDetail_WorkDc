package NAL_JavaQuestions;

public class _48_BinaryNumber {

	public static void isBinary(int a) {
		boolean val = true;
		int a1=a;
		while(a!=0) {
			int rem = a%10;
		if(rem>1) {
			val=false;
			break;
		}
		else {
			a=a/10;
		}
		}
		
		if(val) {
			System.out.println(a1+" is a binary number");
		}
		else {
			System.out.println(a1+" is not a binary number");
		}
		
	}
	
	public static void isBinary_reg(int a) {
		if(String.valueOf(a).matches("[0-1]+")) {
			System.out.println(a+" is a binary number");
		}
		else {
			System.out.println(a+" is not a binary number");
		}
	}
	
	public static void isBinary_parseint(int a) {
		try {
			Integer.parseInt(String.valueOf(a),2);
			System.out.println(a+" is a binary number");
		}
		catch(Exception e) {
			System.out.println(a+" is not a binary number");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isBinary(1011);
		isBinary(2011);
		isBinary(01);
		isBinary(0);
		System.out.println("****************************");
		isBinary_reg(1011);
		isBinary_reg(2011);
		isBinary_reg(01);
		isBinary_reg(0);
		System.out.println("****************************");
		isBinary_parseint(1011);
		isBinary_parseint(2011);
		isBinary_parseint(01);
		isBinary_parseint(0);
	}

}
