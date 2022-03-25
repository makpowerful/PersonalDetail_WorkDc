package test;

public class Sample10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,2,6,4},{1,2,3,5},{2,3,5,0}};
		int k=a[0][0];
		int l=0;
		int i,max=0;
		
		for( i=0;i<3;i++) {
			
			for(int j=0;j<4;j++) {
				if(a[i][j]<k) {
					k=a[i][j];
					l=j;
					}
				}
				
			}
		
		int o=a[0][l];
		int t=0;
		while(t<3){
			
			if(a[t][l]>o) {
				max=a[t][l];
			}
			t++;
		}
		System.out.println(max);

	}

}
