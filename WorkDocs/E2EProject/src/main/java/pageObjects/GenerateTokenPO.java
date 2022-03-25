package pageObjects;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GenerateTokenPO {

	public String getToken() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://login.microsoftonline.com";
		String response= given().formParam("client_id", "99002e99-6e30-4ace-a18d-fb4fcb0bff84")
		.formParam("client_secret", "gx37Q~BCaf-zri30RTp35rF43GpnRTz3ub596")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "api://8d0cf66d-9e18-4519-9df4-d95af699abc2/.default")
		.when().post("413fa8ab-207d-4b62-9bcd-ea1a8f2f864e/oauth2/v2.0/token")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String token=js.getString("access_token");
//		System.out.println(token);
		return token;

	}

}
