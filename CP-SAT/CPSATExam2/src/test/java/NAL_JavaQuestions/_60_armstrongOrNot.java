package NAL_JavaQuestions;

public class _60_armstrongOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(isArmstrong(153));
	System.out.println(isArmstrong(9474));
	System.out.println(isArmstrong(54748));
	System.out.println(isArmstrong(-1));
	}
	
	public static boolean isArmstrong(int num) {
		int copynum = num;
		if(num<0) {
			return false;
		}
		
		int power = grabPower(num);
		int sum =0;
		while(num!=0) {
			int lastnum = num %10;
			int times =1;
			for(int i=0;i<power;i++) {
				times= times*lastnum;
			}
			sum=sum+times;
			num=num/10;
		}
		//System.out.println(sum);
		//System.out.println(num);
		
		if(sum == copynum) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public static int grabPower(int num) {
		int n = 0;
		while(num!=0) {
			n++;
			num=num/10;
		}
		return n;
	}

}
