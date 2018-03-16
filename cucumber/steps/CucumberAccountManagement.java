package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.GlobalConfig;

public class CucumberAccountManagement {
	WebDriver driver = Hooks.driver;
	
	@Given("the user is on the AMS page")
	public void userOnLoginPage() {
		System.out.println("User is on the login page");
		driver.get(GlobalConfig.AMS_URL);
	}
	
	@When("the user enters valid credentials")
	public void userEntersCredentials() {
		System.out.println("User enters credentials");
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("password");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	@Then("the user should be able to click on update subscriptions")
	public void clickUpdateSubcription() {
		String text = driver.findElement(By.linkText("Updated subscriptions")).getText();
		System.out.println("Clicking on update subscription");
	}
	
}
