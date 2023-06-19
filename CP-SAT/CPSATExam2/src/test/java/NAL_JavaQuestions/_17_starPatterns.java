package NAL_JavaQuestions;

public class _17_starPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//*
		//**
		//***
		//****
		//*****
		
		int count = 5;
		for(int i=0;i<count;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------------------");
		//*****
		//****
		//***
		//**
		//*
		for(int i=0;i<=count;i++) {
			for(int j=i;j<count;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------------------");

		//*
		//**
		//***
		//****
		//*****
		//****
		//***
		//**
		//*
		for(int i=0;i<count;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<=count;i++) {
			for(int j=count-1;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------");
	}
	
	
	
}
