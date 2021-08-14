package stepdefinition;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Tesstts {

	
	@Test
	public void addResource(){
		
		
		RequestSpecification res =RestAssured.given();
		
		
		String reqBody="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		
		res.baseUri("https://reqres.in/").body(reqBody);
		
	Response re=	res.post("/api/users");
	
	
	String response = re.asString();
	
	System.out.println(re.getStatusCode());
	
	System.out.println(re.asString());
	
	JsonPath js = new JsonPath(response);
	
	String idvalue= js.get("id");
	
	
	System.out.println(idvalue);
	
	ValidatableResponse result   =  re.then();
		
		
		
	}
}
