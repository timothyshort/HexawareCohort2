package frameworks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {
	
	// setup function
	@BeforeMethod
	public void setup() {
		System.out.println("Starting TestNG test");
	}
	
	// teardown function
	@AfterMethod
	public void teardown() {
		System.out.println("Ending TestNG test");
	}
	
	// test function
	@Test
	public void test() {
		System.out.println("Executing TestNG test");
	}

}
