package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@calculator",
		features = "src/test/resources/Features", 
		glue = {"stepDefinitions", "hooks", "utilities"},
		monochrome = true
	)

public class RunTest {
	
}
