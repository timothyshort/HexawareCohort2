package cucumber.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.DriverFactory;

public class Hooks {
	static WebDriver driver;
	
	@Before
	public void setup() {
		driver = DriverFactory.start("chrome");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
