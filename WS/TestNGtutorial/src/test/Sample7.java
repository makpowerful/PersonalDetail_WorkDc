package test;

public class Sample7 implements Interface1{

	public static void main(String[] args) {
		//int k=1;
		for(int i=1;i<5;i++) {
			//System.out.print(k);
			
			for(int j=1;j<=i;j++) {
							
				System.out.print(j*3);
				
				System.out.print("\t");
			//	System.out.print(k+i);
			}
			
			System.out.println("");
			Sample7 t=new Sample7();
			t.Test1();
			t.Test2();
			
		}
		
	}

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		System.out.println("Test1");
	}

	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		
	}
}
