package data;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CSV;
import utilities.DriverFactory;
import utilities.GlobalConfig;
import utilities.Screenshot;

@RunWith(value=Parameterized.class)
public class LoginCSV {
	WebDriver driver;
	String username;
	String password;
	
	@Before
	public void setup() {
		driver = DriverFactory.start("Firefox", GlobalConfig.AMS_URL);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		// UI Test Steps
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);		
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		Thread.sleep(1000);
		
		// Assertions
		String pageText = driver.findElement(By.xpath("html/body")).getText();
		if (!pageText.contains("Welcome back")) {
			Screenshot.takeByOutcome(driver, "fail", username);
			fail();
		}
		else {
			Screenshot.takeByOutcome(driver, "pass", username);
		}
	}
	
	@Parameters
	public static List<String[]> getTestData() {
		return CSV.get(GlobalConfig.TESTDATA_DIR + "LoginTestData.csv");
	}
	
	public LoginCSV(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

}
