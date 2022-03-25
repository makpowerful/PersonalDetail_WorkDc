import static io.restassured.RestAssured.*;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.mainObject;

public class testOAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url= "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjHIMpKLE-LwPljuYjq5-KmB1aLm7oXxNyeoseDcq25j4C4GrX_hZ_rjjPCGdEt8g&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		
		String[] parseString=url.split("code=");
		String[] code=parseString[1].split("scope=");
		System.out.println(code[0]);
		
		String Token=given().queryParams("code", code[0]).urlEncodingEnabled(false)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().post("https://www.googleapis.com/oauth2/v4/token")
		.then().extract().response().asString();
		
		JsonPath js=new JsonPath(Token);
		String access_Token=js.get("access_token");
		
		 
		
		 mainObject gc=given().queryParam("access_token", access_Token).expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/getCourse.php").then().extract().response().as(mainObject.class);
		
		
		
		System.out.println(gc.getInstructor());
		
		//System.out.println(gc.getCourses().getWebAutomation().get(0).getCourseTitle());
		
		for(int i=0;i<gc.getCourses().getWebAutomation().size();i++) {
			
			System.out.println(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
		}
		

	}

}
