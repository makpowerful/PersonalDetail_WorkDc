import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload2;

public class Addbookeg {
	
	@Test(dataProvider="Addbok")
	public void test_addbook(String isbn, String asile) {
		
		RestAssured.baseURI= "http://216.10.245.166";
		String response=given().header("content-type","application/json").body(payload2.Library(isbn,asile))
		.when().post("Library/Addbook.php").then().log().all().assertThat()
		.statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath js=ReUsableMethods.rawToJson(response);
		String val=js.getString("ID");
		System.out.println(val);
		
	}
	
	@DataProvider(name="Addbok")
	public Object[][] getData() {
		
		return new Object[][] { {"bc2","2sd39s41"}, {"bc3","2sd39s51"}, {"bc4","2sd39s11"} };
		
	}
	
}
