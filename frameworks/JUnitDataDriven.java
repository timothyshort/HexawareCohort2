package frameworks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// Use Parameters in this class
@RunWith(value = Parameterized.class)
public class JUnitDataDriven {
	String email;
	String password;
	
	// @Parameter: define values to parameterize
	@Parameters
	private static String[][] testData() {
		// call function to get data from external data source
		String[][] usernames = {
				{ "tim@testemail.com", "timspassword" }, 
				{ "jordan@freddiemail.com", "jordanspassword" },
				{ "kelly@freddiemail.com", "kellyspassword "}
			};
		return usernames;
	}
	
	// Use Constructor to parameterize values into class
	// This constructor will receive parameters from @Parameters for each iteration
	public JUnitDataDriven(String email, String password) {
		System.out.println("PARAMETERS: " + email + " " + password);
		this.email = email;
		this.password = password;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending test");
	}

	@Test
	public void test() {
		System.out.println("Executing test");
		System.out.println(" > Enter email... " + email);
		System.out.println(" > Enter password... " + password);
	}

}
