package advanced;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import utilities.DriverFactory;

public class ExceptionsAssertions {
	// Login application
	WebDriver driver;
	String email = "tim@testemail.com";
	String password = "password";
	String expected = "pass";
	String message;
	
	@Before
	public void setup() {
		message = "Welcome back!";
		if (expected.equals("fail")) {
			message = "Invalid password, try again!";
		}

		driver = DriverFactory.start("chrome", "http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@Test
	public void withWaits() {
		// Define an Explicit Wait element
		WebDriverWait waitFive = new WebDriverWait(driver, 5);
		WebDriverWait waitTen = new WebDriverWait(driver, 10);
		
		// Execute actions on UI
		waitFive.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("MainContent_txtUserName")))).sendKeys(email);
		waitTen.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("MainContent_txtPassword")))).sendKeys(password);
		waitFive.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("MainContent_btnLogin")))).click();
		
		// Assertions
		String pageText = driver.findElement(By.xpath("html/body")).getText();
		System.out.println(pageText);
		Assert.assertTrue(pageText.contains(message));
	}
	
	@Ignore
	@Test
	public void loginTest() {
		// Login credentials for UI
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// Assertion correct login
		
		/*
		 * Old Way
		 * String confMessage = driver.findElement(By.id("conf_message")).getText();
		 * Assert.assertTrue(confMessage.contains("success"));
		 */
		
		/* 1. Use Selenium Exception Handling with Try-Catch block
		try {
			String confMessage = driver.findElement(By.id("conf_message")).getText();
			System.out.println(confMessage);
		} catch (NoSuchElementException e) {
			Assert.fail("Could not find element id=conf_message.");
		}
		*/
		
		/* 2. Use a different approach to determine if logged in
		String pageTitle = driver.getTitle();
		String pageUrl = driver.getCurrentUrl();
		if (pageUrl.equals("http://sdettraining.com/trguitransactions/Dashboard.aspx")) {
			System.out.println("Logged in correctly");
			String confMessage = driver.findElement(By.id("conf_message")).getText();
			Assert.assertTrue(confMessage.contains("success"));
		}
		*/
		
		// 3. Change item locator to xpath root (html/body for all visible text on page)
		String pageText = driver.findElement(By.xpath("html/body")).getText();
		System.out.println(pageText);
		Assert.assertTrue(pageText.contains(message));
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
