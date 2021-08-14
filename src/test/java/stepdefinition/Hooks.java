package stepdefinition;

import cucumber.api.java.Before;

public class Hooks {

	
	
	@Before("@deletePlace")
	public void beforescenario() throws Throwable
	{
		StepDefinition s=new StepDefinition();
		if(s.placeid==null)
		{
			s.add_place_payload_with("Hooks name", "hooks language","hooks address");
			s.user_hits_API_payload_with_http_request("Addplace", "POST");
			s.verify_place_id_created_mapping_to_using("Hooks name", "GetPlace");
		}
	}
}
