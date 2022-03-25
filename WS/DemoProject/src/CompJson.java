import java.util.ArrayList;

import files.payload2;
import io.restassured.path.json.JsonPath;

public class CompJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(payload2.complxjson());
		
		//1. Print No of courses returned by API
		int count =  js.getInt("courses.size()");
		System.out.println("The  no  of courses are: "+count);
		//2.Print Purchase Amount
		int count2 =  js.getInt("dashboard.purchaseAmount");
		System.out.println("The purchase amount is: "+count2);
		//3. Print Title of the first course
		String title =  js.getString("courses[0].title");
		System.out.println("The purchase amount is: "+title);
		//4. Print All course titles and their respective Prices
		//ArrayList<String> list=new ArrayList();
		//list= js.getString("courses.title");
		for(int i=0;i<count;i++) {
			String title1= js.get("courses["+i+"].title");
			System.out.println(title1);
			int price1= js.getInt("courses["+i+"].price");
			System.out.println(price1);
		}

		//5. Print no of copies sold by RPA Course
		for(int m=0;m<count;m++) {
			
			String title2=js.get("courses["+m+"].title");
			if(title2.equalsIgnoreCase("RPA")) {
				
				int copies= js.getInt("courses["+m+"].copies");
				System.out.println("The number of copies sold of RPA are: "+copies);
			}
			
		}
		

		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum2=0;
		for(int n=0;n<count;n++) {
			
			int price=js.get("courses["+n+"].price");
			int copy=js.get("courses["+n+"].copies");
			int sum = price*copy;
			System.out.println(sum);
			sum2=sum +sum2;
			System.out.println(sum2);
			
			
		}
		
		

	}

}
