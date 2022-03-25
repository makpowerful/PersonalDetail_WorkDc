import io.restassured.RestAssured;

import pojo.locationSub;
import pojo.mainaddPlace;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;



public class Basics3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		mainaddPlace ap= new mainaddPlace();
		
		locationSub l= new locationSub();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		ap.setAccuracy(50);
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress("29, side layout, cohen 09");
		
		List<String> typeval=new ArrayList<String>();
		typeval.add("shoe park");
		typeval.add("shop");
		ap.setTypes(typeval);
		
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-IN");
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(ap)
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println(response);
	
	
	}
}
