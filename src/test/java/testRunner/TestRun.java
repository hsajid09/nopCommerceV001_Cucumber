package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=  ".\\Features\\Customer.feature",
		glue="stepDefinations",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", 
									"html:test-output"},
		tags= "@tag1"
		)
public class TestRun {
	
	

}
