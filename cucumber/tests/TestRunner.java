package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		glue = "cucumber.steps",
		tags = { "@SmokeTests" },
		format = { "html:reports", "json:reports/cucumberResults.json" }
		)
public class TestRunner {

}

// True: "@SmokeTests"
// NOT: "~@SmokeTests"
// AND: { "@Login" , "~@Ignore" }
// OR: { "@SmokeTests, @CurrentTest" }
// COMPLEX: { "@AccountManagement", "@SmokeTests, @RegressionTest, @CurrentTest }