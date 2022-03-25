package pageObjects;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RequestHandlerPO {
	public String getBody(String payloadName) throws FileNotFoundException, IOException, ParseException {
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\kmotwani\\eclipse-workspace\\RestHandson\\payload.json"));
	JSONObject jsonObject = (JSONObject)obj;
	String requestBody = (String)jsonObject.get(payloadName).toString();
//    System.out.println(requestBody);
	return requestBody;
	
	}
	
	public String setIndvId(String indvId) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\kmotwani\\eclipse-workspace\\RestHandson\\payload.json"));
		JSONObject jsonObject = (JSONObject)obj;
		JSONObject json=(JSONObject)jsonObject.get("QualifiedIndividual");
		json.replace("primaryApplicationIndividualId", indvId);
		String value = (String)json.get("primaryApplicationIndividualId").toString();
		String body=(String)jsonObject.get("QualifiedIndividual").toString();
//		System.out.println(value);
//		System.out.println(body);
		return body;
		
	}

}
