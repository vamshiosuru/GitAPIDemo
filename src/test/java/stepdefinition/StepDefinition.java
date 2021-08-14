package stepdefinition;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.* ;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplacepojo;
import pojo.Locationpojo;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {
	RequestSpecification res;

	ResponseSpecification  resSpec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	
	static String placeid;
	//if we dont add static keyword for placeid , for next scenario it would be null and with static , place id value will be same for all test scenarios
	
	

	@Given("^Add place payload with \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_place_payload_with(String name, String language, String address) throws Throwable {
		res=given().spec(requestSpecification())
				.body(data.addplacepayload(name,language,address)) ;
	}
	
	@When("^user hits \"([^\"]*)\" API payload with \"([^\"]*)\" http request$")
	public void user_hits_API_payload_with_http_request(String arg1, String arg2) throws Throwable {
		//constructor will be called with value of resource we passed 
		
		APIresources api=APIresources.valueOf(arg1);
		
		if(arg2.equalsIgnoreCase("POST") || arg2.equalsIgnoreCase("DELETE") ||arg2.equalsIgnoreCase("UPDATE"))
		{
			response=res.when().post(api.getResource());
		}
		else if(arg2.equalsIgnoreCase("GET"))
		{
			response=res.when().get(api.getResource());
		}
		

	}


	@Then("^API call is success with http status code (\\d+)$")
	public void api_call_is_success_with_http_status_code(int arg1) throws Throwable {
		resSpec=new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(200).build();

		//.then().log().all().spec(resSpec).extract().response();
			response.then().spec(resSpec).extract().response();
	   assertEquals(response.getStatusCode(),arg1);
	}

@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
public void in_response_body_is(String arg1, String arg2) throws Throwable {
	/*String resp=response.asString();
	JsonPath js=new JsonPath(resp);
	 assertEquals(js.getString(arg1),arg2);*/
	 assertEquals(getResponseelement(response,arg1),arg2);
}

@Then("^verify place_id created mapping to \"([^\"]*)\" using  \"([^\"]*)\"$")
public void verify_place_id_created_mapping_to_using(String expectedname, String resourcename) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	placeid=getResponseelement(response,"place_id");
	res=given().spec(requestSpecification()).queryParam("place_id", placeid);
	
	user_hits_API_payload_with_http_request(resourcename,"GET");
	/*APIresources api=APIresources.valueOf(arg2);
	response=res.when().get(api.getResource());*/
	System.out.println(getResponseelement(response,"name"));
	String actualname=getResponseelement(response,"name");
	 assertEquals(actualname,expectedname);
}

@Given("^deleteplacepayload$")
public void deleteplacepayload() throws Throwable {
	/*res=given().spec(requestSpecification())
			.body(data.deleteplacepayload(placeid)) ;*/
	res=given().spec(requestSpecification())
			.body("{\r\n" + 
					"\"place_id\":\""+placeid+"\"\r\n" + 
					"\r\n" + 
					"}") ;
}



	

	

}
