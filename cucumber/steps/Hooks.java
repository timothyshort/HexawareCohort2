package cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void before(Scenario s) {
		System.out.println("*****");
		System.out.println("STARTING SCENARIO: " + s.getName());
		System.out.println("*****");
	}
	
	@After
	public void after() {
		System.out.println("*****");
		System.out.println("ENDING SCENARIO");
		System.out.println("*****");
	}
	
	@After
	public void afterEval(Scenario s) {
		if(s.isFailed()) {
			System.out.println("This scenario failed: " + s.getName());
			// Call DriverFactory
		}
	}

}
