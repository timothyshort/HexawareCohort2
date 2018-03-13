package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.GlobalConfig;

public class CucumberLogin {
	WebDriver driver;
	
	@When("^the user enters a valid username$")
	public void the_user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
	}

	@When("^the user enters a bad password$")
	public void the_user_enters_a_bad_password() throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("badpassword2123");
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
		driver = DriverFactory.start("chrome", GlobalConfig.AMS_URL);
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
	
}