package RS_DS_Alogrithms;
import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {4,1,2,7,9,3};
		int temp;
		int minIndex;
		
		for(int i =0; i< arr.length;i++)  //n
		{
		minIndex = i;
			for(int j=i;j<arr.length;j++) //n
			{
				if(arr[j]<arr[minIndex])
				{
					temp =arr[minIndex];
					arr[minIndex] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));

}
}