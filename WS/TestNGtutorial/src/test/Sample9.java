package test;

public class Sample9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = {{1,2,6,4},{1,2,3,4},{2,3,5,0}};
		int k=a[0][0];
		for(int i=0;i<3;i++) {
			
			for(int j=0;j<4;j++) {
				if(a[i][j]>k) {
					k=a[i][j];
					
				}
				
			}
		}
		System.out.println(k);

	}

}
