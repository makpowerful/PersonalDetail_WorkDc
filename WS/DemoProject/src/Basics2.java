import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload2;

public class Basics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload2.payload())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String placeid = js.getString("place_id");

		//put
		
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get
		given().queryParam("key", "qaclick123").queryParam("place_id",placeid).header("Content-Type","application/json")
		.when().get("maps/api/place/get/json").then().log().all().assertThat().body("name", equalTo("Frontline 21 house"));
	}
	
	

}
