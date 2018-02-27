package frameworks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import utilities.DriverFactory;

public class JUnitTests {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		String browserType = "IE";
		String loginURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = DriverFactory.start(browserType, loginURL);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void loginTest() {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Assert.assertTrue("Testing page title", !driver.getTitle().contains("SDET"));
	}
	
	@Test
	public void newAccountTest() {
		System.out.println("Implement new account test");
	}

}
