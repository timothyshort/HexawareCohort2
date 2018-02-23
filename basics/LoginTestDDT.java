package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestDDT {

	public static void main(String[] args) throws InterruptedException {
		String browserToTest = "firefox";
		// multiUsernameTest();
		oneUsernameTest(browserToTest);
	}
	
	public static void multiUsernameTest() throws InterruptedException {
		System.out.println("TEST STARTING");
		
		// Define variables using arrays
		String[] username = { "tim@testemail.com", "matt@sdettraining.com", "tim@testemail.com", "matt@sdettraining.com" };
		String[] password = { "trpass", "password", "trpass", "password" };
		String[] browserType = { "chrome", "firefox", "chrome", "firefox" };
		
		int numOfElements = username.length;
		System.out.println("Number of test cases: " + numOfElements);
		
		// Iterate through array using a loop
		for (int index=0; index<numOfElements; index++) {
			
			// Test Steps
			// 1. Initialize browser
			WebDriver driver = utilities.DriverFactory.start(browserType[index]);
			driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
			
			// 2. Enter form fields
			driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username[index]);
			driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password[index]);
			Thread.sleep(1000);
			driver.findElement(By.id("MainContent_btnLogin")).click();
			Thread.sleep(1000);
			
			// 3. Assertion
			String result = driver.findElement(By.id("conf_message")).getText();
			if (result.contains("success")) {
				System.out.println("TEST PASSED");
			}
			else {
				System.out.println("TEST FAILED");
			}
			
			// Terminate session
			driver.quit();
		}
		
		System.out.println("TEST COMPLETE");
	}
	
	public static void oneUsernameTest(String browserType) throws InterruptedException {
		System.out.println("TEST STARTING");
		
		// Define variables using arrays
		String username = "tim@testemail.com";
		String[] password = { "2309u", "sdfsf", "sdfew", "trpass" };
		int numOfElements = password.length;
		System.out.println("Number of test cases: " + numOfElements);
		
		// Initialize browser
		WebDriver driver = utilities.DriverFactory.start(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Enter username
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
		
		// Iterate through BAD passwords
		for (int index=0; index<numOfElements-1; index++) {
			driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password[index]);
			driver.findElement(By.id("MainContent_btnLogin")).click();
			
			/*
			String message = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
			if (message.contains("Invalid")) {
				System.out.println("BAD PASSWORD TEST PASSED: " + index);
			}
			*/
			utilities.ValueAssertions.contains(driver, By.id("MainContent_lblTransactionResult"), "Invalid");
			Thread.sleep(1000);
			
		}
		
		// Enter good password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password[numOfElements-1]);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Thread.sleep(1000);
		utilities.ValueAssertions.contains(driver, By.id("conf_message"), "success");
		
		// Terminate session
		driver.quit();
		
		System.out.println("TEST COMPLETE");
	}

}
