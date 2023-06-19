package RS_DS_Alogrithms;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {4,1,2,13,9,7,3};
		int temp;
		
		for(int i =0;i<arr.length;i++) //n -
		{
			
			for(int j =1; j<arr.length-i;j++)//n
			{
				//swap
				if(arr[j] < arr[j-1])
				{
					temp = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
					
					//swap
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}

}
