package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountDemo {

	public static void main(String[] args) throws InterruptedException {
		// Define variables
		String webUrl = "http://sdettraining.com/projects/";
		String name = "Matt";
		String email = "matt@sdettraining.com";
		String phoneNumber = "7897897897";
		String gender = "male";
		String password = "password";
		String country = "Australia";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		boolean occasionalEmail = true;
		
		// 1. Initialize the browser
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 2. Go to SDET Training projects page
		driver.get(webUrl);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		// 3. Click on "Account Management System"
		Thread.sleep(1000);
		driver.findElement(By.linkText("Account Management System")).click();
		
		// 4. Click on "Create Account"
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Account".toUpperCase())).click();
		
		// 5. Fill out the New User form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phoneNumber);
		
		// Radio button
		if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.id("MainContent_Male")).click();
			System.out.println("Male Radio Button Selected: " + driver.findElement(By.id("MainContent_Male")).isSelected());
		}
		else if (gender.equalsIgnoreCase("female")) {
			driver.findElement(By.id("MainContent_Female")).click();
			System.out.println("Female Radio Button Selected: " + driver.findElement(By.id("MainContent_Female")).isSelected());
		}
		
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue(country);
		
		// Checkboxes
		if (weeklyEmail) {
			if (!driver.findElement(By.id("MainContent_checkWeeklyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
			}
		}
		else {
			if (driver.findElement(By.id("MainContent_checkWeeklyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
			}
		}
		if (monthlyEmail) {
			if (!driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
			}
		}
		else {
			if (driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
			}
		}
		if (occasionalEmail) {
			if (!driver.findElement(By.id("MainContent_checkUpdates")).isSelected()) {
				driver.findElement(By.id("MainContent_checkUpdates")).click();
			}
		}
		else {
			if (driver.findElement(By.id("MainContent_checkUpdates")).isSelected()) {
				driver.findElement(By.id("MainContent_checkUpdates")).click();
			}
		}
		
		// Submit
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		Thread.sleep(1000);
		
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println(result);

		// Add a wait, then close browser
		Thread.sleep(2000);
		driver.quit();
	}

}
