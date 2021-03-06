package cucumber.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.GlobalConfig;
import utilities.Screenshot;

public class CucumberAccountManagement {
	WebDriver driver;
	
	@Before("@AccountManagementTests")
	public void setup() {
		driver = DriverFactory.start("chrome");
	}
	
	@After("@AccountManagementTests")
	public void tearDown(Scenario s) {
		if(s.isFailed()) {
			System.out.println("Saving Screenshot");
			Screenshot.takeByTestCase(driver, "cucumberTests", s.getName());
		}
		driver.quit();
	}
	
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
	
	@Then("the user should be able to click Update Subscriptions")
	public void clickUpdateSubcription() {
		Assert.assertTrue(driver.findElement(By.linkText("Updated subscriptions")).isDisplayed());
	}
	
	@Then("the user should be able to click Change Password")
	public void clickChangePassword() {
		Assert.assertTrue(driver.findElement(By.linkText("Change password")).isDisplayed());
	}
	
	@Then("the user should be able to click Cancel Account")
	public void clickCancelAccount() {
		Assert.assertTrue(driver.findElement(By.linkText("Cancel account")).isDisplayed());
	}
	
	@Then("^the user should be able to click Pay Bill$")
	public void the_user_should_be_able_to_click_Pay_Bill() throws Throwable {
		// Assert.assertTrue(driver.findElement(By.linkText("Pay bill")).isDisplayed());
		Assert.fail();
	}
	
	@Then("^the user should be able to click account preferences$")
	public void the_user_should_be_able_to_click_account_preferences(DataTable arg1) throws Throwable {
	    List<List<String>> items = arg1.raw();
	    for (String item : items.get(0)) {
	    	System.out.println("Looking for: " + item);
			Assert.assertTrue(driver.findElement(By.linkText(item)).isDisplayed());
	    }
	}
	
	@Given("^the user clicks Update Subscriptions$")
	public void the_user_clicks_Update_Subscriptions() throws Throwable {
		Assert.assertTrue(driver.findElement(By.linkText("Updated subscriptions")).isDisplayed());
	}

	@When("^the user selects \"([^\"]*)\"$")
	public void the_user_selects(String arg1) throws Throwable {
	    Assert.fail();
	}

	@When("^the user clicks Save$")
	public void the_user_clicks_Save() throws Throwable {
	    System.out.println("User clicks Save");
	}

	@Then("^the user should get a confirmation$")
	public void the_user_should_get_a_confirmation() throws Throwable {
	    System.out.println("User gets confirmation");
	}
	
}
