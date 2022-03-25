package test;

public class Sample12 extends Sample11 {
    int b = 5;
	public void getdata() {
		int a=11;
		int b=3;
		System.out.println(a+", "+b);
		super.getdata();
		System.out.println(super.b);
		System.out.println(this.b);
	}
	 
	Sample12(){
		System.out.println("Test");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample12 s=new Sample12();
		s.getdata();
		Sample12 t=new Sample12();

	}

}
