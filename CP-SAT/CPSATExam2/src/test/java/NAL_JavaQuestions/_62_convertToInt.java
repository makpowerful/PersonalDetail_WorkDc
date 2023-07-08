package NAL_JavaQuestions;

public class _62_convertToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "123";
	System.out.println(convert2Int(string)+10);
	String string1 = "1";
	System.out.println(convert2Int(string1)+10);
	}
	
	public static int convert2Int(String s) {
		if(s.length()==1) {
			int val1=(int)s.charAt(0) - 48;
			return val1;
		}
		
		int sum=0;
		for(int i=0;i<s.length();i++) {
			int val=(int)s.charAt(i) - 48;
			sum=sum*10+val;
		}
		return sum;
	}

}
