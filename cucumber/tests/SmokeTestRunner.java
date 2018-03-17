package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		glue = "cucumber.steps",
		tags = "@SmokeTests"
		)
public class SmokeTestRunner {

}
