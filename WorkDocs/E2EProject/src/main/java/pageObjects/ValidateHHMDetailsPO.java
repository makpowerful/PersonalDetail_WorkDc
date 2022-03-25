package pageObjects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resources.base;

public class ValidateHHMDetailsPO extends base{
	
	
	
	
	
	public ValidateHHMDetailsPO() {
		// TODO Auto-generated constructor stub

	}
	
	
    public String validateHOHDetails(String indvId) throws FileNotFoundException, IOException, ParseException {
    	GenerateTokenPO gt = new GenerateTokenPO();
		RequestHandlerPO rh = new RequestHandlerPO();
		String auth = gt.getToken();
		RestAssured.baseURI = "https://portaltest15.maine.gov";
		String requestBody=rh.getBody("QualifiedIndividual");
		requestBody=rh.setIndvId(indvId);
		String response= given().header("Content-Type", "application/json").header("API","Prefill").header("Authorization",auth)
		.body(requestBody).when().post("services/msb/api/ios")
		.then().assertThat().statusCode(200).extract().response().asString();
		
//		JsonPath js = new JsonPath(response);
//		String value=js.getString("Payload.SSP_Member__c[0].FirstName__c");
//		System.out.println(value);
//		Assert.assertEquals(value, "AVIRAL");
		return response;
		
		
	}

	
    
}
