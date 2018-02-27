package frameworks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitIntro {
	
	// 1. Unit Test Framework as guide to flow of the test
	
	// 1. Start a web browser session, initialize test settings, connect to data source
	@Before
	public void setup() {
		System.out.println("Setting up the test...");
	}
	
	// 2. Test steps on UI
	@Test
	public void loginTest() {
		System.out.println("  Executing test on login");
		String expectedValue = "success";
		String actualValue = "success";
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void newAccountTest() {
		System.out.println("  Executing tests on newAccount");
	}
	
	// 3. Closing the web browser session, closing db connections, generate test reports
	@After
	public void teardown() {
		System.out.println("Ending test");
	}
	
}
