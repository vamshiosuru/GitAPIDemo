package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Stepdefinition {

	@Given("^user is on netbanking landing page$")
	public void user_is_on_netbanking_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user is on netbanking landing page");
	}

	@When("^user logs in to  application with username \"([^\"]*)\"  password \"([^\"]*)\"$")
    public void user_logs_in_to_application_with_username_something_password_something(String strArg1, String strArg2) throws Throwable {
		System.out.println("user logs in to  application with username  "+strArg1);
		System.out.println("user logs in to  application with  password  "+strArg2);
		System.out.println("one-making changes from different machine");
		System.out.println("two-making changes from different machine");
		System.out.println("three-making changes from different machine");
		System.out.println("four-making changes from different machine");
		System.out.println("five-making changes from different machine");
		System.out.println("six-making changes from different machine");
		System.out.println("seven-making changes from different machine");
    }
	
	

	@Then("^homepage is populated$")
	public void homepage_is_populated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("homepage is populated");
		System.out.println("homepage is populated");
		System.out.println("homepage is populated");
	}

	@And("^cards are displayed$")
	public void cards_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("cards are displayed");
		System.out.println("cards are displayed");
		System.out.println("cards are displayed");
	}



}