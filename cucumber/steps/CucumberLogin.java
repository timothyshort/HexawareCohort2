package cucumber.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.Excel;
import utilities.GlobalConfig;

public class CucumberLogin {
	WebDriver driver;
	
	@Before("@Login")
	public void setup() {
		driver = DriverFactory.start("chrome");
	}
	
	@After("@Login")
	public void tearDown() {
		driver.quit();
	}
	
	String[][] data = null;
		
	@When("^the user enters a \"(.*)\" as the username$")
	public void the_user_enters_a_valid_username(String username) throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
	}

	@When("^the user enters a \"(.*)\" as a bad password$")
	public void the_user_enters_a_bad_password(String password) throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	}

	@When("^the user clicks login$")
	public void the_user_clicks_login() throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}

	@Then("^the user should not be able to login$")
	public void the_user_should_not_be_able_to_login() throws Throwable {
	    System.out.println("User should not be able to login");
	}

	@Then("^the user should get a invalid message$")
	public void the_user_should_get_a_invalid_message() throws Throwable {
	    System.out.println(driver.findElement(By.id("MainContent_lblTransactionResult")).getText());
	}
	
	// Given the user is on the login page
	@Given("the user is on the login page")
	public void userOnLoginPage() {
		System.out.println("User is on the login page");
		driver.get(GlobalConfig.AMS_URL);
		// driver = DriverFactory.start("chrome", GlobalConfig.AMS_URL);
	}
	
	// When the user enters credentials
	@When("the user enters credentials")
	public void userEntersCredentials() {
		System.out.println("User enters credentials");
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("password");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	// Then the user should be able to login
	@Then("the user should be able to login")
	public void userShouldLogin() {
		System.out.println("User should be able to login");
		driver.findElement(By.id("conf_message")).getText();
	}
	
	@And("homepage should be SDET Training")
	public void homepageShouldBeSDETTraining() {
		System.out.println("Page Title: " + driver.getTitle());
	}
	
	@When("^the user enters username and password$")
	public void userEntersUsernameAndPassword(DataTable data) {
		System.out.println("User enters username and password");
		// Extract datatable into list
		List<List<String>> credentials = data.raw();
		
		// Parse list into local variables
		String username = credentials.get(0).get(0);
		String password = credentials.get(0).get(1);
		
		// Perform action on the UI
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	@When("^the user enters username and password credentials$")
	public void userEntersUsernamePasswordCredentials(DataTable data) {
		// Extract datatable into map and iterate through map
		for (Map<String, String> credentials : data.asMaps(String.class, String.class)) {
			// Parse list into local variables
			String username = credentials.get("USERNAME");
			String password = credentials.get("PASSWORD");
			
			// Clear the textboxes
			driver.findElement(By.name("ctl00$MainContent$txtUserName")).clear();
			driver.findElement(By.name("ctl00$MainContent$txtPassword")).clear();
			
			// Perform action on the UI
			driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
			driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
			driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		}
	}
		
	@When("^user enters username as (.*)$")
	public void userEntersUsername(String username) {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
	}
	
	@And("^user enters password as (.*)$")
	public void userEntersPassword(String password) {
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	}
	
}