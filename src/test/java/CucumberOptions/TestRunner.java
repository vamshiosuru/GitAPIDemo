package CucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/java/features" 
 ,glue={"stepDefinition"}
 )    //  example: Features: src/test/resources/features, Glue: com.package.name.stepdefs

public class TestRunner {

}