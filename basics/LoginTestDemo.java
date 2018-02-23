package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDemo {
	
	public static void main(String[] args) {
		// Location of browser's driver
		String path = "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe";
		
		// 1. Start a web browser session --> a Selenium WebDriver
		System.out.println("Starting a new browser session");
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		
		// 2. Navigate to the application URL
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// Locate the element, what do we want to do, what values do we want to pass?
		
		// 3. Enter the username
		System.out.println("Entering login credentials");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter the password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		
		// 5. Click submit
		System.out.println("Clicking submit");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// 6. "Assert" the successful login -- capture text
		String result = driver.findElement(By.id("conf_message")).getText();
		System.out.println(result);
		
		if (result.contains("success")) {
			System.out.println("TEST PASSED");
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		// 7. Close the browser
		System.out.println("Closing the browser");
		driver.quit();
	}

}
