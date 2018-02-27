package frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class TestNGTests {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		String browserType = "IE";
		String loginURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = DriverFactory.start(browserType, loginURL);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 2)
	public void loginTest() {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Assert.assertTrue(!driver.getTitle().contains("SDET"));
	}
	
	@Test(priority = 1)
	public void newAccountTest() {
		System.out.println("Implement new account test");
	}

}
